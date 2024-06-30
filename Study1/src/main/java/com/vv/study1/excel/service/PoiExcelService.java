package com.vv.study1.excel.service;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

/**
 * @author kw
 * @program WorkProject
 * @description POIexcel业务接口
 * @create 2023 - 12 - 09 19:24
 **/
@Service
public abstract class PoiExcelService {


    public abstract void downTemplateExcel(HttpServletResponse response) throws FileNotFoundException;
}
