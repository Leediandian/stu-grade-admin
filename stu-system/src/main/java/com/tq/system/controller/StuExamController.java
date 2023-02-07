package com.tq.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.tq.system.domain.stu.StuExam;
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
import com.tq.system.service.IStuExamService;
import com.tq.common.utils.poi.ExcelUtil;
import com.tq.common.core.page.TableDataInfo;

/**
 * 课程考试安排Controller
 * 
 * @author tq
 * @date 2022-11-28
 */
@RestController
@RequestMapping("/system/exam")
public class StuExamController extends BaseController
{
    @Autowired
    private IStuExamService stuExamService;

    /**
     * 查询课程考试安排列表
     */
    @PreAuthorize("@ss.hasPermi('system:exam:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuExam stuExam)
    {
        startPage();
        List<StuExam> list = stuExamService.selectStuExamList(stuExam);
        return getDataTable(list);
    }

    /**
     * 查询课程考试安排所有列表 不分页
     */
    @PreAuthorize("@ss.hasPermi('system:exam:allList')")
    @GetMapping("/allList")
    public AjaxResult allList()
    {
        List<StuExam> list = stuExamService.selectStuExamList(new StuExam());
        return success(list);
    }

    /**
     * 导出课程考试安排列表
     */
    @PreAuthorize("@ss.hasPermi('system:exam:export')")
    @Log(title = "课程考试安排", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuExam stuExam)
    {
        List<StuExam> list = stuExamService.selectStuExamList(stuExam);
        ExcelUtil<StuExam> util = new ExcelUtil<StuExam>(StuExam.class);
        util.exportExcel(response, list, "课程考试安排数据");
    }

    /**
     * 获取课程考试安排详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:exam:query')")
    @GetMapping(value = "/{examId}")
    public AjaxResult getInfo(@PathVariable("examId") Long examId)
    {
        return success(stuExamService.selectStuExamByExamId(examId));
    }

    /**
     * 新增课程考试安排
     */
    @PreAuthorize("@ss.hasPermi('system:exam:add')")
    @Log(title = "课程考试安排", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuExam stuExam)
    {
        StuExam item = new StuExam();
        item.setCourseId(stuExam.getCourseId());
        List<StuExam> list  = stuExamService.selectStuExamList(item);
        if(list.size()>0){
            return error("当前课程已安排考试");
        }
        return toAjax(stuExamService.insertStuExam(stuExam));
    }

    /**
     * 修改课程考试安排
     */
    @PreAuthorize("@ss.hasPermi('system:exam:edit')")
    @Log(title = "课程考试安排", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuExam stuExam)
    {
        return toAjax(stuExamService.updateStuExam(stuExam));
    }

    /**
     * 删除课程考试安排
     */
    @PreAuthorize("@ss.hasPermi('system:exam:remove')")
    @Log(title = "课程考试安排", businessType = BusinessType.DELETE)
	@DeleteMapping("/{examIds}")
    public AjaxResult remove(@PathVariable Long[] examIds)
    {
        return toAjax(stuExamService.deleteStuExamByExamIds(examIds));
    }
}
