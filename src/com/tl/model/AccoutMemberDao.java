package com.tl.model;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("accountMemberDao")
public class AccoutMemberDao {	
	@Autowired
	private AccountMember accountMember;
	
	@Autowired @Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	public AccountMember findById(int accountid) throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		AccountMember acc = session.get(AccountMember.class, accountid);		
		return acc;	
		
	}
}
