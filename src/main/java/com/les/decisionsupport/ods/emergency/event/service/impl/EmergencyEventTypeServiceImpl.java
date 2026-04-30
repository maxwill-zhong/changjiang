package com.les.decisionsupport.ods.emergency.event.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.les.decisionsupport.base.utils.StringUtils;
import com.les.decisionsupport.ods.emergency.event.mapper.EmergencyEventTypeMapper;
import com.les.decisionsupport.ods.emergency.event.model.EmergencyEventType;
import com.les.decisionsupport.ods.emergency.event.service.IEmergencyEventTypeService;
import com.les.decisionsupport.ods.emergency.event.vo.EmergencyEventTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergencyEventTypeServiceImpl extends ServiceImpl<EmergencyEventTypeMapper, EmergencyEventType> implements IEmergencyEventTypeService {
    @Autowired
    private EmergencyEventTypeMapper eventTypeMapper;

    @Override
    public Page<EmergencyEventType> selectList(EmergencyEventTypeVo vo) {
        Page<EmergencyEventType> page = new Page<>(vo.getCurrentPage(), vo.getPageSize());
        LambdaQueryWrapper<EmergencyEventType> lqw = buildQueryWrapper(vo);

        return baseMapper.selectPage(page, lqw); // 无条件分页查询
    }

    @Override
    public List<EmergencyEventType> selectEventTypeList(EmergencyEventTypeVo vo) {
        LambdaQueryWrapper<EmergencyEventType> lqw = new LambdaQueryWrapper<>();
        lqw.eq(EmergencyEventType::getDelFlag, "0");
        return baseMapper.selectList(lqw);
    }


    private LambdaQueryWrapper<EmergencyEventType> buildQueryWrapper(EmergencyEventTypeVo vo) {
        LambdaQueryWrapper<EmergencyEventType> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(StringUtils.isNotBlank(vo.getEventType()), EmergencyEventType::getEventType, vo.getEventType())
                .eq(StringUtils.isNotBlank(vo.getEventName()), EmergencyEventType::getEventName, vo.getEventName())
                .eq(StringUtils.isNotBlank(vo.getInfos()), EmergencyEventType::getInfos, vo.getInfos())
                .eq(StringUtils.isNotBlank(vo.getCreateBy()), EmergencyEventType::getCreateBy, vo.getCreateBy())
                .eq(StringUtils.isNotBlank(vo.getCreateDate()), EmergencyEventType::getCreateDate, vo.getCreateDate())
                .eq(StringUtils.isNotBlank(vo.getUpdateBy()), EmergencyEventType::getUpdateBy, vo.getUpdateBy())
                .eq(StringUtils.isNotBlank(vo.getUpdateDate()), EmergencyEventType::getUpdateDate, vo.getUpdateDate())
                .eq(StringUtils.isNotBlank(vo.getDelFlag()), EmergencyEventType::getDelFlag, vo.getDelFlag())
                .eq(StringUtils.isNotBlank(vo.getRemarks()), EmergencyEventType::getRemarks, vo.getRemarks())
                .eq(vo.getCreated() != null, EmergencyEventType::getCreated, vo.getCreated())
                .eq(vo.getUpdated() != null, EmergencyEventType::getUpdated, vo.getUpdated())
                .eq(StringUtils.isNotBlank(vo.get_source()), EmergencyEventType::get_source, vo.get_source())
                .eq(StringUtils.isNotBlank(vo.getBatchno()), EmergencyEventType::getBatchno, vo.getBatchno());

        return queryWrapper;
    }

    // 其他业务方法
}
