package cn.itsource.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;
import java.util.Date;

public class ArticlewagesExcel implements Serializable {
    @Excel(name = "编号")
    private Integer id;
    @Excel(name = "姓名")
    private String empName;
    @Excel(name = "应发工资")
    private Integer shouldSend;
    @Excel(name = "奖金")
    private Integer bonus;
    @Excel(name = "罚款")
    private Integer fine;
    @Excel(name = "投保")
    private Integer insured;
    @Excel(name = "时间")
    private Date time;
    @Excel(name = "实发工资")
    private Integer realHair;
}
