package cn.itsource.model;

import javax.persistence.*;

@Table(name = "ehr_paygrades")
public class Paygrades {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 等级名称
     */
    private String name;

    /**
     * 对应工资
     */
    private Integer salary;

    /**
     * 备注
     */
    private String mark;

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
     * 获取等级名称
     *
     * @return name - 等级名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置等级名称
     *
     * @param name 等级名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取对应工资
     *
     * @return salary - 对应工资
     */
    public Integer getSalary() {
        return salary;
    }

    /**
     * 设置对应工资
     *
     * @param salary 对应工资
     */
    public void setSalary(Integer salary) {
        this.salary = salary;
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