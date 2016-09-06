package com.jbl.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Tcertificate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tcertificate", catalog = "bzcts")
public class Tcertificate implements java.io.Serializable {

	// Fields

	private Integer id;
	private Tsupplier tsupplier;
	private String name;
	private Integer type;
	private String no;
	private String unit;
	private Date validate;

	// Constructors

	/** default constructor */
	public Tcertificate() {
	}

	/** full constructor */
	public Tcertificate(Tsupplier tsupplier, String name, Integer type, String no, String unit, Date validate) {
		this.tsupplier = tsupplier;
		this.name = name;
		this.type = type;
		this.no = no;
		this.unit = unit;
		this.validate = validate;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sid")
	public Tsupplier getTsupplier() {
		return this.tsupplier;
	}

	public void setTsupplier(Tsupplier tsupplier) {
		this.tsupplier = tsupplier;
	}

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "no", length = 100)
	public String getNo() {
		return this.no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	@Column(name = "unit", length = 100)
	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "validate", length = 19)
	public Date getValidate() {
		return this.validate;
	}

	public void setValidate(Date validate) {
		this.validate = validate;
	}

}