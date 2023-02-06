package com.tq.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.tq.system.domain.stu.StuTeacher;
import com.tq.system.service.IStuTeacherService;
import com.tq.common.utils.poi.ExcelUtil;
import com.tq.common.core.page.TableDataInfo;

/**
 * 教师Controller
 * 
 * @author tq
 * @date 2022-11-22
 */
@RestController
@RequestMapping("/system/teacher")
public class StuTeacherController extends BaseController
{
    @Autowired
    private IStuTeacherService stuTeacherService;

    /**
     * 查询所有教师列表
     */
    @PreAuthorize("@ss.hasPermi('system:teacher:allList')")
    @GetMapping("/allList")
    public AjaxResult allList(StuTeacher stuTeacher)
    {
        List<StuTeacher> list = stuTeacherService.selectStuTeacherList(stuTeacher);
        return success(list);
    }

    /**
     * 查询教师列表 分页
     */
    @PreAuthorize("@ss.hasPermi('system:teacher:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuTeacher stuTeacher)
    {
        startPage();
        List<StuTeacher> list = stuTeacherService.selectStuTeacherList(stuTeacher);
        return getDataTable(list);
    }

    /**
     * 导出教师列表
     */
    @PreAuthorize("@ss.hasPermi('system:teacher:export')")
    @Log(title = "教师", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuTeacher stuTeacher)
    {
        List<StuTeacher> list = stuTeacherService.selectStuTeacherList(stuTeacher);
        ExcelUtil<StuTeacher> util = new ExcelUtil<StuTeacher>(StuTeacher.class);
        util.exportExcel(response, list, "教师数据");
    }

    /**
     * 获取教师详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:teacher:query')")
    @GetMapping(value = "/{teaId}")
    public AjaxResult getInfo(@PathVariable("teaId") Long teaId)
    {
        return success(stuTeacherService.selectStuTeacherByTeaId(teaId));
    }

    /**
     * 新增教师
     */
    @PreAuthorize("@ss.hasPermi('system:teacher:add')")
    @Log(title = "教师", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuTeacher stuTeacher)
    {
        return toAjax(stuTeacherService.insertStuTeacher(stuTeacher));
    }

    /**
     * 修改教师
     */
    @PreAuthorize("@ss.hasPermi('system:teacher:edit')")
    @Log(title = "教师", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuTeacher stuTeacher)
    {
        return toAjax(stuTeacherService.updateStuTeacher(stuTeacher));
    }

    /**
     * 删除教师
     */
    @PreAuthorize("@ss.hasPermi('system:teacher:remove')")
    @Log(title = "教师", businessType = BusinessType.DELETE)
	@DeleteMapping("/{teaIds}")
    public AjaxResult remove(@PathVariable Long[] teaIds)
    {
        return toAjax(stuTeacherService.deleteStuTeacherByTeaIds(teaIds));
    }
}
