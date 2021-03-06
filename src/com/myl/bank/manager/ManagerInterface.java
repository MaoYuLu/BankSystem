package com.myl.bank.manager;

import com.myl.bank.util.AccountOverDrawnException;
import com.myl.bank.util.InvalidDepositException;

/**
 * 该接口中包含了银行系统的基本操作方法
 * @author MaoYuLu
 *功能： 1.完成注册功能的实现--register 2.完成登录功能的实现--login
 *3.完成存款功能的实现--deposit 4.完成取款功能的实现-- withdrawals 
 *5.完成余额查询功能的实现-- inquiry 6.完成转账功能的实现--transfer 7. 完成退出系统功能的实现—exitSystem
 */
public  interface ManagerInterface {
	
	/**
	 * 完成注册功能的实现
	 * @param s1 strin类型
	 * @param s2
	 */
		void register(String s1,String s2);  
		
		/**
		 * 完成登录功能的实现
		 * @param s1
		 * @param s2
		 */
		void login(String s1,String s2); 
		
		/**
		 * 完成存款功能的实现
		 * @param s1
		 * @param s2
		 * @param num1
		 * @return
		 * @throws InvalidDepositException
		 */
		String depositMoney(String s1, String s2,double num1) throws InvalidDepositException;    
		
		/**
		 * 完成取款功能的实现
		 * @param s1
		 * @param s2
		 * @param num1
		 * @return
		 * @throws AccountOverDrawnException
		 */
		String withdrawals(String s1, String s2, double num1) throws AccountOverDrawnException;  
		
		/**
		 * 完成余额查询功能的实现
		 * @param s1
		 * @param s2
		 * @return
		 */
		double inquiry(String s1, String s2); 
		
		/**
		 *  转账的方法
		 * @param s1
		 */
		void transfer(String s1); 
}
