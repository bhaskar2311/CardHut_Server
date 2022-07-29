package com.lti.dao;

import java.util.List;

import com.lti.entity.Transaction;

public interface TransactionDao {
	
	Transaction addTransactionOfProduct(Transaction transaction);
	List<Transaction> viewTransactionByCardNo(int cardNo);
	List<Transaction> viewTransactionsByProductId(int productId);
	
	

}
