package com.wl.model.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 测试实体
 * @author wuli
 * @date 2019年12月2日上午9:51:26
 */
@Entity
@Table(name = "test")
@GenericGenerator(strategy = "uuid", name = "hibernate-uuid")
public class Hello {
	@Id
	@GeneratedValue(generator = "hibernate-uuid")
	@Column(name = "test_id")
	private String id;
	private String name;
	@Column(columnDefinition = "timestamp")
	private Date time;
	private String[] names;
	@Column(columnDefinition = "json" )
	private String[] jsonString;
	private String test;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getNames() {
		return names;
	}
	public void setNames(String[] names) {
		this.names = names;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	
}
