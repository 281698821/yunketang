package cn.itsource.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ehr_applicant")
public class Applicant {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 名字
     */
    private String name;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 电话
     */
    private String phone;

    private String qq;

    /**
     * 箱邮
     */
    private String email;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 现住址
     */
    @Column(name = "currentAddress")
    private String currentaddress;

    /**
     * 应聘时间
     */
    @Column(name = "applicantTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date applicanttime;

    /**
     * 技术特长
     */
    private String specialty;

    /**
     * 试官评价面
     */
    private String comments;

    /**
     * 备注
     */
    private String mark;

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
     * 获取名字
     *
     * @return name - 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名字
     *
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取箱邮
     *
     * @return email - 箱邮
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置箱邮
     *
     * @param email 箱邮
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取现住址
     *
     * @return currentAddress - 现住址
     */
    public String getCurrentaddress() {
        return currentaddress;
    }

    /**
     * 设置现住址
     *
     * @param currentaddress 现住址
     */
    public void setCurrentaddress(String currentaddress) {
        this.currentaddress = currentaddress;
    }

    /**
     * 获取应聘时间
     *
     * @return applicantTime - 应聘时间
     */
    public Date getApplicanttime() {
        return applicanttime;
    }

    /**
     * 设置应聘时间
     *
     * @param applicanttime 应聘时间
     */
    public void setApplicanttime(Date applicanttime) {
        this.applicanttime = applicanttime;
    }

    /**
     * 获取技术特长
     *
     * @return specialty - 技术特长
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * 设置技术特长
     *
     * @param specialty 技术特长
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    /**
     * 获取试官评价面
     *
     * @return comments - 试官评价面
     */
    public String getComments() {
        return comments;
    }

    /**
     * 设置试官评价面
     *
     * @param comments 试官评价面
     */
    public void setComments(String comments) {
        this.comments = comments;
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
        return "Applicant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", currentaddress='" + currentaddress + '\'' +
                ", applicanttime=" + applicanttime +
                ", specialty='" + specialty + '\'' +
                ", comments='" + comments + '\'' +
                ", mark='" + mark + '\'' +
                ", logictodelete=" + logictodelete +
                '}';
    }
}