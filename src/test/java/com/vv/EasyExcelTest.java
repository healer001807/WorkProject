package com.vv;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.vv.pojo.dto.UserBoundCouponDTO;
import com.vv.utils.DTimeUtils;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2023 - 05 - 24 20:34
 **/
@SpringBootTest
public class EasyExcelTest {

    @SneakyThrows
    @Test
    public void writeEasyExcel() {
        String filePath = "D:\\study\\" + DTimeUtils.getFileDateTime() + ".xlsx";
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        ExcelWriter writer = EasyExcel.write(filePath, UserBoundCouponDTO.class).build();
        for (int i1 = 0; i1 < 2; i1++) {
            WriteSheet writeSheet = EasyExcel.writerSheet("导出优惠券" + (i1)).build();
            for (int i = 0; i < 2; i++) {
                List<UserBoundCouponDTO> couponDTOList = new LinkedList<>();
                UserBoundCouponDTO userBoundCouponDTO = new UserBoundCouponDTO();
                userBoundCouponDTO.setCouponId("XL00001");
                userBoundCouponDTO.setUserPhone("123457845101");
                couponDTOList.add(userBoundCouponDTO);
                writer.write(couponDTOList, writeSheet);
            }
        }

        writer.close();

    }
}
