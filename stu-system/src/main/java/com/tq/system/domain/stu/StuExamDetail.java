package com.tq.system.domain.stu;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tq.common.annotation.Excel;
import com.tq.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 课程考试安排明细对象 stu_exam_detail
 * 
 * @author tq
 * @date 2022-11-28
 */
public class StuExamDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 考试明细编号 */
    private Long examDetailId;

    /** 考试编号 */
    private Long examId;

    @Excel(name = "考试名称")
    private String examName;

    @Excel(name = "课程编号")
    private String courseId;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    @Excel(name = "考试场地")
    private String examClassroom;

    /** 安排时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "安排时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date scheduleTime;

    /** 考试起始时间 */
    @Excel(name = "考试起始时间")
    private String examStartTime;

    /** 考试结束时间 */
    @Excel(name = "考试结束时间")
    private String examEndTime;

    /** 学生编号 */
    private Long stuId;

    /** 学生名称 */
    @Excel(name = "学生名称")
    private String stuName;

    /** 考试性质/类型  （0代表线下笔试-闭卷 1代表线下笔试-开卷 2代表线下机试 3代表大作业考察形式 4代表实训考察形式） */
    @Excel(name = "考试性质/类型",readConverterExp = "0=代表线下笔试-闭卷,1=代表线下笔试-开卷,2=代表线下机试,3=代表大作业考察形式,4=代表实训考察形式")
    private String examType;

    /** 班级编号 */
    private Long classId ;
    /** 班级名称 */
    private String className;

    /** 教師编号 */
    private Long teaId;

    public void setExamDetailId(Long examDetailId) 
    {
        this.examDetailId = examDetailId;
    }

    public Long getExamDetailId() 
    {
        return examDetailId;
    }
    public void setExamId(Long examId) 
    {
        this.examId = examId;
    }

    public Long getExamId() 
    {
        return examId;
    }
    public void setStuId(Long stuId) 
    {
        this.stuId = stuId;
    }

    public Long getStuId() 
    {
        return stuId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getExamClassroom() {
        return examClassroom;
    }

    public void setExamClassroom(String examClassroom) {
        this.examClassroom = examClassroom;
    }

    public Date getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Date scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getExamStartTime() {
        return examStartTime;
    }

    public void setExamStartTime(String examStartTime) {
        this.examStartTime = examStartTime;
    }

    public String getExamEndTime() {
        return examEndTime;
    }

    public void setExamEndTime(String examEndTime) {
        this.examEndTime = examEndTime;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
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


    public Long getTeaId() {
        return teaId;
    }

    public void setTeaId(Long teaId) {
        this.teaId = teaId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("examDetailId", getExamDetailId())
            .append("examId", getExamId())
            .append("stuId", getStuId())
            .append("teaId", getTeaId())
            .toString();
    }
}
