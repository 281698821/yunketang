package cn.itsource.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import java.util.Date;

public class ReleasesExcel implements java.io.Serializable{
    @Excel(name = "编号")
    private Integer id;

    @Excel(name = "技能要求",width = 30)
    private String skillsrequired;

    @Excel(name = "招聘人数")
    private Integer hiring;

    @Excel(name = "薪资预算",width = 30)
    private Integer wagebudget;

    @Excel(name = "发起时间",width = 30, format = "yyyy-MM-dd")
    private Date initiatetime;

    @Excel(name = "状态",width = 30,replace = {"已处理_1","未处理_2"})
    private Integer state;

    @Excel(name = "备注",width = 30)
    private String mark;

    @Excel(name = "发布人")
    private  String empName;
    //private Integer empId;

    @Excel(name = "渠道",width = 30)
    private String channeName;
    //private Integer channelId;*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkillsrequired() {
        return skillsrequired;
    }

    public void setSkillsrequired(String skillsrequired) {
        this.skillsrequired = skillsrequired;
    }

    public Integer getHiring() {
        return hiring;
    }

    public void setHiring(Integer hiring) {
        this.hiring = hiring;
    }

    public Integer getWagebudget() {
        return wagebudget;
    }

    public void setWagebudget(Integer wagebudget) {
        this.wagebudget = wagebudget;
    }

    public Date getInitiatetime() {
        return initiatetime;
    }

    public void setInitiatetime(Date initiatetime) {
        this.initiatetime = initiatetime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getChanneName() {
        return channeName;
    }

    public void setChanneName(String channeName) {
        this.channeName = channeName;
    }
}