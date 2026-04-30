package com.les.decisionsupport.ods.emergency.event.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("ods_emergency_disposal_cost_assessment")
public class EmergencyDisposalCostAssessment {
    @TableId(type = IdType.AUTO)  // 使用 MyBatis-Plus 的雪花算法生成 ID
    private Long id;
    private Double eventId;
    private String eventName;
    private String eventType;
    private String eventTime;
    private Double materialLoss;
    private Double equipmentLoss;
    private Integer personnelAllocation;
    private Integer vehicleAllocation;
    private String delFlag;
    private String remarks;
    private String updateBy;
    private Date updateDate;
    private Date createDate;
    private String createBy;
    private Long created;
    private Long updated;
    private String _source;
    private String batchno;
}