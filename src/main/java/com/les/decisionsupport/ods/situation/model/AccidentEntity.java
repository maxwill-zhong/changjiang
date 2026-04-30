package com.les.decisionsupport.ods.situation.model;

import lombok.Data;

@Data
public class AccidentEntity {
    // 事件id
    private String id;

    // 部门ID
    private String departmentId;

    // 部门名称
    private String departmentName;

    // 发生时间
    private String occurringTime;

    // 预计结束时间
    private String expectedTerminalTime;

    // 结束时间
    private String terminalTime;

    // 事件类型
    private String incidentType;

    // 道路ID
    private String roadId;

    // 道路名称
    private String roadName;

    // 方向
    private String direction;

    // 天气编码
    private String weather;

    // 占用车道
    private String numberOfOccupiedLanes;

    // 车辆信息
    private String vehiclesInfo;

    // 车道数量
    private String numberOfLanes;

    // 涉及人数
    private String numberOfPeople;

    // 轻伤人数
    private Long numberOfSlightInjury;

    // 重伤人数
    private Long numberOfSeriousInjury;

    // 死亡人数
    private Long numberOfFatality;

    // 经度
    private String lng;

    //纬度
    private String lat;
}
