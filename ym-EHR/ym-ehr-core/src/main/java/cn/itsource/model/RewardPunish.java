package cn.itsource.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ehr_rewardpunish")
public class RewardPunish {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 情况说明
     */
    private String situation;

    /**
     * 金额
     */
    private Integer money;

    /**
     * 判断
     */
    private Integer judge;

    /**
     * 奖罚时间
     */
    private Date time;

    /**
     * 对应员工
     */
    @Column(name = "emp_id")
    private Integer empId;
    private Emp emp;

    /**
     * 逻辑删除字段
     */
    private Integer logictodelete;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取情况说明
     *
     * @return situation - 情况说明
     */
    public String getSituation() {
        return situation;
    }

    /**
     * 设置情况说明
     *
     * @param situation 情况说明
     */
    public void setSituation(String situation) {
        this.situation = situation;
    }

    /**
     * 获取金额
     *
     * @return money - 金额
     */
    public Integer getMoney() {
        return money;
    }

    /**
     * 设置金额
     *
     * @param money 金额
     */
    public void setMoney(Integer money) {
        this.money = money;
    }

    /**
     * 获取判断
     *
     * @return judge - 判断
     */
    public Integer getJudge() {
        return judge;
    }

    /**
     * 设置判断
     *
     * @param judge 判断
     */
    public void setJudge(Integer judge) {
        this.judge = judge;
    }

    /**
     * 获取奖罚时间
     *
     * @return time - 奖罚时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置奖罚时间
     *
     * @param time 奖罚时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取对应员工
     *
     * @return emp_id - 对应员工
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * 设置对应员工
     *
     * @param empId 对应员工
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * 获取逻辑删除字段
     *
     * @return logicToDelete - 逻辑删除字段
     */
    public Integer getLogictodelete() {
        return logictodelete;
    }

    /**
     * 设置逻辑删除字段
     *
     * @param logictodelete 逻辑删除字段
     */
    public void setLogictodelete(Integer logictodelete) {
        this.logictodelete = logictodelete;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public Emp getEmp() {
        return emp;
    }

    @Override
    public String toString() {
        return "RewardPunish{" +
                "id=" + id +
                ", situation='" + situation + '\'' +
                ", money=" + money +
                ", judge=" + judge +
                ", time=" + time +
                ", empId=" + empId +
                ", logictodelete=" + logictodelete +
                '}';
    }
}