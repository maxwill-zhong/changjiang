package com.les.decisionsupport.ods.rehearsal.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class RehearsalReportVO {

    @Data
    public static class ReportOverview {
        private String dept;      // 单位
        private Date editTime;    // 编制日期
        private Date actTime;     // 演练时间
        private String location;  // 演练地点
    }

    @Data
    public static class People {
        private String id;
        private String dept;
        private String name;
        private String phone;
        private String task;
    }
    @Data
    public static class ExerciseOverview {
        private String target;           // 演练目的
        private String scene;            // 演练场景
        private List<People> peopleList; // 参与人员
    }

    @Data
    public static class Task {
        private String id;
        private String dept;
        private String task;
        private LocalDateTime startTime;  // 编制日期
        private LocalDateTime endTime;    // 演练时间
        private Integer time;
    }

    @Data
    public static class Result {
        private String report;          // 报告
        private String plan;            // 预案
        private String treatment;       // 处置
        private Allocation allocation;  // 分配
        private String communication;   // 交流
        private List<Task> taskList;    // 任务列表
    }

    @Data
    public static class Allocation {
        private String summary;      // 总结
        private String video;        // 视频列表
        private String personVideo;  // 人员视频列表
        private String expert;       // 专家列表
        private String shelter;      // 避难所列表
    }

    @Data
    public static class Issue {
        private String tech;          // 技术问题
        private String flow;          // 流程问题
        private String person;        // 人员问题
        private String resource;      // 资源问题
        private String coordination;  // 协调问题
    }

    private String title;                       // 报告标题
    private ReportOverview reportOverview;      // 报告概述
    private ExerciseOverview exerciseOverview;  // 报告概述
    private Result result;                      // 演练结果
    private Issue issue;                        // 问题
    private Issue improvement;                  // 提高
    private String conclusion;                  // 报告概述
}
