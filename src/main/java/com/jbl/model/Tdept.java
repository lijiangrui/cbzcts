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
 * Tdept entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tdept", catalog = "bzcts")
public class Tdept implements java.io.Serializable {

	// Fields

	private Integer id;
	private Tcompany tcompany;
	private Tdept tdept;
	private String name;
	private String no;
	private Boolean deltriger;
	private Set<Ttype> ttypes = new HashSet<Ttype>(0);
	private Set<Tuser> tusers = new HashSet<Tuser>(0);
	private Set<Tdept> tdepts = new HashSet<Tdept>(0);

	// Constructors

	/** default constructor */
	public Tdept() {
	}

	/** minimal constructor */
	public Tdept(String name) {
		this.name = name;
	}

	/** full constructor */
	public Tdept(Tcompany tcompany, Tdept tdept, String name, Boolean deltriger, Set<Ttype> ttypes, Set<Tuser> tusers, Set<Tdept> tdepts) {
		this.tcompany = tcompany;
		this.tdept = tdept;
		this.name = name;
		this.deltriger = deltriger;
		this.ttypes = ttypes;
		this.tusers = tusers;
		this.tdepts = tdepts;
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
	@JoinColumn(name = "cid")
	public Tcompany getTcompany() {
		return this.tcompany;
	}

	public void setTcompany(Tcompany tcompany) {
		this.tcompany = tcompany;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pid")
	public Tdept getTdept() {
		return this.tdept;
	}

	public void setTdept(Tdept tdept) {
		this.tdept = tdept;
	}

	@Column(name = "name", nullable = false, length = 200)
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tdept")
	public Set<Ttype> getTtypes() {
		return this.ttypes;
	}

	public void setTtypes(Set<Ttype> ttypes) {
		this.ttypes = ttypes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tdept")
	public Set<Tuser> getTusers() {
		return this.tusers;
	}

	public void setTusers(Set<Tuser> tusers) {
		this.tusers = tusers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tdept")
	public Set<Tdept> getTdepts() {
		return this.tdepts;
	}

	public void setTdepts(Set<Tdept> tdepts) {
		this.tdepts = tdepts;
	}
	@Column(name="no")
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

}