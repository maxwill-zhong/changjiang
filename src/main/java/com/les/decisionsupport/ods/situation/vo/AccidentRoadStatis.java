package com.les.decisionsupport.ods.situation.vo;

import lombok.Data;

/**
 * 事故按道路统计
 */
@Data
public class AccidentRoadStatis {
    // 道路ID
    String roadId;
    // 道路名称
    String roadName;
    // 管理部门ID
    String deptId;
    // 管理部门
    String deptName;
    // 事故数量
    String totalNum;
}
