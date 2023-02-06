package com.tq.system.domain.vo;

import com.tq.common.annotation.Excel;
import com.tq.common.core.domain.BaseEntity;
import com.tq.system.domain.stu.StuStudent;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 班级对象 stu_class
 * 
 * @author tq
 * @date 2022-11-22
 */
public class StuClassVo extends BaseEntity
{

    /** 班级编号 */
    private Long classId;

    /** 班级名称 */
    private String className;

    /** 年级 */
    private String classGrade;

    /** 专业编号 */
    private Long majorId;

    /** 专业名称 */
    private String majorName;

    /** 显示顺序 */
    private Integer orderNum;

    private List<StuStudent> children;

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

    public List<StuStudent> getChildren() {
        return children;
    }

    public void setChildren(List<StuStudent> children) {
        this.children = children;
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
            .append("children", getChildren())
            .toString();
    }
}
