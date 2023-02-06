package com.tq.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tq.system.domain.stu.StuExam;
import com.tq.system.domain.stu.StuExamDetail;
import com.tq.system.domain.stu.StuGrade;
import com.tq.system.mapper.stu.StuCourseMapper;
import com.tq.system.mapper.stu.StuExamDetailMapper;
import com.tq.system.mapper.stu.StuExamMapper;
import com.tq.system.mapper.stu.StuGradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tq.system.service.IStuExamService;

/**
 * 课程考试安排Service业务层处理
 * 
 * @author tq
 * @date 2022-11-28
 */
@Service
public class StuExamServiceImpl implements IStuExamService 
{
    @Autowired
    private StuExamMapper stuExamMapper;

    @Autowired
    private StuExamDetailMapper stuExamDetailMapper;

    @Autowired
    private StuGradeMapper stuGradeMapper;

    /**
     * 查询课程考试安排
     * 
     * @param examId 课程考试安排主键
     * @return 课程考试安排
     */
    @Override
    public StuExam selectStuExamByExamId(Long examId)
    {
        return stuExamMapper.selectStuExamByExamId(examId);
    }

    /**
     * 查询课程考试安排列表
     * 
     * @param stuExam 课程考试安排
     * @return 课程考试安排
     */
    @Override
    public List<StuExam> selectStuExamList(StuExam stuExam)
    {
        return stuExamMapper.selectStuExamList(stuExam);
    }

    /**
     * 新增课程考试安排
     * 
     * @param stuExam 课程考试安排
     * @return 结果
     */
    @Override
    public int insertStuExam(StuExam stuExam)
    {
        int flot = stuExamMapper.insertStuExam(stuExam);
        System.out.println(flot);
        StuGrade stuGrade = new StuGrade();
        stuGrade.setCourseId(stuExam.getCourseId());
        //新增课程考试后把其下面的学生也添加进去
        List<StuGrade> list = stuGradeMapper.selectStuGradeList(stuGrade);
        List<StuExamDetail> elist = new ArrayList<>();
        for(int i =0;i<list.size();i++){
            StuExamDetail stuExamDetail = new StuExamDetail();
            stuExamDetail.setStuId(list.get(i).getStuId());
            stuExamDetail.setExamId(stuExam.getExamId());
            elist.add(stuExamDetail);
        }
        elist.forEach((e) -> {
            stuExamDetailMapper.insertStuExamDetail(e);
        });
        //课程明细信息 修改其考试编号
        list.forEach((e) -> {
            e.setExamId(stuExam.getExamId());
            stuGradeMapper.updateStuGrade(e);
        });
        return flot;
    }

    /**
     * 修改课程考试安排
     * 
     * @param stuExam 课程考试安排
     * @return 结果
     */
    @Override
    public int updateStuExam(StuExam stuExam)
    {
        return stuExamMapper.updateStuExam(stuExam);
    }

    /**
     * 批量删除课程考试安排
     * 
     * @param examIds 需要删除的课程考试安排主键
     * @return 结果
     */
    @Override
    public int deleteStuExamByExamIds(Long[] examIds)
    {
        return stuExamMapper.deleteStuExamByExamIds(examIds);
    }

    /**
     * 删除课程考试安排信息
     * 
     * @param examId 课程考试安排主键
     * @return 结果
     */
    @Override
    public int deleteStuExamByExamId(Long examId)
    {
        return stuExamMapper.deleteStuExamByExamId(examId);
    }
}
