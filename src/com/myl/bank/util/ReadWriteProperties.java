package com.myl.bank.util;

import java.io.*;
import java.util.*;
import com.myl.bank.*;
import com.myl.bank.manager.ManagerImpl;
import com.myl.bank.test.LoginFrame;

/**
 * @author MaoYuLu 
 * ��ȡ��д��properties�ļ�������
 */
public class ReadWriteProperties {

	// ����˽�е�properties�ļ��еı���
	private String date, user_name, user_pwd, user_money;
	//�½�һ��properties����
	Properties props = new Properties();
	MD5Util md5 = new MD5Util();

	/**
	 * ��ȡproperties�ļ����û���
	 * @param name ������û���
	 * @param pwd ���������
	 * @return  user_name���ش��ļ����ó����û���
	 */
	public String readUserName(String name, String pwd) {
		try {
			File file = new File("src/" + name + ".properties");
			FileInputStream in = new FileInputStream(file);
			props.load(in);
			in.close();
			user_name = props.getProperty("user_name");
		} catch (IOException e) {
			System.out.println(e);
		}
		return user_name;
	}
	
	/**
	 * ��ȡproperties�ļ�������
	 * @param name ������û���
	 * @param pwd ���������
	 * @return  user_pwd ���ش��ļ����ó�������
	 */
	public String readUserPwd(String name, String pwd) {
		try {
			File file = new File("src/" + name + ".properties");
			FileInputStream in = new FileInputStream(file);
			props.load(in);
			in.close();
			user_pwd = props.getProperty("user_pwd");
		} catch (IOException e) {
			System.out.println(e);
		}
		return user_pwd;
	}


	/**
	 * ��ȡproperties�ļ�������
	 * @param name������û���
	 * @param pwd ���������
	 * @return date ���ش��ļ����ó�������
	 */
	public String readDate(String name, String pwd) {
		try {
			File file = new File("src/" + name + ".properties");
			FileInputStream in = new FileInputStream(file);
			props.load(in);
			in.close();
			date = props.getProperty("date");
		} catch (IOException e) {
			System.out.println(e);
		}
		return date;
	}


	/**
	 * ��ȡproperties�ļ��Ľ��
	 * @param name ������û���
	 * @param pwd ���������
	 * @return user_money ���ش��ļ����ó��Ľ��
	 */
	public double readUserMoney(String name, String pwd) {
		try {
			File file = new File("src/" + name + ".properties");
			FileInputStream in = new FileInputStream(file);
			props.load(in);
			user_money = props.getProperty("user_money");
		} catch (IOException e) {
			System.out.println(e);
		}
		return Double.valueOf(user_money);
	}

	/**
	 * ���û��ĸ�����Ϣд�뵽properties�ļ�
	 * @param name ������û���
	 * @param pwd ���������
	 * @param date �����������
	 * @param moneyu ����Ľ��
	 */
	public String writePrperties(String name, String pwd, String date, double money) {
		try {
			File file = new File("src/Bank.properties");
			FileInputStream in = new FileInputStream(file);
			props.load(in);
			in.close();
			String smoney = Double.toString(money);
			// ���ļ�������ڱ�����ֵ�����ඨ���˵�˽�б���
			props.setProperty("user_name", name);
			props.setProperty("user_pwd", pwd);
			props.setProperty("date", date);
			props.setProperty("user_money", smoney);
			//����������������µ��ļ������
			File file1 = new File("src/" + name + ".properties");
			FileOutputStream out = new FileOutputStream(file1);
			props.store(out, "file1");
			//�ر������
			out.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		return null;
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

}