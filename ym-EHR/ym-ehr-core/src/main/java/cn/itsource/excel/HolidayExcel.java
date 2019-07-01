package cn.itsource.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

public class HolidayExcel {

    @Excel(name = "编号")
    private Integer id;

    /**
     * 节目名称
     */
    @Excel(name = "节目名称")
    private String name;

    /**
     * 节目时间
     */
    @Excel(name = "活动时间",width = 30, format = "yyyy-MM-dd")
    private Date time;

	@Excel(name = "节目祝福语")
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
