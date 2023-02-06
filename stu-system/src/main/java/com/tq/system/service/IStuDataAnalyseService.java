package com.tq.system.service;

import com.tq.common.core.domain.AjaxResult;
import com.tq.system.domain.stu.StuStudent;
import com.tq.system.domain.vo.StudentUploadVo;

import java.util.List;
import java.util.Map;

/**
 * 数据分析Service接口
 * 
 * @author tq
 * @date 2022-11-22
 */
public interface IStuDataAnalyseService
{
    /**
     * 学生成绩数据分析
     * @return
     */
    Map searchStuAnalyse();

    /**
     * 课程成绩数据分析
     * @return
     */
    Map searchScoreAnalyse();
}
