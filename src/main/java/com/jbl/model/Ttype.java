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
import org.hibernate.annotations.GenericGenerator;

/**
 * Ttype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ttype", catalog = "bzcts")
public class Ttype implements java.io.Serializable {

	// Fields

	private Integer id;
	private Tdept tdept;
	private String name;
	private Boolean deltriger;
	private String type;
	private Set<Tpatrol> tpatrols = new HashSet<Tpatrol>(0);
	private Set<Tcharge> tcharges = new HashSet<Tcharge>(0);

	// Constructors

	/** default constructor */
	public Ttype() {
	}

	/** minimal constructor */
	public Ttype(Tdept tdept, String name, Boolean deltriger) {
		this.tdept = tdept;
		this.name = name;
		this.deltriger = deltriger;
	}

	/** full constructor */
	public Ttype(Tdept tdept, String name, Boolean deltriger, String type, Set<Tpatrol> tpatrols, Set<Tcharge> tcharges) {
		this.tdept = tdept;
		this.name = name;
		this.deltriger = deltriger;
		this.type = type;
		this.tpatrols = tpatrols;
		this.tcharges = tcharges;
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
	@JoinColumn(name = "deptid", nullable = false)
	public Tdept getTdept() {
		return this.tdept;
	}

	public void setTdept(Tdept tdept) {
		this.tdept = tdept;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "deltriger", nullable = false)
	public Boolean getDeltriger() {
		return this.deltriger;
	}

	public void setDeltriger(Boolean deltriger) {
		this.deltriger = deltriger;
	}

	@Column(name = "type", length = 10)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ttype")
	public Set<Tpatrol> getTpatrols() {
		return this.tpatrols;
	}

	public void setTpatrols(Set<Tpatrol> tpatrols) {
		this.tpatrols = tpatrols;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ttype")
	public Set<Tcharge> getTcharges() {
		return this.tcharges;
	}

	public void setTcharges(Set<Tcharge> tcharges) {
		this.tcharges = tcharges;
	}

}