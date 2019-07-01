/**
 * 代号:隐无为 2018：
 * 文件名：UserExcel.java
 * 修改人：
 * 描述：
 */
package cn.itsource.excel;

import java.util.Date;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * 用途：业务模块名称
 */
@SuppressWarnings("serial")
public class UserExcel implements java.io.Serializable{
	@Excel(name = "编号")
	private Integer id;
	@Excel(name = "账号" ,width = 30)
	private String loginName;
	@Excel(name = "用户昵称")
	private String userName;
	@Excel(name = "性别", replace = { "男_1", "女_0" })
	private Integer sex;
	@Excel(name = "出生日期",width = 30, format = "yyyy-MM-dd")
	private Date birthday;
	@Excel(name = "年龄")
	private Integer age;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}


}
