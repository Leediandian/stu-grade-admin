package com.tq.system.service.impl;

import java.util.List;

import com.tq.system.domain.stu.StuGradeObjection;
import com.tq.system.mapper.stu.StuGradeObjectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tq.system.service.IStuGradeObjectionService;

/**
 * 成绩异议处理记录Service业务层处理
 * 
 * @author tq
 * @date 2022-11-28
 */
@Service
public class StuGradeObjectionServiceImpl implements IStuGradeObjectionService 
{
    @Autowired
    private StuGradeObjectionMapper stuGradeObjectionMapper;

    /**
     * 查询成绩异议处理记录
     * 
     * @param gradeObjId 成绩异议处理记录主键
     * @return 成绩异议处理记录
     */
    @Override
    public StuGradeObjection selectStuGradeObjectionByGradeObjId(Long gradeObjId)
    {
        return stuGradeObjectionMapper.selectStuGradeObjectionByGradeObjId(gradeObjId);
    }

    /**
     * 查询成绩异议处理记录列表
     * 
     * @param stuGradeObjection 成绩异议处理记录
     * @return 成绩异议处理记录
     */
    @Override
    public List<StuGradeObjection> selectStuGradeObjectionList(StuGradeObjection stuGradeObjection)
    {
        return stuGradeObjectionMapper.selectStuGradeObjectionList(stuGradeObjection);
    }

    /**
     * 新增成绩异议处理记录
     * 
     * @param stuGradeObjection 成绩异议处理记录
     * @return 结果
     */
    @Override
    public int insertStuGradeObjection(StuGradeObjection stuGradeObjection)
    {
        return stuGradeObjectionMapper.insertStuGradeObjection(stuGradeObjection);
    }

    /**
     * 修改成绩异议处理记录
     * 
     * @param stuGradeObjection 成绩异议处理记录
     * @return 结果
     */
    @Override
    public int updateStuGradeObjection(StuGradeObjection stuGradeObjection)
    {
        return stuGradeObjectionMapper.updateStuGradeObjection(stuGradeObjection);
    }

    /**
     * 批量删除成绩异议处理记录
     * 
     * @param gradeObjIds 需要删除的成绩异议处理记录主键
     * @return 结果
     */
    @Override
    public int deleteStuGradeObjectionByGradeObjIds(Long[] gradeObjIds)
    {
        return stuGradeObjectionMapper.deleteStuGradeObjectionByGradeObjIds(gradeObjIds);
    }

    /**
     * 删除成绩异议处理记录信息
     * 
     * @param gradeObjId 成绩异议处理记录主键
     * @return 结果
     */
    @Override
    public int deleteStuGradeObjectionByGradeObjId(Long gradeObjId)
    {
        return stuGradeObjectionMapper.deleteStuGradeObjectionByGradeObjId(gradeObjId);
    }
}
