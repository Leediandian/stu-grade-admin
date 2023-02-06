package com.tq.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.tq.system.domain.stu.StuCourse;
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
import com.tq.system.service.IStuCourseService;
import com.tq.common.utils.poi.ExcelUtil;
import com.tq.common.core.page.TableDataInfo;

/**
 * 课程Controller
 * 
 * @author tq
 * @date 2022-11-28
 */
@RestController
@RequestMapping("/system/course")
public class StuCourseController extends BaseController
{
    @Autowired
    private IStuCourseService stuCourseService;

    /**
     * 查询所有课程列表
     */
    @PreAuthorize("@ss.hasPermi('system:course:allList')")
    @GetMapping("/allList")
    public AjaxResult allList(StuCourse stuCourse)
    {
        List<StuCourse> list = stuCourseService.selectStuCourseList(stuCourse);
        for ( StuCourse item: list) {
            item.setCourseName(item.getClassName()+"-"+item.getCourseName()+"-"+item.getTeaName());
        }
        return success(list);
    }

    /**
     * 查询课程分页列表
     */
    @PreAuthorize("@ss.hasPermi('system:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuCourse stuCourse)
    {
        startPage();
        List<StuCourse> list = stuCourseService.selectStuCourseList(stuCourse);
        return getDataTable(list);
    }

    /**
     * 导出课程列表
     */
    @PreAuthorize("@ss.hasPermi('system:course:export')")
    @Log(title = "课程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuCourse stuCourse)
    {
        List<StuCourse> list = stuCourseService.selectStuCourseList(stuCourse);
        ExcelUtil<StuCourse> util = new ExcelUtil<StuCourse>(StuCourse.class);
        util.exportExcel(response, list, "课程数据");
    }

    /**
     * 获取课程详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:course:query')")
    @GetMapping(value = "/{courseId}")
    public AjaxResult getInfo(@PathVariable("courseId") Long courseId)
    {
        return success(stuCourseService.selectStuCourseByCourseId(courseId));
    }

    /**
     * 新增课程
     */
    @PreAuthorize("@ss.hasPermi('system:course:add')")
    @Log(title = "课程", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuCourse stuCourse)
    {
        return toAjax(stuCourseService.insertStuCourse(stuCourse));
    }

    /**
     * 修改课程
     */
    @PreAuthorize("@ss.hasPermi('system:course:edit')")
    @Log(title = "课程", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuCourse stuCourse)
    {
        return toAjax(stuCourseService.updateStuCourse(stuCourse));
    }

    /**
     * 删除课程
     */
    @PreAuthorize("@ss.hasPermi('system:course:remove')")
    @Log(title = "课程", businessType = BusinessType.DELETE)
	@DeleteMapping("/{courseIds}")
    public AjaxResult remove(@PathVariable Long[] courseIds)
    {
        return toAjax(stuCourseService.deleteStuCourseByCourseIds(courseIds));
    }
}
