package cn.itsource.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

public class CompanyNameExcel implements Serializable {

    /**
     * 公司名称
     */
    @Excel(name = "所属公司")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
