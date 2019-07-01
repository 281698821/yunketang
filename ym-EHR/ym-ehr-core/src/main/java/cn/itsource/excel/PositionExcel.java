package cn.itsource.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;

import java.io.Serializable;

public class PositionExcel implements Serializable {
    /**
     * 编号
     */
    @Excel(name = "编号")
    private Integer id;

    /**
     * 职位名称
     */
    @Excel(name = "职位名称",width = 30)
    private String name;

    /**
     * 备注
     */
    @Excel(name = "备注",width = 30)
    private String mark;

    /**
     * 对应部门
     */

    @ExcelEntity
    private DeptNameExcel deptNameExcel;

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
     * 获取编号
     *
     * @return name - 编号
     */
    public String getName() {
        return name;
    }

    /**
     * 设置编号
     *
     * @param name 编号
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

    //获得部门


    public DeptNameExcel getDeptNameExcel() {
        return deptNameExcel;
    }

    public void setDeptNameExcel(DeptNameExcel deptNameExcel) {
        this.deptNameExcel = deptNameExcel;
    }
}
