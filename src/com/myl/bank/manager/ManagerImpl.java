package com.myl.bank.manager;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.myl.bank.model.*;
import com.myl.bank.test.*;
import com.myl.bank.util.*;

/**
 * ��ManagerImpl�Ƕ�ManagerInterface�ӿ��з�����ʵ��
 */
public class ManagerImpl implements ManagerInterface {

	//������������MoneyBeam����
//	MoneyBeam m = new MoneyBeam();
	ReadWriteProperties rwprops = new ReadWriteProperties();
	MD5Util md5 = new MD5Util();
	//String nameAfterMd5 = md5.getMD5(name);
	
	//���ע�Ṧ�ܵ�ʵ��
	@Override
	public void register(String s1, String s2) {
		File file = new File("src/"+s1+".properties");
		if (file.exists()) {
			JOptionPane.showMessageDialog(null, "�˺��Ѵ��ڣ�������ע���˺Ż��¼���˺�", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
		}else if(s1.isEmpty() && s2.isEmpty()) {  
            JOptionPane.showMessageDialog(null,"�������û��������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
        }else if (s1.isEmpty()) {
			JOptionPane.showMessageDialog(null, "�������û�����", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
		} else if (s2.isEmpty()) {
			JOptionPane.showMessageDialog(null, "���������룡", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
		} else if (!s1.isEmpty() && !s2.isEmpty()) {
			String nameAfterMd5 = md5.getMD5(s1);
			rwprops.writePrperties(s1, s2, new Date().toString(), 0);
			JOptionPane.showMessageDialog(null, "ע��ɹ���", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
		}
	}

	//��ɵ�¼���ܵ�ʵ��
	@Override
	public void login(String s1, String s2) {
		File file = new File("src/"+s1+".properties");
		if (!s1.isEmpty() && !s2.isEmpty() && !file.exists()) {
			JOptionPane.showMessageDialog(null, "�˺Ų����ڣ���ע�ᣡ", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
		}else if((s1.equals(rwprops.readUserName(s1, s2))) && (s2.equals(rwprops.readUserPwd(s1, s2)))) {
			JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); 
			rwprops.getProps().setProperty("date", new Date().toString());
			UserFrame uf = new UserFrame();
			uf.userFrame(s1,s2); 
			//�����˺ź������UserFrame
		}else if(s1.isEmpty() && s2.isEmpty()) {  
            JOptionPane.showMessageDialog(null,"�������û��������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
        }else if (s1.isEmpty()) {
			JOptionPane.showMessageDialog(null, "�������û�����", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
		} else if (s2.isEmpty()) {
			JOptionPane.showMessageDialog(null, "���������룡", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
		}else {  
            JOptionPane.showMessageDialog(null,"�û��������������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);  
        }  
	}

	//��ɴ��ܵ�ʵ��
	@Override
	public String depositMoney(String name, String pwd, double num1) throws InvalidDepositException {
		double usermoney = rwprops.readUserMoney(name, pwd);
		if(num1>=0) {
			usermoney += num1;
		}else {
			InvalidDepositException ide = new InvalidDepositException();
			ide.dealInvalidDepositException(num1);
		}
		return rwprops.writePrperties(name, pwd, new Date().toString(), usermoney);
	}

	//���ȡ��ܵ�ʵ��
	@Override
	public String withdrawals(String name, String pwd, double num1) throws AccountOverDrawnException {
		double usermoney = rwprops.readUserMoney(name, pwd);
		if((usermoney-num1)>0) {
			usermoney -= num1;
		}else {
			AccountOverDrawnException ade = new AccountOverDrawnException();
			ade.dealAccountOverDrawnException(num1, usermoney);
		}
		return rwprops.writePrperties(name, pwd, new Date().toString(), usermoney);
	}

	//�������ѯ���ܵ�ʵ��
	@Override
	public double inquiry(String name,String pwd) {			
		return rwprops.readUserMoney(name, pwd);
	}
	
	// ת�˵ķ���
	@Override
	public void transfer(String s1) {
		// TODO Auto-generated method stub
		
	}
/*	   
    public static void main(String []args) {
   	 ManagerImpl mi = new ManagerImpl();
   	 mi.register("1", "123");
    }
*/


}
