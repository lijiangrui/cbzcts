package com.jbl.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jbl.service.RepairService;

@Namespace("/")
@Action(value="repairAction")
public class RepairAction extends BaseAction {
	private RepairService repairService;

	public RepairService getRepairService() {
		return repairService;
	}
	@Autowired
	public void setRepairService(RepairService repairService) {
		this.repairService = repairService;
	}
	
	public void init(){
		try {
			repairService.repair();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
