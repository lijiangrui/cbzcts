package com.jbl.decorator;

import org.displaytag.decorator.TableDecorator;

import com.jbl.pagemodel.User;

public class UserDisplayTagDecorator extends TableDecorator{

	public String getDeltriger() throws UnsupportedOperationException{
		User user = (User)getCurrentRowObject();
		return "<input type='button' value='编辑' onclick='modifyItem("+user.getId()+");' /><input type='button' value='删除' onclick='deleteItem("+user.getId()+");' />";
	}
}
