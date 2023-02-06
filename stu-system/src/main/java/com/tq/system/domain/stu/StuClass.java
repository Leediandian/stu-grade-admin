package com.tq.system.domain.stu;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tq.common.annotation.Excel;
import com.tq.common.core.domain.BaseEntity;

/**
 * 班级对象 stu_class
 * 
 * @author tq
 * @date 2022-11-22
 */
public class StuClass extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 班级编号 */
    private Long classId;

    /** 班级名称 */
    @Excel(name = "班级名称")
    private String className;

    /** 年级 */
    @Excel(name = "年级")
    private String classGrade;

    /** 专业编号 */
    private Long majorId;

    /** 专业名称 */
    @Excel(name = "专业名称")
    private String majorName;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Integer orderNum;

    public void setClassId(Long classId) 
    {
        this.classId = classId;
    }

    public Long getClassId() 
    {
        return classId;
    }
    public void setClassName(String className) 
    {
        this.className = className;
    }

    public String getClassName() 
    {
        return className;
    }
    public void setClassGrade(String classGrade) 
    {
        this.classGrade = classGrade;
    }

    public String getClassGrade() 
    {
        return classGrade;
    }
    public void setMajorId(Long majorId) 
    {
        this.majorId = majorId;
    }

    public Long getMajorId() 
    {
        return majorId;
    }
    public void setOrderNum(Integer orderNum) 
    {
        this.orderNum = orderNum;
    }

    public Integer getOrderNum() 
    {
        return orderNum;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("classId", getClassId())
            .append("className", getClassName())
            .append("classGrade", getClassGrade())
            .append("majorId", getMajorId())
            .append("orderNum", getOrderNum())
            .append("majorName", getMajorName())
            .toString();
    }
}
