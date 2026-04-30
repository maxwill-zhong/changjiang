package com.les.decisionsupport.ods.security.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("kg_node")
public class Node {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String type;
    private String note;
    private String parentId;
    private String remark;
    private String updateBy;
    private Date updateTime;
    private Date createTime;
    private String createBy;
}
