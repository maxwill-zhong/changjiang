package com.les.decisionsupport.ods.emergency.event.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.les.decisionsupport.ods.emergency.event.model.EmergencyDisposalCostAssessment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmergencyDisposalCostAssessmentMapper extends BaseMapper<EmergencyDisposalCostAssessment> {

    List<EmergencyDisposalCostAssessment> findAll(EmergencyDisposalCostAssessment record);

    int insert(EmergencyDisposalCostAssessment record);

    int updateByPrimaryKey(EmergencyDisposalCostAssessment record);

    int deleteByPrimaryKey(Long id);
}
