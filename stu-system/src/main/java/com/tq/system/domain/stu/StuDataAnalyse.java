package com.tq.system.domain.stu;


import com.tq.common.annotation.Excel;
import com.tq.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 学生数据分析对象  stu_grade
 *
 * @author tq
 * @date 2022-11-28
 */
public class StuDataAnalyse extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 课程明细编号
     */
    private Long gradeId;
    /**
     * 学号
     */
    @Excel(name = "学号")
    private String stuNum;
    /**
     * 学生编号
     */
    private Long stuId;

    /**
     * 学生姓名
     */
    @Excel(name = "学生姓名")
    private String stuName;

    /**
     * 课程编号
     */
    @Excel(name = "课程编号")
    private Long courseId;

    /**
     * 课程名称
     */
    @Excel(name = "课程名称")
    private String courseName;

    /**
     * 课程绩点
     */
    @Excel(name = "课程绩点")
    private BigDecimal gradeGpa;

    /**
     * 卷面成绩
     */
    @Excel(name = "卷面成绩")
    private BigDecimal scaledGrades;

    /**
     * 平时成绩
     */
    @Excel(name = "平时成绩")
    private BigDecimal usualGrades;

    /**
     * 最终成绩
     */
    @Excel(name = "最终成绩")
    private BigDecimal scoreGrades;

    /**
     * 考试编号
     */
    @Excel(name = "考试编号")
    private Long examId;

    /**
     * 课程学分
     */
    private Integer courseCredit;

    /**
     * 班级编号
     */
    private Integer classId;

    /**
     * 班级名称
     */
    private String className;

    /**
     * 学期
     */
    @Excel(name = "学期")
    private String term;

    /**
     * 任课教师编号
     */
    private Long teaId;

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setGradeGpa(BigDecimal gradeGpa) {
        this.gradeGpa = gradeGpa;
    }

    public BigDecimal getGradeGpa() {
        return gradeGpa;
    }

    public void setScaledGrades(BigDecimal scaledGrades) {
        this.scaledGrades = scaledGrades;
    }

    public BigDecimal getScaledGrades() {
        return scaledGrades;
    }

    public void setUsualGrades(BigDecimal usualGrades) {
        this.usualGrades = usualGrades;
    }

    public BigDecimal getUsualGrades() {
        return usualGrades;
    }

    public void setScoreGrades(BigDecimal scoreGrades) {
        this.scoreGrades = scoreGrades;
    }

    public BigDecimal getScoreGrades() {
        return scoreGrades;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public Long getExamId() {
        return examId;
    }


    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(Integer courseCredit) {
        this.courseCredit = courseCredit;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


    public void setTerm(String term) {
        this.term = term;
    }

    public String getTerm() {
        return term;
    }

    public Long getTeaId() {
        return teaId;
    }

    public void setTeaId(Long teaId) {
        this.teaId = teaId;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("gradeId", getGradeId())
                .append("stuId", getStuId())
                .append("courseId", getCourseId())
                .append("gradeGpa", getGradeGpa())
                .append("scaledGrades", getScaledGrades())
                .append("usualGrades", getUsualGrades())
                .append("scoreGrades", getScoreGrades())
                .append("examId", getExamId())
                .append("stuName", getStuName())
                .append("courseName", getCourseName())
                .append("courseCredit", getCourseCredit())
                .append("term", getTerm())
                .append("stuNum", getStuNum())
                .append("teaId", getTeaId())
                .toString();
    }
}
