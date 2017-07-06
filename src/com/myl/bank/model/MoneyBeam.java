package com.myl.bank.model;

import java.util.Date;

import com.myl.bank.util.ReadWriteProperties;

/**
 * @author MaoYuLu
 *��װmoney����
 */
public class MoneyBeam {

	private double money;
	ReadWriteProperties rwprops = new ReadWriteProperties();
	
	//�޲ι��캯��
	public MoneyBeam() {
		this.money = 0;
	}
	

	//�����ṩ���еķ�����ȡ˽������money
	public  double getMoney(String name, String pwd) {
		money = rwprops.readUserMoney(name, pwd);
		return money;
	}

	//�����ṩ���еķ�������˽������money
	public String setMoney(String name, String pwd, double money1) {
		this.money = money1;
		return rwprops.writePrperties(name, pwd, new Date().toString(), money);
	}
}
