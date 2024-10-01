package com.tduy.repository.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "building")
public class BuildingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "street")
	private String street;

	@Column(name = "ward")
	private String ward;

	@Column(name = "structure")
	private String structure;

	@Column(name = "numberofbasement")
	private Integer numberOfBasement;

	@Column(name = "floorarea")
	private Long floorArea;

	@Column(name = "rentprice")
	private Long rentPrice;

	@Column(name = "rentpricedescription")
	private String rentPriceDescription;

	@Column(name = "servicefee")
	private String serviceFee;

	@Column(name = "carfee")
	private String carFee;

	@Column(name = "motorbikefee")
	private String motorbikeFee;

	@Column(name = "overtimefee")
	private String overtimeFee;

	@Column(name = "waterfee")
	private String waterFee;

	@Column(name = "electricityfee")
	private String electricityFee;

	@Column(name = "deposit")
	private String deposit;

	@Column(name = "payment")
	private String payment;

	@Column(name = "renttime")
	private String renttime;

	@Column(name = "decorationtime")
	private String decorationtime;

	@Column(name = "brokeragefee")
	private Float brokerageFee;

	@Column(name = "note")
	private String note;

	@Column(name = "linkofbuilding")
	private String linkofbuilding;

	@Column(name = "map")
	private String map;

	@Column(name = "image")
	private String image;

	@Column(name = "createddate")
	private Date createddate;

	@Column(name = "modifieddate")
	private Date modifieddate;

	@Column(name = "createdby")
	private String createdby;

	@Column(name = "modifiedby")
	private String modifiedby;

	@Column(name = "managername")
	private String managerName;

	@Column(name = "managerphonenumber")
	private String managerPhoneNumber;

	@ManyToOne
	@JoinColumn(name = "districtid")
	private DistrictEntity districtEntity;

	@ManyToMany(mappedBy = "buildingEntities")
	private List<RentTypeEntity> rentTypeEntities = new ArrayList<>();

	@OneToMany(mappedBy = "buildingEntity")
	private List<RentAreaEntity> areaEntities = new ArrayList<>();

	@ManyToMany(mappedBy = "buildingEntities")
	private List<UserEntity> userEntities = new ArrayList<>();

	public List<UserEntity> getUserEntities() {
		return userEntities;
	}

	public void setUserEntities(List<UserEntity> userEntities) {
		this.userEntities = userEntities;
	}

	public List<RentAreaEntity> getAreaEntities() {
		return areaEntities;
	}

	public void setAreaEntities(List<RentAreaEntity> areaEntities) {
		this.areaEntities = areaEntities;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public String getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(String serviceFee) {
		this.serviceFee = serviceFee;
	}

	public String getCarFee() {
		return carFee;
	}

	public void setCarFee(String carFee) {
		this.carFee = carFee;
	}

	public String getMotorbikeFee() {
		return motorbikeFee;
	}

	public void setMotorbikeFee(String motorbikeFee) {
		this.motorbikeFee = motorbikeFee;
	}

	public String getOvertimeFee() {
		return overtimeFee;
	}

	public void setOvertimeFee(String overtimeFee) {
		this.overtimeFee = overtimeFee;
	}

	public String getWaterFee() {
		return waterFee;
	}

	public void setWaterFee(String waterFee) {
		this.waterFee = waterFee;
	}

	public String getElectricityFee() {
		return electricityFee;
	}

	public void setElectricityFee(String electricityFee) {
		this.electricityFee = electricityFee;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getRenttime() {
		return renttime;
	}

	public void setRenttime(String renttime) {
		this.renttime = renttime;
	}

	public String getDecorationtime() {
		return decorationtime;
	}

	public void setDecorationtime(String decorationtime) {
		this.decorationtime = decorationtime;
	}

	public Float getBrokerageFee() {
		return brokerageFee;
	}

	public void setBrokerageFee(Float brokerageFee) {
		this.brokerageFee = brokerageFee;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getLinkofbuilding() {
		return linkofbuilding;
	}

	public void setLinkofbuilding(String linkofbuilding) {
		this.linkofbuilding = linkofbuilding;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

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

	public List<RentTypeEntity> getRentTypeEntities() {
		return rentTypeEntities;
	}

	public void setRentTypeEntities(List<RentTypeEntity> rentTypeEntities) {
		this.rentTypeEntities = rentTypeEntities;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public String getRentPriceDescription() {
		return rentPriceDescription;
	}

	public void setRentPriceDescription(String rentPriceDescription) {
		this.rentPriceDescription = rentPriceDescription;
	}

	public DistrictEntity getDistrictEntity() {
		return districtEntity;
	}

	public void setDistrictEntity(DistrictEntity districtEntity) {
		this.districtEntity = districtEntity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}

	public void setManagerPhoneNumber(String managerPhoneNumber) {
		this.managerPhoneNumber = managerPhoneNumber;
	}

	public Long getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(Long floorArea) {
		this.floorArea = floorArea;
	}

	public Long getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Long rentPrice) {
		this.rentPrice = rentPrice;
	}

}
