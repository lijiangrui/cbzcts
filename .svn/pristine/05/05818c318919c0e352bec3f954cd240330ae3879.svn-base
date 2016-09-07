package com.jbl.decorator;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.displaytag.decorator.TableDecorator;

import com.jbl.pagemodel.Certificate;


public class CertificateDisplayTagDecorator extends TableDecorator{
	
	public String getType() throws UnsupportedOperationException{
		Certificate cer = (Certificate)getCurrentRowObject();
		String[] typeNames = {"业务类型","质量管理","认证管理","认证认可","执行标准","食品相关产品","生产许可证","特种设备","自愿性认证","其他业务"};
		return typeNames[cer.getType()-1];
	}
	
	public String getValidate() throws UnsupportedOperationException{
		Certificate cer = (Certificate)getCurrentRowObject();
		Date validate = cer.getValidate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(validate);
	}
}
