package com.les.decisionsupport.ods.emergency.event.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.les.decisionsupport.ods.emergency.event.model.EmergencyEventType;
import com.les.decisionsupport.ods.emergency.event.vo.EmergencyEventTypeVo;

import java.util.List;

public interface IEmergencyEventTypeService extends IService<EmergencyEventType> {

    Page<EmergencyEventType>  selectList(EmergencyEventTypeVo vo);

    List<EmergencyEventType> selectEventTypeList(EmergencyEventTypeVo vo);
}