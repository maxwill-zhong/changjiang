package com.les.decisionsupport.ods.emergency.event.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ods_emergency_event_type")
public class EmergencyEventType {
    @TableId(value = "id", type = IdType.AUTO)
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