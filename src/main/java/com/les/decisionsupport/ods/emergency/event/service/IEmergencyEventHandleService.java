package com.les.decisionsupport.ods.emergency.event.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.les.decisionsupport.ods.emergency.event.model.EmergencyEventHandle;
import com.les.decisionsupport.ods.emergency.event.vo.EmergencyEventHandleVo;

import java.util.List;

public interface IEmergencyEventHandleService  {
    Page<EmergencyEventHandle> selectPageList(EmergencyEventHandleVo vo);

    List<EmergencyEventHandle> selectEventList(EmergencyEventHandleVo vo);

    EmergencyEventHandle getEventById(Long id);

    int saveEntity(EmergencyEventHandle handle);

    int update(EmergencyEventHandle handle);

    int remove(Long id);
}