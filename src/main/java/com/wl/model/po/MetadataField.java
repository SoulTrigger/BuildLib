package com.wl.model.po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.wl.model.dto.MetadataElement;
import com.wl.model.dto.MetadataSchema;

/**
 * 元数据字段定义
 * 
 * @author wuli
 * @date 2019年12月2日上午9:45:54
 */
@Entity
@Table(name = "metadatafield")
public class MetadataField extends BaseGenerator {

	@Enumerated(value = EnumType.STRING)
	private MetadataSchema schema;
	@Enumerated(value = EnumType.STRING)
	private MetadataElement element;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "field", orphanRemoval = true, fetch = FetchType.LAZY)
	private Set<MetadataValue> metadataValues = new HashSet<>();
	private String columnQualifier;
	private String shortColumnQualifier;
	private String noteQualifier;
	private String defaultQualifier;

	public MetadataSchema getSchema() {
		return schema;
	}

	public void setSchema(MetadataSchema schema) {
		this.schema = schema;
	}

	public MetadataElement getElement() {
		return element;
	}

	public void setElement(MetadataElement element) {
		this.element = element;
	}

	public Set<MetadataValue> getMetadataValues() {
		return metadataValues;
	}

	public void setMetadataValues(Set<MetadataValue> metadataValues) {
		this.metadataValues = metadataValues;
	}

	public String getColumnQualifier() {
		return columnQualifier;
	}

	public void setColumnQualifier(String columnQualifier) {
		this.columnQualifier = columnQualifier;
	}

	public String getNoteQualifier() {
		return noteQualifier;
	}

	public void setNoteQualifier(String noteQualifier) {
		this.noteQualifier = noteQualifier;
	}

	public String getDefaultQualifier() {
		return defaultQualifier;
	}

	public void setDefaultQualifier(String defaultQualifier) {
		this.defaultQualifier = defaultQualifier;
	}

	public String getShortColumnQualifier() {
		return shortColumnQualifier;
	}

	public void setShortColumnQualifier(String shortColumnQualifier) {
		this.shortColumnQualifier = shortColumnQualifier;
	}
}
