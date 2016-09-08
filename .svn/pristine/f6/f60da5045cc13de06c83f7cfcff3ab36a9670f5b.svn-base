package com.jbl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbl.dao.AreaDAO;
import com.jbl.model.Tarea;
import com.jbl.pagemodel.Area;
import com.jbl.service.AreaService;
import com.jbl.util.CommonUtils;

@Service(value="areaService")
public class AreaServiceImpl implements AreaService{

	private AreaDAO areaDAO;
	
	public AreaDAO getAreaDAO() {
		return areaDAO;
	}
	@Autowired
	public void setAreaDAO(AreaDAO areaDAO) {
		this.areaDAO = areaDAO;
	}

	@Override
	public List<Area> getAreasByPid(int pid) throws Exception {
		String hql = "from Tarea t where t.deltrigger = 0 and t.tarea.id = :pid";
		Map<String,Object> params = new HashMap<String,Object>();
		List<Area> areaList = new ArrayList<Area>();
		params.put("pid", pid);
		List<Tarea> tareaList = areaDAO.find(hql,params);
		if(CommonUtils.isNotNull(tareaList)){
			for(Tarea ta : tareaList){
				Area area = new Area();
				copyProperties(ta,area);
				area.setPid(ta.getTarea().getId());
				areaList.add(area);
			}
		}
		return areaList;
	}
	private void copyProperties(Tarea ta, Area area) {
		BeanUtils.copyProperties(ta, area);
	}

}
