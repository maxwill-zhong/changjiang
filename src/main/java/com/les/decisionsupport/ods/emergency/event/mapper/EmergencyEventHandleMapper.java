package com.les.decisionsupport.ods.emergency.event.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.les.decisionsupport.ods.emergency.event.model.EmergencyEventHandle;
import com.les.decisionsupport.ods.emergency.event.vo.EmergencyEventHandleVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmergencyEventHandleMapper extends BaseMapper<EmergencyEventHandle> {

    List<EmergencyEventHandle> selectByConditions(EmergencyEventHandleVo vo);

}
