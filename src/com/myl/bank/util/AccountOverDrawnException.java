package com.myl.bank.util;

import javax.swing.JOptionPane;

/**
 * @author MaoYulu
 *ȡ������ʱ�׳��쳣
 */
public class AccountOverDrawnException extends Exception{

	//�޲ι��캯��
	public AccountOverDrawnException() {}
	
	//�̳и���Ĺ��캯��
	public AccountOverDrawnException(String message) {
		super(message);
	}
	
	//���� ȡ������ĺ���
	public void dealAccountOverDrawnException(double num1, double num2) throws AccountOverDrawnException {
		if((num1-num2)>0) {
			//����Ľ���ȥ�ܽ�����0ʱ����ʾ��ʾ��
			JOptionPane.showMessageDialog(null,
					"����Ľ������ܽ����㣬��������С���ܽ�������","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
		}
	}
}
