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
@Table(name = "requeststatus")
public class RequestStatus extends CoreEntity {
	private static final long serialVersionUID = 1L;
		
		@Id
		@Column(name = "id_request_status")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		@Column(name = "status_name")
		private String request_status_name;
		
		
		public RequestStatus() {
			
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getRequest_status_name() {
			return request_status_name;
		}


		public void setRequest_status_name(String request_status_name) {
			this.request_status_name = request_status_name;
		}
		
		
		
}
