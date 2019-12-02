package com.wl.model.po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "role")
@Entity
public class Role extends BaseGenerator {
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<User> users = new HashSet<>();
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Collection> collections = new HashSet<>();
	@Column(name = "permission_name")
	private String name;

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Collection> getCollections() {
		return collections;
	}

	public void setCollections(Set<Collection> collections) {
		this.collections = collections;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
