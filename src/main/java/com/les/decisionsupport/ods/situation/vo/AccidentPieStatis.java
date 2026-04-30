package com.les.decisionsupport.ods.situation.vo;

import lombok.Data;

/**
 * 事故分组统计通用返回
 */
@Data
public class AccidentPieStatis {
    // 名称
    String keyName;
    // 事故数量
    Long totalNum;
}
