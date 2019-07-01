package cn.itsource.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ehr_company")
public class Company {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 公司所在地
     */
    private String address;

    /**
     * 备注
     */
    private String mark;

    /**
     * 逻辑删除
     */
    @Column(name = "logicToDelete")
    private Integer logictodelete;

    /**
     * 注册时间
     */
    @Column(name = "createTime")
    private Date createtime;

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
     * 获取公司名称
     *
     * @return name - 公司名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置公司名称
     *
     * @param name 公司名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取公司所在地
     *
     * @return address - 公司所在地
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置公司所在地
     *
     * @param address 公司所在地
     */
    public void setAddress(String address) {
        this.address = address;
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

    /**
     * 获取注册时间
     *
     * @return createTime - 注册时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置注册时间
     *
     * @param createtime 注册时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mark='" + mark + '\'' +
                ", logictodelete=" + logictodelete +
                ", createtime=" + createtime +
                '}';
    }
}