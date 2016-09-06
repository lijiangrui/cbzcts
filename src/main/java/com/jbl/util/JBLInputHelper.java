package com.jbl.util;

public class JBLInputHelper extends CommonUtils{
	
	public String id ,name,type,value;
	
	public JBLInputHelper(String type) {
		this.type = type;
	}
	
	public String toString(){
		return makeInputHTML();
	}

	private String makeInputHTML() {
		return "<input type='"+type+"' name='"+name+"' id='"+id+"'>"+value+"</input>";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
