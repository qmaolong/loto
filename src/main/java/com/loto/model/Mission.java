package com.loto.model;

import java.math.BigDecimal;
import java.util.Date;

public class Mission {
    private Long id;

    private Long userId;

    private String title;

    private String missionType;

    private String content;

    private String example;

    private String cityLimit;

    private Integer paytype;

    private Integer status;

    private BigDecimal totalCommission;

    private Long totalCount;

    private BigDecimal perCommission;

    private Long restCount;

    private Date expiredTime;

    private Integer timeLimit;

    private Integer perCountLimit;

    private Long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMissionType() {
        return missionType;
    }

    public void setMissionType(String missionType) {
        this.missionType = missionType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getCityLimit() {
        return cityLimit;
    }

    public void setCityLimit(String cityLimit) {
        this.cityLimit = cityLimit;
    }

    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(BigDecimal totalCommission) {
        this.totalCommission = totalCommission;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public BigDecimal getPerCommission() {
        return perCommission;
    }

    public void setPerCommission(BigDecimal perCommission) {
        this.perCommission = perCommission;
    }

    public Long getRestCount() {
        return restCount;
    }

    public void setRestCount(Long restCount) {
        this.restCount = restCount;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Integer getPerCountLimit() {
        return perCountLimit;
    }

    public void setPerCountLimit(Integer perCountLimit) {
        this.perCountLimit = perCountLimit;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}