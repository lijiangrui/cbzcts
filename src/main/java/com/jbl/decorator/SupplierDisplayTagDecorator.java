package com.jbl.decorator;

import org.displaytag.decorator.TableDecorator;

import com.jbl.pagemodel.Supplier;

public class SupplierDisplayTagDecorator extends TableDecorator{

	public String getDeltriger() throws UnsupportedOperationException{
		Supplier supplier = (Supplier)getCurrentRowObject();
		return "<input type='button' value='编辑' onclick='modifyItem("+supplier.getId()+");' /><input type='button' value='删除' onclick='deleteItem("+supplier.getId()+");' />";
	}
}
