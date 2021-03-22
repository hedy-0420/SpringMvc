package com.tl.model;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository("accountDaoHib")
public class AccountDaoHib {
	@Autowired
	private Account account;
	
	@Autowired @Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	public AccountDaoHib() {
	}

	public Account findById(int accountid) throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		Account acc = session.get(Account.class, accountid);		
		return acc;
		
		
	}
	
}
