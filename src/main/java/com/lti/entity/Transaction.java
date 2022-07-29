package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {

	@Id
	@SequenceGenerator(name="transaction_seq",initialValue = 5001,allocationSize = 1)
	@GeneratedValue(generator = "transaction_seq", strategy = GenerationType.SEQUENCE)
	private int transactionId;
	private int userId;
	private int emiScheme;	
	private LocalDate orderDate;
	private double paidAmount;
	private int productId; //FK
//	private String productName;
	private double balanceAmount;
	private int cardNo;
	
	
	
	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	//Mappings
	@ManyToOne
	@JoinColumn(name="emiCardNo")
	EmiCard emiCard;
	
	@ManyToOne
	//@JoinColumn(name="productId")
	Product product;
	
	
	//Parameterized Constructors
	
	public EmiCard getEmiCard() {
		return emiCard;
	}

	public void setEmiCard(EmiCard emiCard) {
		this.emiCard = emiCard;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Transaction(int transactionId,int userId, int emiScheme, LocalDate orderDate, double paidAmount,
			int productId, double balanceAmount) {
		super();
		this.transactionId = transactionId;
		this.userId = userId;
		this.emiScheme = emiScheme;
		this.orderDate = orderDate;
		this.paidAmount = paidAmount;
		this.productId = productId;
//		this.productName = productName;
		this.balanceAmount = balanceAmount;
	}
	
	//Getters and Setters

	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getEmiScheme() {
		return emiScheme;
	}

	public void setEmiScheme(int emiScheme) {
		this.emiScheme = emiScheme;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

//	public String getProductName() {
//		return productName;
//	}
//
//	public void setProductName(String productName) {
//		this.productName = productName;
//	}

	public double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	
	
	
	
}
