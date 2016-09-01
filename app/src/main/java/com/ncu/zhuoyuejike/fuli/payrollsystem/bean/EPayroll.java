package com.ncu.zhuoyuejike.fuli.payrollsystem.bean;

import java.sql.Date;

/**
 * Created by Administrator on 2016/7/13.
 * 员工月工资表
 */
public class EPayroll {
    private int Eid;    //员工ID
    private String Ename;   //员工姓名
    private Date PayrollDate;   //工资日期
    private float EOvertimeAllowance;   //加班津贴
    private float EBonus;   //奖金
    private float EMonthSalary; //月工资

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

    public Date getPayrollDate() {
        return PayrollDate;
    }

    public void setPayrollDate(Date payrollDate) {
        PayrollDate = payrollDate;
    }

    public float getEOvertimeAllowance() {
        return EOvertimeAllowance;
    }

    public void setEOvertimeAllowance(float EOvertimeAllowance) {
        this.EOvertimeAllowance = EOvertimeAllowance;
    }

    public float getEBonus() {
        return EBonus;
    }

    public void setEBonus(float EBonus) {
        this.EBonus = EBonus;
    }

    public float getEMonthSalary() {
        return EMonthSalary;
    }

    public void setEMonthSalary(float EMonthSalary) {
        this.EMonthSalary = EMonthSalary;
    }
}
