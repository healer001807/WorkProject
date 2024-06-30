package com.vv.study1;

import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Study1ApplicationTestsTest {

    private Study1ApplicationTests study1ApplicationTestsUnderTest;

    @BeforeEach
    void setUp() {
        study1ApplicationTestsUnderTest = new Study1ApplicationTests();
    }

    @Test
    void testContextLoads() {
        study1ApplicationTestsUnderTest.contextLoads();
    }

    @Test
    void testTest() throws Exception {
        // Setup
        // Run the test
        study1ApplicationTestsUnderTest.test();

        // Verify the results
    }

    @Test
    void testTest_ThrowsIOException() {
        // Setup
        // Run the test
        assertThatThrownBy(() -> study1ApplicationTestsUnderTest.test()).isInstanceOf(IOException.class);
    }

    @Test
    void testCreateDataValidation() {
        // Setup
        // Run the test
        final HSSFDataValidation result = study1ApplicationTestsUnderTest.createDataValidation(0, 0, 0, 0,
                new String[]{"dataS"});

        // Verify the results
    }
}
