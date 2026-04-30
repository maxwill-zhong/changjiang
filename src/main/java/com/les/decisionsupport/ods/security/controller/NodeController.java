package com.les.decisionsupport.ods.security.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.les.decisionsupport.base.ActionResult;
import com.les.decisionsupport.ods.security.model.Node;
import com.les.decisionsupport.ods.security.service.INodeService;
import com.les.decisionsupport.ods.security.vo.NodeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security/nodes")
public class NodeController {
    @Autowired
    private INodeService nodeService;

    @GetMapping("/list")
    public ActionResult getPage(NodeVo nodeVo) {
//        startPage();
        Page<Node> page = nodeService.getNodePage(nodeVo);
        return ActionResult.success(page);
    }

    @PostMapping
    @Transactional
    public ActionResult<?> addNode(@RequestBody Node node) {
        int result = nodeService.addNode(node);
        if (result > 0) {
            return ActionResult.success("添加成功");
        } else {
            return ActionResult.success("添加失败");
        }
    }

    @PutMapping
    @Transactional
    public ActionResult<?> updateNode(@RequestBody Node node) {
        int result = nodeService.updateNode(node);
        if (result > 0) {
            return ActionResult.success("更新成功");
        } else {
            return ActionResult.success("更新失败");
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ActionResult<?> deleteNode(@PathVariable String id) {
        int result = nodeService.deleteNode(id);
        if (result > 0) {
            return ActionResult.success("删除成功");
        } else {
            return ActionResult.success("删除失败");
        }
    }

    @GetMapping("/{id}")
    public ActionResult getNodeById(@PathVariable String id) {
        return ActionResult.success(nodeService.getNodeById(id));
    }

    @GetMapping
    public ActionResult getAllNodes() {
        return ActionResult.success(nodeService.getAllNodes());
    }

    @GetMapping("/parent/{parentId}")
    public ActionResult getNodesByParentId(@PathVariable String parentId) {
        return ActionResult.success(nodeService.getNodesByParentId(parentId));
    }

    // 自定义分页查询接口
    @GetMapping("/custom-page")
    public ActionResult customPageQuery(NodeVo nodeVo) {
        return ActionResult.success(nodeService.listByCustomPageQuery(nodeVo));
    }

    // 自定义非分页查询接口
    @GetMapping("/custom-list")
    public ActionResult customListQuery(NodeVo nodeVo) {
        return ActionResult.success(nodeService.listByCustomQuery(nodeVo));
    }
}
