package com.les.decisionsupport.ods.emergency.event.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.les.decisionsupport.base.vo.Pagination;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class EmergencyEventHandleVo extends Pagination {
    private Long id;
    private String eventName;
    private String eventType;
    private String eventTime;
    private String reporter;
    private String reporterPhone;
    private String eventUnit;
    private String eventInfo;
    private String eventAffix;
    private String leaderOpinion;
    private String proposedOpinions;
    private String processingResult;
    private String handler;
    private String dutyer;
    private String receiptTime;
    private String eventState;
    private String createBy;
    private String createDate;
    private String updateBy;
    private String updateDate;
    private String delFlag;
    private String remarks;
    private String eventId;
    private Boolean resubmit;
    private String created;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String startDate;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String endDate;
}