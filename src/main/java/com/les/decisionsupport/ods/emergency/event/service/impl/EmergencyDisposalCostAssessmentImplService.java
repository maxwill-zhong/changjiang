package com.les.decisionsupport.ods.emergency.event.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.les.decisionsupport.base.utils.DateUtils;
import com.les.decisionsupport.ods.emergency.event.mapper.EmergencyDisposalCostAssessmentMapper;
import com.les.decisionsupport.ods.emergency.event.model.EmergencyDisposalCostAssessment;
import com.les.decisionsupport.ods.emergency.event.service.IEmergencyDisposalCostAssessmentService;
import com.les.decisionsupport.ods.emergency.event.vo.EmergencyDisposalCostAssessmentVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmergencyDisposalCostAssessmentImplService extends ServiceImpl<EmergencyDisposalCostAssessmentMapper,
        EmergencyDisposalCostAssessment> implements IEmergencyDisposalCostAssessmentService {
    @Autowired
    private EmergencyDisposalCostAssessmentMapper disposalCostAssessmentMapper;

    public Page<EmergencyDisposalCostAssessment> getPageList(EmergencyDisposalCostAssessmentVo vo) {
        Page<EmergencyDisposalCostAssessment> page = new Page<>(vo.getCurrentPage(), vo.getPageSize());
        LambdaQueryWrapper<EmergencyDisposalCostAssessment> queryWrapper = buildQueryWrapper(vo);
        queryWrapper.orderByDesc(EmergencyDisposalCostAssessment::getCreateDate);
        return baseMapper.selectPage(page, queryWrapper); // 无条件分页查询
    }

    public int addEmergencyDisposalCostAssessment(EmergencyDisposalCostAssessment record) {
        // TODO USER待更新
        record.setCreateBy("");
        record.setCreateDate(DateUtils.getNowTime());
        return disposalCostAssessmentMapper.insert(record);
    }

    public int updateEmergencyDisposalCostAssessment(EmergencyDisposalCostAssessment record) {
        // TODO USER待更新
        record.setUpdateBy("");
        record.setUpdateDate(DateUtils.getNowTime());
       return disposalCostAssessmentMapper.updateById(record);
    }

    public EmergencyDisposalCostAssessment getInfo(Long id) {
        QueryWrapper<EmergencyDisposalCostAssessment> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(EmergencyDisposalCostAssessment::getId, id);
        return this.getOne(queryWrapper);
    }
    public int deleteEmergencyDisposalCostAssessment(Long id) {
        return disposalCostAssessmentMapper.deleteById(id);
    }


    /**
     * 查询条件生成
     * @param vo
     * @return
     */
    private LambdaQueryWrapper<EmergencyDisposalCostAssessment> buildQueryWrapper(EmergencyDisposalCostAssessmentVo vo) {
        LambdaQueryWrapper<EmergencyDisposalCostAssessment> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StringUtils.isNotBlank(vo.getEventName()), EmergencyDisposalCostAssessment::getEventName, vo.getEventName());
        queryWrapper.eq(StringUtils.isNotBlank(vo.getEventType()), EmergencyDisposalCostAssessment::getEventType, vo.getEventType());
        if (StringUtils.isNotEmpty(vo.getStartDate()) && StringUtils.isNotEmpty(vo.getEndDate())) {
            queryWrapper.ge(EmergencyDisposalCostAssessment::getEventTime, vo.getStartDate());
            queryWrapper.le(EmergencyDisposalCostAssessment::getEventTime, vo.getEndDate());
        }
        queryWrapper.eq(vo.getMaterialLoss() != null, EmergencyDisposalCostAssessment::getMaterialLoss, vo.getMaterialLoss());
        queryWrapper.eq(vo.getEquipmentLoss() != null, EmergencyDisposalCostAssessment::getMaterialLoss, vo.getMaterialLoss());
        queryWrapper.eq(EmergencyDisposalCostAssessment::getDelFlag, "0");
        return queryWrapper;
    }
}
