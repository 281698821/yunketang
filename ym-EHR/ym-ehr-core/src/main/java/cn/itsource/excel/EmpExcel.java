package cn.itsource.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.itsource.model.Dept;
import cn.itsource.model.Paygrades;
import cn.itsource.model.Position;

import java.util.Date;

public class EmpExcel {

    @Excel(name = "编号")
    private Integer id;

    /**
     * 证件照
     */
    @Excel(name = "头像",type=2,height=20)
    private String img;
    /**
     * 企业微信id
     */
    @Excel(name = "企业微信id")
    private String userid;

    /**
     * 名字
     */
    @Excel(name = "名字")
    private String name;

    /**
     * 密码
     */
    @Excel(name = "密码")
    private String password;


    /**
     * 出生日期
     */
    @Excel(name = "出生日期",width=30)
    private Date birthday;

    /**
     * 性别
     */
    @Excel(name = "性别")
    private String sex;

    /**
     * 电话
     */
    @Excel(name = "电话",width=30)
    private String phone;

    @Excel(name = "QQ",width=30)
    private String qq;

    /**
     * 邮箱
     */
    @Excel(name = "邮箱",width=30)
    private String email;

    /**
     * 年龄
     */
    @Excel(name = "年龄")
    private Integer age;

    /**
     * 现住址
     */
    @Excel(name = "现住址",width=30)
    private String currentaddress;

    /**
     * 入职时间
     */
    @Excel(name = "入职时间",width=30)
    private Date inductiontime;

    /**
     * 特长
     */
    @Excel(name = "特长",width=15)
    private String specialty;

    /**
     * 备注
     */
    @Excel(name = "备注",width=20)
    private String mark;

    /**
     * 部门
     */

    @ExcelEntity
    private DeptNameExcel deptNameExcel;

    /**
     * 薪资等级
     */
    @ExcelEntity
    private PaygradesNameExcel paygradesNameExcel;

    /**
     * 职位
     */
    @ExcelEntity
    private PositionNameExcel positionNameExcel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCurrentaddress() {
        return currentaddress;
    }

    public void setCurrentaddress(String currentaddress) {
        this.currentaddress = currentaddress;
    }

    public Date getInductiontime() {
        return inductiontime;
    }

    public void setInductiontime(Date inductiontime) {
        this.inductiontime = inductiontime;
    }


    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public DeptNameExcel getDeptNameExcel() {
        return deptNameExcel;
    }

    public void setDeptNameExcel(DeptNameExcel deptNameExcel) {
        this.deptNameExcel = deptNameExcel;
    }

    public PaygradesNameExcel getPaygradesNameExcel() {
        return paygradesNameExcel;
    }

    public void setPaygradesNameExcel(PaygradesNameExcel paygradesNameExcel) {
        this.paygradesNameExcel = paygradesNameExcel;
    }

    public PositionNameExcel getPositionNameExcel() {
        return positionNameExcel;
    }

    public void setPositionNameExcel(PositionNameExcel positionNameExcel) {
        this.positionNameExcel = positionNameExcel;
    }
}
