package cn.itsource.model.wechat;

import javax.persistence.*;

@Table(name = "ehr_empdate")
public class EmpDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 员工id
     */
    private String userid;

    /**
     * 员工姓名
     */
    @Column(name = "empName")
    private String empname;

    /**
     * 打卡分组（如：上班日）
     */
    private String groupname;

    /**
     * 打卡类型（如：上下班）
     */
    @Column(name = "checkin_type")
    private String checkin_type;

    /**
     * 异常类型
     */
    @Column(name = "exception_type")
    private String exception_type;

    /**
     * 打卡时间
     */
    @Column(name = "checkin_time")
    private Long checkin_time;

    /**
     * 所属公司
     */
    @Column(name = "location_title")
    private String location_title;

    /**
     * 打卡地点
     */
    @Column(name = "location_detail")
    private String location_detail;

    private String wifiname;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取员工id
     *
     * @return userid - 员工id
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置员工id
     *
     * @param userid 员工id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取员工姓名
     *
     * @return empName - 员工姓名
     */
    public String getEmpname() {
        return empname;
    }

    /**
     * 设置员工姓名
     *
     * @param empname 员工姓名
     */
    public void setEmpname(String empname) {
        this.empname = empname;
    }

    /**
     * 获取打卡分组（如：上班日）
     *
     * @return groupname - 打卡分组（如：上班日）
     */
    public String getGroupname() {
        return groupname;
    }

    /**
     * 设置打卡分组（如：上班日）
     *
     * @param groupname 打卡分组（如：上班日）
     */
    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }


    /**
     * @return wifiname
     */
    public String getWifiname() {
        return wifiname;
    }

    /**
     * @param wifiname
     */
    public void setWifiname(String wifiname) {
        this.wifiname = wifiname;
    }

    public String getCheckin_type() {
        return checkin_type;
    }

    public void setCheckin_type(String checkin_type) {
        this.checkin_type = checkin_type;
    }

    public String getException_type() {
        return exception_type;
    }

    public void setException_type(String exception_type) {
        this.exception_type = exception_type;
    }

    public Long getCheckin_time() {
        return checkin_time;
    }

    public void setCheckin_time(Long checkin_time) {
        this.checkin_time = checkin_time;
    }

    public String getLocation_title() {
        return location_title;
    }

    public void setLocation_title(String location_title) {
        this.location_title = location_title;
    }

    public String getLocation_detail() {
        return location_detail;
    }

    public void setLocation_detail(String location_detail) {

        this.location_detail = location_detail;
    }

    @Override
    public String toString() {
        return "EmpDate{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", empname='" + empname + '\'' +
                ", groupname='" + groupname + '\'' +
                ", checkin_type='" + checkin_type + '\'' +
                ", exception_type='" + exception_type + '\'' +
                ", checkin_time=" + checkin_time +
                ", location_title='" + location_title + '\'' +
                ", location_detail='" + location_detail + '\'' +
                ", wifiname='" + wifiname + '\'' +
                '}';
    }
}