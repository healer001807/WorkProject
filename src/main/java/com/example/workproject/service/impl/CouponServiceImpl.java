package com.example.workproject.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.workproject.enums.TaskEnum;
import com.example.workproject.mapper.CouponMapper;
import com.example.workproject.mapper.TaskMapper;
import com.example.workproject.pojo.dto.TaskDTO;
import com.example.workproject.pojo.dto.UserBoundCouponDTO;
import com.example.workproject.pojo.vo.CouponEasyExcelVO;
import com.example.workproject.service.CouponService;
import com.example.workproject.utils.DTimeUtils;
import com.example.workproject.utils.ReadFileUtils;
import com.example.workproject.utils.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author kw
 * @program WrokProject
 * @description 优惠券业务实现
 * @create 2023 - 05 - 20 14:31
 **/
@Slf4j
@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @Autowired
    private CouponMapper couponMapper;
    @Autowired
    private TaskMapper taskMapper;

    @Value("${per.total}")
    private Integer perTotal; // 每次执行数据

    @Value("${sheet.size}")
    private Integer sheetSize; // 每页显示数

    @Override
    public String sendCoupon(MultipartFile multipartFile) {
        String resp = "{\"code\":\"999999\"}"; // todo 后续统一
        // 1.非空校验
        if (null == multipartFile) {
            return resp;
        }
        // 2.读取文件名
        String originalFilename = multipartFile.getOriginalFilename();
        String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        if (!"csv".equals(fileSuffix)) {
            return resp;
        }
        // 3.解析文件 todo 如何减少读文件时间
        try {
            Collection<String> mobilePhones = ReadFileUtils.readCsvList(multipartFile);

            // 4.多线程处理数据
            runCoupon(mobilePhones.stream().toList());

            // 5.返回成功
            resp = "{\"code\":\"000000\"}";
            return resp;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * @description 导出用户发券数据
     * @author kangwei
     * @date 2023-5-22
     @return void
     */
    @Override
    public String exportCoupon() {
        String resp = "{\"code\":\"999999\"}"; // todo 后续统一
        // 1.向job表中插入一条导出数据的消息
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTaskSeq(UUIDUtils.getUUID()); // 流水号
        taskDTO.setTaskType(TaskEnum.NOT_EXECUTED.getStatus()); // 初始化 0-未执行
        int row = taskMapper.insertTask(taskDTO);
        if (row <= 0) {
            return resp;
        }
        // 2.插入成功，返回成功，否则返回失败
        resp = "{\"code\":\"000000\"}";
        return resp;
    }

    /**
     * 执行数据导出操作
     * int startPageNo = i * (sheetSize / perTotal) + 1; // 0*(20/10)+1 1
     * int endPageNo = (i + 1) * (sheetSize / perTotal); // (0+1)*2 2
     * 23秒导出10000数据 -- 效率慢 后续优化
     *
     * @return
     */
    @Override
    public String doExportCoupon() throws IOException {
        String resp = "{\"code\":\"999999\",\"filePath\":\"\"}"; // todo 后续统一
        long startTime = System.currentTimeMillis();
        // 分页读取数据
        // 1.查询总数据量
        int total = couponMapper.selectTotal();
        // 2.数据量大，使用多个sheet
        int sheetCount = total % sheetSize == 0 ? total / sheetSize : total / sheetSize + 1;
        // 3.文件名 todo
        String filePath = "D:\\study\\" + DTimeUtils.getFileDateTime() + ".xlsx";
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        // 3.分批
        ExcelWriter excelWriter = EasyExcel.write(filePath, CouponEasyExcelVO.class).build();
        for (int i = 0; i < sheetCount; i++) {
            WriteSheet writeSheet = EasyExcel.writerSheet("导出优惠券" + (i)).build();
            int selectCount = sheetSize % perTotal == 0 ? sheetSize / perTotal : sheetSize / perTotal + 1;
            for (int i1 = 0; i1 < selectCount; i1++) {
                // 计算开始索引
                int startPageNo = (i1) * perTotal;
                // 写excel
                List<CouponEasyExcelVO> couponEasyExcelVOS = BeanUtil.copyToList(couponMapper.selectCouponList(startPageNo, perTotal), CouponEasyExcelVO.class);
                excelWriter.write(couponEasyExcelVOS, writeSheet);
            }
        }
        excelWriter.close(); // 关闭easyExcel流
        resp = "{\"code\":\"0000\",\"filePath\":\"" + filePath + "\"}";
        log.info("数据导出消费时间" + (System.currentTimeMillis() - startTime) / 1000 + "秒");
        return resp;
    }

    /***
     * @description 执行发券功能
     * @param mobilePhones
     * @return void
     * @author
     * @date 2023/5/21
     **/

    private void runCoupon(List<String> mobilePhones) {
        // 发券
        long startTime = System.currentTimeMillis();
        int total = mobilePhones.size(); // 总数
        int count = (total + perTotal - 1) / perTotal;
        List<Callable<Integer>> task = new LinkedList<>();
        CompletionService completionService = new ExecutorCompletionService(threadPoolExecutor);
        List<CompletionService> completionServices = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            int fromIndex = i * perTotal;
            int toIndex = Math.min(((i + 1) * perTotal), total);
            List<Map<String, Object>> couponBatch = mobilePhones.subList(fromIndex, toIndex).stream().map(s -> {
                Map<String, Object> map = new HashMap<>();
                map.put("couponSeq", UUID.randomUUID().toString().replaceAll("-", ""));
                map.put("userPhone", s);
                map.put("templateSeq", "L00001");
                return map;
            }).toList();

            completionService.submit(() -> couponMapper.insertCouponBatch(couponBatch));
            log.info("线程" + completionService.poll());
//                completionServices.add(completionService);
//            task.add(() -> couponMapper.insertCouponBatch(couponBatch));
        }
//        for (CompletionService service : completionServices) {
//            log.info("线程" + service.poll());
//        }
//        List<Future<Integer>> futures = threadPoolExecutor.invokeAll(task);
//        for (Future<Integer> future : futures) {
//            if (future.isCancelled()) {
//                break;
//            }
//            log.info("正在退出的线程" + future.get());
//        }
        log.info("消费时间为" + (System.currentTimeMillis() - startTime) + "毫秒");
    }
}
