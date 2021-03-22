package com.tl.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class HelloController extends AbstractController {

	@Override
	@RequestMapping(path ="/hello.controller",method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		Set<String> s = getServletContext().getResourcePaths("/");
		for(String s1 :s) {
			System.out.println(s1);
		}
		
		String name= request.getParameter("username");
		Map<String, String> errors = new HashMap<String,String>();
		request.setAttribute("errors", errors);
		
		if(name==null||name.length()==0) {
			errors.put("reply","name is require");
		}
		
		if(errors!=null&&!errors.isEmpty()) {
			return new ModelAndView("/form.jsp");
		}
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		
		return new ModelAndView("/success.jsp");
	}

}
