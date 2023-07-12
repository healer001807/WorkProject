package com.vv.admin.service;

import com.vv.util.ResUtils;

/**
 * @program: WorkProject
 * @description: 文件上传业务接口
 * @author: kangwei
 * @create: 2023-05-22 15:50
 **/
public interface FileService {

    /***
     * @description 异步上传文件
     * @param []
     * @return com.vv.util.ResUtils
     * @author
     * @date 2023/7/5
     **/

    ResUtils uploadAsync();
}
