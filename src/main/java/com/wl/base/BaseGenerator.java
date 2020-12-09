package com.wl.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

/**
 * ID生成策略
 * @author wuli
 * @date 2019年10月18日下午3:47:05
 */
@MappedSuperclass
public class BaseGenerator implements Serializable{
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name ="uuid",strategy = "uuid2")
	private String id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createTime;
	
	private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
