package com.les.decisionsupport.ods.emergency.event.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.les.decisionsupport.base.ActionResult;
import com.les.decisionsupport.ods.emergency.event.model.EmergencyDisposalCostAssessment;
import com.les.decisionsupport.ods.emergency.event.service.IEmergencyDisposalCostAssessmentService;
import com.les.decisionsupport.ods.emergency.event.vo.EmergencyDisposalCostAssessmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 应急处置成本评估
 */
@RestController
@RequestMapping("/emergency/disposal/cost")
public class EmergencyDisposalCostAssessmentController  {

    @Autowired
    private IEmergencyDisposalCostAssessmentService emergencyDisposalCostAssessmentService;

    @PostMapping("/list")
    public ActionResult getList(@RequestBody EmergencyDisposalCostAssessmentVo disposalCosVo) {
        Page<EmergencyDisposalCostAssessment> page = emergencyDisposalCostAssessmentService.getPageList(disposalCosVo);
        return ActionResult.success(page);
    }

    @PostMapping("/add")
    public ActionResult<?> save(@RequestBody EmergencyDisposalCostAssessment record) {
        emergencyDisposalCostAssessmentService.addEmergencyDisposalCostAssessment(record);
        return ActionResult.success("添加成功");
    }

    @PostMapping("/update")
    public ActionResult<?> update(@RequestBody EmergencyDisposalCostAssessment record) {
        emergencyDisposalCostAssessmentService.updateEmergencyDisposalCostAssessment(record);
        return ActionResult.success("更新成功");
    }

    @PostMapping("/{id}")
    public ActionResult<Void> delete(@PathVariable Long id) {
        EmergencyDisposalCostAssessment entity = emergencyDisposalCostAssessmentService.getInfo(id);
        if (entity != null) {
            emergencyDisposalCostAssessmentService.deleteEmergencyDisposalCostAssessment(id);
        }
        return ActionResult.success("删除成功");
    }
}
