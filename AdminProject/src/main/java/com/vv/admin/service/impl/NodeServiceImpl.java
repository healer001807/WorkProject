package com.vv.admin.service.impl;

import com.vv.admin.mapper.NodeMapper;
import com.vv.admin.pojo.dto.NodeDTO;
import com.vv.admin.service.NodeService;
import com.vv.util.ResUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.w3c.dom.Node;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author kw
 * @program WorkProject
 * @description 树形结构实现层
 * @create 2023 - 07 - 04 20:42
 **/
@Service
public class NodeServiceImpl implements NodeService {

    @Resource
    private NodeMapper nodeMapper;

    @Override
    public List<NodeDTO> getNodeList() {
        // 模拟查询数据库构造
        NodeDTO first = NodeDTO.builder().nodeId(1).nodePid(0).nodeName("first").build();
        NodeDTO second = NodeDTO.builder().nodeId(2).nodePid(1).nodeName("second").build();
        NodeDTO third = NodeDTO.builder().nodeId(3).nodePid(2).nodeName("third").build();
        NodeDTO four = NodeDTO.builder().nodeId(4).nodePid(3).nodeName("four").build();
        NodeDTO six = NodeDTO.builder().nodeId(5).nodePid(4).nodeName("six").build();

        return Arrays.asList(first, second, third, four, six);
    }

    @Override
    public ResUtils buildTree(List<NodeDTO> nodeDTOS) {
        if (Optional.ofNullable(nodeDTOS).isEmpty()) {
            return ResUtils.failed();
        }
        // 构建树形结构
        Map<Integer, List<NodeDTO>> nodeMap = nodeDTOS.stream().filter(nodeDTO -> nodeDTO.getNodePid() != 0)
                .collect(Collectors.groupingBy(NodeDTO::getNodePid));
        // 循环
        nodeDTOS.forEach(nodeDTO -> nodeDTO.setTreeNode(nodeMap.get(nodeDTO.getNodeId())));
        //
        return ResUtils.success(nodeDTOS.stream().filter(nodeDTO -> nodeDTO.getNodePid() == 0).collect(Collectors.toList()));
    }
}
