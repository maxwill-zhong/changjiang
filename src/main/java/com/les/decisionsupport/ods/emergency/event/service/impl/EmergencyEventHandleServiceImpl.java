package com.les.decisionsupport.ods.emergency.event.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.les.decisionsupport.ods.emergency.event.mapper.EmergencyEventHandleMapper;
import com.les.decisionsupport.ods.emergency.event.model.EmergencyEventHandle;
import com.les.decisionsupport.ods.emergency.event.service.IEmergencyEventHandleService;
import com.les.decisionsupport.ods.emergency.event.vo.EmergencyEventHandleVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergencyEventHandleServiceImpl extends ServiceImpl<EmergencyEventHandleMapper, EmergencyEventHandle> implements IEmergencyEventHandleService {
    @Autowired
    private EmergencyEventHandleMapper handleMapper;

    @Override
    public Page<EmergencyEventHandle> selectPageList(EmergencyEventHandleVo vo){
        Page<EmergencyEventHandle> page = new Page<>(vo.getCurrentPage(), vo.getPageSize());
        LambdaQueryWrapper<EmergencyEventHandle> lqw = buildQueryWrapper(vo);
        lqw.orderByDesc(EmergencyEventHandle::getCreateDate);

        return baseMapper.selectPage(page, lqw); // 无条件分页查询
    }

    @Override
    public List<EmergencyEventHandle> selectEventList(EmergencyEventHandleVo vo) {
       return handleMapper.selectByConditions(vo);
    }

    @Override
    public EmergencyEventHandle getEventById(Long id) {
        return handleMapper.selectById(id);
    }

    @Override
    public int saveEntity(EmergencyEventHandle handle) {
        return handleMapper.insert(handle);
    }

    @Override
    public int update(EmergencyEventHandle handle) {
        return handleMapper.updateById(handle);
    }

    @Override
    public int remove(Long id) {
        return handleMapper.deleteById(id);
    }

    /**
     * 查询条件生成
     * @param vo
     * @return
     */
    private LambdaQueryWrapper<EmergencyEventHandle> buildQueryWrapper(EmergencyEventHandleVo vo) {
        LambdaQueryWrapper<EmergencyEventHandle> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StringUtils.isNotBlank(vo.getEventName()), EmergencyEventHandle::getEventName, vo.getEventName());
        queryWrapper.eq(StringUtils.isNotBlank(vo.getEventType()), EmergencyEventHandle::getEventType, vo.getEventType());
        if (StringUtils.isNotEmpty(vo.getStartDate()) && StringUtils.isNotEmpty(vo.getEndDate())) {
            queryWrapper.ge(EmergencyEventHandle::getEventTime, vo.getStartDate());
            queryWrapper.le(EmergencyEventHandle::getEventTime, vo.getEndDate());
        }
        queryWrapper.eq(StringUtils.isNotBlank(vo.getReporter()), EmergencyEventHandle::getReporter, vo.getReporter());
        queryWrapper.eq(StringUtils.isNotBlank(vo.getReporterPhone()), EmergencyEventHandle::getReporterPhone, vo.getReporterPhone());
        queryWrapper.eq(StringUtils.isNotBlank(vo.getEventUnit()), EmergencyEventHandle::getEventUnit, vo.getEventUnit());
        queryWrapper.like(StringUtils.isNotBlank(vo.getEventInfo()), EmergencyEventHandle::getEventInfo, vo.getEventInfo());
        queryWrapper.eq(StringUtils.isNotBlank(vo.getEventAffix()), EmergencyEventHandle::getEventAffix, vo.getEventAffix());
        queryWrapper.like(StringUtils.isNotBlank(vo.getLeaderOpinion()), EmergencyEventHandle::getLeaderOpinion, vo.getLeaderOpinion());
        queryWrapper.like(StringUtils.isNotBlank(vo.getProposedOpinions()), EmergencyEventHandle::getProposedOpinions, vo.getProposedOpinions());
        queryWrapper.like(StringUtils.isNotBlank(vo.getProcessingResult()), EmergencyEventHandle::getProcessingResult, vo.getProcessingResult());
        queryWrapper.eq(StringUtils.isNotBlank(vo.getHandler()), EmergencyEventHandle::getHandler, vo.getHandler());
        queryWrapper.eq(StringUtils.isNotBlank(vo.getDutyer()), EmergencyEventHandle::getDutyer, vo.getDutyer());
        queryWrapper.eq(StringUtils.isNotBlank(vo.getReceiptTime()), EmergencyEventHandle::getReceiptTime, vo.getReceiptTime());
        queryWrapper.eq(StringUtils.isNotBlank(vo.getEventState()), EmergencyEventHandle::getEventState, vo.getEventState());
        queryWrapper.eq(StringUtils.isNotBlank(vo.getCreateBy()), EmergencyEventHandle::getCreateBy, vo.getCreateBy());
        queryWrapper.eq(StringUtils.isNotBlank(vo.getCreateDate()), EmergencyEventHandle::getCreateDate, vo.getCreateDate());
        queryWrapper.eq(StringUtils.isNotBlank(vo.getUpdateBy()), EmergencyEventHandle::getUpdateBy, vo.getUpdateBy());
        queryWrapper.eq(StringUtils.isNotBlank(vo.getUpdateDate()), EmergencyEventHandle::getUpdateDate, vo.getUpdateDate());
        queryWrapper.eq(StringUtils.isNotBlank(vo.getDelFlag()), EmergencyEventHandle::getDelFlag, vo.getDelFlag());
        queryWrapper.like(StringUtils.isNotBlank(vo.getRemarks()), EmergencyEventHandle::getRemarks, vo.getRemarks());
        queryWrapper.eq(StringUtils.isNotBlank(vo.getEventId()), EmergencyEventHandle::getEventId, vo.getEventId());
        queryWrapper.eq(vo.getResubmit() != null, EmergencyEventHandle::getResubmit, vo.getResubmit());
        queryWrapper.eq(StringUtils.isNotBlank(vo.getCreated()), EmergencyEventHandle::getCreated, vo.getCreated());

        return queryWrapper;
    }

    // 其他业务方法
}