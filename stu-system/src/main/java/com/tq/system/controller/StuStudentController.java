package com.tq.system.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.SyncReadListener;
import com.tq.common.config.TqConfig;
import com.tq.common.core.domain.entity.SysUser;
import com.tq.common.utils.file.FileUploadUtils;
import com.tq.common.utils.file.MimeTypeUtils;
import com.tq.system.domain.vo.StudentUploadVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tq.common.annotation.Log;
import com.tq.common.core.controller.BaseController;
import com.tq.common.core.domain.AjaxResult;
import com.tq.common.enums.BusinessType;
import com.tq.system.domain.stu.StuStudent;
import com.tq.system.service.IStuStudentService;
import com.tq.common.utils.poi.ExcelUtil;
import com.tq.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 学生Controller
 * 
 * @author tq
 * @date 2022-11-22
 */
@RestController
@RequestMapping("/system/student")
public class StuStudentController extends BaseController
{
    @Autowired
    private IStuStudentService stuStudentService;

    /**
     * 查询院级列表/班级列表/专业列表
     */
    @PreAuthorize("@ss.hasPermi('system:student:searchCommonList')")
    @GetMapping("/searchCommonList")
    public AjaxResult searchCommonList()
    {
        Map map = stuStudentService.getSearchCommonList();
        return success(map);
    }


    /**
     * 查询学生列表
     */
    @PreAuthorize("@ss.hasPermi('system:student:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuStudent stuStudent)
    {
        startPage();
        List<StuStudent> list = stuStudentService.selectStuStudentList(stuStudent);
        return getDataTable(list);
    }

    /**
     * 导出学生列表
     */
    @PreAuthorize("@ss.hasPermi('system:student:export')")
    @Log(title = "学生", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuStudent stuStudent)
    {
        List<StuStudent> list = stuStudentService.selectStuStudentList(stuStudent);
        ExcelUtil<StuStudent> util = new ExcelUtil<StuStudent>(StuStudent.class);
        util.exportExcel(response, list, "学生数据");
    }

    /**
     * 获取学生详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:student:query')")
    @GetMapping(value = "/{stuId}")
    public AjaxResult getInfo(@PathVariable("stuId") Long stuId)
    {
        return success(stuStudentService.selectStuStudentByStuId(stuId));
    }

    /**
     * 新增学生
     */
    @PreAuthorize("@ss.hasPermi('system:student:add')")
    @Log(title = "学生", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuStudent stuStudent)
    {
        return toAjax(stuStudentService.insertStuStudent(stuStudent));
    }

    /**
     * 修改学生
     */
    @PreAuthorize("@ss.hasPermi('system:student:edit')")
    @Log(title = "学生", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuStudent stuStudent)
    {
        return toAjax(stuStudentService.updateStuStudent(stuStudent));
    }

    /**
     * 删除学生
     */
    @PreAuthorize("@ss.hasPermi('system:student:remove')")
    @Log(title = "学生", businessType = BusinessType.DELETE)
	@DeleteMapping("/{stuIds}")
    public AjaxResult remove(@PathVariable Long[] stuIds)
    {
        return toAjax(stuStudentService.deleteStuStudentByStuIds(stuIds));
    }

    /**
     * 导入学生列表
     */
    @PreAuthorize("@ss.hasPermi('system:student:import')")
    @PostMapping("/import")
    public AjaxResult importList(@RequestParam("importFile")MultipartFile importFile) throws Exception
    {
        if (importFile != null) {
            String fileName = FileUploadUtils.upload(TqConfig.getImportPath(), importFile, MimeTypeUtils.EXCEL_EXTENSION);
            List<StudentUploadVo> list = new ArrayList<>();
            EasyExcel.read(new File(TqConfig.getProfile()+fileName),StudentUploadVo.class,new SyncReadListener(){
                @Override
                public void invoke(Object object, AnalysisContext context) {
                    list.add((StudentUploadVo) object);
                }
            }).doReadAll();

            return stuStudentService.importList(list);
        }


        return error("上传文件异常，请联系管理员");
    }

    /**
     * 生成导入模板
     */
    @PostMapping("/importStudentTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<StudentUploadVo> util = new ExcelUtil<StudentUploadVo>(StudentUploadVo.class);
        util.importTemplateExcel(response, "学生数据");
    }
}
