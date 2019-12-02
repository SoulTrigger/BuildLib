package com.wl.model.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 元数据字段值定义
 * 
 * @author wuli
 * @date 2019年12月2日上午9:45:41
 */
@Entity
@Table(name = "metadatavalue")
public class MetadataValue extends BaseGenerator {
	@ManyToOne
	private Item item;
	@ManyToOne
	private MetadataField field;
	@Column(columnDefinition = "TEXT")
	private String textValue;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public MetadataField getField() {
		return field;
	}

	public void setField(MetadataField field) {
		this.field = field;
	}

	public String getTextValue() {
		return textValue;
	}

	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}
}
