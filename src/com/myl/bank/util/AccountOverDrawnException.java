package com.myl.bank.util;

import javax.swing.JOptionPane;

/**
 * @author MaoYulu
 *取款超出余额时抛出异常
 */
public class AccountOverDrawnException extends Exception{

	//无参构造函数
	public AccountOverDrawnException() {}
	
	//继承父类的构造函数
	public AccountOverDrawnException(String message) {
		super(message);
	}
	
	//处理 取款超出余额的函数
	public void dealAccountOverDrawnException(double num1, double num2) throws AccountOverDrawnException {
		if((num1-num2)>0) {
			//输入的金额减去总金额大于0时，显示提示框
			JOptionPane.showMessageDialog(null,
					"输入的金额大于总金额，余额不足，请新输入小于总金额的数！","提示消息",JOptionPane.WARNING_MESSAGE);
		}
	}
}
