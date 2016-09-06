package com.jbl.model;

import java.sql.Timestamp;
import java.util.Date;
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
 * Tuser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tuser", catalog = "bzcts", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Tuser implements java.io.Serializable {

	// Fields

	private Integer id;
	private Trole trole;
	private Tdept tdept;
	private Ttitle ttitle;
	private String name;
	private String realname;
	private String pwd;
	private String tel;
	private String email;
	private Date createtime;
	private Date modifytime;
	private String menu;
	private Boolean deltriger;
	private String chargeDepts;
	private Set<Trecord> trecords = new HashSet<Trecord>(0);
	private Set<Tpatrol> tpatrols = new HashSet<Tpatrol>(0);
	private Set<Tcharge> tcharges = new HashSet<Tcharge>(0);

	// Constructors

	/** default constructor */
	public Tuser() {
	}

	/** minimal constructor */
	public Tuser(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}

	/** full constructor */
	public Tuser(Trole trole, Tdept tdept, Ttitle ttitle, String name, String realname, String pwd, String tel, String email, Timestamp createtime, Timestamp modifytime, String menu, Boolean deltriger, String chargeDepts, Set<Trecord> trecords, Set<Tpatrol> tpatrols) {
		this.trole = trole;
		this.tdept = tdept;
		this.ttitle = ttitle;
		this.name = name;
		this.realname = realname;
		this.pwd = pwd;
		this.tel = tel;
		this.email = email;
		this.createtime = createtime;
		this.modifytime = modifytime;
		this.menu = menu;
		this.deltriger = deltriger;
		this.chargeDepts = chargeDepts;
		this.trecords = trecords;
		this.tpatrols = tpatrols;
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
	@JoinColumn(name = "roleid")
	public Trole getTrole() {
		return this.trole;
	}

	public void setTrole(Trole trole) {
		this.trole = trole;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deptid")
	public Tdept getTdept() {
		return this.tdept;
	}

	public void setTdept(Tdept tdept) {
		this.tdept = tdept;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "titleId")
	public Ttitle getTtitle() {
		return this.ttitle;
	}

	public void setTtitle(Ttitle ttitle) {
		this.ttitle = ttitle;
	}

	@Column(name = "name", unique = true, nullable = false, length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "realname", length = 100)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "pwd", nullable = false, length = 36)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "tel", length = 100)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "createtime", length = 19)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Column(name = "modifytime", length = 19)
	public Date getModifytime() {
		return this.modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	@Column(name = "menu", length = 100)
	public String getMenu() {
		return this.menu;
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

	@Column(name = "chargeDepts", length = 50)
	public String getChargeDepts() {
		return this.chargeDepts;
	}

	public void setChargeDepts(String chargeDepts) {
		this.chargeDepts = chargeDepts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tuser")
	public Set<Trecord> getTrecords() {
		return this.trecords;
	}

	public void setTrecords(Set<Trecord> trecords) {
		this.trecords = trecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tuser")
	public Set<Tpatrol> getTpatrols() {
		return this.tpatrols;
	}

	public void setTpatrols(Set<Tpatrol> tpatrols) {
		this.tpatrols = tpatrols;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tuser")
	public Set<Tcharge> getTcharges() {
		return tcharges;
	}

	public void setTcharges(Set<Tcharge> tcharges) {
		this.tcharges = tcharges;
	}
}