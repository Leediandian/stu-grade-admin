package com.tq.system.service.impl;

import java.util.List;

import com.tq.system.domain.stu.StuCourse;
import com.tq.system.mapper.stu.StuCourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tq.system.service.IStuCourseService;

/**
 * 课程Service业务层处理
 * 
 * @author tq
 * @date 2022-11-28
 */
@Service
public class StuCourseServiceImpl implements IStuCourseService 
{
    @Autowired
    private StuCourseMapper stuCourseMapper;

    /**
     * 查询课程
     * 
     * @param courseId 课程主键
     * @return 课程
     */
    @Override
    public StuCourse selectStuCourseByCourseId(Long courseId)
    {
        return stuCourseMapper.selectStuCourseByCourseId(courseId);
    }

    /**
     * 查询课程列表
     * 
     * @param stuCourse 课程
     * @return 课程
     */
    @Override
    public List<StuCourse> selectStuCourseList(StuCourse stuCourse)
    {
        return stuCourseMapper.selectStuCourseList(stuCourse);
    }

    /**
     * 新增课程
     * 
     * @param stuCourse 课程
     * @return 结果
     */
    @Override
    public int insertStuCourse(StuCourse stuCourse)
    {
        return stuCourseMapper.insertStuCourse(stuCourse);
    }

    /**
     * 修改课程
     * 
     * @param stuCourse 课程
     * @return 结果
     */
    @Override
    public int updateStuCourse(StuCourse stuCourse)
    {
        return stuCourseMapper.updateStuCourse(stuCourse);
    }

    /**
     * 批量删除课程
     * 
     * @param courseIds 需要删除的课程主键
     * @return 结果
     */
    @Override
    public int deleteStuCourseByCourseIds(Long[] courseIds)
    {
        return stuCourseMapper.deleteStuCourseByCourseIds(courseIds);
    }

    /**
     * 删除课程信息
     * 
     * @param courseId 课程主键
     * @return 结果
     */
    @Override
    public int deleteStuCourseByCourseId(Long courseId)
    {
        return stuCourseMapper.deleteStuCourseByCourseId(courseId);
    }
}
