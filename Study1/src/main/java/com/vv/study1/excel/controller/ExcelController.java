package com.vv.study1.excel.controller;

import com.vv.study1.excel.service.PoiExcelService;
import com.vv.util.ResUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2023 - 11 - 30 22:37
 **/
@Tag(name = "ExcelController", description = "excel文档api")
@RestController
@RequestMapping("excel")
public class ExcelController {
    @Resource
    private PoiExcelService poiExcelService;

    @Operation(summary = "downTemplateExcel", description = "excel模板下载")
    @GetMapping("downTemplateExcel")
    public void downTemplateExcel(HttpServletResponse response) throws FileNotFoundException {
        poiExcelService.downTemplateExcel(response);
    }
}
