package com.les.decisionsupport.ods.emergency.event.vo;

import com.les.decisionsupport.base.vo.Pagination;
import lombok.Data;

import java.util.Date;

@Data
public class EmergencyDisposalCostAssessmentVo extends Pagination {
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
    private Long created;
    private Long updated;
    private String source;
    private String batchno;
    private String updateby; // 最后更新人
    private Date updateDate; // 最后更新时间
    private Date createDate; // 创建时间
    private String createby; // 创建人
    private String startDate;
    private String endDate;
}