package com.vv.admin.pojo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

/**
 * @author kw
 * @program WorkProject
 * @description 树形结构
 * @create 2023 - 07 - 04 20:26
 **/
@Builder
@ToString
@Data
public class NodeDTO {

    private Integer nodeId;
    private String nodeName;
    private Integer nodePid;

    private List<NodeDTO> treeNode = new LinkedList<>();

//    public NodeDTO(Integer nodeId, Integer nodePid) {
//        this.nodeId = nodeId;
//        this.nodePid = nodePid;
//    }
//
//    public NodeDTO(Integer nodeId, Integer nodePid, String nodeName) {
//        this.nodeId = nodeId;
//        this.nodePid = nodePid;
//        this.nodeName = nodeName;
//    }

}
