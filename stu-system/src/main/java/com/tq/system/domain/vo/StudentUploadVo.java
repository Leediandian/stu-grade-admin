package com.tq.system.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tq.common.annotation.Excel;

import java.util.Date;

public class StudentUploadVo {

    /** 学生编号 */
    private Long stuId;

    /** 学号 */
    @ExcelProperty("学号")
    @Excel(name = "学号")
    private String stuNum;

    /** 学生名称 */
    @ExcelProperty("学生名称")
    @Excel(name = "学生名称")
    private String stuName;

    /** 性别 */
    @ExcelProperty("性别")
    @Excel(name = "性别")
    private String stuSex;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ExcelProperty("出生日期")
    @Excel(name = "出生日期")
    private Date birthDate;

    /** 班级名称 */
    @ExcelProperty("班级名称")
    @Excel(name = "班级名称")
    private String className;

    /** 专业名称 */
    @ExcelProperty("专业名称")
    @Excel(name = "专业名称")
    private String majorName;

    /** 院系名称 */
    @ExcelProperty("院系名称")
    @Excel(name = "院系名称")
    private String departmentName;

    /** 班级编号 */
    private Long classId;

    /** 专业编号 */
    private Long majorId;

    /** 院系编号 */
    private Long departmentId;

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
