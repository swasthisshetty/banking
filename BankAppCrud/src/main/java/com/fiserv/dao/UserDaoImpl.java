package com.fiserv.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fiserv.model.UserDetails;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	public void createAccount(UserDetails user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		
	}
	

	public void removeUser(long accountNum) {
		Session session = sessionFactory.getCurrentSession();
		UserDetails user = (UserDetails) session.get(UserDetails.class, new Long(accountNum));
		if(null != user){
			session.delete(user);
		}

	}
	public double deposit(long accountNum, double amountToTransfer) {
		double finalBalance = 0;
		double result = 0;
		Session session = sessionFactory.getCurrentSession();
		UserDetails user=session.get(UserDetails.class,accountNum);
		user.setBalance(user.getBalance() + amountToTransfer);
		finalBalance = user.getBalance();
		//result+=finalBalance;
		session.update(finalBalance);
		return finalBalance;
	}

	public double withdraw(long accountNum, double amountToTransfer) {
		double finalBalance = 0;
		Session session = sessionFactory.getCurrentSession();
		UserDetails u=session.get(UserDetails.class, accountNum);
		u.setBalance(u.getBalance()-amountToTransfer);
		finalBalance=u.getBalance();
		session.update(finalBalance);
		return 0;
	}

	public int transfer(long debitorAccNum, long creditorAccNum, double amountToTransfer) {
		double finalBalance1 = 0;
		double finalBalance2 = 0;
		Session session = sessionFactory.getCurrentSession();
		UserDetails u1 = session.get(UserDetails.class, debitorAccNum);
		UserDetails u2 = session.get(UserDetails.class, creditorAccNum);
		u1.setBalance(u1.getBalance() - amountToTransfer);
		u2.setBalance(u2.getBalance() + amountToTransfer);
		finalBalance1 = u1.getBalance();
		finalBalance2 = u2.getBalance();
		session.update(finalBalance1);
		session.update(finalBalance2);
		// can you merge if this doesn't work
		return 0;
	}


	public UserDetails getUserData(long accountNum) {
		Session session = sessionFactory.getCurrentSession();		
		UserDetails u1 = (UserDetails) session.get(UserDetails.class, new Long(accountNum));
		return u1;
	}

	public List<UserDetails> listUsers() {
		Session session = sessionFactory.getCurrentSession();
		List<UserDetails> UserList = session.createQuery("from UserDetails").list();
		return UserList;
	}

}
