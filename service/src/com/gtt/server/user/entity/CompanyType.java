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
@Table(name = "companytype")
public class CompanyType extends CoreEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_company_type")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column (name = "type_name")
	private String type_name;
	
	
	
	public CompanyType () {
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getType_name() {
		return type_name;
	}



	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	
	


}
