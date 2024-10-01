package com.tduy.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rentarea")
public class RentAreaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "value")
	private String value;

	@Column(name = "createddate")
	private Date createddate;

	@Column(name = "modifieddate")
	private Date modifieddate;

	@Column(name = "createdby")
	private String createdby;

	@Column(name = "modifiedby")
	private String modifiedby;

	@ManyToOne
	@JoinColumn(name = "buildingid")
	private BuildingEntity buildingEntity;

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BuildingEntity getBuildingEntity() {
		return buildingEntity;
	}

	public void setBuildingEntity(BuildingEntity buildingEntity) {
		this.buildingEntity = buildingEntity;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
