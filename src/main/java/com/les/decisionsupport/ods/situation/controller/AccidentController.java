package com.les.decisionsupport.ods.situation.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.les.decisionsupport.base.ActionResult;
import com.les.decisionsupport.ods.situation.model.AccidentEntity;
import com.les.decisionsupport.ods.situation.service.IAccidentService;
import com.les.decisionsupport.ods.situation.vo.AccidentPieStatis;
import com.les.decisionsupport.ods.situation.vo.AccidentQueryParams;
import com.les.decisionsupport.ods.situation.vo.AccidentRoadStatis;
import com.les.decisionsupport.ods.situation.vo.AccidentStatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 事故数据相关controller
 */
@RestController
@RequestMapping("/situation/accident")
public class AccidentController {

    @Autowired
    private IAccidentService accidentService;

    /**
     * 查询数量统计
     * @return
     */
    @PostMapping("/getAccidentStatis")
    public ActionResult getAccidentStatis(@RequestBody AccidentQueryParams params) {
        AccidentStatis statis = accidentService.getAccidentStatis(params);
        return ActionResult.success(statis);
    }

    /**
     * 按事故地点（路段）统计事故数量
     * @param params
     * @return
     */
    @PostMapping("/getAccidentStatisByRoad")
    public ActionResult getAccidentStatisByRoad(@RequestBody AccidentQueryParams params) {
        List<AccidentRoadStatis> statis = accidentService.getAccidentStatisByRoad(params);
        return ActionResult.success(statis);
    }


    @PostMapping("/getAccidentStatisByIncidentType")
    public ActionResult getAccidentStatisByIncidentType(@RequestBody AccidentQueryParams params) {
        List<AccidentPieStatis> statis = accidentService.getAccidentStatisByIncidentType(params);
        return ActionResult.success(statis);
    }

    @PostMapping("/getAccidentStatisByDay")
    public ActionResult getAccidentStatisByDay(@RequestBody AccidentQueryParams params) {
        List<AccidentPieStatis> statis = accidentService.getAccidentStatisByDay(params);
        return ActionResult.success(statis);
    }

    @PostMapping("/getAccidentStatisByHour")
    public ActionResult getAccidentStatisByHour(@RequestBody AccidentQueryParams params) {
        List<AccidentPieStatis> statis = accidentService.getAccidentStatisByHour(params);
        return ActionResult.success(statis);
    }

    // 查询根据事故道路等级（G国道,S省道,X县道,Y乡道,C村道,Z专用公路）统计数据
    @PostMapping("/getAccidentStatisByRoadLevel")
    public ActionResult getAccidentStatisByRoadLevel(@RequestBody AccidentQueryParams params) {
        List<AccidentPieStatis> statis = accidentService.getAccidentStatisByRoadLevel(params);
        return ActionResult.success(statis);
    }

    // 查询根据天气统计事故数量
    @PostMapping("/getAccidentStatisByWeather")
    public ActionResult getAccidentStatisByWeather(@RequestBody AccidentQueryParams params) {
        List<AccidentPieStatis> statis = accidentService.getAccidentStatisByWeather(params);
        return ActionResult.success(statis);
    }

    // 根据统计颗粒度 week,month,season,year统计事故数量
    @PostMapping("/getAccidentStatisByGranularity")
    public ActionResult getAccidentStatisByGranularity(@RequestBody AccidentQueryParams params) {
        List<AccidentPieStatis> statis = accidentService.getAccidentStatisByGranularity(params);
        return ActionResult.success(statis);
    }



    @PostMapping("/getAccidentPage")
    public ActionResult getAccidentPage(@RequestBody AccidentQueryParams params) {
        Page<AccidentEntity> page = accidentService.getAccidentPage(params);
        return ActionResult.success(page);
    }

    @PostMapping("/getAccidentList")
    public ActionResult getAccidentList(@RequestBody AccidentQueryParams params) {
        List<AccidentEntity> list = accidentService.getAccidentList(params);
        return ActionResult.success(list);
    }

}
