package cn.itsource.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

public class PaygradesExcel implements Serializable {
    /**
     * 编号
     */
   @Excel(name = "编号")
    private Integer id;

    /**
     * 等级名称
     */
    @Excel(name = "等级名称")
    private String name;

    /**
     * 对应工资
     */
    @Excel(name = "对应工资")
    private Integer salary;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String mark;

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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
