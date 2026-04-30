package com.les.decisionsupport.ods.situation.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.les.decisionsupport.ods.situation.model.AccidentEntity;
import com.les.decisionsupport.ods.situation.vo.AccidentPieStatis;
import com.les.decisionsupport.ods.situation.vo.AccidentQueryParams;
import com.les.decisionsupport.ods.situation.vo.AccidentRoadStatis;
import com.les.decisionsupport.ods.situation.vo.AccidentStatis;

import java.util.List;

public interface IAccidentService {

    /**
     * 查询事故统计
     * @param filterParams 过滤条件
     * @return
     */
    AccidentStatis getAccidentStatis(AccidentQueryParams filterParams);

    /**
     * 查询根据事故地点按路段统计数据
     * @param filterParams 过滤条件
     * @return
     */
    List<AccidentRoadStatis> getAccidentStatisByRoad(AccidentQueryParams filterParams);
    /**
     * 查询根据事故类型分类统计数据
     * @param filterParams 过滤条件
     * @return
     */
    List<AccidentPieStatis> getAccidentStatisByIncidentType(AccidentQueryParams filterParams);

    /**
     * 查询根据事故按天统计数据
     * @param filterParams
     * @return
     */
    List<AccidentPieStatis> getAccidentStatisByDay(AccidentQueryParams filterParams);

    /**
     * 查询根据事故按小时统计数据
     * @param filterParams
     * @return
     */
    List<AccidentPieStatis> getAccidentStatisByHour(AccidentQueryParams filterParams);

    /**
     * 查询根据事故道路等级（G国道,S省道,X县道,Y乡道,C村道,Z专用公路）统计数据
     * @param filterParams
     * @return
     */
    List<AccidentPieStatis> getAccidentStatisByRoadLevel(AccidentQueryParams filterParams);

    /**
     * 根据天气类型统计事故数量
     * @param filterParams
     * @return
     */
    List<AccidentPieStatis> getAccidentStatisByWeather(AccidentQueryParams filterParams);

    /**
     * 根据统计颗粒度 week,month,season,year统计事故数量
     * @param filterParams
     * @return
     */
    List<AccidentPieStatis> getAccidentStatisByGranularity(AccidentQueryParams filterParams);

    Page<AccidentEntity> getAccidentPage(AccidentQueryParams filterParams);
    List<AccidentEntity> getAccidentList(AccidentQueryParams filterParams);


}
