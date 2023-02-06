package com.tq.system.mapper.stu;

import java.util.List;
import com.tq.system.domain.stu.StuGradeObjection;

/**
 * 成绩异议处理记录Mapper接口
 * 
 * @author tq
 * @date 2022-11-28
 */
public interface StuGradeObjectionMapper 
{
    /**
     * 查询成绩异议处理记录
     * 
     * @param gradeObjId 成绩异议处理记录主键
     * @return 成绩异议处理记录
     */
    public StuGradeObjection selectStuGradeObjectionByGradeObjId(Long gradeObjId);

    /**
     * 查询成绩异议处理记录列表
     * 
     * @param stuGradeObjection 成绩异议处理记录
     * @return 成绩异议处理记录集合
     */
    public List<StuGradeObjection> selectStuGradeObjectionList(StuGradeObjection stuGradeObjection);

    /**
     * 新增成绩异议处理记录
     * 
     * @param stuGradeObjection 成绩异议处理记录
     * @return 结果
     */
    public int insertStuGradeObjection(StuGradeObjection stuGradeObjection);

    /**
     * 修改成绩异议处理记录
     * 
     * @param stuGradeObjection 成绩异议处理记录
     * @return 结果
     */
    public int updateStuGradeObjection(StuGradeObjection stuGradeObjection);

    /**
     * 删除成绩异议处理记录
     * 
     * @param gradeObjId 成绩异议处理记录主键
     * @return 结果
     */
    public int deleteStuGradeObjectionByGradeObjId(Long gradeObjId);

    /**
     * 批量删除成绩异议处理记录
     * 
     * @param gradeObjIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuGradeObjectionByGradeObjIds(Long[] gradeObjIds);
}
