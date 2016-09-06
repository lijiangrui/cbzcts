package com.jbl.pagemodel;

public class Company {
	private Integer id;
	private int companyId;
	private String name;
	private Boolean deltriger;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getDeltriger() {
		return deltriger;
	}
	public void setDeltriger(Boolean deltriger) {
		this.deltriger = deltriger;
	}
}
