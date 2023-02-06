package com.tq.system.mapper.stu;

import com.tq.system.domain.stu.StuStudent;

import java.util.List;

/**
 * 数据分析Mapper接口
 * 
 * @author tq
 * @date 2022-12-22
 */
public interface StuDataAnalyseMapper
{
    /**
     * 查询学生
     * 
     * @param stuId 学生主键
     * @return 学生
     */
    public StuStudent selectStuStudentByStuId(Long stuId);

    /**
     * 查询学生列表
     * 
     * @param stuStudent 学生
     * @return 学生集合
     */
    public List<StuStudent> selectStuStudentList(StuStudent stuStudent);

    /**
     * 新增学生
     * 
     * @param stuStudent 学生
     * @return 结果
     */
    public int insertStuStudent(StuStudent stuStudent);



}
