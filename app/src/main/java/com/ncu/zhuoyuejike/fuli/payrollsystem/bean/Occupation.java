package com.ncu.zhuoyuejike.fuli.payrollsystem.bean;

/**
 * Created by Administrator on 2016/7/13.
 * 工种
 * 反映员工的工种、等级，基本工资等信息
 */
public class Occupation {
    private occupate EmpOccup;  //工种
    //产品，市场，美工，测试，网页，移动
    enum occupate{PRODUCT,MARKET,UI,TEST,WEB,ANDROID}
    private int OGrage; //等级，按工作年限
    private float EBasicSalary; //基本工资

    public occupate getEmpOccup() {
        return EmpOccup;
    }

    public void setEmpOccup(occupate empOccup) {
        EmpOccup = empOccup;
    }

    public int getOGrage() {
        return OGrage;
    }

    public void setOGrage(int OGrage) {
        this.OGrage = OGrage;
    }

    public float getEBasicSalary() {
        return EBasicSalary;
    }

    public void setEBasicSalary(float EBasicSalary) {
        this.EBasicSalary = EBasicSalary;
    }
}
