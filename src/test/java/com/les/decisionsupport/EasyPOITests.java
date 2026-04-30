package com.les.decisionsupport;

import cn.afterturn.easypoi.word.WordExportUtil;
import cn.hutool.core.io.FileUtil;
import com.les.decisionsupport.ods.rehearsal.util.RehearsalUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileOutputStream;
import java.util.HashMap;

@Slf4j
class EasyPOITests {

    final static String inSrcPath = "template/rehearsal_template.docx";
    final static String outSrcPath = "template";
    final static String outFileName = "rehearsal_generated.docx";

    @Test
    void POITest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext();
        try {
            String isrc = FileUtil.getAbsolutePath(ctx.getResource(inSrcPath).getFile());
            String osrc = FileUtil.getAbsolutePath(ctx.getResource(outSrcPath).getFile()) + "\\" + outFileName;

            log.info("{}", isrc);
            log.info("{}", osrc);

            var report = RehearsalUtil.CreateRehearsalReport();

            var dataMap = new HashMap<String, Object>();
            dataMap.put("report", report);
            dataMap.put("reportOverview", report.getReportOverview());
            dataMap.put("exerciseOverview", report.getExerciseOverview());
            dataMap.put("result", report.getResult());
            dataMap.put("issue", report.getIssue());
            dataMap.put("improvement", report.getImprovement());

            XWPFDocument doc = WordExportUtil.exportWord07(isrc, dataMap);
            FileOutputStream fos = new FileOutputStream(osrc);
            doc.write(fos);
            fos.close();
            log.info("Word 文档生成成功!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
