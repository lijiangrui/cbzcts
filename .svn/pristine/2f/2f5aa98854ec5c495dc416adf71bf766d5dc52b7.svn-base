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
 * Tarea entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tarea", catalog = "bzcts")
public class Tarea implements java.io.Serializable {

	// Fields

	private Integer id;
	private Tarea tarea;
	private String name;
	private Boolean deltrigger;
	private Set<Tarea> tareas = new HashSet<Tarea>(0);
	private Set<Tsupplier> tsuppliers = new HashSet<Tsupplier>(0);

	// Constructors

	/** default constructor */
	public Tarea() {
	}

	/** full constructor */
	public Tarea(Tarea tarea, String name, Boolean deltrigger, Set<Tarea> tareas, Set<Tsupplier> tsuppliers) {
		this.tarea = tarea;
		this.name = name;
		this.deltrigger = deltrigger;
		this.tareas = tareas;
		this.tsuppliers = tsuppliers;
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
	public Tarea getTarea() {
		return this.tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "deltrigger")
	public Boolean getDeltrigger() {
		return this.deltrigger;
	}

	public void setDeltrigger(Boolean deltrigger) {
		this.deltrigger = deltrigger;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tarea")
	public Set<Tarea> getTareas() {
		return this.tareas;
	}

	public void setTareas(Set<Tarea> tareas) {
		this.tareas = tareas;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tarea")
	public Set<Tsupplier> getTsuppliers() {
		return this.tsuppliers;
	}

	public void setTsuppliers(Set<Tsupplier> tsuppliers) {
		this.tsuppliers = tsuppliers;
	}

}