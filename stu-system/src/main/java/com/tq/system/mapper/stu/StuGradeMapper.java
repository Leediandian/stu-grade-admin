package com.tq.system.mapper.stu;

import com.tq.system.domain.stu.StuGrade;

import java.util.List;

/**
 * 课程明细信息Mapper接口
 * 
 * @author tq
 * @date 2022-11-28
 */
public interface StuGradeMapper 
{
    /**
     * 查询课程明细信息
     * 
     * @param gradeId 课程明细信息主键
     * @return 课程明细信息
     */
    public StuGrade selectStuGradeByGradeId(Long gradeId);

    /**
     * 查询课程明细信息列表
     * 
     * @param stuGrade 课程明细信息
     * @return 课程明细信息集合
     */
    public List<StuGrade> selectStuGradeList(StuGrade stuGrade);

    /**
     * 新增课程明细信息
     * 
     * @param stuGrade 课程明细信息
     * @return 结果
     */
    public int insertStuGrade(StuGrade stuGrade);

    /**
     * 修改课程明细信息
     * 
     * @param stuGrade 课程明细信息
     * @return 结果
     */
    public int updateStuGrade(StuGrade stuGrade);

    /**
     * 删除课程明细信息
     * 
     * @param gradeId 课程明细信息主键
     * @return 结果
     */
    public int deleteStuGradeByGradeId(Long gradeId);

    /**
     * 批量删除课程明细信息
     * 
     * @param gradeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuGradeByGradeIds(Long[] gradeIds);

    /**
     * 批量新增课程明细信息
     *
     * @param stuGrade 课程明细信息
     * @return 结果
     */
    public int insertMultipleStuGrade(List<StuGrade> stuGrade);
}
