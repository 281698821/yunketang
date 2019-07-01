package cn.itsource.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ehr_activity")
public class Activity {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 活动主题
     */
    private String theme;

    /**
     * 活动地址
     */
    @Column(name = "activityAddress")
    private String activityaddress;

    /**
     * 活动简介
     */
    private String introduce;

    /**
     * 活动详情
     */
    @Column(name = "activityTheDetail")
    private String activitythedetail;

    /**
     * 活动时间
     */
    @Column(name = "initateTime")
    private Date initatetime;

    /**
     * 活动消费
     */
    private Integer spending;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 组织人
     */
    @OneToMany
    @JoinColumn(name="emp_id")
    private Emp emp;

    /**
     * 逻辑删除字段
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
     * 获取活动主题
     *
     * @return theme - 活动主题
     */
    public String getTheme() {
        return theme;
    }

    /**
     * 设置活动主题
     *
     * @param theme 活动主题
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * 获取活动地址
     *
     * @return activityAddress - 活动地址
     */
    public String getActivityaddress() {
        return activityaddress;
    }

    /**
     * 设置活动地址
     *
     * @param activityaddress 活动地址
     */
    public void setActivityaddress(String activityaddress) {
        this.activityaddress = activityaddress;
    }

    /**
     * 获取活动简介
     *
     * @return introduce - 活动简介
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * 设置活动简介
     *
     * @param introduce 活动简介
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    /**
     * 获取活动详情
     *
     * @return activityTheDetail - 活动详情
     */
    public String getActivitythedetail() {
        return activitythedetail;
    }

    /**
     * 设置活动详情
     *
     * @param activitythedetail 活动详情
     */
    public void setActivitythedetail(String activitythedetail) {
        this.activitythedetail = activitythedetail;
    }

    /**
     * 获取活动时间
     *
     * @return initateTime - 活动时间
     */
    public Date getInitatetime() {
        return initatetime;
    }

    /**
     * 设置活动时间
     *
     * @param initatetime 活动时间
     */
    public void setInitatetime(Date initatetime) {
        this.initatetime = initatetime;
    }

    /**
     * 获取活动消费
     *
     * @return spending - 活动消费
     */
    public Integer getSpending() {
        return spending;
    }

    /**
     * 设置活动消费
     *
     * @param spending 活动消费
     */
    public void setSpending(Integer spending) {
        this.spending = spending;
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

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
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

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                ", activityaddress='" + activityaddress + '\'' +
                ", introduce='" + introduce + '\'' +
                ", activitythedetail='" + activitythedetail + '\'' +
                ", initatetime=" + initatetime +
                ", spending=" + spending +
                ", state=" + state +
                ", emp=" + emp +
                ", logictodelete=" + logictodelete +
                '}';
    }
}