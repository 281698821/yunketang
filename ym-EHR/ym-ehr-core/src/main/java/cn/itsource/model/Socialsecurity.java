package cn.itsource.model;

import javax.persistence.*;

@Table(name = "ehr_socialsecurity")
public class Socialsecurity {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 社保购买率//例：3,代表将员工本月应发工资的3%来投保,公司帮忙缴纳另外的3%
     */
    @Column(name = "purchaseRate")
    private Integer purchaserate;

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
     * 获取社保购买率//例：3,代表将员工本月应发工资的3%来投保,公司帮忙缴纳另外的3%
     *
     * @return purchaseRate - 社保购买率//例：3,代表将员工本月应发工资的3%来投保,公司帮忙缴纳另外的3%
     */
    public Integer getPurchaserate() {
        return purchaserate;
    }

    /**
     * 设置社保购买率//例：3,代表将员工本月应发工资的3%来投保,公司帮忙缴纳另外的3%
     *
     * @param purchaserate 社保购买率//例：3,代表将员工本月应发工资的3%来投保,公司帮忙缴纳另外的3%
     */
    public void setPurchaserate(Integer purchaserate) {
        this.purchaserate = purchaserate;
    }

    /**
     * @return logicToDelete
     */
    public Integer getLogictodelete() {
        return logictodelete;
    }

    /**
     * @param logictodelete
     */
    public void setLogictodelete(Integer logictodelete) {
        this.logictodelete = logictodelete;
    }
}