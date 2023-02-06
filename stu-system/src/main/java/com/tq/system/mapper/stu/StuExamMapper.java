package com.tq.system.mapper.stu;

import java.util.List;
import com.tq.system.domain.stu.StuExam;

/**
 * 课程考试安排Mapper接口
 * 
 * @author tq
 * @date 2022-11-28
 */
public interface StuExamMapper 
{
    /**
     * 查询课程考试安排
     * 
     * @param examId 课程考试安排主键
     * @return 课程考试安排
     */
    public StuExam selectStuExamByExamId(Long examId);

    /**
     * 查询课程考试安排列表
     * 
     * @param stuExam 课程考试安排
     * @return 课程考试安排集合
     */
    public List<StuExam> selectStuExamList(StuExam stuExam);

    /**
     * 新增课程考试安排
     * 
     * @param stuExam 课程考试安排
     * @return 结果
     */
    public int insertStuExam(StuExam stuExam);

    /**
     * 修改课程考试安排
     * 
     * @param stuExam 课程考试安排
     * @return 结果
     */
    public int updateStuExam(StuExam stuExam);

    /**
     * 删除课程考试安排
     * 
     * @param examId 课程考试安排主键
     * @return 结果
     */
    public int deleteStuExamByExamId(Long examId);

    /**
     * 批量删除课程考试安排
     * 
     * @param examIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuExamByExamIds(Long[] examIds);
}
