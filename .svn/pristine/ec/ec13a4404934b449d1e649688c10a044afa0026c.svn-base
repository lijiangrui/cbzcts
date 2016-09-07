package com.jbl.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.jbl.pagemodel.Product;
import com.jbl.pagemodel.Supplier;
import com.jbl.service.ProductService;
import com.jbl.service.SupplierService;
import com.jbl.util.JBLConstants;
import com.jbl.util.Messages;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("basePackage")
@Namespace("/product")
@Action(value="productAction")
public class ProductAction extends BaseAction implements ModelDriven<Product>{
	
	private Product product = new Product();
	@Override
	public Product getModel() {
		return product;
	}
	
	private ProductService proService;

	private SupplierService sprService;
	public ProductService getProService() {
		return proService;
	}
	@Autowired
	public void setProService(ProductService proService) {
		this.proService = proService;
	}

	public SupplierService getSprService() {
		return sprService;
	}
	@Autowired
	public void setSprService(SupplierService sprService) {
		this.sprService = sprService;
	}
	@Action(value="showproductpage",results={
			@Result(name="success",location="/WEB-INF/pages/product/show_product_page.jsp"),
			@Result(name="faile",location="/msg.jsp")
	})
	public String showProductPage(){
		List<Supplier> sprList;
		try {
			sprList = sprService.getSupplierByParams(null);
			selectHtml(sprList, "id", "name", "sid", "sHTML", null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			setMsg(JBLConstants.SEARCH_FAIL);
			return "fail";
		}
		return SUCCESS;
	}
	
	@Action(value="save",results={
			@Result(name="success",location="/savesuccess.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String save(){
		try {
			proService.save(product);
			operateRecord(Messages.SAVE_PRODUCT+product.getName(), JBLConstants.ADD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			setMsg(JBLConstants.SAVE_FAIL);
			return "fail";
		}
		setUrl("showproductpage!showProductPage.action");
		return SUCCESS;
	}
	
	@Action(value="showmodifypage",results={
			@Result(name="success",location="/WEB-INF/pages/product/show_modifyproduct_page.jsp")
	})
	public String showModifyPage(){
		try {
			product = proService.getProductById(product.getId());
			getRequest().setAttribute("product", product);
		} catch (Exception e) {
			return "fail";
		}
		return SUCCESS;
	}

	@Action(value="modify",results={@Result(name="success",location="/sub_success.jsp"),@Result(name="fail",location="/msg.jsp")})
	public String modify(){
		try{
			proService.update(product);
			operateRecord(Messages.MODIFY_PRODUCT+product.getName(), JBLConstants.MODIFY);
		}catch(Exception e){ 
			e.printStackTrace();
			setMsg(JBLConstants.MODIFY_FAIL);
			return "fail";
		}
		setMsg(JBLConstants.MODIFY_SUCCESS);
		return SUCCESS;
	}
	
	@Action(value="showproduct",results={
			@Result(name="success",location="/WEB-INF/pages/product/show_product.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String showProduct(){
		try {
			Integer id = Integer.parseInt(getRequest().getParameter("id"));
			product = proService.getProductById(id);
			getRequest().setAttribute("product", product);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.SEARCH_FAIL);
			return "fail";
		}
		return SUCCESS;
	}
	
	@Action(value="showproductlist",results={
			@Result(name="success",location="/WEB-INF/pages/product/show_product_list.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String showProductList(){
		try {
			Map<String,Object> params = new HashMap<String,Object>();
			List<Product> proList = proService.getProductsByParams(params);
			display(proList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			setMsg(JBLConstants.SEARCH_FAIL);
			return "fail";
		}
		return SUCCESS;
	}
	
	@Action(value="showcheckpage",results={
			@Result(name="success",location="/WEB-INF/pages/product/show_product.jsp"),
			@Result(name="fail",location="msg.jsp")
	})
	public String showCheckPage(){
		try {
			product = proService.getProductById(product.getId());
			getRequest().setAttribute("product", product);
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			setMsg(JBLConstants.SEARCH_FAIL);
			return "fail";
		}
	}
	@Action(value="delete",results={
			@Result(name="success",location="/sub_success.jsp"),
			@Result(name="fail",location="/msg.jsp")})
	public String delete(){
		try {
			product = proService.getProductById(product.getId());
			proService.delete(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			setMsg(JBLConstants.DELETE_FAIL);
			return "fail";
		}
		return SUCCESS;
	}
}
