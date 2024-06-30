package com.vv.study1.excel.service;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PoiExcelServiceImplTest {

    private PoiExcelServiceImpl poiExcelServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        poiExcelServiceImplUnderTest = new PoiExcelServiceImpl();
    }

    @Test
    void testDownTemplateExcel() {
        // Setup
        final HttpServletResponse response = null;

        // Run the test
        poiExcelServiceImplUnderTest.downTemplateExcel(response);

        // Verify the results
    }

    @Test
    void testCreateDataValidation() {
        // Setup
        // Run the test
       // final HSSFDataValidation result = poiExcelServiceImplUnderTest.createDataValidation(0, 0, 0, 0,
            //    new String[]{"dataS"});

        // Verify the results
    }
}
