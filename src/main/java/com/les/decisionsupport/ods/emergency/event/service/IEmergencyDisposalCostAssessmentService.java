package com.les.decisionsupport.ods.emergency.event.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.les.decisionsupport.ods.emergency.event.model.EmergencyDisposalCostAssessment;
import com.les.decisionsupport.ods.emergency.event.vo.EmergencyDisposalCostAssessmentVo;

public interface IEmergencyDisposalCostAssessmentService {
    Page<EmergencyDisposalCostAssessment> getPageList(EmergencyDisposalCostAssessmentVo disposalCostVo);

    int addEmergencyDisposalCostAssessment(EmergencyDisposalCostAssessment record);

    int updateEmergencyDisposalCostAssessment(EmergencyDisposalCostAssessment record);

    int deleteEmergencyDisposalCostAssessment(Long id);

    EmergencyDisposalCostAssessment getInfo(Long id);

}
