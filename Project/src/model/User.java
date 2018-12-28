package model;

import java.util.Date;

public class User {
	private int id;
	private String loginId;
	private String name;
	private Date birthday;
	private String password;
	private String createDate;
	private String updateDate;

	//data save
	public User(String loginId, String name) {
		this.loginId = loginId;
		this.name = name;
	}

	//data set
	public User(int id, String loginId, String name, Date birthday, String password, String createDate, String updateDate) {
		this.id = id;
		this.loginId = loginId;
		this.name = name;
		this.birthday = birthday;
		this.password = password;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public User() {

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}
