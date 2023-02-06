package com.tq.system.domain.stu;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tq.common.annotation.Excel;
import com.tq.common.core.domain.BaseEntity;

/**
 * 课程考试安排对象 stu_exam
 * 
 * @author tq
 * @date 2022-11-28
 */
public class StuExam extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 考试编号 */
    private Long examId;

    /** 考试名称 */
    @Excel(name = "考试名称")
    private String examName;

    /** 考试性质/类型  （0代表线下笔试-闭卷 1代表线下笔试-开卷 2代表线下机试 3代表大作业考察形式 4代表实训考察形式） */
    @Excel(name = "考试类型",readConverterExp = "0=代表线下笔试-闭卷,1=代表线下笔试-开卷,2=代表线下机试,3=代表大作业考察形式,4=代表实训考察形式")
    private String examType;

    /** 考试描述 */
    @Excel(name = "考试描述")
    private String examDesc;

    /** 课程编号 */
    private Long courseId;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** 安排时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "安排时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date scheduleTime;

    /** 考试场地 */
    @Excel(name = "考试场地")
    private String examClassroom;

    /** 考试起始时间 */
    @Excel(name = "考试起始时间")
    private String examStartTime;

    /** 考试结束时间 */
    @Excel(name = "考试结束时间")
    private String examEndTime;
    /** 班级编号 */
    private Long classId ;
    /** 班级名称 */
    private String className;
    /**
     * 任课教师编号
     */
    private Long teaId;

    public void setExamId(Long examId) 
    {
        this.examId = examId;
    }

    public Long getExamId() 
    {
        return examId;
    }
    public void setExamName(String examName) 
    {
        this.examName = examName;
    }

    public String getExamName() 
    {
        return examName;
    }
    public void setExamType(String examType) 
    {
        this.examType = examType;
    }

    public String getExamType() 
    {
        return examType;
    }
    public void setExamDesc(String examDesc) 
    {
        this.examDesc = examDesc;
    }

    public String getExamDesc() 
    {
        return examDesc;
    }
    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }
    public void setScheduleTime(Date scheduleTime) 
    {
        this.scheduleTime = scheduleTime;
    }

    public Date getScheduleTime() 
    {
        return scheduleTime;
    }
    public void setExamClassroom(String examClassroom) 
    {
        this.examClassroom = examClassroom;
    }

    public String getExamClassroom() 
    {
        return examClassroom;
    }
    public void setExamStartTime(String examStartTime)
    {
        this.examStartTime = examStartTime;
    }

    public String getExamStartTime()
    {
        return examStartTime;
    }
    public void setExamEndTime(String examEndTime)
    {
        this.examEndTime = examEndTime;
    }

    public String getExamEndTime()
    {
        return examEndTime;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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
            .append("examId", getExamId())
            .append("examName", getExamName())
            .append("examType", getExamType())
            .append("examDesc", getExamDesc())
            .append("courseId", getCourseId())
            .append("scheduleTime", getScheduleTime())
            .append("examClassroom", getExamClassroom())
            .append("examStartTime", getExamStartTime())
            .append("examEndTime", getExamEndTime())
            .append("courseName", getCourseName())
            .append("teaId", getTeaId())
            .toString();
    }
}
