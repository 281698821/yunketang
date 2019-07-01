package cn.itsource.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ehr_articlewages")
public class Articlewages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 员工id
     */
    @Column(name = "emp_id")
    private Integer empId;

    /**
     * 对应员工
     */
    @Column(name = "empName")
    private String empname;

    /**
     * 应发工资
     */
    @Column(name = "shouldSend")
    private Integer shouldsend;

    /**
     * 奖金
     */
    private Integer bonus;

    /**
     * 罚款
     */
    private Integer fine;

    /**
     * 投保
     */
    private Integer insured;

    /**
     * 发放时间
     */
    private Date time = new Date();

    /**
     * 实发工资
     */
    @Column(name = "realHair")
    private Integer realhair;

    /**
     * 逻辑删除字段
     */
    @Column(name = "logicToDelete")
    private Integer logictodelete;
    private Emp emp;

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    @Override
    public String  toString() {
        return "Articlewages{" +
                "id=" + id +
                ", empId=" + empId +
                ", empname='" + empname + '\'' +
                ", shouldsend=" + shouldsend +
                ", bonus=" + bonus +
                ", fine=" + fine +
                ", insured=" + insured +
                ", time=" + time +
                ", realhair=" + realhair +
                ", logictodelete=" + logictodelete +

                '}';
    }



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
     * @return emp_id - 员工id
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * 设置员工id
     *
     * @param empId 员工id
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * 获取对应员工
     *
     * @return empName - 对应员工
     */
    public String getEmpname() {
        return empname;
    }

    /**
     * 设置对应员工
     *
     * @param empname 对应员工
     */
    public void setEmpname(String empname) {
        this.empname = empname;
    }

    /**
     * 获取应发工资
     *
     * @return shouldSend - 应发工资
     */
    public Integer getShouldsend() {
        return shouldsend;
    }

    /**
     * 设置应发工资
     *
     * @param shouldsend 应发工资
     */
    public void setShouldsend(Integer shouldsend) {
        this.shouldsend = shouldsend;
    }

    /**
     * 获取奖金
     *
     * @return bonus - 奖金
     */
    public Integer getBonus() {
        return bonus;
    }

    /**
     * 设置奖金
     *
     * @param bonus 奖金
     */
    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    /**
     * 获取罚款
     *
     * @return fine - 罚款
     */
    public Integer getFine() {
        return fine;
    }

    /**
     * 设置罚款
     *
     * @param fine 罚款
     */
    public void setFine(Integer fine) {
        this.fine = fine;
    }

    /**
     * 获取投保
     *
     * @return insured - 投保
     */
    public Integer getInsured() {
        return insured;
    }

    /**
     * 设置投保
     *
     * @param insured 投保
     */
    public void setInsured(Integer insured) {

        this.insured = insured;
    }

    /**
     * 获取发放时间
     *
     * @return time - 发放时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getTime() {
        return time;
    }

    /**
     * 设置发放时间
     *
     * @param time 发放时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取实发工资
     *
     * @return realHair - 实发工资
     */
    public Integer getRealhair() {
        return realhair;
    }

    /**
     * 设置实发工资
     *
     * @param realhair 实发工资
     */
    public void setRealhair(Integer realhair) {
        this.realhair = realhair;
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
}