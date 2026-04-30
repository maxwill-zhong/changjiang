package com.les.decisionsupport.ods.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.les.decisionsupport.ods.security.model.Node;
import com.les.decisionsupport.ods.security.vo.NodeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NodeMapper extends BaseMapper<Node> {
    // 分页查询（返回 Page 对象）
    Page<Node> selectByCustomQuery(Page<Node> page, @Param("query") NodeVo nodeVo);

    // 非分页查询（返回 List 集合）
    List<Node> selectByCustomQuery(@Param("query") NodeVo nodeVo);
}
