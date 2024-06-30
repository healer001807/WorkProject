package com.vv.study1.excel.service;

import cn.hutool.core.collection.CollUtil;
import com.vv.study1.excel.utils.ExcelUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kw
 * @program WorkProject
 * @description POI excel业务接口
 * @create 2023 - 12 - 09 19:24
 **/
@Service
public class PoiExcelServiceImpl extends PoiExcelService {

    @Override
    public void downTemplateExcel(HttpServletResponse response) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        // 设置居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        // 字体
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        cellStyle.setFont(font);
        HSSFSheet sheet = workbook.createSheet();

        // 标题 第一行
        HSSFRow row = sheet.createRow(0);
        String[] headerS = {"类型", "名称", "问题展示渠道"};
        for (int i = 0; i < headerS.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(headerS[i]);
            // 类型 单元格类型 字符串 数字
            cell.setCellType(CellType.STRING);
            // 样式
            cell.setCellStyle(cellStyle);
            // 设置列宽
            sheet.setColumnWidth(i, 256 * 30);
        }
        // 数据可从数据库查 todo
        String[] list = {"1类型", "2类型", "3类型"};
        String[] questionDisplayChannelS = {"APP|XCX", "APP", "XCX"};
        Map<String[], CellRangeAddress> listMap = new LinkedHashMap<>();
        listMap.put(list, new CellRangeAddress(1, 10, 0, 0));
        listMap.put(questionDisplayChannelS, new CellRangeAddress(1, 10, 2, 2));
        List<HSSFDataValidation> dataValidationV1 = ExcelUtil.createDataValidationV1(listMap);
        if (CollUtil.isNotEmpty(dataValidationV1)) {
            for (HSSFDataValidation dataValidation : dataValidationV1) {
                sheet.addValidationData(dataValidation);
            }
        }
        // response 响应
        ExcelUtil.getOutPutStream(response, workbook, System.currentTimeMillis() + ".xls");
    }


}
