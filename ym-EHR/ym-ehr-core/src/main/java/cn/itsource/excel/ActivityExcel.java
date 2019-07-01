package cn.itsource.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@SuppressWarnings("serial")
@Data
public class ActivityExcel implements java.io.Serializable {
    @Excel(name = "编号")
    private Integer id;

    /**
     * 活动主题
     */
    @Excel(name = "活动主题")
    private String theme;

    /**
     * 活动地址
     */
    @Excel(name = "活动主题")
    private String activityaddress;

    /**
     * 活动简介
     */
    @Excel(name = "活动简介")
    private String introduce;

    /**
     * 活动详情
     */

    @Excel(name = "活动详情")
    private String activitythedetail;

    /**
     * 活动时间
     */
    @Excel(name = "活动时间",width = 30, format = "yyyy-MM-dd")
    private Date initatetime;

    /**
     * 活动消费
     */
    @Excel(name = "活动消费")
    private Integer spending;

    /**
     * 状态
     */
    @Excel(name = "状态", replace = { "通过_1", "不通过_0" })
    private Integer state;

    /**
     * 组织人
     */
    @Excel(name = "组织人")
    private String emp;



}
