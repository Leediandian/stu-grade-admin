package com.tq.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.tq.system.domain.vo.StuDepartmentVo;
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
import com.tq.system.domain.stu.StuDepartment;
import com.tq.system.service.IStuDepartmentService;
import com.tq.common.utils.poi.ExcelUtil;
import com.tq.common.core.page.TableDataInfo;

/**
 * 院系Controller
 * 
 * @author tq
 * @date 2022-11-22
 */
@RestController
@RequestMapping("/system/department")
public class StuDepartmentController extends BaseController
{
    @Autowired
    private IStuDepartmentService stuDepartmentService;

    /**
     * 查询院系列表 分页
     */
    @PreAuthorize("@ss.hasPermi('system:department:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuDepartment stuDepartment)
    {
        startPage();
        List<StuDepartment> list = stuDepartmentService.selectStuDepartmentList(stuDepartment);
        return getDataTable(list);
    }

    /**
     * 查询院系列表 全部-不分页
     */
    @PreAuthorize("@ss.hasPermi('system:department:allList')")
    @GetMapping("/allList")
    public AjaxResult allList(StuDepartment stuDepartment)
    {
        List<StuDepartment> list = stuDepartmentService.selectStuDepartmentList(stuDepartment);
        return success(list);
    }

    /**
     * 查询院系列表 全部-不分页以及下面的专业
     */
    @PreAuthorize("@ss.hasPermi('system:department:allListChildren')")
    @GetMapping("/allListChildren")
    public AjaxResult allListChildren(StuDepartment stuDepartment)
    {
        List<StuDepartmentVo> list = stuDepartmentService.selectStuDepartmentChildrenList(stuDepartment);
        return success(list);
    }

    /**
     * 导出院系列表
     */
    @PreAuthorize("@ss.hasPermi('system:department:export')")
    @Log(title = "院系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuDepartment stuDepartment)
    {
        List<StuDepartment> list = stuDepartmentService.selectStuDepartmentList(stuDepartment);
        ExcelUtil<StuDepartment> util = new ExcelUtil<StuDepartment>(StuDepartment.class);
        util.exportExcel(response, list, "院系数据");
    }

    /**
     * 获取院系详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:department:query')")
    @GetMapping(value = "/{departmentId}")
    public AjaxResult getInfo(@PathVariable("departmentId") Long departmentId)
    {
        return success(stuDepartmentService.selectStuDepartmentByDepartmentId(departmentId));
    }

    /**
     * 新增院系
     */
    @PreAuthorize("@ss.hasPermi('system:department:add')")
    @Log(title = "院系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuDepartment stuDepartment)
    {
        return toAjax(stuDepartmentService.insertStuDepartment(stuDepartment));
    }

    /**
     * 修改院系
     */
    @PreAuthorize("@ss.hasPermi('system:department:edit')")
    @Log(title = "院系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuDepartment stuDepartment)
    {
        return toAjax(stuDepartmentService.updateStuDepartment(stuDepartment));
    }

    /**
     * 删除院系
     */
    @PreAuthorize("@ss.hasPermi('system:department:remove')")
    @Log(title = "院系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{departmentIds}")
    public AjaxResult remove(@PathVariable Long[] departmentIds)
    {
        return toAjax(stuDepartmentService.deleteStuDepartmentByDepartmentIds(departmentIds));
    }
}
