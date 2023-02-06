package com.tq.system.service.impl;

import java.util.List;

import com.tq.system.domain.stu.StuExamDetail;
import com.tq.system.mapper.stu.StuExamDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tq.system.service.IStuExamDetailService;

/**
 * 课程考试安排明细Service业务层处理
 * 
 * @author tq
 * @date 2022-11-28
 */
@Service
public class StuExamDetailServiceImpl implements IStuExamDetailService 
{
    @Autowired
    private StuExamDetailMapper stuExamDetailMapper;

    /**
     * 查询课程考试安排明细
     * 
     * @param examDetailId 课程考试安排明细主键
     * @return 课程考试安排明细
     */
    @Override
    public StuExamDetail selectStuExamDetailByExamDetailId(Long examDetailId)
    {
        return stuExamDetailMapper.selectStuExamDetailByExamDetailId(examDetailId);
    }

    /**
     * 查询课程考试安排明细列表
     * 
     * @param stuExamDetail 课程考试安排明细
     * @return 课程考试安排明细
     */
    @Override
    public List<StuExamDetail> selectStuExamDetailList(StuExamDetail stuExamDetail)
    {
        return stuExamDetailMapper.selectStuExamDetailList(stuExamDetail);
    }

    /**
     * 新增课程考试安排明细
     * 
     * @param stuExamDetail 课程考试安排明细
     * @return 结果
     */
    @Override
    public int insertStuExamDetail(StuExamDetail stuExamDetail)
    {
        return stuExamDetailMapper.insertStuExamDetail(stuExamDetail);
    }

    /**
     * 修改课程考试安排明细
     * 
     * @param stuExamDetail 课程考试安排明细
     * @return 结果
     */
    @Override
    public int updateStuExamDetail(StuExamDetail stuExamDetail)
    {
        return stuExamDetailMapper.updateStuExamDetail(stuExamDetail);
    }

    /**
     * 批量删除课程考试安排明细
     * 
     * @param examDetailIds 需要删除的课程考试安排明细主键
     * @return 结果
     */
    @Override
    public int deleteStuExamDetailByExamDetailIds(Long[] examDetailIds)
    {
        return stuExamDetailMapper.deleteStuExamDetailByExamDetailIds(examDetailIds);
    }

    /**
     * 删除课程考试安排明细信息
     * 
     * @param examDetailId 课程考试安排明细主键
     * @return 结果
     */
    @Override
    public int deleteStuExamDetailByExamDetailId(Long examDetailId)
    {
        return stuExamDetailMapper.deleteStuExamDetailByExamDetailId(examDetailId);
    }
}
