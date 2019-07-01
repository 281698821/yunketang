package cn.itsource.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("serial")
public class AttEmpViewExcel {
    @Excel(name = "编号")
    private Integer id;
    @Excel(name = "打卡时间" ,width = 30,format = "yyyy-MM-dd HH:mm:ss")
    private Date clockintime;
    @Excel(name = "打卡地点")
    private String clockiniocation;
    @Excel(name = "标记")
    private Integer tag;
    @Excel(name = "工号")
    private Integer empId;
    @Excel(name = "员工姓名")
    private String name;

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