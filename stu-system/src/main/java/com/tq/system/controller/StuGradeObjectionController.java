package com.tq.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.tq.system.domain.stu.StuGradeObjection;
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
import com.tq.system.service.IStuGradeObjectionService;
import com.tq.common.utils.poi.ExcelUtil;
import com.tq.common.core.page.TableDataInfo;

/**
 * 成绩异议处理记录Controller
 * 
 * @author tq
 * @date 2022-11-28
 */
@RestController
@RequestMapping("/system/objection")
public class StuGradeObjectionController extends BaseController
{
    @Autowired
    private IStuGradeObjectionService stuGradeObjectionService;

    /**
     * 查询成绩异议处理记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:objection:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuGradeObjection stuGradeObjection)
    {
        startPage();
        List<StuGradeObjection> list = stuGradeObjectionService.selectStuGradeObjectionList(stuGradeObjection);
        return getDataTable(list);
    }

    /**
     * 导出成绩异议处理记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:objection:export')")
    @Log(title = "成绩异议处理记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuGradeObjection stuGradeObjection)
    {
        List<StuGradeObjection> list = stuGradeObjectionService.selectStuGradeObjectionList(stuGradeObjection);
        ExcelUtil<StuGradeObjection> util = new ExcelUtil<StuGradeObjection>(StuGradeObjection.class);
        util.exportExcel(response, list, "成绩异议处理记录数据");
    }

    /**
     * 获取成绩异议处理记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:objection:query')")
    @GetMapping(value = "/{gradeObjId}")
    public AjaxResult getInfo(@PathVariable("gradeObjId") Long gradeObjId)
    {
        return success(stuGradeObjectionService.selectStuGradeObjectionByGradeObjId(gradeObjId));
    }

    /**
     * 新增成绩异议处理记录
     */
    @PreAuthorize("@ss.hasPermi('system:objection:add')")
    @Log(title = "成绩异议处理记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuGradeObjection stuGradeObjection)
    {
        return toAjax(stuGradeObjectionService.insertStuGradeObjection(stuGradeObjection));
    }

    /**
     * 修改成绩异议处理记录
     */
    @PreAuthorize("@ss.hasPermi('system:objection:edit')")
    @Log(title = "成绩异议处理记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuGradeObjection stuGradeObjection)
    {
        return toAjax(stuGradeObjectionService.updateStuGradeObjection(stuGradeObjection));
    }

    /**
     * 删除成绩异议处理记录
     */
    @PreAuthorize("@ss.hasPermi('system:objection:remove')")
    @Log(title = "成绩异议处理记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{gradeObjIds}")
    public AjaxResult remove(@PathVariable Long[] gradeObjIds)
    {
        return toAjax(stuGradeObjectionService.deleteStuGradeObjectionByGradeObjIds(gradeObjIds));
    }
}
