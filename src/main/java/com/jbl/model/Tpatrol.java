package com.jbl.model;

import java.sql.Timestamp;
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
 * Tpatrol entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tpatrol", catalog = "bzcts")
public class Tpatrol implements java.io.Serializable {

	// Fields

	private Integer id;
	private Ttype ttype;
	private Tsupplier tsupplier;
	private Tuser tuser;
	private String content;
	private String result;
	private Date patrolTime;
	private Date createTime;
	private String serialNo;

	// Constructors

	/** default constructor */
	public Tpatrol() {
	}

	/** full constructor */
	public Tpatrol(Ttype ttype, Tsupplier tsupplier, Tuser tuser, String content, String result, Timestamp patrolTime, Timestamp createTime, String serialNo) {
		this.ttype = ttype;
		this.tsupplier = tsupplier;
		this.tuser = tuser;
		this.content = content;
		this.result = result;
		this.patrolTime = patrolTime;
		this.createTime = createTime;
		this.serialNo = serialNo;
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
	@JoinColumn(name = "tid")
	public Ttype getTtype() {
		return this.ttype;
	}

	public void setTtype(Ttype ttype) {
		this.ttype = ttype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sid")
	public Tsupplier getTsupplier() {
		return this.tsupplier;
	}

	public void setTsupplier(Tsupplier tsupplier) {
		this.tsupplier = tsupplier;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public Tuser getTuser() {
		return this.tuser;
	}

	public void setTuser(Tuser tuser) {
		this.tuser = tuser;
	}

	@Column(name = "content", length = 300)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "result", length = 1000)
	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Column(name = "patrolTime", length = 19)
	public Date getPatrolTime() {
		return this.patrolTime;
	}

	public void setPatrolTime(Date patrolTime) {
		this.patrolTime = patrolTime;
	}

	@Column(name = "createTime", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "serialNo", length = 32)
	public String getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

}