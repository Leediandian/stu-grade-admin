package com.tq.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.tq.system.domain.stu.StuStudent;
import com.tq.system.domain.vo.StuClassVo;
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
import com.tq.system.domain.stu.StuClass;
import com.tq.system.service.IStuClassService;
import com.tq.common.utils.poi.ExcelUtil;
import com.tq.common.core.page.TableDataInfo;

/**
 * 班级Controller
 * 
 * @author tq
 * @date 2022-11-22
 */
@RestController
@RequestMapping("/system/class")
public class StuClassController extends BaseController
{
    @Autowired
    private IStuClassService stuClassService;

    /**
     * 查询班级列表
     */
    @PreAuthorize("@ss.hasPermi('system:class:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuClass stuClass)
    {
        startPage();
        List<StuClass> list = stuClassService.selectStuClassList(stuClass);
        return getDataTable(list);
    }

    /**
     * 导出班级列表
     */
    @PreAuthorize("@ss.hasPermi('system:class:export')")
    @Log(title = "班级", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuClass stuClass)
    {
        List<StuClass> list = stuClassService.selectStuClassList(stuClass);
        ExcelUtil<StuClass> util = new ExcelUtil<StuClass>(StuClass.class);
        util.exportExcel(response, list, "班级数据");
    }

    /**
     * 获取班级详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:class:query')")
    @GetMapping(value = "/{classId}")
    public AjaxResult getInfo(@PathVariable("classId") Long classId)
    {
        return success(stuClassService.selectStuClassByClassId(classId));
    }

    /**
     * 新增班级
     */
    @PreAuthorize("@ss.hasPermi('system:class:add')")
    @Log(title = "班级", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuClass stuClass)
    {
        return toAjax(stuClassService.insertStuClass(stuClass));
    }

    /**
     * 修改班级
     */
    @PreAuthorize("@ss.hasPermi('system:class:edit')")
    @Log(title = "班级", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuClass stuClass)
    {
        return toAjax(stuClassService.updateStuClass(stuClass));
    }

    /**
     * 删除班级
     */
    @PreAuthorize("@ss.hasPermi('system:class:remove')")
    @Log(title = "班级", businessType = BusinessType.DELETE)
	@DeleteMapping("/{classIds}")
    public AjaxResult remove(@PathVariable Long[] classIds)
    {
        return toAjax(stuClassService.deleteStuClassByClassIds(classIds));
    }

    /**
     * 查询班级列表及下面的学生列表
     */
    @PreAuthorize("@ss.hasPermi('system:class:listOfStudent')")
    @GetMapping("/listOfStudent")
    public AjaxResult listOfStudent ()
    {
        List<StuClassVo> list = stuClassService.selectListOfStudent();
        return success(list);
    }

    /**
     * 查询班级列表及下面的学生列表 (查询的是还没生成账号的学生数据)
     */
    @PreAuthorize("@ss.hasPermi('system:class:listOfStudentByNullUserName')")
    @GetMapping("/listOfStudentByNullUserName")
    public AjaxResult listOfStudentByNullUserName()
    {
        List<StuClassVo> list = stuClassService.listOfStudentByNullUserName();
        return success(list);
    }
}
