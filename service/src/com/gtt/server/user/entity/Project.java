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
@Table(name = "project")
public class Project extends CoreEntity{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_project")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Company id_customer;
	@Column(name = "project_name")
	private String project_name;
	
	
	public Project() {
	
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Company getId_customer() {
		return id_customer;
	}


	public void setId_customer(Company id_customer) {
		this.id_customer = id_customer;
	}


	public String getProject_name() {
		return project_name;
	}


	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}


	

}
