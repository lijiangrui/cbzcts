package com.jbl.model;

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
 * Tproduct entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tproduct", catalog = "bzcts")
public class Tproduct implements java.io.Serializable {

	// Fields

	private Integer id;
	private Tsupplier tsupplier;
	private String name;
	private String capacity;
	private String yearCapacity;
	private String yearProfit;
	private String yearTax;
	private String saleTo;
	private Boolean deltriger;

	// Constructors

	/** default constructor */
	public Tproduct() {
	}

	/** full constructor */
	public Tproduct(Tsupplier tsupplier, String name, String capacity, String yearCapacity, String yearProfit, String yearTax, String saleTo) {
		this.tsupplier = tsupplier;
		this.name = name;
		this.capacity = capacity;
		this.yearCapacity = yearCapacity;
		this.yearProfit = yearProfit;
		this.yearTax = yearTax;
		this.saleTo = saleTo;
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

	@Column(name = "yearProfit", length = 100)
	public String getYearProfit() {
		return this.yearProfit;
	}

	public void setYearProfit(String yearProfit) {
		this.yearProfit = yearProfit;
	}

	@Column(name = "yearTax", length = 100)
	public String getYearTax() {
		return this.yearTax;
	}

	public void setYearTax(String yearTax) {
		this.yearTax = yearTax;
	}

	@Column(name = "saleTo", length = 100)
	public String getSaleTo() {
		return this.saleTo;
	}

	public void setSaleTo(String saleTo) {
		this.saleTo = saleTo;
	}

	@Column(name="deltriger")
	public Boolean getDeltriger() {
		return deltriger;
	}

	public void setDeltriger(Boolean deltriger) {
		this.deltriger = deltriger;
	}
	
}