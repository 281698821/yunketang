package cn.itsource.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;

import java.io.Serializable;

public class DeptExcel implements Serializable {
    /**
     * 编号
     */

    @Excel(name = "编号")
    private Integer id;

    /**
     * 部门名称
     */
    /* @Excel(name = "主讲老师_teacherEntity,代课老师_absent",
    isImportField = "true_major,true_absent")*/
    @Excel(name = "部门名称",width = 30)
    private String name;

    /**
     * 备注
     */
    @Excel(name = "备注",width = 30)
    private String mark;

    /**
     * 所属公司
     */
    @ExcelEntity
    private CompanyNameExcel companyNameExcel;

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
     * 获取部门名称
     *
     * @return name - 部门名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置部门名称
     *
     * @param name 部门名称
     */
    public void setName(String name) {
        this.name = name;
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

    /*public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }*/

    public CompanyNameExcel getCompanyNameExcel() {
        return companyNameExcel;
    }

    public void setCompanyNameExcel(CompanyNameExcel companyNameExcel) {
        this.companyNameExcel = companyNameExcel;
    }
}
