package com.jbl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbl.dao.TitleDAO;
import com.jbl.model.Ttitle;
import com.jbl.pagemodel.Title;
import com.jbl.service.TitleService;
import com.jbl.util.CommonUtils;

@Service(value="titleService")
public class TitleServiceImpl implements TitleService {

	private TitleDAO titleDAO;
	
	public TitleDAO getTitleDAO() {
		return titleDAO;
	}
	
	@Autowired
	public void setTitleDAO(TitleDAO titleDAO) {
		this.titleDAO = titleDAO;
	}

	@Override
	public List<Title> getAllTitles() throws Exception {
		String hql = "from Ttitle tt where 1=1 and tt.deltriger =0";
		List<Ttitle> ttlist = titleDAO.find(hql);
		List<Title> tList = copyProperties(ttlist);
		return tList;
	}

	private List<Title> copyProperties(List<Ttitle> ttlist) {
		List<Title> tList = new ArrayList<Title>();
		if(CommonUtils.isNotNull(ttlist)){
			for(Ttitle tt : ttlist){
				tList.add(copyProperties(tt));
			}
		}
		return tList;
	}

	private Title copyProperties(Ttitle tt) {
		Title t = new Title();
		BeanUtils.copyProperties(tt, t);
		return t;
	}

}
