package cn.itsource.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ehr_departure")
public class Departure {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 离职说明
     */
    private String instructions;

    /**
     * 离职时间
     */
    @Column(name = "departureTime")
    private Date departuretime;

    /**
     * 离职员工
     */
    @Column(name = "emp_id")
    private Integer empId;

    /**
     * 逻辑删除字段
     */
    @Column(name = "logicToDelete")
    private Integer logictodelete;

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
     * 获取离职说明
     *
     * @return instructions - 离职说明
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * 设置离职说明
     *
     * @param instructions 离职说明
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    /**
     * 获取离职时间
     *
     * @return departureTime - 离职时间
     */
    public Date getDeparturetime() {
        return departuretime;
    }

    /**
     * 设置离职时间
     *
     * @param departuretime 离职时间
     */
    public void setDeparturetime(Date departuretime) {
        this.departuretime = departuretime;
    }

    /**
     * 获取离职员工
     *
     * @return emp_id - 离职员工
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * 设置离职员工
     *
     * @param empId 离职员工
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * 获取逻辑删除字段
     *
     * @return logicToDelete - 逻辑删除字段
     */
    public Integer getLogictodelete() {
        return logictodelete;
    }

    /**
     * 设置逻辑删除字段
     *
     * @param logictodelete 逻辑删除字段
     */
    public void setLogictodelete(Integer logictodelete) {
        this.logictodelete = logictodelete;
    }

    @Override
    public String toString() {
        return "Departure{" +
                "id=" + id +
                ", instructions='" + instructions + '\'' +
                ", departuretime=" + departuretime +
                ", empId=" + empId +
                ", logictodelete=" + logictodelete +
                '}';
    }
}