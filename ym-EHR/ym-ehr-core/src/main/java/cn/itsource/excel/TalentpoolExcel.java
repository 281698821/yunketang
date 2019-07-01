package cn.itsource.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;


public class TalentpoolExcel implements java.io.Serializable{
    @Excel(name = "编号")
    private Integer id;

    @Excel(name = "名字",width = 25)
    private String name;

    @Excel(name = "性别", replace = { "男_1", "女_0" })
    private Integer sex;

    @Excel(name = "电话",width = 30)
    private String phone;

    @Excel(name = "qq",width = 30)
    private String qq;

    @Excel(name = "邮箱",width = 30)
    private String email;

    @Excel(name = "年龄")
    private Integer age;

    @Excel(name = "现住址",width = 50)
    private String currentaddress;

    @Excel(name = "技术特长",width = 30)
    private String specialty;

    @Excel(name = "圈内评价",width = 30)
    private String comments;

    @Excel(name = "现所在公司",width = 30)
    private String asthecompany;

    @Excel(name = "备注",width = 30)
    private String mark;




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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAsthecompany() {
        return asthecompany;
    }

    public void setAsthecompany(String asthecompany) {
        this.asthecompany = asthecompany;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }


}