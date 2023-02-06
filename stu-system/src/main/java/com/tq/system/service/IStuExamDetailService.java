package com.tq.system.service;

import java.util.List;
import com.tq.system.domain.stu.StuExamDetail;

/**
 * 课程考试安排明细Service接口
 * 
 * @author tq
 * @date 2022-11-28
 */
public interface IStuExamDetailService 
{
    /**
     * 查询课程考试安排明细
     * 
     * @param examDetailId 课程考试安排明细主键
     * @return 课程考试安排明细
     */
    public StuExamDetail selectStuExamDetailByExamDetailId(Long examDetailId);

    /**
     * 查询课程考试安排明细列表
     * 
     * @param stuExamDetail 课程考试安排明细
     * @return 课程考试安排明细集合
     */
    public List<StuExamDetail> selectStuExamDetailList(StuExamDetail stuExamDetail);

    /**
     * 新增课程考试安排明细
     * 
     * @param stuExamDetail 课程考试安排明细
     * @return 结果
     */
    public int insertStuExamDetail(StuExamDetail stuExamDetail);

    /**
     * 修改课程考试安排明细
     * 
     * @param stuExamDetail 课程考试安排明细
     * @return 结果
     */
    public int updateStuExamDetail(StuExamDetail stuExamDetail);

    /**
     * 批量删除课程考试安排明细
     * 
     * @param examDetailIds 需要删除的课程考试安排明细主键集合
     * @return 结果
     */
    public int deleteStuExamDetailByExamDetailIds(Long[] examDetailIds);

    /**
     * 删除课程考试安排明细信息
     * 
     * @param examDetailId 课程考试安排明细主键
     * @return 结果
     */
    public int deleteStuExamDetailByExamDetailId(Long examDetailId);
}
