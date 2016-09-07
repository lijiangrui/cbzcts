package com.jbl.interceptor;

import java.util.Map;

import com.jbl.action.ExitAction;
import com.jbl.action.LoginAction;
import com.jbl.pagemodel.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginingInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map session = actionInvocation.getInvocationContext().getSession();
		Object action = actionInvocation.getAction();
		if(action instanceof LoginAction || action instanceof ExitAction){
			return actionInvocation.invoke();
		}
		User user = (User)session.get("currentuser");
		if(user == null){
			return Action.LOGIN;
		}
		return actionInvocation.invoke();
	}

}
