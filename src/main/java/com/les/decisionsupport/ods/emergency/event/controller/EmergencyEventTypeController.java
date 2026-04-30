package com.les.decisionsupport.ods.emergency.event.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.les.decisionsupport.base.ActionResult;
import com.les.decisionsupport.ods.emergency.event.model.EmergencyEventType;
import com.les.decisionsupport.ods.emergency.event.service.IEmergencyEventTypeService;
import com.les.decisionsupport.ods.emergency.event.vo.EmergencyEventTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emergency/eventtype")
public class EmergencyEventTypeController {

    @Autowired
    private IEmergencyEventTypeService eventTypeService;

    @PostMapping("/list")
    public ActionResult getList(EmergencyEventTypeVo vo) {
        Page<EmergencyEventType> page =  eventTypeService.selectList(vo);
        return ActionResult.success(page);
    }

    @GetMapping("/{id}")
    public EmergencyEventType getById(@PathVariable Long id) {
        return eventTypeService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody EmergencyEventType eventType) {
        eventTypeService.save(eventType);
    }

    @PutMapping
    public void update(@RequestBody EmergencyEventType eventType) {
        eventTypeService.updateById(eventType);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        eventTypeService.removeById(id);
    }

    @PostMapping("/getEventTypeList")
    public ActionResult getEventTypeList(EmergencyEventTypeVo vo) {
        return ActionResult.success(eventTypeService.selectEventTypeList(vo));
    }
}