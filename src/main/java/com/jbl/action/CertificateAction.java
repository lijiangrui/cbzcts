package com.jbl.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.jbl.pagemodel.Certificate;
import com.jbl.pagemodel.Product;
import com.jbl.pagemodel.Supplier;
import com.jbl.service.CertificateService;
import com.jbl.service.ProductService;
import com.jbl.service.SupplierService;
import com.jbl.util.JBLConstants;
import com.jbl.util.Messages;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("basePackage")
@Namespace("/certificate")
@Action(value="certificateAction")
public class CertificateAction extends BaseAction implements ModelDriven<Certificate>{
	
	private Certificate certificate = new Certificate();
	@Override
	public Certificate getModel() {
		return certificate;
	}
	
	private CertificateService cerService;
	private SupplierService sprService;

	public CertificateService getCerService() {
		return cerService;
	}
	@Autowired
	public void setCerService(CertificateService cerService) {
		this.cerService = cerService;
	}

	public SupplierService getSprService() {
		return sprService;
	}
	@Autowired
	public void setSprService(SupplierService sprService) {
		this.sprService = sprService;
	}
	
	@Action(value="showcertificatepage",results={
			@Result(name="success",location="/WEB-INF/pages/certificate/show_certificate_page.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String showCertificatePage(){
		try {
			List<Supplier> suList = sprService.getSupplierByParams(null);
			selectHtml(suList, "id", "name", "sid", "sHTML", null, null);
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			setMsg(JBLConstants.SEARCH_FAIL);
			return "fail";
		}
	}
	
	@Action(value="save",results={
			@Result(name="success",location="/savesuccess.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String save(){
		try {
			cerService.save(certificate);
			operateRecord(Messages.SAVE_CERTIFICATE+certificate.getNo(), JBLConstants.ADD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			setMsg(JBLConstants.SAVE_FAIL);
			return "fail";
		}
		setUrl("showcertificatepage!showCertificatePage.action");
		return SUCCESS;
	}
	
	@Action(value="showmodifypage",results={
			@Result(name="success",location="/WEB-INF/pages/certificate/show_modifycertificate_page.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String showModifyPage(){
		try {
			certificate = cerService.getCertificateById(certificate.getId());
			getRequest().setAttribute("certificate", certificate);
		} catch (Exception e) {
			return "fail";
		}
		return SUCCESS;
	}

	@Action(value="modify",results={@Result(name="success",location="/sub_success.jsp"),@Result(name="fail",location="/msg.jsp")})
	public String modify(){
		try{
			cerService.update(certificate);
			operateRecord(Messages.MODIFY_CERTIFICATE+certificate.getNo(), JBLConstants.MODIFY);
		}catch(Exception e){ 
			e.printStackTrace();
			setMsg(JBLConstants.MODIFY_FAIL);
			return "fail";
		}
		setMsg(JBLConstants.SAVE_SUCCESS);
		return SUCCESS;
	}
	
	@Action(value="delete",results={
			@Result(name="success",location="/sub_success.jsp"),
			@Result(name="fail",location="/msg.jsp")})
	public String delete(){
		try {
			certificate = cerService.getCertificateById(certificate.getId());
			cerService.delete(certificate);
			operateRecord(Messages.DELETE_CERTIFICATE+certificate.getNo(), JBLConstants.DELETE);
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			setMsg(JBLConstants.DELETE_FAIL);
			return "fail";
		}
	}
	
	@Action(value="showcertificate",results={
			@Result(name="success",location="/WEB-INF/pages/certificate/show_certificate.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String showCertificate(){
		try {
			Integer id = Integer.parseInt(getRequest().getParameter("id"));
			certificate = cerService.getCertificateById(id);
			getRequest().setAttribute("certificate", certificate);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.SEARCH_FAIL);
			return "fail";
		}
		return SUCCESS;
	}
	
	@Action(value="showcheckpage",results={
			@Result(name="success",location="/WEB-INF/pages/certificate/show_certificate.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String showCheckPage() {
		return showCertificate();
	}
	
	@Action(value="showcertificatelist",results={
			@Result(name="success",location="/WEB-INF/pages/certificate/show_certificate_list.jsp"),
			@Result(name="fail",location="/msg.jsp")
		
	})
	public String showCertificateList() {
		Map<String,Object> param = new HashMap<String, Object>();
		List<Certificate> cerList;
		try {
			cerList = cerService.getCertificatesByParam(param);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.SEARCH_FAIL);
			return "fail";
		}
		display(cerList);
		return SUCCESS;
	}
	
	@Action(value="searchcertificatelist",results={
			@Result(name="success",location="/WEB-INF/pages/certificate/show_certificate_list.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String searchCertificateList(){
		
		return SUCCESS;
	}
}
