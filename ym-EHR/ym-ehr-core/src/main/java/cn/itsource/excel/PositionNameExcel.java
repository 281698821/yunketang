package cn.itsource.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;

import java.io.Serializable;

public class PositionNameExcel implements Serializable {
    /**
     * 职位名称
     */
    @Excel(name = "职位名称",width = 30)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
