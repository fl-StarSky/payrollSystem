package com.ncu.zhuoyuejike.fuli.payrollsystem.bean;

/**
 * Created by Administrator on 2016/7/13.
 * 员工
 */
public class Employee {
    private int Eid;    //员工ID
    private String Ename;   //姓名
    private String Ejob;    //职务
    private String Edepartment; //部门
    private float EBasicSalary; //基本工资
    private float EOvertimeAllowance;   //加班津贴
    private float EAnnualBonus; //年终奖==（员工本年度的工资总和＋津贴的总和）/12）

    public int getEid() {
        return Eid;
    }

    public void setEid(int eid) {
        Eid = eid;
    }

    public String getEname() {
        return Ename;
    }

    public void setEname(String ename) {
        Ename = ename;
    }

    public String getEjob() {
        return Ejob;
    }

    public void setEjob(String ejob) {
        Ejob = ejob;
    }

    public String getEdepartment() {
        return Edepartment;
    }

    public void setEdepartment(String edepartment) {
        Edepartment = edepartment;
    }

    public float getEBasicSalary() {
        return EBasicSalary;
    }

    public void setEBasicSalary(float EBasicSalary) {
        this.EBasicSalary = EBasicSalary;
    }

    public float getEOvertimeAllowance() {
        return EOvertimeAllowance;
    }

    public void setEOvertimeAllowance(float EOvertimeAllowance) {
        this.EOvertimeAllowance = EOvertimeAllowance;
    }

    public float getEAnnualBonus() {
        return EAnnualBonus;
    }

    public void setEAnnualBonus(float EAnnualBonus) {
        this.EAnnualBonus = EAnnualBonus;
    }
}
