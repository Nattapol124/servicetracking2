package com.gtt.server.user.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.core.entity.CoreEntity;

@Entity
@Table(name = "userprefix")
public class UserPrefix extends CoreEntity{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_user_prefix")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "prefix_name")
	private String prefix_name;
	
	
	public UserPrefix() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPrefix_name() {
		return prefix_name;
	}


	public void setPrefix_name(String prefix_name) {
		this.prefix_name = prefix_name;
	}
	
}