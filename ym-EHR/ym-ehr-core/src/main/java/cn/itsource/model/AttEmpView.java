package cn.itsource.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "v_att_emp")
public class AttEmpView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 打卡时间
     */
    @Column(name = "clockInTime")
    private Date clockintime;

    /**
     * 打卡位置
     */
    @Column(name = "clockInIocation")
    private String clockiniocation;

    /**
     * 标记
     */
    private Integer tag;

    /**
     * 员工
     */
    @Column(name = "emp_id")
    private Integer empId;

    /**
     * 逻辑删除
     */
    @Column(name = "logictoDelete")
    private Integer logictodelete;

    /**
     * 名字
     */
    private String name;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取打卡时间
     *
     * @return clockInTime - 打卡时间
     */
    public Date getClockintime() {
        return clockintime;
    }

    /**
     * 设置打卡时间
     *
     * @param clockintime 打卡时间
     */
    public void setClockintime(Date clockintime) {
        this.clockintime = clockintime;
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
     * 获取标记
     *
     * @return tag - 标记
     */
    public Integer getTag() {
        return tag;
    }

    /**
     * 设置标记
     *
     * @param tag 标记
     */
    public void setTag(Integer tag) {
        this.tag = tag;
    }

    /**
     * 获取员工
     *
     * @return emp_id - 员工
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * 设置员工
     *
     * @param empId 员工
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

    /**
     * 获取名字
     *
     * @return name - 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名字
     *
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name;
    }
}