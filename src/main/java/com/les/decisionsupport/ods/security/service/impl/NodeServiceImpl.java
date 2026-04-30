package com.les.decisionsupport.ods.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.les.decisionsupport.base.utils.StringUtils;
import com.les.decisionsupport.ods.security.mapper.NodeMapper;
import com.les.decisionsupport.ods.security.model.Node;
import com.les.decisionsupport.ods.security.service.INodeService;
import com.les.decisionsupport.ods.security.vo.NodeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeServiceImpl extends ServiceImpl<NodeMapper, Node> implements INodeService  {
    @Autowired
    private NodeMapper nodeMapper;

    @Override
    public int addNode(Node node) {
        return baseMapper.insert(node);
    }

    @Override
    public int updateNode(Node node) {
        return baseMapper.updateById(node);
    }

    @Override
    public int deleteNode(String id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public Node getNodeById(String id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<Node> getAllNodes() {
        return nodeMapper.selectList(new QueryWrapper());
    }

    @Override
    public Page<Node> getNodePage(NodeVo nodeVo) {
        Page<Node> page = new Page<>(nodeVo.getCurrentPage(), nodeVo.getPageSize());
        LambdaQueryWrapper<Node> queryWrapper = new LambdaQueryWrapper<>();
        if (nodeVo.getName() != null && !nodeVo.getName().isEmpty()) {
            queryWrapper.like(StringUtils.isNotEmpty(nodeVo.getName()), Node::getName, nodeVo.getName())
                    .eq(Node::getName, nodeVo.getName());
        }
        return baseMapper.selectPage(page, queryWrapper); // 无条件分页查询
    }

    @Override
    public List<Node> getNodesByParentId(String parentId) {
        QueryWrapper<Node> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parentId", parentId);
        return nodeMapper.selectList(queryWrapper);
    }

    // 自定义分页查询
    @Override
    public Page<Node> listByCustomPageQuery(NodeVo nodeVo) {
        Page<Node> page = new Page<>(nodeVo.getCurrentPage(), nodeVo.getPageSize());
        return baseMapper.selectByCustomQuery(page, nodeVo);
    }

    // 自定义非分页查询
    @Override
    public List<Node> listByCustomQuery(NodeVo nodeVo) {
        return baseMapper.selectByCustomQuery(nodeVo);
    }
}
