package com.tq.system.domain.stu;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tq.common.annotation.Excel;
import com.tq.common.core.domain.BaseEntity;

/**
 * 学生对象 stu_student
 * 
 * @author tq
 * @date 2022-11-22
 */
public class StuStudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学生编号 */
    private Long stuId;

    /** 学号 */
    @Excel(name = "学号")
    private String stuNum;

    /** 学生名称 */
    @Excel(name = "学生名称")
    private String stuName;

    /** 性别 */
    @Excel(name = "性别", readConverterExp = "0=男,1=女,2=未知")
    private String stuSex;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthDate;

    /** 班级编号 */
    private Long classId;

    /** 班级名称 */
    @Excel(name = "班级名称")
    private String className;

    /** 专业编号 */
    private Long majorId;

    /** 专业名称 */
    @Excel(name = "专业名称")
    private String majorName;

    /** 院系编号 */
    private Long departmentId;

    /** 院系名称 */
    @Excel(name = "院系名称")
    private String departmentName;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setStuId(Long stuId) 
    {
        this.stuId = stuId;
    }

    public Long getStuId() 
    {
        return stuId;
    }
    public void setStuNum(String stuNum) 
    {
        this.stuNum = stuNum;
    }

    public String getStuNum() 
    {
        return stuNum;
    }
    public void setStuName(String stuName) 
    {
        this.stuName = stuName;
    }

    public String getStuName() 
    {
        return stuName;
    }
    public void setStuSex(String stuSex) 
    {
        this.stuSex = stuSex;
    }

    public String getStuSex() 
    {
        return stuSex;
    }
    public void setBirthDate(Date birthDate) 
    {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() 
    {
        return birthDate;
    }
    public void setClassId(Long classId)
    {
        this.classId = classId;
    }

    public Long getClassId()
    {
        return classId;
    }
    public void setMajorId(Long majorId) 
    {
        this.majorId = majorId;
    }

    public Long getMajorId() 
    {
        return majorId;
    }
    public void setDepartmentId(Long departmentId) 
    {
        this.departmentId = departmentId;
    }

    public Long getDepartmentId() 
    {
        return departmentId;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stuId", getStuId())
            .append("stuNum", getStuNum())
            .append("stuName", getStuName())
            .append("stuSex", getStuSex())
            .append("birthDate", getBirthDate())
            .append("classId", getClassId())
            .append("majorId", getMajorId())
            .append("departmentId", getDepartmentId())
            .append("delFlag", getDelFlag())
            .append("className", getClassName())
            .append("majorName", getMajorName())
            .append("departmentName", getDepartmentName())
            .toString();
    }
}
