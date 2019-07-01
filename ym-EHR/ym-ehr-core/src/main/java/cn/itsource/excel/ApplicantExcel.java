/**
 * 代号:隐无为 2018：
 * 文件名：UserExcel.java
 * 修改人：
 * 描述：
 */
package cn.itsource.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * 用途：业务模块名称
 */
@SuppressWarnings("serial")
public class ApplicantExcel implements java.io.Serializable{
	@Excel(name = "编号")
	private Integer id;
	@Excel(name = "名字" ,width = 30)
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
	@Excel(name = "应聘时间",width = 30, format = "yyyy-MM-dd")
	private Date applicanttime;
	@Excel(name = "技术特长",width = 30)
	private String specialty;
	@Excel(name = "试官评价面",width = 50)
	private String comments;
	@Excel(name = "备注",width = 50)
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

	public Date getApplicanttime() {
		return applicanttime;
	}

	public void setApplicanttime(Date applicanttime) {
		this.applicanttime = applicanttime;
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

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

}
