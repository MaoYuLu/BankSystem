package com.myl.bank.model;

import java.util.Date;

import com.myl.bank.util.ReadWriteProperties;

/**
 * @author MaoYuLu
 *封装money数据
 */
public class MoneyBeam {

	private double money;
	ReadWriteProperties rwprops = new ReadWriteProperties();
	
	//无参构造函数
	public MoneyBeam() {
		this.money = 0;
	}
	

	//对外提供公有的方法获取私有属性money
	public  double getMoney(String name, String pwd) {
		money = rwprops.readUserMoney(name, pwd);
		return money;
	}

	//对外提供公有的方法设置私有属性money
	public String setMoney(String name, String pwd, double money1) {
		this.money = money1;
		return rwprops.writePrperties(name, pwd, new Date().toString(), money);
	}
}
