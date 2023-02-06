package com.tq.system.service;

import java.util.List;
import com.tq.system.domain.stu.StuClass;
import com.tq.system.domain.vo.StuClassVo;

/**
 * 班级Service接口
 * 
 * @author tq
 * @date 2022-11-22
 */
public interface IStuClassService 
{
    /**
     * 查询班级
     * 
     * @param classId 班级主键
     * @return 班级
     */
    public StuClass selectStuClassByClassId(Long classId);

    /**
     * 查询班级列表
     * 
     * @param stuClass 班级
     * @return 班级集合
     */
    public List<StuClass> selectStuClassList(StuClass stuClass);

    /**
     * 新增班级
     * 
     * @param stuClass 班级
     * @return 结果
     */
    public int insertStuClass(StuClass stuClass);

    /**
     * 修改班级
     * 
     * @param stuClass 班级
     * @return 结果
     */
    public int updateStuClass(StuClass stuClass);

    /**
     * 批量删除班级
     * 
     * @param classIds 需要删除的班级主键集合
     * @return 结果
     */
    public int deleteStuClassByClassIds(Long[] classIds);

    /**
     * 删除班级信息
     * 
     * @param classId 班级主键
     * @return 结果
     */
    public int deleteStuClassByClassId(Long classId);

    /**
     * 查询班级列表及下面的学生
     *
     * @param
     * @return 结果
     */
    List<StuClassVo> selectListOfStudent();

    /**
     * 查询学生列表 (查询的是还没生成账号的学生数据)
     *
     * @param
     * @return 结果
     */
    List<StuClassVo> listOfStudentByNullUserName();
}
