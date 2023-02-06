package com.tq.system.service.impl;


import com.tq.system.mapper.stu.StuClassMapper;
import com.tq.system.mapper.stu.StuDepartmentMapper;
import com.tq.system.mapper.stu.StuMajorMapper;
import com.tq.system.mapper.stu.StuStudentMapper;
import com.tq.system.service.IStuDataAnalyseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * 数据分析Service业务层处理
 *
 * @author tq
 * @date 2022-11-22
 */
@Service
public class StuDataAnalyseServiceImpl implements IStuDataAnalyseService {
    @Autowired
    private StuStudentMapper stuStudentMapper;
    @Autowired
    private StuClassMapper stuClassMapper;
    @Autowired
    private StuDepartmentMapper stuDepartmentMapper;
    @Autowired
    private StuMajorMapper stuMajorMapper;

    /**
     * 学生成绩数据分析
     *
     * @return
     */
    @Override
    public Map searchStuAnalyse() {
        return null;
    }

    /**
     * 课程成绩数据分析
     *
     * @return
     */
    @Override
    public Map searchScoreAnalyse() {
        return null;
    }
}
