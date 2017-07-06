package com.myl.bank.manager;

import com.myl.bank.util.AccountOverDrawnException;
import com.myl.bank.util.InvalidDepositException;

/**
 * �ýӿ��а���������ϵͳ�Ļ�����������
 * @author MaoYuLu
 *���ܣ� 1.���ע�Ṧ�ܵ�ʵ��--register 2.��ɵ�¼���ܵ�ʵ��--login
 *3.��ɴ��ܵ�ʵ��--deposit 4.���ȡ��ܵ�ʵ��-- withdrawals 
 *5.�������ѯ���ܵ�ʵ��-- inquiry 6.���ת�˹��ܵ�ʵ��--transfer 7. ����˳�ϵͳ���ܵ�ʵ�֡�exitSystem
 */
public  interface ManagerInterface {
	
	/**
	 * ���ע�Ṧ�ܵ�ʵ��
	 * @param s1 strin����
	 * @param s2
	 */
		void register(String s1,String s2);  
		
		/**
		 * ��ɵ�¼���ܵ�ʵ��
		 * @param s1
		 * @param s2
		 */
		void login(String s1,String s2); 
		
		/**
		 * ��ɴ��ܵ�ʵ��
		 * @param s1
		 * @param s2
		 * @param num1
		 * @return
		 * @throws InvalidDepositException
		 */
		String depositMoney(String s1, String s2,double num1) throws InvalidDepositException;    
		
		/**
		 * ���ȡ��ܵ�ʵ��
		 * @param s1
		 * @param s2
		 * @param num1
		 * @return
		 * @throws AccountOverDrawnException
		 */
		String withdrawals(String s1, String s2, double num1) throws AccountOverDrawnException;  
		
		/**
		 * �������ѯ���ܵ�ʵ��
		 * @param s1
		 * @param s2
		 * @return
		 */
		double inquiry(String s1, String s2); 
		
		/**
		 *  ת�˵ķ���
		 * @param s1
		 */
		void transfer(String s1); 
}
