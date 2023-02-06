package com.tq.system.mapper.stu;

import java.util.List;
import com.tq.system.domain.stu.StuTeacher;

/**
 * 教师Mapper接口
 * 
 * @author tq
 * @date 2022-11-22
 */
public interface StuTeacherMapper 
{
    /**
     * 查询教师
     * 
     * @param teaId 教师主键
     * @return 教师
     */
    public StuTeacher selectStuTeacherByTeaId(Long teaId);

    /**
     * 查询教师列表
     * 
     * @param stuTeacher 教师
     * @return 教师集合
     */
    public List<StuTeacher> selectStuTeacherList(StuTeacher stuTeacher);

    /**
     * 新增教师
     * 
     * @param stuTeacher 教师
     * @return 结果
     */
    public int insertStuTeacher(StuTeacher stuTeacher);

    /**
     * 修改教师
     * 
     * @param stuTeacher 教师
     * @return 结果
     */
    public int updateStuTeacher(StuTeacher stuTeacher);

    /**
     * 删除教师
     * 
     * @param teaId 教师主键
     * @return 结果
     */
    public int deleteStuTeacherByTeaId(Long teaId);

    /**
     * 批量删除教师
     * 
     * @param teaIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuTeacherByTeaIds(Long[] teaIds);
}
