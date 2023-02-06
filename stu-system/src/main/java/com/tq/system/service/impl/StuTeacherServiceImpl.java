package com.tq.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tq.system.mapper.stu.StuTeacherMapper;
import com.tq.system.domain.stu.StuTeacher;
import com.tq.system.service.IStuTeacherService;

/**
 * 教师Service业务层处理
 * 
 * @author tq
 * @date 2022-11-22
 */
@Service
public class StuTeacherServiceImpl implements IStuTeacherService 
{
    @Autowired
    private StuTeacherMapper stuTeacherMapper;

    /**
     * 查询教师
     * 
     * @param teaId 教师主键
     * @return 教师
     */
    @Override
    public StuTeacher selectStuTeacherByTeaId(Long teaId)
    {
        return stuTeacherMapper.selectStuTeacherByTeaId(teaId);
    }

    /**
     * 查询教师列表
     * 
     * @param stuTeacher 教师
     * @return 教师
     */
    @Override
    public List<StuTeacher> selectStuTeacherList(StuTeacher stuTeacher)
    {
        return stuTeacherMapper.selectStuTeacherList(stuTeacher);
    }

    /**
     * 新增教师
     * 
     * @param stuTeacher 教师
     * @return 结果
     */
    @Override
    public int insertStuTeacher(StuTeacher stuTeacher)
    {
        return stuTeacherMapper.insertStuTeacher(stuTeacher);
    }

    /**
     * 修改教师
     * 
     * @param stuTeacher 教师
     * @return 结果
     */
    @Override
    public int updateStuTeacher(StuTeacher stuTeacher)
    {
        return stuTeacherMapper.updateStuTeacher(stuTeacher);
    }

    /**
     * 批量删除教师
     * 
     * @param teaIds 需要删除的教师主键
     * @return 结果
     */
    @Override
    public int deleteStuTeacherByTeaIds(Long[] teaIds)
    {
        return stuTeacherMapper.deleteStuTeacherByTeaIds(teaIds);
    }

    /**
     * 删除教师信息
     * 
     * @param teaId 教师主键
     * @return 结果
     */
    @Override
    public int deleteStuTeacherByTeaId(Long teaId)
    {
        return stuTeacherMapper.deleteStuTeacherByTeaId(teaId);
    }
}
