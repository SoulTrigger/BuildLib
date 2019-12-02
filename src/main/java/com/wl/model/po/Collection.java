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
	@ManyToOne
	private Community community;
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
