package cn.itsource.model;

import javax.persistence.*;

@Table(name = "ehr_rule")
public class Rule {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 规则名称
     */
    @Column(name = "rulesName")
    private String rulesname;

    /**
     * 打卡次数
     */
    @Column(name = "clockInNum")
    private Integer clockinnum;

    /**
     * 上午上班打卡时间
     */
    @Column(name = "amStartTime")
    private String amstarttime;

    /**
     * 上午下班打卡时间
     */
    @Column(name = "amEndTime")
    private String amendtime;

    /**
     * 下午上班打卡时间
     */
    @Column(name = "pmStartTime")
    private String pmstarttime;

    /**
     * 下午下班打卡时间
     */
    @Column(name = "pmEndTime")
    private String pmendtime;

    /**
     * 打卡位置
     */
    @Column(name = "clockInIocation")
    private String clockiniocation;

    /**
     * 说明
     */
    private Integer instructions;

    /**
     * 规则发布人
     */
    @Column(name = "emp_id")
    private Integer empId;

    /**
     * 逻辑删除
     */
    @Column(name = "logictoDelete")
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
     * 获取规则名称
     *
     * @return rulesName - 规则名称
     */
    public String getRulesname() {
        return rulesname;
    }

    /**
     * 设置规则名称
     *
     * @param rulesname 规则名称
     */
    public void setRulesname(String rulesname) {
        this.rulesname = rulesname;
    }

    /**
     * 获取打卡次数
     *
     * @return clockInNum - 打卡次数
     */
    public Integer getClockinnum() {
        return clockinnum;
    }

    /**
     * 设置打卡次数
     *
     * @param clockinnum 打卡次数
     */
    public void setClockinnum(Integer clockinnum) {
        this.clockinnum = clockinnum;
    }

    /**
     * 获取上午上班打卡时间
     *
     * @return amStartTime - 上午上班打卡时间
     */
    public String getAmstarttime() {
        return amstarttime;
    }

    /**
     * 设置上午上班打卡时间
     *
     * @param amstarttime 上午上班打卡时间
     */
    public void setAmstarttime(String amstarttime) {
        this.amstarttime = amstarttime;
    }

    /**
     * 获取上午下班打卡时间
     *
     * @return amEndTime - 上午下班打卡时间
     */
    public String getAmendtime() {
        return amendtime;
    }

    /**
     * 设置上午下班打卡时间
     *
     * @param amendtime 上午下班打卡时间
     */
    public void setAmendtime(String amendtime) {
        this.amendtime = amendtime;
    }

    /**
     * 获取下午上班打卡时间
     *
     * @return pmStartTime - 下午上班打卡时间
     */
    public String getPmstarttime() {
        return pmstarttime;
    }

    /**
     * 设置下午上班打卡时间
     *
     * @param pmstarttime 下午上班打卡时间
     */
    public void setPmstarttime(String pmstarttime) {
        this.pmstarttime = pmstarttime;
    }

    /**
     * 获取下午下班打卡时间
     *
     * @return pmEndTime - 下午下班打卡时间
     */
    public String getPmendtime() {
        return pmendtime;
    }

    /**
     * 设置下午下班打卡时间
     *
     * @param pmendtime 下午下班打卡时间
     */
    public void setPmendtime(String pmendtime) {
        this.pmendtime = pmendtime;
    }

    /**
     * 获取打卡位置
     *
     * @return clockInIocation - 打卡位置
     */
    public String getClockiniocation() {
        return clockiniocation;
    }

    /**
     * 设置打卡位置
     *
     * @param clockiniocation 打卡位置
     */
    public void setClockiniocation(String clockiniocation) {
        this.clockiniocation = clockiniocation;
    }

    /**
     * 获取说明
     *
     * @return instructions - 说明
     */
    public Integer getInstructions() {
        return instructions;
    }

    /**
     * 设置说明
     *
     * @param instructions 说明
     */
    public void setInstructions(Integer instructions) {
        this.instructions = instructions;
    }

    /**
     * 获取规则发布人
     *
     * @return emp_id - 规则发布人
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * 设置规则发布人
     *
     * @param empId 规则发布人
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * 获取逻辑删除
     *
     * @return logictoDelete - 逻辑删除
     */
    public Integer getLogictodelete() {
        return logictodelete;
    }

    /**
     * 设置逻辑删除
     *
     * @param logictodelete 逻辑删除
     */
    public void setLogictodelete(Integer logictodelete) {
        this.logictodelete = logictodelete;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "id=" + id +
                ", rulesname='" + rulesname + '\'' +
                ", clockinnum=" + clockinnum +
                ", amstarttime='" + amstarttime + '\'' +
                ", amendtime='" + amendtime + '\'' +
                ", pmstarttime='" + pmstarttime + '\'' +
                ", pmendtime='" + pmendtime + '\'' +
                ", clockiniocation='" + clockiniocation + '\'' +
                ", instructions=" + instructions +
                ", empId=" + empId +
                ", logictodelete=" + logictodelete +
                '}';
    }
}