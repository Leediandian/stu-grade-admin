package com.tq.system.service;

import java.util.List;
import java.util.Map;

import com.tq.common.core.domain.AjaxResult;
import com.tq.system.domain.stu.StuStudent;
import com.tq.system.domain.vo.StudentUploadVo;

/**
 * 学生Service接口
 * 
 * @author tq
 * @date 2022-11-22
 */
public interface IStuStudentService 
{
    /**
     * 查询学生
     * 
     * @param stuId 学生主键
     * @return 学生
     */
    public StuStudent selectStuStudentByStuId(Long stuId);

    /**
     * 查询学生列表
     * 
     * @param stuStudent 学生
     * @return 学生集合
     */
    public List<StuStudent> selectStuStudentList(StuStudent stuStudent);

    /**
     * 新增学生
     * 
     * @param stuStudent 学生
     * @return 结果
     */
    public int insertStuStudent(StuStudent stuStudent);

    /**
     * 修改学生
     * 
     * @param stuStudent 学生
     * @return 结果
     */
    public int updateStuStudent(StuStudent stuStudent);

    /**
     * 批量删除学生
     * 
     * @param stuIds 需要删除的学生主键集合
     * @return 结果
     */
    public int deleteStuStudentByStuIds(Long[] stuIds);

    /**
     * 删除学生信息
     * 
     * @param stuId 学生主键
     * @return 结果
     */
    public int deleteStuStudentByStuId(Long stuId);

    /**
     * 学生管理 通用搜索列表 院级/班级/专业
     *
     * @param
     * @return 结果
     */
    Map getSearchCommonList();

    /**
     * 学生管理 通过excel生成数据
     *
     * @param list
     * @return 结果
     */
    AjaxResult importList(List<StudentUploadVo> list);


}
