package com.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class CoreEntity implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "create_by", insertable = true, updatable = false)
	private String createBy;
	@Column(name = "create_date", insertable = true, updatable = false)
	private Date createDate;
	@Column(name = "update_by", insertable = true, updatable = true)
	private String updateBy;
	@Column(name = "update_date", insertable = true, updatable = true)
	private Date updateDate;

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
