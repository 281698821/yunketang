package cn.itsource.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

public class PaygradesNameExcel implements Serializable {

    /**
     * 等级名称
     */
    @Excel(name = "薪资等级")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
