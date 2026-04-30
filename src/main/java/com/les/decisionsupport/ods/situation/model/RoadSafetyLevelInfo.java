package com.les.decisionsupport.ods.situation.model;

import lombok.Data;

/**
 * 道路安全等级评估信息表
 */
@Data
public class RoadSafetyLevelInfo {

    private String id;
    // 批次号
    private String batchNo;
    // tims_dt_road_id'
    private String roadId;
    // 百度road_base_info_v2 ids 逗号隔开
    private String bRoadIds;
    // 百度road_seg_base_info ids 逗号隔开
    private String bRoadSegIds;
    // 雾气评级
    private String fogLevel;
    // 雨评级
    private String rainLevel;
    // 风评级
    private String windLevel;
    // 冰冻评级
    private String freezeLevel;
    // 雪评级
    private String snowLevel;
    // 流量突变评级
    private String flowSuddenLevel;
    // 路段车速差评级
    private String speedDiffLevel;
    // 路面车型构成评级
    private String vehicleTypeLevel;
    // 交通事件发生时剩余通行能力评级
    private String remainingCapacityLevel;
    // 违法行为评级评级
    private String illegalEventLevel;
    // 历史交通事故评级评级
    private String accidentLevel;
    // 公路安全设施评级
    private String roadSafetyDeviceLevel;
    // 公路危险点（段）评级
    private String roadDangerPointLevel;
    // 评估数据范围开始时间
    private String rangeStartTime;
    // 评估数据范围结束时间
    private String rangeEndTime;

    private String createTime;

    private String updateTime;

}
