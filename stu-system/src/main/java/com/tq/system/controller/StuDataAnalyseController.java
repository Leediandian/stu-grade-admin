package com.tq.system.controller;


import com.tq.common.core.controller.BaseController;
import com.tq.common.core.domain.AjaxResult;
import com.tq.system.domain.stu.StuDataAnalyse;
import com.tq.system.service.IStuDataAnalyseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数据统计Controller
 *
 * @author tq
 * @date 2022-12-22
 */
@RestController
@RequestMapping("/system/analyse")
public class StuDataAnalyseController extends BaseController {
    @Autowired
    private IStuDataAnalyseService stuDataAnalyseService;

    /**
     * 查询单一个学生全部成绩数据分析
     */
    @PreAuthorize("@ss.hasPermi('system:analyse:stuAnalyse')")
    @PostMapping("/stuAnalyse")
    public AjaxResult searchStuAnalyse(StuDataAnalyse stuDataAnalyse) {
        List<StuDataAnalyse> list = stuDataAnalyseService.searchStuAnalyse(stuDataAnalyse);
        return success(list);
    }

    /**
     * 查询该课程里所有学生的成绩数据分析
     */
    @PreAuthorize("@ss.hasPermi('system:analyse:scoreAnalyse')")
    @PostMapping("/scoreAnalyse")
    public AjaxResult searchScoreAnalyse(StuDataAnalyse stuDataAnalyse) {
        List<StuDataAnalyse> list = stuDataAnalyseService.searchScoreAnalyse(stuDataAnalyse);
        return success(list);
    }


}
