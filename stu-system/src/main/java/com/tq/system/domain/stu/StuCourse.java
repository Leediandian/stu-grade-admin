package com.tq.system.domain.stu;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tq.common.annotation.Excel;
import com.tq.common.core.domain.BaseEntity;

/**
 * 课程对象 stu_course
 *
 * @author tq
 * @date 2022-11-28
 */
public class StuCourse extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 课程编号
     */
    private Long courseId;

    /**
     * 课程名
     */
    @Excel(name = "课程名")
    private String courseName;

    /**
     * 课程学分
     */
    @Excel(name = "课程学分")
    private Integer courseCredit;

    /**
     * 学时
     */
    @Excel(name = "学时")
    private Integer courseHours;

    /**
     * 任课教师编号
     */
    private Long teaId;

    /**
     * 任课教师
     */
    @Excel(name = "任课教师")
    private String teaName;

    /**
     * 开课时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开课时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date courseDate;

    /**
     * 修读方式（0 必修 1 限选   2 任选  ）
     */
    @Excel(name = "修读方式", readConverterExp = "0=必修,1=限选,2=任选")
    private String studyingWay;

    /**
     * 课程大类 (公共必修课/公共选修课/集中实践课/拓展课程/专业基础课/专业核心课/专业选修课)
     */
    @Excel(name = "课程大类")
    private String courseType;
    /**
     * 卷面成绩占最终成绩的比例
     */
    private BigDecimal scaledGradesProportion;
    /**
     * 平时成绩占最终成绩的比例
     */
    private BigDecimal usualGradesProportion;
    /**
     * 班级编号
     */
    private Long classId;
    /**
     * 班级名称
     */
    private String className;

    /**
     * 学期
     */
    @Excel(name = "学期")
    private String term;

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseCredit(Integer courseCredit) {
        this.courseCredit = courseCredit;
    }

    public Integer getCourseCredit() {
        return courseCredit;
    }

    public void setCourseHours(Integer courseHours) {
        this.courseHours = courseHours;
    }

    public Integer getCourseHours() {
        return courseHours;
    }

    public void setTeaId(Long teaId) {
        this.teaId = teaId;
    }

    public Long getTeaId() {
        return teaId;
    }

    public void setCourseDate(Date courseDate) {
        this.courseDate = courseDate;
    }

    public Date getCourseDate() {
        return courseDate;
    }

    public void setStudyingWay(String studyingWay) {
        this.studyingWay = studyingWay;
    }

    public String getStudyingWay() {
        return studyingWay;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseType() {
        return courseType;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public BigDecimal getUsualGradesProportion() {
        return usualGradesProportion;
    }

    public void setUsualGradesProportion(BigDecimal usualGradesProportion) {
        this.usualGradesProportion = usualGradesProportion;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public BigDecimal getScaledGradesProportion() {
        return scaledGradesProportion;
    }

    public void setScaledGradesProportion(BigDecimal scaledGradesProportion) {
        this.scaledGradesProportion = scaledGradesProportion;
    }
    public void setTerm(String term) {
        this.term = term;
    }

    public String getTerm() {
        return term;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("courseId", getCourseId())
                .append("courseName", getCourseName())
                .append("courseCredit", getCourseCredit())
                .append("courseHours", getCourseHours())
                .append("teaId", getTeaId())
                .append("courseDate", getCourseDate())
                .append("studyingWay", getStudyingWay())
                .append("courseType", getCourseType())
                .append("teaName", getTeaName())
                .append("usualGradesProportion", getUsualGradesProportion())
                .append("term", getTerm())
                .toString();
    }
}
