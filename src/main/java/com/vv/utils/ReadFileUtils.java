package com.vv.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author kw
 * @program WrokProject
 * @description 读文件
 * @create 2023 - 05 - 20 23:33
 **/
@Slf4j
public class ReadFileUtils {

    /***
     * @description 读csv文件 hutool 工具
     * @param filePath
     * @return java.util.Collection<java.lang.String>
     * @author
     * @date 2023/5/20
     **/

    public static Collection<String> readCsvList(String filePath) {
        long start = System.currentTimeMillis();
        Collection<String> collection = Collections.synchronizedCollection(Lists.newArrayList());
        File touch = FileUtil.touch(filePath);
        FileInputStream fileInputStream = IoUtil.toStream(touch);
        BufferedReader reader = IoUtil.getReader(new BufferedReader(new InputStreamReader(fileInputStream)));
//        BufferedReader utf8Reader = IoUtil.getUtf8Reader(fileInputStream);
        List<String> dataList = reader.lines().parallel().toList();
        collection.addAll(dataList);
        System.out.println("-----执行结束-----" + (System.currentTimeMillis() - start) + "ms");
        return collection;
    }

    /***
     * @description 读csv文件 MultipartFile
     * @param multipartFile
     * @return java.util.Collection<java.lang.String>
     * @author
     * @date 2023/5/20
     **/

    public static Collection<String> readCsvList(MultipartFile multipartFile) throws IOException {
        long start = System.currentTimeMillis();
        Collection<String> collection = Collections.synchronizedCollection(Lists.newArrayList());
        BufferedReader reader = IoUtil.getReader(new BufferedReader(new InputStreamReader(multipartFile.getInputStream())));
        List<String> dataList = reader.lines().parallel().toList();
        collection.addAll(dataList);
        log.info("-----执行结束-----" + (System.currentTimeMillis() - start) + "ms");
        return collection;
    }

    /***
     * @description apache-commons-csv
     * @param multipartFile
     * @return java.util.List<java.lang.String>
     * @author
     * @date 2023/5/20
     **/

    public static List<String> readCsvString(MultipartFile multipartFile) {
        long readTime = System.currentTimeMillis();
        List<String> dataList = new CopyOnWriteArrayList<>();
        CSVParser csvRecords = null;
        try {
            csvRecords = CSVFormat.DEFAULT.parse(new BufferedReader(new InputStreamReader(multipartFile.getInputStream())));
            for (CSVRecord csvRecord : csvRecords) {
                dataList.addAll(csvRecord.stream().toList());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info("读文件时间：" + (System.currentTimeMillis() - readTime) + " 毫秒");
        return dataList;
    }

}
