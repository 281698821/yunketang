package cn.itsource.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ehr_channel")
public class Channel {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 渠道名称或地址
     */
    private String name;

    /**
     * 备注
     */
    private String mark;

    /**
     * 渠道上传时间
     */
    @Column(name = "addTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date addtime;

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
     * 获取渠道名称或地址
     *
     * @return name - 渠道名称或地址
     */
    public String getName() {
        return name;
    }

    /**
     * 设置渠道名称或地址
     *
     * @param name 渠道名称或地址
     */
    public void setName(String name) {
        this.name = name;
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
     * 获取渠道上传时间
     *
     * @return addTime - 渠道上传时间
     */
    public Date getAddtime() {
        return addtime;
    }

    /**
     * 设置渠道上传时间
     *
     * @param addtime 渠道上传时间
     */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
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
}