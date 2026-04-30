package com.les.decisionsupport.ods.emergency.event.vo;

import com.les.decisionsupport.base.vo.Pagination;
import lombok.Data;

@Data
public class EmergencyEventTypeVo extends Pagination {
    private Long id;
    private String eventType;
    private String eventName;
    private String infos;
    private String createBy;
    private String createDate;
    private String updateBy;
    private String updateDate;
    private String delFlag;
    private String remarks;
    private Long created;
    private Long updated;
    private String _source;
    private String batchno;
}