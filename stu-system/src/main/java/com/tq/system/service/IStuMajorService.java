package com.tq.system.service;

import java.util.List;
import com.tq.system.domain.stu.StuMajor;

/**
 * 专业Service接口
 * 
 * @author tq
 * @date 2022-11-22
 */
public interface IStuMajorService 
{
    /**
     * 查询专业
     * 
     * @param majorId 专业主键
     * @return 专业
     */
    public StuMajor selectStuMajorByMajorId(Long majorId);

    /**
     * 查询专业列表
     * 
     * @param stuMajor 专业
     * @return 专业集合
     */
    public List<StuMajor> selectStuMajorList(StuMajor stuMajor);

    /**
     * 新增专业
     * 
     * @param stuMajor 专业
     * @return 结果
     */
    public int insertStuMajor(StuMajor stuMajor);

    /**
     * 修改专业
     * 
     * @param stuMajor 专业
     * @return 结果
     */
    public int updateStuMajor(StuMajor stuMajor);

    /**
     * 批量删除专业
     * 
     * @param majorIds 需要删除的专业主键集合
     * @return 结果
     */
    public int deleteStuMajorByMajorIds(Long[] majorIds);

    /**
     * 删除专业信息
     * 
     * @param majorId 专业主键
     * @return 结果
     */
    public int deleteStuMajorByMajorId(Long majorId);
}
