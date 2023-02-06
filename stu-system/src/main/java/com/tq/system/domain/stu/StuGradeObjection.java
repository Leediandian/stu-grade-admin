package com.tq.system.domain.stu;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tq.common.annotation.Excel;
import com.tq.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 成绩异议处理记录对象 stu_grade_objection
 *
 * @author tq
 * @date 2022-1-28
 */
public class StuGradeObjection extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 成绩异议编号
     */
    private Long gradeObjId;

    /**
     * 成绩编号
     */
    @Excel(name = "成绩编号")
    private Long gradeId;

    /**
     * 成绩异议说明
     */
    @Excel(name = "成绩异议说明")
    private String gradeObjDesc;

    /**
     * 处理状态（0代表待审批 1代表已处理）
     */
    @Excel(name = "处理状态", readConverterExp = "0=代表待审批,1=代表已处理")
    private String operationStatus;

    /**
     * 处理反馈
     */
    @Excel(name = "处理反馈")
    private String feedback;

    /**
     * 学生编号
     */
    private Long stuId;
    /**
     * 课程编号
     */
    @Excel(name = "课程编号")
    private Long courseId;
    /**
     * 任课教师编号
     */
    private Long teaId;
    /**
     * 课程名称
     */
    @Excel(name = "课程名称")
    private String courseName;
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

    public void setGradeObjId(Long gradeObjId) {
        this.gradeObjId = gradeObjId;
    }

    public Long getGradeObjId() {
        return gradeObjId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeObjDesc(String gradeObjDesc) {
        this.gradeObjDesc = gradeObjDesc;
    }

    public String getGradeObjDesc() {
        return gradeObjDesc;
    }

    public void setOperationStatus(String operationStatus) {
        this.operationStatus = operationStatus;
    }

    public String getOperationStatus() {
        return operationStatus;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getFeedback() {
        return feedback;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getTeaId() {
        return teaId;
    }

    public void setTeaId(Long teaId) {
        this.teaId = teaId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public BigDecimal getScaledGrades() {
        return scaledGrades;
    }

    public void setScaledGrades(BigDecimal scaledGrades) {
        this.scaledGrades = scaledGrades;
    }

    public BigDecimal getUsualGrades() {
        return usualGrades;
    }

    public void setUsualGrades(BigDecimal usualGrades) {
        this.usualGrades = usualGrades;
    }

    public BigDecimal getScoreGrades() {
        return scoreGrades;
    }

    public void setScoreGrades(BigDecimal scoreGrades) {
        this.scoreGrades = scoreGrades;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("gradeObjId", getGradeObjId())
                .append("gradeId", getGradeId())
                .append("gradeObjDesc", getGradeObjDesc())
                .append("operationStatus", getOperationStatus())
                .append("feedback", getFeedback())
                .append("stuId", getStuId())
                .append("courseId", getCourseId())
                .append("teaId", getTeaId())
                .append("courseName", getCourseName())
                .append("scaledGrades", getScaledGrades())
                .append("usualGrades", getUsualGrades())
                .append("scoreGrades", getScoreGrades())
                .toString();
    }
}
