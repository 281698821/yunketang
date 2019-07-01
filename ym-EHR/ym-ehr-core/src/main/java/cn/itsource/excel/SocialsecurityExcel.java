package cn.itsource.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;
@ExcelTarget("SocialsecurityEntity")
public class SocialsecurityExcel implements Serializable {

    @Excel(name = "社保福利", suffix = "%")
    private Integer purchaserate;

    public Integer getPurchaserate() {
        return purchaserate;
    }

    public void setPurchaserate(Integer purchaserate) {
        this.purchaserate = purchaserate;
    }
}
