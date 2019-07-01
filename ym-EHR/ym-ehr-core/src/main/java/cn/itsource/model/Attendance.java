package cn.itsource.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ehr_attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "clockInTime")
    private Date clockintime;

    @Column(name = "clockInIocation")
    private String clockiniocation;

    private Integer tag;

    @Column(name = "emp_id")
    private Integer empId;

    @Column(name = "logictoDelete")
    private Integer logictodelete;

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
     * @return clockInTime
     */
    public Date getClockintime() {
        return clockintime;
    }

    /**
     * @param clockintime
     */
    public void setClockintime(Date clockintime) {
        this.clockintime = clockintime;
    }

    /**
     * @return clockInIocation
     */
    public String getClockiniocation() {
        return clockiniocation;
    }

    /**
     * @param clockiniocation
     */
    public void setClockiniocation(String clockiniocation) {
        this.clockiniocation = clockiniocation;
    }

    /**
     * @return tag
     */
    public Integer getTag() {
        return tag;
    }

    /**
     * @param tag
     */
    public void setTag(Integer tag) {
        this.tag = tag;
    }

    /**
     * @return emp_id
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * @param empId
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * @return logictoDelete
     */
    public Integer getLogictodelete() {
        return logictodelete;
    }

    /**
     * @param logictodelete
     */
    public void setLogictodelete(Integer logictodelete) {
        this.logictodelete = logictodelete;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", clockintime=" + clockintime +
                ", clockiniocation='" + clockiniocation + '\'' +
                ", tag=" + tag +
                ", empId=" + empId +
                ", logictodelete=" + logictodelete +
                '}';
    }
}