package com.ncu.zhuoyuejike.fuli.payrollsystem.bean;

import java.sql.Date;

/**
 * Created by Administrator on 2016/7/13.
 * 津贴
 */
public class OvertimeAllowance {
    private Date Odate; //加班时间
    private type Otype; //加班类型
    enum type{PUTONG,BIX,QIANGZHI}//普通，必须，强制
    private float Odays;    //加班天数
    private float ODetial;  //津贴情况

    public Date getOdate() {
        return Odate;
    }

    public void setOdate(Date odate) {
        Odate = odate;
    }

    public type getOtype() {
        return Otype;
    }

    public void setOtype(type otype) {
        Otype = otype;
    }

    public float getOdays() {
        return Odays;
    }

    public void setOdays(float odays) {
        Odays = odays;
    }

    public float getODetial() {
        return ODetial;
    }

    public void setODetial(float ODetial) {
        this.ODetial = ODetial;
    }
}
