package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {
	static int i =0;
	public abstract String execute(HttpServletRequest request,HttpServletResponse response);
}
