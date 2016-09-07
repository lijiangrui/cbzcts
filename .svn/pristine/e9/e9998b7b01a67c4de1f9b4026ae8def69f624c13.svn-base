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
 * Trecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "trecord", catalog = "bzcts")
public class Trecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Tuser tuser;
	private Date operateTime;
	private String ip;
	private int type;
	private String something;

	// Constructors

	/** default constructor */
	public Trecord() {
	}

	/** full constructor */
	public Trecord(Tuser tuser, Date operateTime, String something,int type) {
		this.tuser = tuser;
		this.operateTime = operateTime;
		this.something = something;
		this.type = type;
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
	@JoinColumn(name = "operaterId", nullable = false)
	public Tuser getTuser() {
		return this.tuser;
	}

	public void setTuser(Tuser tuser) {
		this.tuser = tuser;
	}
	@Column(name = "type", nullable = false,length=2)
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	@Column(name = "operateTime", nullable = false, length = 19)
	public Date getOperateTime() {
		return this.operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	@Column(name = "something", nullable = false, length = 30)
	public String getSomething() {
		return this.something;
	}

	public void setSomething(String something) {
		this.something = something;
	}

	@Column(name="ip")
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	

}