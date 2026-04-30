package com.les.decisionsupport.ods.emergency.event.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.les.decisionsupport.base.ActionResult;
import com.les.decisionsupport.ods.emergency.event.model.EmergencyEventHandle;
import com.les.decisionsupport.ods.emergency.event.service.IEmergencyEventHandleService;
import com.les.decisionsupport.ods.emergency.event.vo.EmergencyEventHandleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emergency/event/handle")
public class EmergencyEventHandleController {

    @Autowired
    private IEmergencyEventHandleService handleService;

    @PostMapping("/list")
    public ActionResult getList(@RequestBody EmergencyEventHandleVo vo) {
        Page<EmergencyEventHandle> page = handleService.selectPageList(vo);
        return ActionResult.success(page);
    }

    @GetMapping("/{id}")
    public ActionResult getById(@PathVariable Long id) {
        return ActionResult.success(handleService.getEventById(id));
    }

    @PostMapping
    public void add(@RequestBody EmergencyEventHandle handle) {
        handleService.saveEntity(handle);
    }

    @PutMapping
    public void update(@RequestBody EmergencyEventHandle handle) {
        handleService.update(handle);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        handleService.remove(id);
    }


    @GetMapping("/getEvents")
    public ActionResult getEvents(EmergencyEventHandleVo vo) {
        List<EmergencyEventHandle> list = handleService.selectEventList(vo);
        return ActionResult.success(list);
    }
}