package com.wl.model.po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 元数据条目定义
 * 
 * @author wuli
 * @date 2019年11月21日下午4:24:36
 */
@Entity
@Table(name = "item")
public class Item extends BaseGenerator {
	@ManyToOne(fetch = FetchType.EAGER)
	private User submitter;
	private int clickNum;
	private Boolean del = false;
	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<MetadataValue> metadataValues = new HashSet<>();

	public void setMetadata(MetadataField field, MetadataValue value) {
		this.metadataValues.add(value);
		value.setField(field);
		value.setItem(this);
	}

	public User getSubmitter() {
		return submitter;
	}

	public void setSubmitter(User submitter) {
		this.submitter = submitter;
	}

	public int getClickNum() {
		return clickNum;
	}

	public void setClickNum(int clickNum) {
		this.clickNum = clickNum;
	}

	public Boolean getDel() {
		return del;
	}

	public void setDel(Boolean del) {
		this.del = del;
	}

	public Set<MetadataValue> getMetadataValues() {
		return metadataValues;
	}

	public void setMetadataValues(Set<MetadataValue> metadataValues) {
		this.metadataValues = metadataValues;
	}
}
