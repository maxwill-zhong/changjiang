package com.les.decisionsupport.ods.situation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.les.decisionsupport.ods.situation.model.AccidentEntity;
import com.les.decisionsupport.ods.situation.vo.AccidentPieStatis;
import com.les.decisionsupport.ods.situation.vo.AccidentRoadStatis;
import com.les.decisionsupport.ods.situation.vo.AccidentStatis;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AccidentMapper extends BaseMapper<AccidentEntity> {

    // 分页查询（返回 Page 对象）
    Page<AccidentEntity> selectByCustomQuery(Page<AccidentEntity> page,
                                             @Param("startTime") Date startTime,
                                             @Param("endTime") Date endTime,
                                             @Param("deptName") String deptName,
                                             @Param("location") String location,
                                             @Param("keyWord") String keyWord,
                                             @Param("caseKeyWord") String caseKeyWord,
                                             @Param("startHour") String startHour,
                                             @Param("endHour") String endHour,
                                             @Param("accidentTypes") String accidentTypes);

    // 非分页查询（返回 List 集合）
    List<AccidentEntity> selectByCustomQuery(@Param("startTime") Date startTime,
                                             @Param("endTime") Date endTime,
                                             @Param("deptName") String deptName,
                                             @Param("location") String location,
                                             @Param("keyWord") String keyWord,
                                             @Param("caseKeyWord") String caseKeyWord,
                                             @Param("startHour") String startHour,
                                             @Param("endHour") String endHour,
                                             @Param("accidentTypes") String accidentTypes);


    /**
     * 查询事故统计数据
     *
     * @param location 发生地点
     * @param keyWord 关键词
     * @param caseKeyWord 案情关键词
     * @param startTime 发生时间范围：开始时间
     * @param endTime 发生时间范围：结束时间
     * @param deptName 部门名称
     * @param startHour 发生时间时段范围：开始小时数
     * @param endHour 发生时间时段范围：结束小时数
     * @param accidentTypes 事件类型(逗号隔开)：slight轻伤 serious重伤 death死亡 simple简单
     * @return
     */
    AccidentStatis selectAccidentStatis(
            @Param("startTime") Date startTime,
            @Param("endTime") Date endTime,
            @Param("deptName") String deptName,
            @Param("location") String location,
            @Param("keyWord") String keyWord,
            @Param("caseKeyWord") String caseKeyWord,
            @Param("startHour") String startHour,
            @Param("endHour") String endHour,
            @Param("accidentTypes") String accidentTypes
    );


    /**
     * 查询根据事故地点按路段统计数据
     *
     * @param location 发生地点
     * @param keyWord 关键词
     * @param caseKeyWord 案情关键词
     * @param startTime 发生时间范围：开始时间
     * @param endTime 发生时间范围：结束时间
     * @param deptName 部门名称
     * @param startHour 发生时间时段范围：开始小时数
     * @param endHour 发生时间时段范围：结束小时数
     * @param accidentTypes 事件类型(逗号隔开)：slight轻伤 serious重伤 death死亡 simple简单
     * @return
     */
    List<AccidentRoadStatis> selectAccidentStatisGroupByRoad(
            @Param("startTime") Date startTime,
            @Param("endTime") Date endTime,
            @Param("deptName") String deptName,
            @Param("location") String location,
            @Param("keyWord") String keyWord,
            @Param("caseKeyWord") String caseKeyWord,
            @Param("startHour") String startHour,
            @Param("endHour") String endHour,
            @Param("accidentTypes") String accidentTypes,
            @Param("limitSize") Long limitSize
    );

    /**
     * 根据类型分组统计
     * @param startTime
     * @param endTime
     * @param deptName
     * @param location
     * @param keyWord
     * @param caseKeyWord
     * @param startHour
     * @param endHour
     * @param accidentTypes
     * @param limitSize
     * @return
     */
    List<AccidentPieStatis> selectAccidentGroupStatis(
            @Param("startTime") Date startTime,
            @Param("endTime") Date endTime,
            @Param("deptName") String deptName,
            @Param("location") String location,
            @Param("keyWord") String keyWord,
            @Param("caseKeyWord") String caseKeyWord,
            @Param("startHour") String startHour,
            @Param("endHour") String endHour,
            @Param("accidentTypes") String accidentTypes,
            @Param("limitSize") Long limitSize,
            @Param("groupParam") String groupParam,
            @Param("orderParam") String orderParam,
            @Param("whereAppend") String whereAppend
    );
}
