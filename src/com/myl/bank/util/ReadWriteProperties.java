package com.myl.bank.util;

import java.io.*;
import java.util.*;
import com.myl.bank.*;
import com.myl.bank.manager.ManagerImpl;
import com.myl.bank.test.LoginFrame;

/**
 * @author MaoYuLu 
 * 读取和写入properties文件的内容
 */
public class ReadWriteProperties {

	// 设置私有的properties文件有的变量
	private String date, user_name, user_pwd, user_money;
	//新建一个properties对象
	Properties props = new Properties();
	MD5Util md5 = new MD5Util();

	/**
	 * 读取properties文件的用户名
	 * @param name 传入的用户名
	 * @param pwd 传入的密码
	 * @return  user_name返回从文件中拿出的用户名
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
	 * 读取properties文件的密码
	 * @param name 传入的用户名
	 * @param pwd 传入的密码
	 * @return  user_pwd 返回从文件中拿出的密码
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
	 * 读取properties文件的日期
	 * @param name传入的用户名
	 * @param pwd 传入的密码
	 * @return date 返回从文件中拿出的日期
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
	 * 读取properties文件的金额
	 * @param name 传入的用户名
	 * @param pwd 传入的密码
	 * @return user_money 返回从文件中拿出的金额
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
	 * 将用户的各项信息写入到properties文件
	 * @param name 传入的用户名
	 * @param pwd 传入的密码
	 * @param date 传入的用日期
	 * @param moneyu 传入的金额
	 */
	public String writePrperties(String name, String pwd, String date, double money) {
		try {
			File file = new File("src/Bank.properties");
			FileInputStream in = new FileInputStream(file);
			props.load(in);
			in.close();
			String smoney = Double.toString(money);
			// 将文件中项对于变量的值赋给类定义了的私有变量
			props.setProperty("user_name", name);
			props.setProperty("user_pwd", pwd);
			props.setProperty("date", date);
			props.setProperty("user_money", smoney);
			//将载入的内容生成新的文件并输出
			File file1 = new File("src/" + name + ".properties");
			FileOutputStream out = new FileOutputStream(file1);
			props.store(out, "file1");
			//关闭输出流
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