package com.les.decisionsupport.ods.rehearsal.util;

import cn.hutool.core.lang.generator.SnowflakeGenerator;
import com.les.decisionsupport.ods.rehearsal.vo.RehearsalReportVO;
import cn.hutool.core.date.DateUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RehearsalUtil {

    static SnowflakeGenerator generator = new SnowflakeGenerator();

    // 生成默认演练模板报告
    public static RehearsalReportVO CreateRehearsalReport() {
        RehearsalReportVO report = new RehearsalReportVO();

        // 报告信息
        report.setTitle("应急演练");
        report.setConclusion("总结本次演练的成效与收获，强调改进措施的重要性和紧迫性，同时对未来应急管理工作提出期望。");

        // 引言-报告概述
        RehearsalReportVO.ReportOverview reportOverview = new RehearsalReportVO.ReportOverview();
        reportOverview.setDept("有关部门");
        reportOverview.setEditTime(DateUtil.date());
        reportOverview.setActTime(DateUtil.date());
        reportOverview.setLocation("有关地点");

        // 引言-演练概述
        RehearsalReportVO.ExerciseOverview exerciseOverview = new RehearsalReportVO.ExerciseOverview();
        exerciseOverview.setTarget("旨在检验和提升针对某个事故的应急响应能力。");
        exerciseOverview.setScene("详细描述演练的模拟情景，包括时间、地点、突发事件类型等。");
        // 引言-演练概述-参与单位部门列表
        List<RehearsalReportVO.People> peopleList = new ArrayList<>();
        RehearsalReportVO.People person = new RehearsalReportVO.People();
        person.setId(generator.next().toString());
        person.setDept("有关部门");
        person.setName("张三");
        person.setTask("有关任务");
        person.setPhone("13922225555");
        peopleList.add(person);
        exerciseOverview.setPeopleList(peopleList);

        // 演练实施情况
        RehearsalReportVO.Result result = new RehearsalReportVO.Result();
        result.setReport("评估事件报告的及时性、准确性、完整性，报告流程的规范性及报告内容的准确性。");
        result.setPlan("评估应急响应的及时性、有效性，是否能够有效组织应急工作。");
        result.setTreatment("评估参演人员对应急处置方案的熟悉程度，现场处置措施的合理性和有效性。");
        result.setCommunication("评估对外发布信息的及时性、准确性及沟通机制的有效性。");
        // 演练实施情况-资源调配
        RehearsalReportVO.Allocation allocation = new RehearsalReportVO.Allocation();
        allocation.setSummary("评估参演人员对应急处置方案的熟悉程度，现场处置措施的合理性和有效性。");
        allocation.setVideo("视频1，视频2，视频3");
        allocation.setPersonVideo("视频1，视频2，视频3");
        allocation.setExpert("大明，小红");
        allocation.setShelter("避难所1，避难所2");
        result.setAllocation(allocation);
        // 演练实施情况-应急处置相关任务
        List<RehearsalReportVO.Task> taskList = new ArrayList<>();
        RehearsalReportVO.Task task = new RehearsalReportVO.Task();
        task.setId(generator.next().toString());
        task.setDept("有关部门");
        task.setTask("相关任务");
        task.setStartTime(LocalDateTime.now());
        task.setEndTime(LocalDateTime.now());
        task.setTime(20);
        taskList.add(task);
        result.setTaskList(taskList);

        // 存在问题与不足
        RehearsalReportVO.Issue issue = new RehearsalReportVO.Issue();
        issue.setTech("指出在演练中发现的技术、设备或系统方面的问题。");
        issue.setFlow("分析应急预案的缺陷、流程不畅或冗余环节。");
        issue.setPerson("评估参演人员的专业知识、技能水平及团队协作能力。");
        issue.setResource("指出应急物资储备不足、调配困难或浪费现象。");
        issue.setCoordination("指出各部门间、上下级间的沟通障碍与协作不畅情况。");

        // 改进措施与建议
        RehearsalReportVO.Issue improvement = new RehearsalReportVO.Issue();
        improvement.setTech("提出对设备、技术或系统的升级、改造或优化建议。");
        improvement.setFlow("根据评估结果，修订应急预案，简化流程，提高效率。");
        improvement.setPerson("制定针对性的培训计划，提升人员专业技能和应急意识。");
        improvement.setResource("增加必要的应急物资储备，完善资源调配机制。");
        improvement.setCoordination("建立高效的沟通协调机制，加强部门间、上下级间的协作与联动。");

        report.setReportOverview(reportOverview);
        report.setExerciseOverview(exerciseOverview);
        report.setResult(result);
        report.setIssue(issue);
        report.setImprovement(improvement);

        return report;
    }
}
