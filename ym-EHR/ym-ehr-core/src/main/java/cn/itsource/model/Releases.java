package cn.itsource.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ehr_releases")
public class Releases {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 技能要求
     */
    @Column(name = "skillsRequired")
    private String skillsrequired;

    /**
     * 招聘人数
     */
    private Integer hiring;

    /**
     * 薪资预算
     */
    @Column(name = "wageBudget")
    private Integer wagebudget;

    /**
     * 发起时间
     */
    @Column(name = "initiateTime")
    private Date initiatetime;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 备注
     */
    private String mark;

    /**
     * 发布人
     */
    @Column(name = "emp_id")
    private Integer empId;

    /**
     * 渠道
     */
    @Column(name = "channel_id")
    private Integer channelId;

    /**
     * 逻辑删除
     */
    @Column(name = "logicToDelete")
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
     * 获取技能要求
     *
     * @return skillsRequired - 技能要求
     */
    public String getSkillsrequired() {
        return skillsrequired;
    }

    /**
     * 设置技能要求
     *
     * @param skillsrequired 技能要求
     */
    public void setSkillsrequired(String skillsrequired) {
        this.skillsrequired = skillsrequired;
    }

    /**
     * 获取招聘人数
     *
     * @return hiring - 招聘人数
     */
    public Integer getHiring() {
        return hiring;
    }

    /**
     * 设置招聘人数
     *
     * @param hiring 招聘人数
     */
    public void setHiring(Integer hiring) {
        this.hiring = hiring;
    }

    /**
     * 获取薪资预算
     *
     * @return wageBudget - 薪资预算
     */
    public Integer getWagebudget() {
        return wagebudget;
    }

    /**
     * 设置薪资预算
     *
     * @param wagebudget 薪资预算
     */
    public void setWagebudget(Integer wagebudget) {
        this.wagebudget = wagebudget;
    }

    /**
     * 获取发起时间
     *
     * @return initiateTime - 发起时间
     */
    public Date getInitiatetime() {
        return initiatetime;
    }

    /**
     * 设置发起时间
     *
     * @param initiatetime 发起时间
     */
    public void setInitiatetime(Date initiatetime) {
        this.initiatetime = initiatetime;
    }

    /**
     * 获取状态
     *
     * @return state - 状态
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态
     *
     * @param state 状态
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取备注
     *
     * @return mark - 备注
     */
    public String getMark() {
        return mark;
    }

    /**
     * 设置备注
     *
     * @param mark 备注
     */
    public void setMark(String mark) {
        this.mark = mark;
    }

    /**
     * 获取发布人
     *
     * @return emp_id - 发布人
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * 设置发布人
     *
     * @param empId 发布人
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * 获取渠道
     *
     * @return channel_id - 渠道
     */
    public Integer getChannelId() {
        return channelId;
    }

    /**
     * 设置渠道
     *
     * @param channelId 渠道
     */
    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    /**
     * 获取逻辑删除
     *
     * @return logicToDelete - 逻辑删除
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
}