package cn.itsource.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;
import java.util.Date;

//@ExcelTarget("companyEntity")
public class CompanyExcel implements Serializable {
    /**
     * 编号
     */
    @Excel(name = "编号")
    private Integer id;

    /**
     * 公司名称
     */
    @Excel(name = "公司名称",width = 30)
    private String name;

    /**
     * 公司所在地
     */
    @Excel(name = "公司所在地",width = 30)
    private String address;

    /**
     * 备注
     */
    @Excel(name = "备注",width = 30)
    private String mark;

    /**
     * 注册时间
     */
    @Excel(name = "注册时间",width = 30,format="yyyy-MM-dd")
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
     * 获取注册时间
     *
     * @return createTime - 注册时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
