package com.vv.study1.excel.utils;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2023 - 12 - 09 21:56
 **/
public class ExcelUtil {
    public static List<HSSFDataValidation> createDataValidationV1(Map<String[], CellRangeAddress> map) {
        List<HSSFDataValidation> dataValidationList = new LinkedList<>();
        for (Map.Entry<String[], CellRangeAddress> entry : map.entrySet()) {
            CellRangeAddressList cellRangeAddressList = new CellRangeAddressList();
            cellRangeAddressList.addCellRangeAddress(entry.getValue());
            // 创建下拉数据列
            DVConstraint dvConstraint = DVConstraint.createExplicitListConstraint(entry.getKey());
            // 将下拉数据放入下拉框
            dataValidationList.add(new HSSFDataValidation(cellRangeAddressList, dvConstraint));
        }
        return dataValidationList;
    }

    public static void getOutPutStream(HttpServletResponse response, HSSFWorkbook hssfWorkbook, String fileName) {
        response.setContentType("application/octet-stream;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            hssfWorkbook.write(outputStream);
        } catch (IOException ignored) {

        } finally {
            try {
                if (hssfWorkbook != null) {
                    hssfWorkbook.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException ignored) {

            }
        }
    }

}
