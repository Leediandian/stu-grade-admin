package com.tq.system.service.impl;

import java.util.List;

import com.tq.system.domain.vo.StuClassVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tq.system.mapper.stu.StuClassMapper;
import com.tq.system.domain.stu.StuClass;
import com.tq.system.service.IStuClassService;

/**
 * 班级Service业务层处理
 * 
 * @author tq
 * @date 2022-11-22
 */
@Service
public class StuClassServiceImpl implements IStuClassService 
{
    @Autowired
    private StuClassMapper stuClassMapper;

    /**
     * 查询班级
     * 
     * @param classId 班级主键
     * @return 班级
     */
    @Override
    public StuClass selectStuClassByClassId(Long classId)
    {
        return stuClassMapper.selectStuClassByClassId(classId);
    }

    /**
     * 查询班级列表
     * 
     * @param stuClass 班级
     * @return 班级
     */
    @Override
    public List<StuClass> selectStuClassList(StuClass stuClass)
    {
        return stuClassMapper.selectStuClassList(stuClass);
    }

    /**
     * 新增班级
     * 
     * @param stuClass 班级
     * @return 结果
     */
    @Override
    public int insertStuClass(StuClass stuClass)
    {
        return stuClassMapper.insertStuClass(stuClass);
    }

    /**
     * 修改班级
     * 
     * @param stuClass 班级
     * @return 结果
     */
    @Override
    public int updateStuClass(StuClass stuClass)
    {
        return stuClassMapper.updateStuClass(stuClass);
    }

    /**
     * 批量删除班级
     * 
     * @param classIds 需要删除的班级主键
     * @return 结果
     */
    @Override
    public int deleteStuClassByClassIds(Long[] classIds)
    {
        return stuClassMapper.deleteStuClassByClassIds(classIds);
    }

    /**
     * 删除班级信息
     * 
     * @param classId 班级主键
     * @return 结果
     */
    @Override
    public int deleteStuClassByClassId(Long classId)
    {
        return stuClassMapper.deleteStuClassByClassId(classId);
    }

    /**
     * 查询班级列表及下面的学生列表
     *
     * @param
     * @return 结果
     */
    @Override
    public List<StuClassVo> selectListOfStudent() {
        return stuClassMapper.selectListOfStudent();
    }

    /**
     * 查询班级列表及下面的学生列表 (查询的是还没生成账号的学生数据)
     *
     * @param
     * @return 结果
     */
    @Override
    public List<StuClassVo> listOfStudentByNullUserName() {
        return stuClassMapper.selectListOfStudentByNullUserName();
    }
}
