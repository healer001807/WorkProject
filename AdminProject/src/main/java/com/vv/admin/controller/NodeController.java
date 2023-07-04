package com.vv.admin.controller;

import com.vv.admin.pojo.dto.NodeDTO;
import com.vv.admin.service.NodeService;
import com.vv.util.ResUtils;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kw
 * @program WorkProject
 * @description 树形结构api
 * @create 2023 - 07 - 04 20:36
 **/
@RestController
@RequestMapping("node")
public class NodeController {

    @Resource
    private NodeService nodeService;

    /***
    * @description
    * @param []
    * @return com.vv.util.ResUtils
    * @author 
    * @date 2023/7/4
    
    **/
    
    @GetMapping("getNodeList")
    public ResUtils getNodeList() {
        return nodeService.buildTree(nodeService.getNodeList());
    }
}
