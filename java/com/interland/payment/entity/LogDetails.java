

package com.interland.payment.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "EFTSECADT")

public class LogDetails implements Serializable{
    
    @Id
    @Column(name = "USER_ID")
    String userId;
    @Id
    @Column(name = "LOG_TIME")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date logTime;
    @Column(name = "LOGIN_STS")
    String logStatus;
    @Column(name = "LOGIN_TYPE")
    String loginType;
    @Column(name = "REASON")
    String reason;
    @Column(name = "IPID")
    String ipAddress;
    @Column(name = "SYS_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date sysDate;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(String logStatus) {
        this.logStatus = logStatus;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getSysDate() {
        return sysDate;
    }

    public void setSysDate(Date sysDate) {
        this.sysDate = sysDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
    public String getLoginType() {
        return loginType;
    }
}
