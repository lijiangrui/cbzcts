package com.jbl.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;

/**
 * Tcompany entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tcompany", catalog = "bzcts", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Tcompany implements java.io.Serializable {

	// Fields

	private Integer id;
	private Tcompany tcompany;
	private String name;
	private Boolean deltriger;
	private Set<Tdept> tdepts = new HashSet<Tdept>(0);
	private Set<Tcompany> tcompanies = new HashSet<Tcompany>(0);

	// Constructors

	/** default constructor */
	public Tcompany() {
	}

	/** minimal constructor */
	public Tcompany(String name) {
		this.name = name;
	}

	/** full constructor */
	public Tcompany(Tcompany tcompany, String name, Boolean deltriger, Set<Tdept> tdepts, Set<Tcompany> tcompanies) {
		this.tcompany = tcompany;
		this.name = name;
		this.deltriger = deltriger;
		this.tdepts = tdepts;
		this.tcompanies = tcompanies;
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
	@JoinColumn(name = "pid")
	public Tcompany getTcompany() {
		return this.tcompany;
	}

	public void setTcompany(Tcompany tcompany) {
		this.tcompany = tcompany;
	}

	@Column(name = "name", unique = true, nullable = false, length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "deltriger")
	public Boolean getDeltriger() {
		return this.deltriger;
	}

	public void setDeltriger(Boolean deltriger) {
		this.deltriger = deltriger;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tcompany")
	public Set<Tdept> getTdepts() {
		return this.tdepts;
	}

	public void setTdepts(Set<Tdept> tdepts) {
		this.tdepts = tdepts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tcompany")
	public Set<Tcompany> getTcompanies() {
		return this.tcompanies;
	}

	public void setTcompanies(Set<Tcompany> tcompanies) {
		this.tcompanies = tcompanies;
	}

}