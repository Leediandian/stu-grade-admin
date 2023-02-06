package com.tq.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tq.system.mapper.stu.StuMajorMapper;
import com.tq.system.domain.stu.StuMajor;
import com.tq.system.service.IStuMajorService;

/**
 * 专业Service业务层处理
 * 
 * @author tq
 * @date 2022-11-22
 */
@Service
public class StuMajorServiceImpl implements IStuMajorService 
{
    @Autowired
    private StuMajorMapper stuMajorMapper;

    /**
     * 查询专业
     * 
     * @param majorId 专业主键
     * @return 专业
     */
    @Override
    public StuMajor selectStuMajorByMajorId(Long majorId)
    {
        return stuMajorMapper.selectStuMajorByMajorId(majorId);
    }

    /**
     * 查询专业列表
     * 
     * @param stuMajor 专业
     * @return 专业
     */
    @Override
    public List<StuMajor> selectStuMajorList(StuMajor stuMajor)
    {
        return stuMajorMapper.selectStuMajorList(stuMajor);
    }

    /**
     * 新增专业
     * 
     * @param stuMajor 专业
     * @return 结果
     */
    @Override
    public int insertStuMajor(StuMajor stuMajor)
    {
        return stuMajorMapper.insertStuMajor(stuMajor);
    }

    /**
     * 修改专业
     * 
     * @param stuMajor 专业
     * @return 结果
     */
    @Override
    public int updateStuMajor(StuMajor stuMajor)
    {
        return stuMajorMapper.updateStuMajor(stuMajor);
    }

    /**
     * 批量删除专业
     * 
     * @param majorIds 需要删除的专业主键
     * @return 结果
     */
    @Override
    public int deleteStuMajorByMajorIds(Long[] majorIds)
    {
        return stuMajorMapper.deleteStuMajorByMajorIds(majorIds);
    }

    /**
     * 删除专业信息
     * 
     * @param majorId 专业主键
     * @return 结果
     */
    @Override
    public int deleteStuMajorByMajorId(Long majorId)
    {
        return stuMajorMapper.deleteStuMajorByMajorId(majorId);
    }
}
