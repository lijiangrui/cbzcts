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
	private String no;
	private String size;
	private String material;
	private String purpose;
	private Boolean deltriger;

	// Constructors

	/** default constructor */
	public Tproduct() {
	}

	/** full constructor */
	public Tproduct(Tsupplier tsupplier, String name) {
		this.tsupplier = tsupplier;
		this.name = name;
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

	@Column(name = "no", length = 100)
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
	@Column(name="size", length=100)
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Column(name = "material", length = 100)
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	@Column(name = "purpose", length = 100)
	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Column(name="deltriger")
	public Boolean getDeltriger() {
		return deltriger;
	}

	public void setDeltriger(Boolean deltriger) {
		this.deltriger = deltriger;
	}
	
}