package com.tq.system.mapper.stu;

import java.util.List;
import com.tq.system.domain.stu.StuStudent;

/**
 * 学生Mapper接口
 * 
 * @author tq
 * @date 2022-11-22
 */
public interface StuStudentMapper 
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

    /**
     * 修改学生
     * 
     * @param stuStudent 学生
     * @return 结果
     */
    public int updateStuStudent(StuStudent stuStudent);

    /**
     * 删除学生
     * 
     * @param stuId 学生主键
     * @return 结果
     */
    public int deleteStuStudentByStuId(Long stuId);

    /**
     * 批量删除学生
     * 
     * @param stuIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuStudentByStuIds(Long[] stuIds);


}
