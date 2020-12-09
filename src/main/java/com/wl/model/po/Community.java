package com.wl.model.po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.wl.base.BaseGenerator;

/**
 * prarent level
 * 
 * @author wuli
 * @date 2019年10月21日上午9:46:25
 */
@Entity
@Table(name = "community")
public class Community extends BaseGenerator {
	@Column(name = "community_name")
	private String name;
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	private Community parent;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "parent", fetch = FetchType.EAGER)
	private Set<Community> child = new HashSet<>();
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "community", fetch = FetchType.EAGER)
	private Set<Collection> collections = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Community> getChild() {
		return child;
	}

	public void setChild(Set<Community> child) {
		for (Community community : child) {
			community.setParent(this);
		}
		this.child = child;
	}

	public Set<Collection> getCollections() {
		return collections;
	}

	public void setCollections(Set<Collection> collections) {
		for (Collection collection : collections) {
			collection.setCommunity(this);
		}
		this.collections = collections;
	}

	public Community getParent() {
		return parent;
	}

	public void setParent(Community parent) {
		this.parent = parent;
	}
}
