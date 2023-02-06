package com.tq.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.tq.system.domain.stu.StuExamDetail;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tq.common.annotation.Log;
import com.tq.common.core.controller.BaseController;
import com.tq.common.core.domain.AjaxResult;
import com.tq.common.enums.BusinessType;
import com.tq.system.service.IStuExamDetailService;
import com.tq.common.utils.poi.ExcelUtil;
import com.tq.common.core.page.TableDataInfo;

/**
 * 课程考试安排明细Controller
 * 
 * @author tq
 * @date 2022-11-28
 */
@RestController
@RequestMapping("/system/detail")
public class StuExamDetailController extends BaseController
{
    @Autowired
    private IStuExamDetailService stuExamDetailService;

    /**
     * 查询课程考试安排明细列表
     */
    @PreAuthorize("@ss.hasPermi('system:detail:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuExamDetail stuExamDetail)
    {
        startPage();
        List<StuExamDetail> list = stuExamDetailService.selectStuExamDetailList(stuExamDetail);
        return getDataTable(list);
    }

    /**
     * 导出课程考试安排明细列表
     */
    @PreAuthorize("@ss.hasPermi('system:detail:export')")
    @Log(title = "课程考试安排明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuExamDetail stuExamDetail)
    {
        List<StuExamDetail> list = stuExamDetailService.selectStuExamDetailList(stuExamDetail);
        ExcelUtil<StuExamDetail> util = new ExcelUtil<StuExamDetail>(StuExamDetail.class);
        util.exportExcel(response, list, "课程考试安排明细数据");
    }

    /**
     * 获取课程考试安排明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:detail:query')")
    @GetMapping(value = "/{examDetailId}")
    public AjaxResult getInfo(@PathVariable("examDetailId") Long examDetailId)
    {
        return success(stuExamDetailService.selectStuExamDetailByExamDetailId(examDetailId));
    }

    /**
     * 新增课程考试安排明细
     */
    @PreAuthorize("@ss.hasPermi('system:detail:add')")
    @Log(title = "课程考试安排明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuExamDetail stuExamDetail)
    {
        return toAjax(stuExamDetailService.insertStuExamDetail(stuExamDetail));
    }

    /**
     * 修改课程考试安排明细
     */
    @PreAuthorize("@ss.hasPermi('system:detail:edit')")
    @Log(title = "课程考试安排明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuExamDetail stuExamDetail)
    {
        return toAjax(stuExamDetailService.updateStuExamDetail(stuExamDetail));
    }

    /**
     * 删除课程考试安排明细
     */
    @PreAuthorize("@ss.hasPermi('system:detail:remove')")
    @Log(title = "课程考试安排明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{examDetailIds}")
    public AjaxResult remove(@PathVariable Long[] examDetailIds)
    {
        return toAjax(stuExamDetailService.deleteStuExamDetailByExamDetailIds(examDetailIds));
    }
}
