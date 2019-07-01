package cn.itsource.model;


import java.util.Date;
import javax.persistence.*;

@Table(name = "ehr_emp")
public class Emp {
    /**
     * 工号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 企业微信id
     */
    private String userid;

    /**
     * crm_签名
     */
    private String sign;

    /**
     * crm_头像
     */
    private String avatar;

    /**
     * 名字
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 证件照
     */
    private String img;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 性别
     */
    private String sex;

    /**
     * 电话
     */
    private String phone;

    @Column(name = "QQ")
    private String qq;

    /**
     * 邮箱
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
     * 入职时间
     */
    @Column(name = "inductionTime")
    private Date inductiontime;

    /**
     * 状态//五种情况：在职(1)，出差(2)，离职(3)，休假(4)，请假(5)
     */
    private Integer state;

    /**
     * 特长
     */
    private String specialty;

    /**
     * 备注
     */
    private String mark;

    /**
     * 是否已经登录系统 1.已经登录 0未登录
     */
    @Column(name = "isLogin")
    private Integer islogin;

    /**
     * 部门
     */
    @Column(name = "dept_id")
    private Integer deptId;

    @ManyToOne
    @JoinColumn(name="dept_id")
    private Dept dept;

    /**
     * 薪资等级
     */
    @Column(name = "paygrades_id")
    private Integer paygradesId;

    @ManyToOne
    @JoinColumn(name="paygrades_id")
    private Paygrades paygrades;

    /**
     * 职位
     */
    @Column(name = "position_id")
    private Integer positionId;

    @ManyToOne
    @JoinColumn(name="position_id")
    private Position position;

    /**
     * 逻辑删除（默认为1，删除后为0）
     */
    @Column(name = "logicToDelete")
    private Integer logictodelete;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Paygrades getPaygrades() {
        return paygrades;
    }

    public void setPaygrades(Paygrades paygrades) {
        this.paygrades = paygrades;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * 获取工号
     *
     * @return id - 工号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置工号
     *
     * @param id 工号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取企业微信id
     *
     * @return userid - 企业微信id
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置企业微信id
     *
     * @param userid 企业微信id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取crm_签名
     *
     * @return sign - crm_签名
     */
    public String getSign() {
        return sign;
    }

    /**
     * 设置crm_签名
     *
     * @param sign crm_签名
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * 获取crm_头像
     *
     * @return avatar - crm_头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置crm_头像
     *
     * @param avatar crm_头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取证件照
     *
     * @return img - 证件照
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置证件照
     *
     * @param img 证件照
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 获取出生日期
     *
     * @return birthday - 出生日期
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置出生日期
     *
     * @param birthday 出生日期
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
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
     * @return QQ
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
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
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
     * 获取入职时间
     *
     * @return inductionTime - 入职时间
     */
    public Date getInductiontime() {
        return inductiontime;
    }

    /**
     * 设置入职时间
     *
     * @param inductiontime 入职时间
     */
    public void setInductiontime(Date inductiontime) {
        this.inductiontime = inductiontime;
    }

    /**
     * 获取状态//五种情况：在职(1)，出差(2)，离职(3)，休假(4)，请假(5)
     *
     * @return state - 状态//五种情况：在职(1)，出差(2)，离职(3)，休假(4)，请假(5)
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态//五种情况：在职(1)，出差(2)，离职(3)，休假(4)，请假(5)
     *
     * @param state 状态//五种情况：在职(1)，出差(2)，离职(3)，休假(4)，请假(5)
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取特长
     *
     * @return specialty - 特长
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * 设置特长
     *
     * @param specialty 特长
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
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
     * 获取是否已经登录系统 1.已经登录 0未登录
     *
     * @return isLogin - 是否已经登录系统 1.已经登录 0未登录
     */
    public Integer getIslogin() {
        return islogin;
    }

    /**
     * 设置是否已经登录系统 1.已经登录 0未登录
     *
     * @param islogin 是否已经登录系统 1.已经登录 0未登录
     */
    public void setIslogin(Integer islogin) {
        this.islogin = islogin;
    }

    /**
     * 获取部门
     *
     * @return dept_id - 部门
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * 设置部门
     *
     * @param deptId 部门
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取薪资等级
     *
     * @return paygrades_id - 薪资等级
     */
    public Integer getPaygradesId() {
        return paygradesId;
    }

    /**
     * 设置薪资等级
     *
     * @param paygradesId 薪资等级
     */
    public void setPaygradesId(Integer paygradesId) {
        this.paygradesId = paygradesId;
    }

    /**
     * 获取职位
     *
     * @return position_id - 职位
     */
    public Integer getPositionId() {
        return positionId;
    }

    /**
     * 设置职位
     *
     * @param positionId 职位
     */
    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    /**
     * 获取逻辑删除（默认为1，删除后为0）
     *
     * @return logicToDelete - 逻辑删除（默认为1，删除后为0）
     */
    public Integer getLogictodelete() {
        return logictodelete;
    }


    /**
     * 设置逻辑删除（默认为1，删除后为0）
     *
     * @param logictodelete 逻辑删除（默认为1，删除后为0）
     */
    public void setLogictodelete(Integer logictodelete) {
        this.logictodelete = logictodelete;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", sign='" + sign + '\'' +
                ", avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", img='" + img + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", currentaddress='" + currentaddress + '\'' +
                ", inductiontime=" + inductiontime +
                ", state=" + state +
                ", specialty='" + specialty + '\'' +
                ", mark='" + mark + '\'' +
                ", islogin=" + islogin +
                ", deptId=" + deptId +
                ", dept=" + dept +
                ", paygradesId=" + paygradesId +
                ", paygrades=" + paygrades +
                ", positionId=" + positionId +
                ", position=" + position +
                ", logictodelete=" + logictodelete +
                '}';
    }
}