package com.gtt.server.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.entity.CoreEntity;

@Entity
@Table(name = "userproject")
public class UserProject extends CoreEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_user_project")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User id_user;
	@ManyToOne
	@JoinColumn(name = "id_project")
	private Project id_project;

	public UserProject() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getId_user() {
		return id_user;
	}

	public void setId_user(User id_user) {
		this.id_user = id_user;
	}

	public Project getId_project() {
		return id_project;
	}

	public void setId_project(Project id_project) {
		this.id_project = id_project;
	}
	


}
