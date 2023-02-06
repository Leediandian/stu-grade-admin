package com.tq.system.domain.stu;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tq.common.annotation.Excel;
import com.tq.common.core.domain.BaseEntity;

/**
 * 专业对象 stu_major
 * 
 * @author tq
 * @date 2022-11-22
 */
public class StuMajor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 专业编号 */
    private Long majorId;

    /** 专业名称 */
    @Excel(name = "专业名称")
    private String majorName;

    /** 专业代码 */
    @Excel(name = "专业代码")
    private String majorCode;

    /** 所属院系编号 */
    @Excel(name = "所属院系编号")
    private Long departmentId;

    /** 所属院系 */
    private StuDepartment stuDepartment;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Integer orderNum;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setMajorId(Long majorId) 
    {
        this.majorId = majorId;
    }

    public Long getMajorId() 
    {
        return majorId;
    }
    public void setMajorName(String majorName) 
    {
        this.majorName = majorName;
    }

    public String getMajorName() 
    {
        return majorName;
    }
    public void setMajorCode(String majorCode) 
    {
        this.majorCode = majorCode;
    }

    public String getMajorCode() 
    {
        return majorCode;
    }
    public void setDepartmentId(Long departmentId) 
    {
        this.departmentId = departmentId;
    }

    public Long getDepartmentId() 
    {
        return departmentId;
    }
    public void setOrderNum(Integer orderNum) 
    {
        this.orderNum = orderNum;
    }

    public Integer getOrderNum() 
    {
        return orderNum;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    public StuDepartment getStuDepartment() {
        return stuDepartment;
    }

    public void setStuDepartment(StuDepartment stuDepartment) {
        this.stuDepartment = stuDepartment;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("majorId", getMajorId())
                .append("majorName", getMajorName())
                .append("majorCode", getMajorCode())
                .append("departmentId", getDepartmentId())
                .append("orderNum", getOrderNum())
                .append("delFlag", getDelFlag())
                .append("stuDepartment", getStuDepartment().toString())
                .toString();
    }
}
