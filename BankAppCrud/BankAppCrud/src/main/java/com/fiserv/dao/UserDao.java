package com.fiserv.dao;

import java.util.List;


import com.fiserv.model.UserDetails;

public interface UserDao {
	public void createAccount(UserDetails user);
		public void removeUser(long accountNum);


	public double deposit(long accountNum, double amountToTransfer);
	
	public double withdraw(long accountNum, double amountToTransfer);

	public int transfer(long debitorAccNum, long creditorAccNum, double amountToTransfer);

	public UserDetails getUserData(long accountNum);
	
	public List<UserDetails> listUsers();

}
