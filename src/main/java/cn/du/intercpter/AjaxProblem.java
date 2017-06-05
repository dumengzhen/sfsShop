package cn.du.intercpter;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AjaxProblem extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin", "*");
		return invocation.invoke();
	}
	
}
