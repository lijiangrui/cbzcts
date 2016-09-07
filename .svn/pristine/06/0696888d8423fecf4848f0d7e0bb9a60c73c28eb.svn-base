package com.jbl.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="ttemplate",catalog="bzcts")
public class Ttemplate {
	// Fields

	private Integer id;
	private String templateName;
	private Integer userId;
	private Integer areaId;
	private String name;
	private String position;
	private String code;
	private String license;
	private String legalPerson;
	private String idNo;
	private String contactPerson;
	private String contact;
	private Integer scaleId;
	private Integer zcCapital;
	private Integer gdCapital;
	private Date foundDate;
	private Integer zcTypeId;
	private Integer cpTypeId;
	private String product;
	private String capacity;
	private String yearCapacity;
	private Double yearProfit;
	private Double yearTax;
	private String saleTo;
	private Boolean validation;
	private Date createTime;
	private Boolean deltriger;

	// Constructors

	/** default constructor */
	public Ttemplate() {
	}
	public Ttemplate(Integer id, Integer areaId, String name, String position, String code, String license, String legalPerson, String idNo, String contactPerson, String contact, Integer scaleId, Integer zcCapital, Integer gdCapital, Date foundDate, Integer zcTypeId, Integer cpTypeId, String product, String capacity, String yearCapacity, Double yearProfit, Double yearTax, String saleTo, Boolean validation, Date createTime, Boolean deltriger) {
		super();
		this.id = id;
		this.areaId = areaId;
		this.name = name;
		this.position = position;
		this.code = code;
		this.license = license;
		this.legalPerson = legalPerson;
		this.idNo = idNo;
		this.contactPerson = contactPerson;
		this.contact = contact;
		this.scaleId = scaleId;
		this.zcCapital = zcCapital;
		this.gdCapital = gdCapital;
		this.foundDate = foundDate;
		this.zcTypeId = zcTypeId;
		this.cpTypeId = cpTypeId;
		this.product = product;
		this.capacity = capacity;
		this.yearCapacity = yearCapacity;
		this.yearProfit = yearProfit;
		this.yearTax = yearTax;
		this.saleTo = saleTo;
		this.validation = validation;
		this.createTime = createTime;
		this.deltriger = deltriger;
	}


	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 300)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "position", length = 300)
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name = "code", length = 100)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "license", length = 100)
	public String getLicense() {
		return this.license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	@Column(name = "legalPerson", length = 100)
	public String getLegalPerson() {
		return this.legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	@Column(name = "idNo", length = 100)
	public String getIdNo() {
		return this.idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	@Column(name = "contactPerson", length = 100)
	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	@Column(name = "contact", length = 100)
	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name = "scaleId")
	public Integer getScaleId() {
		return this.scaleId;
	}

	public void setScaleId(Integer scaleId) {
		this.scaleId = scaleId;
	}

	@Column(name = "zcCapital")
	public Integer getZcCapital() {
		return this.zcCapital;
	}

	public void setZcCapital(Integer zcCapital) {
		this.zcCapital = zcCapital;
	}

	@Column(name = "gdCapital")
	public Integer getGdCapital() {
		return this.gdCapital;
	}

	public void setGdCapital(Integer gdCapital) {
		this.gdCapital = gdCapital;
	}

	@Column(name = "foundDate", length = 19)
	public Date getFoundDate() {
		return this.foundDate;
	}

	public void setFoundDate(Date foundDate) {
		this.foundDate = foundDate;
	}

	@Column(name = "zcTypeId")
	public Integer getZcTypeId() {
		return this.zcTypeId;
	}

	public void setZcTypeId(Integer zcTypeId) {
		this.zcTypeId = zcTypeId;
	}
	@Column(name = "cpTypeId")
	public Integer getCpTypeId() {
		return cpTypeId;
	}

	public void setCpTypeId(Integer cpTypeId) {
		this.cpTypeId = cpTypeId;
	}
	@Column(name = "product")
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Column(name = "capacity", length = 100)
	public String getCapacity() {
		return this.capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	@Column(name = "yearCapacity", length = 100)
	public String getYearCapacity() {
		return this.yearCapacity;
	}

	public void setYearCapacity(String yearCapacity) {
		this.yearCapacity = yearCapacity;
	}

	@Column(name = "yearProfit", precision = 11)
	public Double getYearProfit() {
		return this.yearProfit;
	}

	public void setYearProfit(Double yearProfit) {
		this.yearProfit = yearProfit;
	}

	@Column(name = "yearTax", precision = 11)
	public Double getYearTax() {
		return this.yearTax;
	}

	public void setYearTax(Double yearTax) {
		this.yearTax = yearTax;
	}

	@Column(name = "saleTo", length = 100)
	public String getSaleTo() {
		return this.saleTo;
	}

	public void setSaleTo(String saleTo) {
		this.saleTo = saleTo;
	}

	@Column(name = "validation")
	public Boolean getValidation() {
		return this.validation;
	}

	public void setValidation(Boolean validation) {
		this.validation = validation;
	}

	@Column(name = "createTime", nullable = false, length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "deltriger", nullable = true)
	public Boolean getDeltriger() {
		return this.deltriger;
	}

	public void setDeltriger(Boolean deltriger) {
		this.deltriger = deltriger;
	}

	@Column(name="areaId")
	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	@Column(name="templateName")
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	@Column(name="userId")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
