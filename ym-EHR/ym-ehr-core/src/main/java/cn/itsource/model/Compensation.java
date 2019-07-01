package cn.itsource.model;

import javax.persistence.*;

@Table(name = "ehr_compensation")
public class Compensation {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 基本工资
     */
    @Column(name = "basicSalary")
    private Integer basicsalary;

    /**
     * 补贴
     */
    private Integer subsidies;

    /**
     * 社保率
     */
    @Column(name = "socialSecurity_id")
    private Integer socialsecurityId;

    /**
     * 对应员工
     */
    @Column(name = "emp_id")
    private Integer empId;




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
     * 获取基本工资
     *
     * @return basicSalary - 基本工资
     */
    public Integer getBasicsalary() {
        return basicsalary;
    }

    /**
     * 设置基本工资
     *
     * @param basicsalary 基本工资
     */
    public void setBasicsalary(Integer basicsalary) {
        this.basicsalary = basicsalary;
    }

    /**
     * 获取补贴
     *
     * @return subsidies - 补贴
     */
    public Integer getSubsidies() {
        return subsidies;
    }

    /**
     * 设置补贴
     *
     * @param subsidies 补贴
     */
    public void setSubsidies(Integer subsidies) {
        this.subsidies = subsidies;
    }

    /**
     * 获取社保率
     *
     * @return socialSecurity_id - 社保率
     */
    public Integer getSocialsecurityId() {
        return socialsecurityId;
    }

    public void setSocialsecurityId(Integer socialsecurityId) {
        this.socialsecurityId = socialsecurityId;
    }

    /**
     * 获取对应员工
     *
     * @return emp_id - 对应员工
     */
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
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
        return "Compensation{" +
                "id=" + id +
                ", basicsalary=" + basicsalary +
                ", subsidies=" + subsidies +
                ", socialsecurityId=" + socialsecurityId +
                ", empId=" + empId +
                ", logictodelete=" + logictodelete +
                '}';
    }
}