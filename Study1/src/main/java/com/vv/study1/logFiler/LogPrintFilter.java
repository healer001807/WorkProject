package com.vv.study1.logFiler;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.codec.Base64;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: WorkProject
 * @description: 过滤base64加密的图片流
 * @author: kangwei
 * @create: 2023-11-14 15:09
 **/
public class LogPrintFilter {

    private static final String FILE_FILTER_PATTERN = "\"[\\w+-=\\\\]{1024,}?\"";
    /**
     * 这个表达式目前不支持多数据，后续更改
     */
    private static final String FILE_FILTER_PATTERN2 = "(data:;base64,)*(.+)";


    /**
     * 日志入参返参打印过滤base64图片流
     * ，减少日志文件
     *
     * @param json
     * @return
     */
    public static String filterBase64V1(String json) {
        return json.replaceAll(FILE_FILTER_PATTERN, "\"base64 very long string \"");
    }

    /**
     * 支持单个，目前不支持其他业务参数一起
     *
     * @param base64
     * @return
     */
    public static String filterBase64V2(String base64) {
        Pattern compile = Pattern.compile(FILE_FILTER_PATTERN2);
        Matcher matcher = compile.matcher(base64);
        if (matcher.matches()) {
            base64 = "";
        }
        return base64;
    }
}
