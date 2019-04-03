package com.hit.aunt.minedays.entity;

import java.util.Date;

public class Schedule {
    private Long taskID;//日程id
    private String title;//标题
    private String taskDesc;//详细描述
    private Date startTime;//工作开始日期
    private Date endTime;//工作结束日期
    private Date createTime;//创建日期
    private Date lastEditTime;//更新日期
    private Person person;//创建人
    private Integer perorities;//权重（紧急程度）
    private Integer enableStatus;//状态：0.不可用1.可用

    public Long getTaskID() {
        return taskID;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getPerorities() {
        return perorities;
    }

    public void setPerorities(Integer perorities) {
        this.perorities = perorities;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }
}
