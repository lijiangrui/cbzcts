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
 * Tcharge entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tcharge", catalog = "bzcts")
public class Tcharge implements java.io.Serializable {

	// Fields

	private Integer id;
	private String serialNo;
	private Ttype ttype;
	private Tsupplier tsupplier;
	private Tuser tuser;
	private Date chargeTime;
	private Date createTime;
	private String no;
	private int money;
	private String comment;

	// Constructors

	/** default constructor */
	public Tcharge() {
	}

	/** minimal constructor */
	public Tcharge(Ttype ttype, Tsupplier tsupplier,  String no, int money) {
		this.ttype = ttype;
		this.tsupplier = tsupplier;
		this.no = no;
		this.money = money;
	}

	/** full constructor */
	public Tcharge(Ttype ttype, Tsupplier tsupplier, Date chargeTime, Date createTime, String no, int money) {
		this.ttype = ttype;
		this.tsupplier = tsupplier;
		this.chargeTime = chargeTime;
		this.createTime = createTime;
		this.no = no;
		this.money = money;
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
	
	@Column(name="serialNo",nullable=false,length=32)
	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tid", nullable = false)
	public Ttype getTtype() {
		return this.ttype;
	}

	public void setTtype(Ttype ttype) {
		this.ttype = ttype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sid", nullable = false)
	public Tsupplier getTsupplier() {
		return this.tsupplier;
	}

	public void setTsupplier(Tsupplier tsupplier) {
		this.tsupplier = tsupplier;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	public Tuser getTuser() {
		return tuser;
	}

	public void setTuser(Tuser tuser) {
		this.tuser = tuser;
	}

	@Column(name = "chargeTime", length = 19)
	public Date getChargeTime() {
		return this.chargeTime;
	}

	public void setChargeTime(Date chargeTime) {
		this.chargeTime = chargeTime;
	}

	@Column(name = "createTime", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "no", nullable = false, length = 50)
	public String getNo() {
		return this.no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	@Column(name = "money", nullable = false, precision = 22, scale = 0)
	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	@Column(name = "comment")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}