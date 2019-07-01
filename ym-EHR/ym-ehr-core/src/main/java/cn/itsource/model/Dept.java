package cn.itsource.model;

import javax.persistence.*;

@Table(name = "ehr_dept")
public class Dept {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 备注
     */
    private String mark;

    /**
     * 所属公司
     */
    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;

    /**
     * 逻辑删除
     */
    @Column(name = "logicToDelete")
    private Integer logictodelete;

    /**
     * crm_部门头像
     */
    private String avatar;

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
     * 获取部门名称
     *
     * @return name - 部门名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置部门名称
     *
     * @param name 部门名称
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

    /*public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }*/

     public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
     * 获取crm_部门头像
     *
     * @return avatar - crm_部门头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置crm_部门头像
     *
     * @param avatar crm_部门头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mark='" + mark + '\'' +
                ", company=" + company +
                ", logictodelete=" + logictodelete +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}