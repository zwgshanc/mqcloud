package com.sohu.tv.mq.cloud.bo;

import java.util.Date;

import com.sohu.tv.mq.cloud.util.DateUtil;

/**
 * broker
 * 
 * @author yongfeigao
 * @date 2018年11月14日
 */
public class Broker {
    // cluster id
    private int cid;
    // ip:port
    private String addr;

    private Date createTime;
    // 检测状态
    private int checkStatus;
    // 检测时间
    private Date checkTime;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(int checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getCreateTimeFormat() {
        if(getCreateTime() == null) {
            return null;
        }
        return DateUtil.getFormat(DateUtil.YMD_DASH_BLANK_HMS_COLON).format(getCreateTime());
    }
    
    public String getCheckTimeFormat() {
        if(getCheckTime() == null) {
            return "";
        }
        return DateUtil.getFormat(DateUtil.YMD_DASH_BLANK_HMS_COLON).format(getCheckTime());
    }
    
    public String getCheckStatusDesc() {
        CheckStatusEnum checkStatusEnum = CheckStatusEnum.getCheckStatusEnumByStatus(getCheckStatus());
        if (CheckStatusEnum.FAIL == checkStatusEnum) {
            return "<font style='font-weight:bold' color='red'>" + checkStatusEnum.getDesc() + "</font>";
        }
        return checkStatusEnum.getDesc();
    }
}
