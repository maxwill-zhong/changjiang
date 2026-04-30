package com.les.decisionsupport.ods.emergency.event.model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ods_emergency_event_handle")
public class EmergencyEventHandle {
    @TableId(value = "id", type = IdType.AUTO)
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
}