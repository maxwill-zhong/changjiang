package com.les.decisionsupport.ods.situation.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.les.decisionsupport.base.vo.Pagination;
import lombok.Data;

import java.util.Date;

/**
 * 事故数据查询条件
 */
@Data
public class AccidentQueryParams extends Pagination {

    // 发生时间范围：开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;
    // 发生时间范围：结束时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;
    // 部门名称
    private String deptName;
    // 发生地点
    private String location;
    // 关键词
    private String keyWord;
    // 案情关键词（车辆信息）
    private String caseKeyWord;
    // 发生时间时段范围：开始小时数
    private String startHour;
    // 发生时间时段范围：结束小时数
    private String endHour;
    // 事件类型(逗号隔开)：slight轻伤 serious重伤 death死亡 simple简单
    private String accidentTypes;


    // 统计颗粒度 week,month,season,year
    private String statisticalGranularity;

    // 结果数量限制
    private Long limitSize;



}
