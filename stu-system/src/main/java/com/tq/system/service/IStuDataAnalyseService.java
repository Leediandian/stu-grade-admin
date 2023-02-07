package com.tq.system.service;

import com.tq.system.domain.stu.StuDataAnalyse;

import java.util.List;

/**
 * 数据分析Service接口
 *
 * @author tq
 * @date 2022-11-22
 */
public interface IStuDataAnalyseService {
    /**
     * 查询单一个学生全部成绩数据分析
     *
     * @return
     */
    List<StuDataAnalyse> searchStuAnalyse(StuDataAnalyse stuDataAnalyse);

    /**
     * 查询该课程里所有学生的成绩数据分析
     *
     * @return
     */
    List<StuDataAnalyse> searchScoreAnalyse(StuDataAnalyse stuDataAnalyse);
}
