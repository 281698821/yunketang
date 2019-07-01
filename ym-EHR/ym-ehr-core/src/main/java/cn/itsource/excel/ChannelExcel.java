package cn.itsource.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

public class ChannelExcel implements java.io.Serializable{
    @Excel(name = "编号")
    private Integer id;

    @Excel(name = "渠道名称或地址" ,width = 30)
    private String name;

    @Excel(name = "备注",width = 50)
    private String mark;

    @Excel(name = "渠道上传时间",width = 30, format = "yyyy-MM-dd")
    private Date addtime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

}