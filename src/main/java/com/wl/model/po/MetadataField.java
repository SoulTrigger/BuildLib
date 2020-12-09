package com.wl.model.po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wl.base.BaseGenerator;
import com.wl.model.dto.MetadataElement;

/**
 * 元数据自定义字段
 * 
 * @author wuli
 * @date 2019年12月2日上午9:45:54
 */
@Entity
public class MetadataField extends BaseGenerator {
	//字段所属分类
	private String columnSchema;
	//字段呈现类型
	@Enumerated(value = EnumType.STRING)
	private MetadataElement columnElement;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "field", orphanRemoval = true, fetch = FetchType.LAZY)
	private Set<MetadataValue> metadataValues = new HashSet<>();
	private String columnName;
	private String shortColumnName;
	private String label;
	private String defaultValue;
	@ColumnDefault("true")
	private Boolean isShow;
	public String getColumnSchema() {
		return columnSchema;
	}
	public void setColumnSchema(String columnSchema) {
		this.columnSchema = columnSchema;
	}
	public MetadataElement getColumnElement() {
		return columnElement;
	}
	public void setColumnElement(MetadataElement columnElement) {
		this.columnElement = columnElement;
	}
	public Set<MetadataValue> getMetadataValues() {
		return metadataValues;
	}
	public void setMetadataValues(Set<MetadataValue> metadataValues) {
		this.metadataValues = metadataValues;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getShortColumnName() {
		return shortColumnName;
	}
	public void setShortColumnName(String shortColumnName) {
		this.shortColumnName = shortColumnName;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public Boolean getIsShow() {
		return isShow;
	}
	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}
}
