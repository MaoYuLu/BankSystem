package com.myl.bank.test;

//����java�İ�
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File.*;
import javax.swing.*;
//�����Զ����
import com.myl.bank.manager.ManagerImpl;

/**
 * @author MaoYulu
 * ����ϵͳ�Ľ������
 */
public class LoginFrame extends JFrame implements ActionListener {

	// �������
	JPanel jpa1, jpa2, jpa3;
	JLabel jlb1, jlb2;
	JButton jb1, jb2, jb3;
	JTextField jtf1;
	JPasswordField jpf;
	//�½����ܹ��������
	ManagerImpl mimp = new ManagerImpl();
	
	public void loginFrame() {
		jpa1 = new JPanel();
		jpa2 = new JPanel();
		jpa3 = new JPanel();

		jlb1 = new JLabel("�˺�:");
		jlb2 = new JLabel("����:");
		jb1 = new JButton("ע��");
		jb1.addActionListener(this); //��"ע��"��ť���м���
		jb2 = new JButton("��¼"); 
		jb2.addActionListener(this); //��"��¼"��ť���м���
		jb3 = new JButton("����"); 
		jb3.addActionListener(this); //��"����"��ť���м���
		jtf1 = new JTextField(10);  //�������������
		jpf = new JPasswordField(10);  //���������

		// ���ò��ֹ���
		this.setLayout(new GridLayout(4, 1));

		// ����������
		jpa1.add(jlb1);
		jpa1.add(jtf1);
		jpa2.add(jlb2);
		jpa2.add(jpf);
		jpa3.add(jb1);
		jpa3.add(jb2);
		jpa3.add(jb3);

		this.add(jpa1);
		this.add(jpa2);
		this.add(jpa3);

		this.setTitle("���е�¼ϵͳ");
		this.setSize(200, 300);
		this.setLocationRelativeTo(null); // ���ô���Ϊ��Ļ������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "��¼") {
			mimp.login(jtf1.getText(), jpf.getText());
		} else if (e.getActionCommand() == "ע��") {
			mimp.register(jtf1.getText(), jpf.getText());
		} else if (e.getActionCommand() == "����") {
			clear();
		}
	}
	
	/*
	 * �˺ſ��������������
	 */
	public void clear() {
		jtf1.setText("");
		jpf.setText("");
	}
}