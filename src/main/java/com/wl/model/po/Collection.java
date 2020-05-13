package com.wl.model.po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * end level
 * 
 * @author wuli
 * @date 2019年10月21日上午9:49:10
 */
@Entity
@Table(name = "collection")
public class Collection extends BaseGenerator {
	@Column(name = "collection_name")
	private String name;
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	private Community community;
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToMany(mappedBy = "collections", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Role> roles = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
