package com.fiserv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiserv.dao.UserDao;
import com.fiserv.model.UserDetails;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public void setuserDAO(UserDao userDao) {
		this.userDao = userDao;
	}
	public void createAccount(UserDetails user) {
		userDao.createAccount(user);
		
	}
	public void removeUser(long accountNum) {
		userDao.removeUser(accountNum);
		
	}


	public double deposit(long accountNum, double amountToTransfer) {
		return userDao.deposit(accountNum, amountToTransfer);
	}

	public double withdraw(long accountNum, double amountToTransfer) {
		return userDao.withdraw(accountNum, amountToTransfer);
	}

	public int transfer(long debitorAccNum, long creditorAccNum, double amountToTransfer) {
		// TODO Auto-generated method stub
		return 0;
	}

	public UserDetails getUserData(long accountNum) {
		return userDao.getUserData(accountNum);
	}

	public List<UserDetails> listUsers() {
		return this.userDao.listUsers();
	}

}
