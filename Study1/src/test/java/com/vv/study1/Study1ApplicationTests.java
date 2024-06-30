package com.vv.study1;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SpringBootTest
class Study1ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test() throws IOException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet = hssfWorkbook.createSheet();
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("类型");
        row.createCell(1).setCellValue("名称");
        row.createCell(2).setCellValue("问题展示渠道");
        List<String> list = Arrays.asList("1类型", "2类型", "3类型");
        String[] questionDisplayChannelS = {"APP|XCX", "APP", "XCX"};
        List<HSSFDataValidation> dataValidations = new LinkedList<>();
        HSSFDataValidation dataValidation = createDataValidation(1, 10, 0, 0, String.join(",", list).split(","));
        if (dataValidation != null) {
            dataValidations.add(dataValidation);
        }
        sheet.addValidationData(dataValidation);
        HSSFDataValidation dataValidation1 = createDataValidation(1, 10, 2, 2, questionDisplayChannelS);
        if (dataValidation != null) {
            dataValidations.add(dataValidation);
        }
        sheet.addValidationData(dataValidation1);
        FileOutputStream out = new FileOutputStream("D:\\study\\temp\\test1.xls");
        hssfWorkbook.write(out);
        out.close();
    }

    public HSSFDataValidation createDataValidation(int firstRow, int lastRow, int firstCol, int lastCol, String[] dataS) {
        // 指定将下拉框添加至1-10行，0-0列。即第一列的第2到11行
        CellRangeAddressList cas = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
        //创建下拉数据列
        DVConstraint dvConstraint = DVConstraint.createExplicitListConstraint(dataS);
        //将下拉数据放入下拉框
        HSSFDataValidation dataValidation = new HSSFDataValidation(cas, dvConstraint);
        return dataValidation;
    }

    @Test
    public void test2() {
        List<Integer> list = filterPositiveNumbers(Arrays.asList(1, 2, 3, 4));
        System.out.println(list);
        List<Integer> list1 = filterEvenNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println(list1);
        List<Integer> list2 = filterNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), x -> x % 2 == 0);
        System.out.println(list2);
    }

    public static List<Integer> filterPositiveNumbers(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (number > 0) {
                result.add(number);
            }
        }
        return result;
    }

    public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                result.add(number);
            }
        }
        return result;
    }


    public List<Integer> filterNumbers(List<Integer> numbers, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (predicate.test(number)) {
                result.add(number);
            }
        }
        return result;
    }


}
