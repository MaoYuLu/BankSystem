package com.myl.bank.util;

import javax.swing.JOptionPane;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

/**
 * @author MaoYulu
 *存款为负数时抛出异常
 */
public class InvalidDepositException extends Exception{

	//无参构造函数
	public InvalidDepositException() {}
	
	//继承父类的构造函数
	public InvalidDepositException(String message) {
		super(message);
	}
	
	//处理负数异常的函数
	public void dealInvalidDepositException(double num1) throws InvalidDepositException {
		if(num1<0) {
			//输入的数字小于0时，显示提示框
			JOptionPane.showMessageDialog(null,
					"输入的金额为负数，请新输入大于0的数！","提示消息",JOptionPane.WARNING_MESSAGE);  
		}
	}
}
