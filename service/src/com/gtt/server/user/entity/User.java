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
@Table(name = "user")
public class User extends CoreEntity {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name = "id_user_type")
	private UserType id_user_type;
	@ManyToOne
	@JoinColumn(name = "id_user_prefix")
	private UserPrefix id_user_prefix;
	@ManyToOne
	@JoinColumn(name = "id_user_position")
	private UserPosition id_user_position;
	@ManyToOne
	@JoinColumn(name = "id_company")
	private Company id_company;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	
	@Column(name = "user_nickname")
	private String nickname;
	@Column(name = "user_firstname")
	private String user_firstname;
	@Column(name = "user_lastname")
	private String user_lastname;
	@Column(name = "user_phone")
	private String user_phone;
	@Column (name = "user_email")
	private String user_email;
	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Company id_customer;
	
	
	public User() {
		
	}
	
	public User(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserType getId_user_type() {
		return id_user_type;
	}

	public void setId_user_type(UserType id_user_type) {
		this.id_user_type = id_user_type;
	}

	public UserPrefix getId_user_prefix() {
		return id_user_prefix;
	}

	public void setId_user_prefix(UserPrefix id_user_prefix) {
		this.id_user_prefix = id_user_prefix;
	}

	public UserPosition getId_user_position() {
		return id_user_position;
	}

	public void setId_user_position(UserPosition id_user_position) {
		this.id_user_position = id_user_position;
	}

	public Company getId_company() {
		return id_company;
	}

	public void setId_company(Company id_company) {
		this.id_company = id_company;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUser_firstname() {
		return user_firstname;
	}

	public void setUser_firstname(String user_firstname) {
		this.user_firstname = user_firstname;
	}

	public String getUser_lastname() {
		return user_lastname;
	}

	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public Company getId_customer() {
		return id_customer;
	}

	public void setId_customer(Company id_customer) {
		this.id_customer = id_customer;
	}

	

	
	
	
	
	
	
}
