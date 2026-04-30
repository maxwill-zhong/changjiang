package com.les.decisionsupport.ods.situation.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.les.decisionsupport.ods.situation.mapper.AccidentMapper;
import com.les.decisionsupport.ods.situation.model.AccidentEntity;
import com.les.decisionsupport.ods.situation.service.IAccidentService;
import com.les.decisionsupport.ods.situation.vo.AccidentPieStatis;
import com.les.decisionsupport.ods.situation.vo.AccidentQueryParams;
import com.les.decisionsupport.ods.situation.vo.AccidentRoadStatis;
import com.les.decisionsupport.ods.situation.vo.AccidentStatis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AccidentServiceImpl implements IAccidentService {

    @Autowired
    private AccidentMapper accidentMapper;

    /**
     * 查询事故统计
     *
     * @param filterParams 过滤参数
     * @return
     */
    @Override
    public AccidentStatis getAccidentStatis(AccidentQueryParams filterParams) {
        return accidentMapper.selectAccidentStatis(
                filterParams.getStartTime(),
                filterParams.getEndTime(),
                filterParams.getDeptName(),
                filterParams.getLocation(),
                filterParams.getKeyWord(),
                filterParams.getCaseKeyWord(),
                filterParams.getStartHour(),
                filterParams.getEndHour(),
                filterParams.getAccidentTypes()
        );
    }

    /**
     * 查询根据事故地点按路段统计数据
     *
     * @param filterParams 过滤条件
     * @return
     */
    @Override
    public List<AccidentRoadStatis> getAccidentStatisByRoad(AccidentQueryParams filterParams) {
        return accidentMapper.selectAccidentStatisGroupByRoad(
                filterParams.getStartTime(),
                filterParams.getEndTime(),
                filterParams.getDeptName(),
                filterParams.getLocation(),
                filterParams.getKeyWord(),
                filterParams.getCaseKeyWord(),
                filterParams.getStartHour(),
                filterParams.getEndHour(),
                filterParams.getAccidentTypes(),
                filterParams.getLimitSize()
        );
    }

    /**
     * 查询根据事故类型分类统计数据
     *
     * @param filterParams 过滤条件
     * @return
     */
    @Override
    public List<AccidentPieStatis> getAccidentStatisByIncidentType(AccidentQueryParams filterParams) {
        return accidentMapper.selectAccidentGroupStatis(
                filterParams.getStartTime(),
                filterParams.getEndTime(),
                filterParams.getDeptName(),
                filterParams.getLocation(),
                filterParams.getKeyWord(),
                filterParams.getCaseKeyWord(),
                filterParams.getStartHour(),
                filterParams.getEndHour(),
                filterParams.getAccidentTypes(),
                filterParams.getLimitSize(),
                "e.incidenttype",
                null,
                " and e.incidenttype is not null"
        );
    }

    /**
     * 查询根据事故按天统计数据
     *
     * @param filterParams
     * @return
     */
    @Override
    public List<AccidentPieStatis> getAccidentStatisByDay(AccidentQueryParams filterParams) {
        return accidentMapper.selectAccidentGroupStatis(
                filterParams.getStartTime(),
                filterParams.getEndTime(),
                filterParams.getDeptName(),
                filterParams.getLocation(),
                filterParams.getKeyWord(),
                filterParams.getCaseKeyWord(),
                filterParams.getStartHour(),
                filterParams.getEndHour(),
                filterParams.getAccidentTypes(),
                filterParams.getLimitSize(),
                "e.f_day",
                "e.f_day asc",
                null
        );
    }

    /**
     * 查询根据事故按小时统计数据
     *
     * @param filterParams
     * @return
     */
    @Override
    public List<AccidentPieStatis> getAccidentStatisByHour(AccidentQueryParams filterParams) {
        return accidentMapper.selectAccidentGroupStatis(
                filterParams.getStartTime(),
                filterParams.getEndTime(),
                filterParams.getDeptName(),
                filterParams.getLocation(),
                filterParams.getKeyWord(),
                filterParams.getCaseKeyWord(),
                filterParams.getStartHour(),
                filterParams.getEndHour(),
                filterParams.getAccidentTypes(),
                filterParams.getLimitSize(),
                "e.f_hour",
                "e.f_hour asc",
                null
        );
    }

    /**
     * 查询根据事故道路等级（G国道,S省道,X县道,Y乡道,C村道,Z专用公路）统计数据
     *
     * @param filterParams
     * @return
     */
    @Override
    public List<AccidentPieStatis> getAccidentStatisByRoadLevel(AccidentQueryParams filterParams) {
        return accidentMapper.selectAccidentGroupStatis(
                filterParams.getStartTime(),
                filterParams.getEndTime(),
                filterParams.getDeptName(),
                filterParams.getLocation(),
                filterParams.getKeyWord(),
                filterParams.getCaseKeyWord(),
                filterParams.getStartHour(),
                filterParams.getEndHour(),
                filterParams.getAccidentTypes(),
                filterParams.getLimitSize(),
                "substr(e.road, 1, 1)",
                null,
                " and e.road is not null"
        );
    }

    /**
     * 根据天气类型统计事故数量
     *
     * @param filterParams
     * @return
     */
    @Override
    public List<AccidentPieStatis> getAccidentStatisByWeather(AccidentQueryParams filterParams) {
        return accidentMapper.selectAccidentGroupStatis(
                filterParams.getStartTime(),
                filterParams.getEndTime(),
                filterParams.getDeptName(),
                filterParams.getLocation(),
                filterParams.getKeyWord(),
                filterParams.getCaseKeyWord(),
                filterParams.getStartHour(),
                filterParams.getEndHour(),
                filterParams.getAccidentTypes(),
                filterParams.getLimitSize(),
                "e.weather",
                null,
                " and e.weather is not null"
        );
    }

    /**
     * 根据统计颗粒度 week,month,season,year统计事故数量
     *
     * @param filterParams
     * @return
     */
    @Override
    public List<AccidentPieStatis> getAccidentStatisByGranularity(AccidentQueryParams filterParams) {
        String groupParam = null;
        if(filterParams.getStatisticalGranularity().equals("year")){
            groupParam = "SUBSTR(e.f_mth,1,4)";
        }else if(filterParams.getStatisticalGranularity().equals("month")){
            groupParam = "e.f_mth";
        }else if(filterParams.getStatisticalGranularity().equals("week")){
            groupParam = "DATE_FORMAT(e.occurringtime,'%Y\"第\"%u\"周\"')";
        }else if(filterParams.getStatisticalGranularity().equals("season")){
            groupParam = "CONCAT(SUBSTR(e.occurringtime, 1, 4),'-Q',CEIL(CAST(SUBSTR(e.occurringtime, 6, 2) AS NUMERIC) / 3))";
        }

        return accidentMapper.selectAccidentGroupStatis(
                filterParams.getStartTime(),
                filterParams.getEndTime(),
                filterParams.getDeptName(),
                filterParams.getLocation(),
                filterParams.getKeyWord(),
                filterParams.getCaseKeyWord(),
                filterParams.getStartHour(),
                filterParams.getEndHour(),
                filterParams.getAccidentTypes(),
                filterParams.getLimitSize(),
                groupParam,
                "key_name",
                null
        );
    }

    @Override
    public Page<AccidentEntity> getAccidentPage(AccidentQueryParams filterParams) {

        Page<AccidentEntity> page = new Page<>(filterParams.getCurrentPage(),
                filterParams.getPageSize());
        return accidentMapper.selectByCustomQuery(page, filterParams.getStartTime(),
                filterParams.getEndTime(),
                filterParams.getDeptName(),
                filterParams.getLocation(),
                filterParams.getKeyWord(),
                filterParams.getCaseKeyWord(),
                filterParams.getStartHour(),
                filterParams.getEndHour(),
                filterParams.getAccidentTypes());

    }

    @Override
    public List<AccidentEntity> getAccidentList(AccidentQueryParams filterParams) {

        return accidentMapper.selectByCustomQuery(filterParams.getStartTime(),
                filterParams.getEndTime(),
                filterParams.getDeptName(),
                filterParams.getLocation(),
                filterParams.getKeyWord(),
                filterParams.getCaseKeyWord(),
                filterParams.getStartHour(),
                filterParams.getEndHour(),
                filterParams.getAccidentTypes());
    }
}
