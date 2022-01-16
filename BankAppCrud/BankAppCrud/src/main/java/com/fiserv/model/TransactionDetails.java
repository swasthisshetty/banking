package com.fiserv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TransactionDetails {
	@Id
	@GeneratedValue
	private int transactionId;
	private int depositerAccNo;
	private int creditorAccNo;
	private float amountToTransfer;
	private String date;
	private float balance;
	private String TransType;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getDepositerAccNo() {
		return depositerAccNo;
	}

	public void setDepositerAccNo(int depositerAccNo) {
		this.depositerAccNo = depositerAccNo;
	}

	public int getCreditorAccNo() {
		return creditorAccNo;
	}

	public void setCreditorAccNo(int creditorAccNo) {
		this.creditorAccNo = creditorAccNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getTransType() {
		return TransType;
	}

	public void setTransType(String transType) {
		TransType = transType;
	}

	public float getAmountToTransfer() {
		return amountToTransfer;
	}

	public void setAmountToTransfer(float amountToTransfer) {
		this.amountToTransfer = amountToTransfer;
	}

}
