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
		void register(String s1,String s2);   //���ע�Ṧ�ܵ�ʵ��
		void login(String s1,String s2);   //��ɵ�¼���ܵ�ʵ��
		String depositMoney(String s1, String s2,double num1) throws InvalidDepositException;    //��ɴ��ܵ�ʵ��
		String withdrawals(String s1, String s2, double num1) throws AccountOverDrawnException;  //���ȡ��ܵ�ʵ��
		double inquiry(String s1, String s2); //�������ѯ���ܵ�ʵ��
		void transfer(String s1); // ת�˵ķ���
}
