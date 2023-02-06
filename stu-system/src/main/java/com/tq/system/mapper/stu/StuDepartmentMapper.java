package com.tq.system.mapper.stu;

import java.util.List;
import com.tq.system.domain.stu.StuDepartment;
import com.tq.system.domain.vo.StuDepartmentVo;

/**
 * 院系Mapper接口
 * 
 * @author tq
 * @date 2022-11-22
 */
public interface StuDepartmentMapper 
{
    /**
     * 查询院系
     * 
     * @param departmentId 院系主键
     * @return 院系
     */
    public StuDepartment selectStuDepartmentByDepartmentId(Long departmentId);

    /**
     * 查询院系列表
     * 
     * @param stuDepartment 院系
     * @return 院系集合
     */
    public List<StuDepartment> selectStuDepartmentList(StuDepartment stuDepartment);

    /**
     * 查询院系列表-以及下面的专业
     *
     * @param stuDepartment 院系
     * @return 院系集合以及children
     */
    public List<StuDepartmentVo> selectStuDepartmentChildrenList(StuDepartment stuDepartment);

    /**
     * 新增院系
     * 
     * @param stuDepartment 院系
     * @return 结果
     */
    public int insertStuDepartment(StuDepartment stuDepartment);

    /**
     * 修改院系
     * 
     * @param stuDepartment 院系
     * @return 结果
     */
    public int updateStuDepartment(StuDepartment stuDepartment);

    /**
     * 删除院系
     * 
     * @param departmentId 院系主键
     * @return 结果
     */
    public int deleteStuDepartmentByDepartmentId(Long departmentId);

    /**
     * 批量删除院系
     * 
     * @param departmentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuDepartmentByDepartmentIds(Long[] departmentIds);
}
