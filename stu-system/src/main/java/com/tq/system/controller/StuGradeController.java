package com.tq.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.tq.system.domain.stu.StuGrade;
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
import com.tq.system.service.IStuGradeService;
import com.tq.common.utils.poi.ExcelUtil;
import com.tq.common.core.page.TableDataInfo;

/**
 * 课程明细信息Controller
 * 
 * @author tq
 * @date 2022-11-28
 */
@RestController
@RequestMapping("/system/grade")
public class StuGradeController extends BaseController
{
    @Autowired
    private IStuGradeService stuGradeService;

    /**
     * 查询课程明细信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:grade:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuGrade stuGrade)
    {
        startPage();
        List<StuGrade> list = stuGradeService.selectStuGradeList(stuGrade);
        return getDataTable(list);
    }


    /**
     * 查询全部课程明细信息列表 不分頁
     */
    @PreAuthorize("@ss.hasPermi('system:grade:allList')")
    @GetMapping("/allList")
    public AjaxResult allList(StuGrade stuGrade)
    {
        List<StuGrade> list = stuGradeService.selectStuGradeList(stuGrade);
        return success(list);
    }

    /**
     * 导出课程明细信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:grade:export')")
    @Log(title = "课程明细信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuGrade stuGrade)
    {
        List<StuGrade> list = stuGradeService.selectStuGradeList(stuGrade);
        ExcelUtil<StuGrade> util = new ExcelUtil<StuGrade>(StuGrade.class);
        util.exportExcel(response, list, "课程明细信息数据");
    }

    /**
     * 获取课程明细信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:grade:query')")
    @GetMapping(value = "/{gradeId}")
    public AjaxResult getInfo(@PathVariable("gradeId") Long gradeId)
    {
        return success(stuGradeService.selectStuGradeByGradeId(gradeId));
    }

    /**
     * 新增课程明细信息
     */
    @PreAuthorize("@ss.hasPermi('system:grade:add')")
    @Log(title = "课程明细信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuGrade stuGrade)
    {
        return toAjax(stuGradeService.insertStuGrade(stuGrade));
    }

    /**
     * 修改课程明细信息
     */
    @PreAuthorize("@ss.hasPermi('system:grade:edit')")
    @Log(title = "课程明细信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuGrade stuGrade)
    {
        return toAjax(stuGradeService.updateStuGrade(stuGrade));
    }

    /**
     * 删除课程明细信息
     */
    @PreAuthorize("@ss.hasPermi('system:grade:remove')")
    @Log(title = "课程明细信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{gradeIds}")
    public AjaxResult remove(@PathVariable Long[] gradeIds)
    {
        return toAjax(stuGradeService.deleteStuGradeByGradeIds(gradeIds));
    }


    /**
     * 批量新增课程明细信息
     */
    @PreAuthorize("@ss.hasPermi('system:grade:addMultiple')")
    @Log(title = "批量新增课程明细信息", businessType = BusinessType.INSERT)
    @PostMapping("/addMultiple")
    public AjaxResult addMultiple(@RequestBody List<StuGrade> stuGrade)
    {
        return toAjax(stuGradeService.insertMultipleStuGrade(stuGrade));
    }
}
