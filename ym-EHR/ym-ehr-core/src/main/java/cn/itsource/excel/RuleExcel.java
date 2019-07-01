package cn.itsource.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import javax.persistence.*;

@SuppressWarnings("serial")
@ExcelTarget("rule")
public class RuleExcel {
    @Excel(name = "编号")
    private Integer id;
    @Excel(name = "规则名称",width = 30)
    private String rulesname;

    /**
     * 打卡次数
     */
    @Excel(name = "打卡次数")
    private Integer clockinnum;

    /**
     * 上午上班打卡时间
     */
    @Excel(name = "上午上班打卡时间")
    private String amstarttime;

    /**
     * 上午下班打卡时间
     */
    @Excel(name = "上午下班打卡时间")
    private String amendtime;

    /**
     * 下午上班打卡时间
     */
    @Excel(name = "下午上班打卡时间")
    private String pmstarttime;

    /**
     * 下午下班打卡时间
     */
    @Excel(name = "下午下班打卡时间")
    private String pmendtime;

    /**
     * 打卡位置
     */
    @Excel(name = "打卡位置",width = 30)
    private String clockiniocation;

    /**
     * 说明
     */
    @Excel(name = "备注")
    private Integer instructions;

    /**
     * 规则发布人
     */
    @Excel(name = "规则发布人")
    private String empName;
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

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}