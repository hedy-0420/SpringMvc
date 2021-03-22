package com.tl.util;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountPicRetrive {
	
	@RequestMapping(path="/ry",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public byte[] processResponseByteArray(HttpServletResponse response,HttpServletRequest request) throws IOException {
		InputStream is = request.getServletContext().getResourceAsStream("/WEB-INF/pages/images/pic5.jpg");
		return IOUtils.toByteArray(is);
		
	}

}
