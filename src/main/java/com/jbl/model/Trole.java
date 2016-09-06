package com.jbl.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;

/**
 * Trole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "trole", catalog = "bzcts", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Trole implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String menu;
	private Boolean chaRight;
	private Boolean deltriger;
	private Set<Tuser> tusers = new HashSet<Tuser>(0);

	// Constructors

	/** default constructor */
	public Trole() {
	}

	/** minimal constructor */
	public Trole(String name) {
		this.name = name;
	}

	/** full constructor */
	public Trole(String name,String menu, Boolean deltriger, Set<Tuser> tusers) {
		this.name = name;
		this.menu = menu;
		this.deltriger = deltriger;
		this.tusers = tusers;
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

	@Column(name = "name", unique = true, nullable = false, length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="menu",length=320)
	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	@Column(name = "deltriger")
	public Boolean getDeltriger() {
		return this.deltriger;
	}

	public void setDeltriger(Boolean deltriger) {
		this.deltriger = deltriger;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "trole")
	public Set<Tuser> getTusers() {
		return this.tusers;
	}

	public void setTusers(Set<Tuser> tusers) {
		this.tusers = tusers;
	}

	@Column(name="chaRight")
	public Boolean getChaRight() {
		return chaRight;
	}

	public void setChaRight(Boolean chaRight) {
		this.chaRight = chaRight;
	}

}