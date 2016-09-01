package com.ncu.zhuoyuejike.fuli.payrollsystem.bean;

/**
 * Created by Administrator on 2016/7/13.
 * 考勤
 */
public class Attendance {
    private int Aid;    //编号
    private int Eid;    //员工ID
    private int Ename;  //员工姓名
    private float AOvertime;    //加班天数
    private float AEvection;    //出差天数
    private float AttendanceDays;   //考勤天数

    public int getAid() {
        return Aid;
    }

    public void setAid(int aid) {
        Aid = aid;
    }

    public int getEid() {
        return Eid;
    }

    public void setEid(int eid) {
        Eid = eid;
    }

    public int getEname() {
        return Ename;
    }

    public void setEname(int ename) {
        Ename = ename;
    }

    public float getAOvertime() {
        return AOvertime;
    }

    public void setAOvertime(float AOvertime) {
        this.AOvertime = AOvertime;
    }

    public float getAEvection() {
        return AEvection;
    }

    public void setAEvection(float AEvection) {
        this.AEvection = AEvection;
    }

    public float getAttendanceDays() {
        return AttendanceDays;
    }

    public void setAttendanceDays(float attendanceDays) {
        AttendanceDays = attendanceDays;
    }
}
