package com.myl.bank.util;

import javax.swing.JOptionPane;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

/**
 * @author MaoYulu
 *���Ϊ����ʱ�׳��쳣
 */
public class InvalidDepositException extends Exception{

	//�޲ι��캯��
	public InvalidDepositException() {}
	
	//�̳и���Ĺ��캯��
	public InvalidDepositException(String message) {
		super(message);
	}
	
	//�������쳣�ĺ���
	public void dealInvalidDepositException(double num1) throws InvalidDepositException {
		if(num1<0) {
			//���������С��0ʱ����ʾ��ʾ��
			JOptionPane.showMessageDialog(null,
					"����Ľ��Ϊ�����������������0������","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
		}
	}
}
