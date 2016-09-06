package com.jbl.pagemodel;

public class Type {
	private Integer id;
	private int deptId;
	private String deptName;
	private String name;
	private String type;
	private Boolean deltriger;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getDeltriger() {
		return deltriger;
	}
	public void setDeltriger(Boolean deltriger) {
		this.deltriger = deltriger;
	}
}
