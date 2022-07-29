package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@SequenceGenerator(name = "user_seq", initialValue = 200, allocationSize = 1)
	@GeneratedValue(generator = "user_seq", strategy = GenerationType.SEQUENCE)
	private int userId;

	private String fullName;

	private String email;

	private String userPassword;

	private String userPhone;

	private String userAddress;

	private String cardType;

	private String userBank;

	private String userAccountNo;

	private String userIfsc;

	// Mappings
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	EmiCard emiCard;

	// Parameterized Constructors

	public User(int userId, String fullName, String email, String userPhone, String userPassword, String userAddress,
			String cardType, String userBank, String userAccountNo, String userIfsc, EmiCard emiCard) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.email = email;
		this.userPhone = userPhone;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
		this.cardType = cardType;
		this.userBank = userBank;
		this.userAccountNo = userAccountNo;
		this.userIfsc = userIfsc;
		this.emiCard = emiCard;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getUserBank() {
		return userBank;
	}

	public void setUserBank(String userBank) {
		this.userBank = userBank;
	}

	public String getUserAccountNo() {
		return userAccountNo;
	}

	public void setUserAccountNo(String userAccountNo) {
		this.userAccountNo = userAccountNo;
	}

	public String getUserIfsc() {
		return userIfsc;
	}

	public void setUserIfsc(String userIfsc) {
		this.userIfsc = userIfsc;
	}

	public EmiCard getEmiCard() {
		return emiCard;
	}

	public void setEmiCard(EmiCard emiCard) {
		this.emiCard = emiCard;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}