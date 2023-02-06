package com.tq.system.service.impl;

import java.util.List;

import com.tq.system.domain.vo.StuDepartmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tq.system.mapper.stu.StuDepartmentMapper;
import com.tq.system.domain.stu.StuDepartment;
import com.tq.system.service.IStuDepartmentService;

/**
 * 院系Service业务层处理
 * 
 * @author tq
 * @date 2022-11-22
 */
@Service
public class StuDepartmentServiceImpl implements IStuDepartmentService 
{
    @Autowired
    private StuDepartmentMapper stuDepartmentMapper;

    /**
     * 查询院系
     * 
     * @param departmentId 院系主键
     * @return 院系
     */
    @Override
    public StuDepartment selectStuDepartmentByDepartmentId(Long departmentId)
    {
        return stuDepartmentMapper.selectStuDepartmentByDepartmentId(departmentId);
    }

    /**
     * 查询院系列表
     * 
     * @param stuDepartment 院系
     * @return 院系
     */
    @Override
    public List<StuDepartment> selectStuDepartmentList(StuDepartment stuDepartment)
    {
        return stuDepartmentMapper.selectStuDepartmentList(stuDepartment);
    }

    /**
     * 询院系列表以及下面的专业
     *
     * @param stuDepartment 院系
     * @return 院系
     */
    @Override
    public List<StuDepartmentVo> selectStuDepartmentChildrenList(StuDepartment stuDepartment) {
        return stuDepartmentMapper.selectStuDepartmentChildrenList(stuDepartment);
    }

    /**
     * 新增院系
     * 
     * @param stuDepartment 院系
     * @return 结果
     */
    @Override
    public int insertStuDepartment(StuDepartment stuDepartment)
    {
        return stuDepartmentMapper.insertStuDepartment(stuDepartment);
    }

    /**
     * 修改院系
     * 
     * @param stuDepartment 院系
     * @return 结果
     */
    @Override
    public int updateStuDepartment(StuDepartment stuDepartment)
    {
        return stuDepartmentMapper.updateStuDepartment(stuDepartment);
    }

    /**
     * 批量删除院系
     * 
     * @param departmentIds 需要删除的院系主键
     * @return 结果
     */
    @Override
    public int deleteStuDepartmentByDepartmentIds(Long[] departmentIds)
    {
        return stuDepartmentMapper.deleteStuDepartmentByDepartmentIds(departmentIds);
    }

    /**
     * 删除院系信息
     * 
     * @param departmentId 院系主键
     * @return 结果
     */
    @Override
    public int deleteStuDepartmentByDepartmentId(Long departmentId)
    {
        return stuDepartmentMapper.deleteStuDepartmentByDepartmentId(departmentId);
    }
}
