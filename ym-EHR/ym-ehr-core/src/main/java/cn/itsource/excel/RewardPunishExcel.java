package cn.itsource.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

public class RewardPunishExcel implements Serializable {
    @Excel(name = "编号")
    private Integer id;

    @Excel(name = "情况说明")
    private String situation;

    @Excel(name = "金额")
    private Integer money;

    @Excel(name = "判断",replace = { "是_1", "否_0" })
    private Integer judge;


    @Excel(name = "奖罚时间",width = 30,format = "yy-MM-dd")
    private Date time;

    @Excel(name = "对应员工")
    private Integer empId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getJudge() {
        return judge;
    }

    public void setJudge(Integer judge) {
        this.judge = judge;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }
}
