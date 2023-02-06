package com.tq.system.domain.stu;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tq.common.annotation.Excel;
import com.tq.common.core.domain.BaseEntity;

/**
 * 教师对象 stu_teacher
 * 
 * @author tq
 * @date 2022-11-22
 */
public class StuTeacher extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long teaId;

    /** 工号 */
    @Excel(name = "工号")
    private String teaNum;

    /** 姓名 */
    @Excel(name = "姓名")
    private String teaName;

    /** 性别 */
    @Excel(name = "用户性别", readConverterExp = "0=男,1=女,2=未知")
    private String teaSex;

    /** 年龄 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "年龄", width = 30, dateFormat = "yyyy-MM-dd")
    private Date teaAge;

    /** 简介 */
    @Excel(name = "简介")
    private String teaDescription;

    /** 职称 */
    @Excel(name = "职称")
    private String jobTitle;

    /** 院系编号 */
    @Excel(name = "院系编号")
    private Long departmentId;

    private String departmentName;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setTeaId(Long teaId) 
    {
        this.teaId = teaId;
    }

    public Long getTeaId() 
    {
        return teaId;
    }
    public void setTeaNum(String teaNum) 
    {
        this.teaNum = teaNum;
    }

    public String getTeaNum() 
    {
        return teaNum;
    }
    public void setTeaName(String teaName) 
    {
        this.teaName = teaName;
    }

    public String getTeaName() 
    {
        return teaName;
    }
    public void setTeaSex(String teaSex) 
    {
        this.teaSex = teaSex;
    }

    public String getTeaSex() 
    {
        return teaSex;
    }
    public void setTeaAge(Date teaAge) 
    {
        this.teaAge = teaAge;
    }

    public Date getTeaAge() 
    {
        return teaAge;
    }
    public void setTeaDescription(String teaDescription) 
    {
        this.teaDescription = teaDescription;
    }

    public String getTeaDescription() 
    {
        return teaDescription;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
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
            .append("teaId", getTeaId())
            .append("teaNum", getTeaNum())
            .append("teaName", getTeaName())
            .append("teaSex", getTeaSex())
            .append("teaAge", getTeaAge())
            .append("teaDescription", getTeaDescription())
            .append("jobTitle", getJobTitle())
            .append("departmentId", getDepartmentId())
            .append("departmentName", getDepartmentName())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
