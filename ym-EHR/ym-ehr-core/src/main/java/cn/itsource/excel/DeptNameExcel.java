package cn.itsource.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

public class DeptNameExcel implements Serializable {

    @Excel(name = "所属部门")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
