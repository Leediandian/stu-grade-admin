package com.tq.system.service.impl;

import java.util.List;

import com.tq.system.domain.stu.StuGrade;
import com.tq.system.mapper.stu.StuGradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tq.system.service.IStuGradeService;

/**
 * 课程明细信息Service业务层处理
 * 
 * @author tq
 * @date 2022-11-28
 */
@Service
public class StuGradeServiceImpl implements IStuGradeService 
{
    @Autowired
    private StuGradeMapper stuGradeMapper;

    /**
     * 查询课程明细信息
     * 
     * @param gradeId 课程明细信息主键
     * @return 课程明细信息
     */
    @Override
    public StuGrade selectStuGradeByGradeId(Long gradeId)
    {
        return stuGradeMapper.selectStuGradeByGradeId(gradeId);
    }

    /**
     * 查询课程明细信息列表
     * 
     * @param stuGrade 课程明细信息
     * @return 课程明细信息
     */
    @Override
    public List<StuGrade> selectStuGradeList(StuGrade stuGrade)
    {
        return stuGradeMapper.selectStuGradeList(stuGrade);
    }

    /**
     * 新增课程明细信息
     * 
     * @param stuGrade 课程明细信息
     * @return 结果
     */
    @Override
    public int insertStuGrade(StuGrade stuGrade)
    {
        return stuGradeMapper.insertStuGrade(stuGrade);
    }

    /**
     * 修改课程明细信息
     * 
     * @param stuGrade 课程明细信息
     * @return 结果
     */
    @Override
    public int updateStuGrade(StuGrade stuGrade)
    {
        return stuGradeMapper.updateStuGrade(stuGrade);
    }

    /**
     * 批量删除课程明细信息
     * 
     * @param gradeIds 需要删除的课程明细信息主键
     * @return 结果
     */
    @Override
    public int deleteStuGradeByGradeIds(Long[] gradeIds)
    {
        return stuGradeMapper.deleteStuGradeByGradeIds(gradeIds);
    }

    /**
     * 删除课程明细信息信息
     * 
     * @param gradeId 课程明细信息主键
     * @return 结果
     */
    @Override
    public int deleteStuGradeByGradeId(Long gradeId)
    {
        return stuGradeMapper.deleteStuGradeByGradeId(gradeId);
    }

    /**
     * 批量新增课程明细信息
     *
     * @param stuGrade 课程明细信息
     * @return 结果
     */
    @Override
    public int insertMultipleStuGrade(List<StuGrade> stuGrade) {
        return stuGradeMapper.insertMultipleStuGrade(stuGrade);
    }
}
