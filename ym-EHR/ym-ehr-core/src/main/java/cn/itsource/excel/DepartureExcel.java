package cn.itsource.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.itsource.model.Emp;

import java.io.Serializable;
import java.util.Date;


public class DepartureExcel implements Serializable {
    @Excel(name = "编号")
    private Integer id;

    @Excel(name = "离职说明")
    private String instructions;

    @Excel(name = "离职时间",width = 30, format = "yyyy-MM-dd")
    private Date departuretime;

    private Integer empId;
    @Excel(name = "对应员工")
    private String empName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Date getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(Date departuretime) {
        this.departuretime = departuretime;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
