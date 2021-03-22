package com.tl.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tl.model.AccountMember;
import com.tl.model.AccoutMemberDao;

@Controller
public class AccountMemberController {
	
	@Autowired @Qualifier("accountMemberDao")
	private AccoutMemberDao accMdao;
	
	@RequestMapping(path="/accountMember.controller")
	public String getAccountMember(Model m) throws SQLException {
		AccountMember acc = accMdao.findById(1001);
		String accName = acc.getAccount();
		m.addAttribute("accName", accName);
		return "account";		
	}
	
	@RequestMapping(path="/accountMember.pic",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public byte[] processResponseByteArray(HttpServletResponse response,HttpServletRequest request) throws IOException, SQLException {
		AccountMember acc = accMdao.findById(1001);
		return acc.getUserProtrait();
		
	}

}
