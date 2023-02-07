package com.tq.system.mapper.stu;

import com.tq.system.domain.stu.StuDataAnalyse;

import java.util.List;

/**
 * 课程明细信息Mapper接口
 * 
 * @author tq
 * @date 2022-11-28
 */
public interface StuAnalyseMapper
{

    /**
     * 查询单一个学生全部成绩数据分析
     * 
     * @param stuGrade 课程明细信息
     * @return 学生数据分析集合
     */
    public List<StuDataAnalyse> searchStuAnalyse(StuDataAnalyse stuGrade);

    /**
     * 查询该课程里所有学生的成绩数据分析
     *
     * @param stuGrade 课程明细信息
     * @return 学生数据分析集合
     */
    public List<StuDataAnalyse> searchScoreAnalyse(StuDataAnalyse stuGrade);


}
