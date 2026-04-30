package com.les.decisionsupport.ods.situation.vo;

import lombok.Data;

/**
 * 事故数量统计
 */
@Data
public class AccidentStatis {

    // 事故总数量
    private Long totalNum;

    // 简单事故数量
    private Long simpleNum;

    // 轻伤事故数量
    private Long slightInjuryNum;

    // 重伤事故数量
    private Long seriousInjuryNum;

    // 死亡事故数量
    private Long deathNum;

}
