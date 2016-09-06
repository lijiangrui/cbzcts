package com.jbl.pagemodel;

public class Role {
	private Integer id;
	private String name;
	private String menu;
	private Boolean chaRight;
	private Boolean deltriger;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public Boolean getDeltriger() {
		return deltriger;
	}
	public void setDeltriger(Boolean deltriger) {
		this.deltriger = deltriger;
	}
	public Boolean getChaRight() {
		return chaRight;
	}
	public void setChaRight(Boolean chaRight) {
		this.chaRight = chaRight;
	}
}
