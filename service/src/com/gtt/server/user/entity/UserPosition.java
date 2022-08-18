package com.gtt.server.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.core.entity.CoreEntity;

@Entity
@Table(name = "UserPosition")
public class UserPosition extends CoreEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_user_position")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column (name = "position_name")
	private String position_name;
	
	
	public UserPosition(){
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPosition_name() {
		return position_name;
	}


	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	
	
}
