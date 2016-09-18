package sample.springboot.mybatis.xmlconfig.service;

import java.util.Date;

/**
 * Sample DTO
 * 
 * @author sbcoba
 *
 */
public class Member {
	private Long id;
	private String name;
	private String phone;
	private Date creationtime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(Date creationtime) {
		this.creationtime = creationtime;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
}
