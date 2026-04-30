package com.les.decisionsupport.ods.security.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.les.decisionsupport.ods.security.model.Node;
import com.les.decisionsupport.ods.security.vo.NodeVo;

import java.util.List;

public interface INodeService {
    int addNode(Node node);

    int updateNode(Node node);

    int deleteNode(String id);

    Node getNodeById(String id);

    List<Node> getAllNodes();

    Page<Node> getNodePage(NodeVo nodeVo);

    List<Node> getNodesByParentId(String parentId);

    // 自定义分页查询
    Page<Node> listByCustomPageQuery(NodeVo nodeVo);

    // 自定义非分页查询
    List<Node> listByCustomQuery(NodeVo nodeVo);
}
