package com.les.decisionsupport.ods.security.vo;

import com.les.decisionsupport.base.vo.Pagination;
import lombok.Data;

import java.util.Date;

@Data
public class NodeVo  extends Pagination {
    private Long id; // 节点ID
    private String name; // 节点名称
    private String type; // 节点类型
    private String note; // 备注
    private String parentId; // 父节点ID
    private String remark; // 备注
    private String updateBy;
    private Date updateTime;
    private Date createTime;
    private String createBy;
}
