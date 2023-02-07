package com.tq.system.service.impl;


import com.tq.system.domain.stu.StuDataAnalyse;
import com.tq.system.mapper.stu.*;
import com.tq.system.service.IStuDataAnalyseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 数据分析Service业务层处理
 *
 * @author tq
 * @date 2022-11-22
 */
@Service
public class StuDataAnalyseServiceImpl implements IStuDataAnalyseService {
    @Autowired
    private StuAnalyseMapper stuAnalyseMapper;


    /**
     * 查询单一个学生全部成绩数据分析
     *
     * @return 学生数据分析集合
     */
    @Override
    public List<StuDataAnalyse> searchStuAnalyse(StuDataAnalyse stuDataAnalyse) {
        return stuAnalyseMapper.searchStuAnalyse(stuDataAnalyse);
    }

    /**
     * 查询该课程里所有学生的成绩数据分析
     *
     * @return 学生数据分析集合
     */
    @Override
    public List<StuDataAnalyse> searchScoreAnalyse(StuDataAnalyse stuDataAnalyse) {
        return stuAnalyseMapper.searchScoreAnalyse(stuDataAnalyse);
    }
}
