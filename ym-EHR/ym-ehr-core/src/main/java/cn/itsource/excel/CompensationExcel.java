package cn.itsource.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;


/**
 * 用途：保存员工薪资
 * 代号：离夜
 */
@SuppressWarnings("serial")
@ExcelTarget("companyEntity")
public class CompensationExcel implements java.io.Serializable {

    @Excel(name = "编号")
    private Integer id;

    /**
     * 对应员工
     */
    @ExcelEntity
    private EmpNameExcel empNameExcel;



    @Excel(name = "基本薪资")
    private Integer basicsalary;

    /**
     * 补贴
     */
    @Excel(name = "补贴")
    private Integer subsidies;
    /**
     * 社保率
     */
    @ExcelEntity
    private SocialsecurityExcel socialsecurityExcel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(Integer basicsalary) {
        this.basicsalary = basicsalary;
    }

    public Integer getSubsidies() {
        return subsidies;
    }

    public void setSubsidies(Integer subsidies) {
        this.subsidies = subsidies;
    }

    public SocialsecurityExcel getSocialsecurityExcel() {
        return socialsecurityExcel;
    }

    public void setSocialsecurityExcel(SocialsecurityExcel socialsecurityExcel) {
        this.socialsecurityExcel = socialsecurityExcel;
    }

    public EmpNameExcel getEmpNameExcel() {
        return empNameExcel;
    }

    public void setEmpNameExcel(EmpNameExcel empNameExcel) {
        this.empNameExcel = empNameExcel;
    }
}
