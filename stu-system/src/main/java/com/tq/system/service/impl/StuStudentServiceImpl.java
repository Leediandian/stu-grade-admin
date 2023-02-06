package com.tq.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tq.common.core.domain.AjaxResult;
import com.tq.system.domain.stu.StuClass;
import com.tq.system.domain.stu.StuDepartment;
import com.tq.system.domain.stu.StuMajor;
import com.tq.system.domain.vo.StuDepartmentVo;
import com.tq.system.domain.vo.StudentUploadVo;
import com.tq.system.mapper.stu.StuClassMapper;
import com.tq.system.mapper.stu.StuDepartmentMapper;
import com.tq.system.mapper.stu.StuMajorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tq.system.mapper.stu.StuStudentMapper;
import com.tq.system.domain.stu.StuStudent;
import com.tq.system.service.IStuStudentService;

/**
 * 学生Service业务层处理
 * 
 * @author tq
 * @date 2022-11-22
 */
@Service
public class StuStudentServiceImpl implements IStuStudentService 
{
    @Autowired
    private StuStudentMapper stuStudentMapper;
    @Autowired
    private StuClassMapper stuClassMapper;
    @Autowired
    private StuDepartmentMapper stuDepartmentMapper;
    @Autowired
    private StuMajorMapper stuMajorMapper;

    /**
     * 查询学生
     * 
     * @param stuId 学生主键
     * @return 学生
     */
    @Override
    public StuStudent selectStuStudentByStuId(Long stuId)
    {
        return stuStudentMapper.selectStuStudentByStuId(stuId);
    }

    /**
     * 查询学生列表
     * 
     * @param stuStudent 学生
     * @return 学生
     */
    @Override
    public List<StuStudent> selectStuStudentList(StuStudent stuStudent)
    {
        return stuStudentMapper.selectStuStudentList(stuStudent);
    }

    /**
     * 新增学生
     * 
     * @param stuStudent 学生
     * @return 结果
     */
    @Override
    public int insertStuStudent(StuStudent stuStudent)
    {
        return stuStudentMapper.insertStuStudent(stuStudent);
    }

    /**
     * 修改学生
     * 
     * @param stuStudent 学生
     * @return 结果
     */
    @Override
    public int updateStuStudent(StuStudent stuStudent)
    {
        return stuStudentMapper.updateStuStudent(stuStudent);
    }

    /**
     * 批量删除学生
     * 
     * @param stuIds 需要删除的学生主键
     * @return 结果
     */
    @Override
    public int deleteStuStudentByStuIds(Long[] stuIds)
    {
        return stuStudentMapper.deleteStuStudentByStuIds(stuIds);
    }

    /**
     * 删除学生信息
     * 
     * @param stuId 学生主键
     * @return 结果
     */
    @Override
    public int deleteStuStudentByStuId(Long stuId)
    {
        return stuStudentMapper.deleteStuStudentByStuId(stuId);
    }

    /**
     * 学生管理 通用搜索列表 院级/班级/专业
     *
     * @param
     * @return 结果
     */
    @Override
    public Map getSearchCommonList() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<StuDepartmentVo> departmentList = stuDepartmentMapper.selectStuDepartmentChildrenList(new StuDepartment());
        List<StuClass> classList = stuClassMapper.selectStuClassList(new StuClass());
        map.put("departmentList",departmentList);
        map.put("classList",classList);
        return map;
    }

    /**
     * 学生管理 通过excel生成数据
     *
     * @param list
     * @return 结果
     */
    @Override
    public AjaxResult importList(List<StudentUploadVo> list) {
        //更新或者添加
        for (StudentUploadVo item : list) {
            //根据专业名称获取专业编号
            StuMajor major = new StuMajor();
            major.setMajorName(item.getMajorName());
            List<StuMajor> mlist= stuMajorMapper.selectStuMajorList(major);

            //根据班级名称获取班级编号
            StuClass classObj = new StuClass();
            classObj.setClassName(item.getClassName());
            List<StuClass> clist= stuClassMapper.selectStuClassList(classObj);

            //根据院级名称获取院级编号
            StuDepartment department = new StuDepartment();
            department.setDepartmentName(item.getDepartmentName());
            List<StuDepartment> dlist= stuDepartmentMapper.selectStuDepartmentList(department);

            StuStudent stu = new StuStudent();

            if(mlist.size()>0){
                stu.setMajorId(mlist.get(0).getMajorId());
            }
            if(clist.size()>0){
                stu.setClassId(clist.get(0).getClassId());
            }
            if(dlist.size()>0){
                stu.setDepartmentId(dlist.get(0).getDepartmentId());
            }
            stu.setStuName(item.getStuName());
            stu.setBirthDate(item.getBirthDate());
            stu.setStuNum(item.getStuNum());
            //0=男,1=女,2=未知
            if(item.getStuSex().equals("男")){
                stu.setStuSex("0");
            }else if(item.getStuSex().equals("女")){
                stu.setStuSex("1");
            }else{
                stu.setStuSex("2");
            }
            stuStudentMapper.insertStuStudent(stu);
        }
        return AjaxResult.success();
    }


}
