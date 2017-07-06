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
 * 类ManagerImpl是对ManagerInterface接口中方法的实现
 */
public class ManagerImpl implements ManagerInterface {

	//单例创建银行MoneyBeam对象
//	MoneyBeam m = new MoneyBeam();
	ReadWriteProperties rwprops = new ReadWriteProperties();
	MD5Util md5 = new MD5Util();
	//String nameAfterMd5 = md5.getMD5(name);
	
	//完成注册功能的实现
	@Override
	public void register(String s1, String s2) {
		File file = new File("src/"+s1+".properties");
		if (file.exists()) {
			JOptionPane.showMessageDialog(null, "账号已存在！请重新注册账号或登录本账号", "提示消息", JOptionPane.WARNING_MESSAGE);
		}else if(s1.isEmpty() && s2.isEmpty()) {  
            JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
        }else if (s1.isEmpty()) {
			JOptionPane.showMessageDialog(null, "请输入用户名！", "提示消息", JOptionPane.WARNING_MESSAGE);
		} else if (s2.isEmpty()) {
			JOptionPane.showMessageDialog(null, "请输入密码！", "提示消息", JOptionPane.WARNING_MESSAGE);
		} else if (!s1.isEmpty() && !s2.isEmpty()) {
			String nameAfterMd5 = md5.getMD5(s1);
			rwprops.writePrperties(s1, s2, new Date().toString(), 0);
			JOptionPane.showMessageDialog(null, "注册成功！", "提示消息", JOptionPane.WARNING_MESSAGE);
		}
	}

	//完成登录功能的实现
	@Override
	public void login(String s1, String s2) {
		File file = new File("src/"+s1+".properties");
		if (!s1.isEmpty() && !s2.isEmpty() && !file.exists()) {
			JOptionPane.showMessageDialog(null, "账号不存在，请注册！", "提示消息", JOptionPane.WARNING_MESSAGE);
		}else if((s1.equals(rwprops.readUserName(s1, s2))) && (s2.equals(rwprops.readUserPwd(s1, s2)))) {
			JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE); 
			rwprops.getProps().setProperty("date", new Date().toString());
			UserFrame uf = new UserFrame();
			uf.userFrame(s1,s2); 
			//传递账号和密码给UserFrame
		}else if(s1.isEmpty() && s2.isEmpty()) {  
            JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
        }else if (s1.isEmpty()) {
			JOptionPane.showMessageDialog(null, "请输入用户名！", "提示消息", JOptionPane.WARNING_MESSAGE);
		} else if (s2.isEmpty()) {
			JOptionPane.showMessageDialog(null, "请输入密码！", "提示消息", JOptionPane.WARNING_MESSAGE);
		}else {  
            JOptionPane.showMessageDialog(null,"用户名或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);  
        }  
	}

	//完成存款功能的实现
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

	//完成取款功能的实现
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

	//完成余额查询功能的实现
	@Override
	public double inquiry(String name,String pwd) {			
		return rwprops.readUserMoney(name, pwd);
	}
	
	// 转账的方法
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
