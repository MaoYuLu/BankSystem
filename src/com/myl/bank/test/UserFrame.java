package com.myl.bank.test;

//����java�İ�
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
//�����Զ����
import com.myl.bank.manager.ManagerImpl;
import com.myl.bank.util.AccountOverDrawnException;
import com.myl.bank.util.InvalidDepositException;
import com.myl.bank.util.ReadWriteProperties;

/**
 * @author MaoYuLu
 * ����ϵͳ���û��������
 */
public class UserFrame extends JFrame implements ActionListener{
	
	// �������
	JPanel jpa1, jpa2, jpa3;
	JLabel jlb1, jlb2;
	JButton jb1, jb2, jb3, jb4;
	JTextField jtf1;
	JScrollPane jscrollPane1;   //���ô�������������
	JTable jtable1;
	DefaultTableModel model;   //���ñ��
	//�½����ܹ��������
	ManagerImpl mimp = new ManagerImpl();
	ReadWriteProperties rwprops = new ReadWriteProperties();

	String username = "";
	String userpwd = "";
	
	public void userFrame(String s1, String s2) {
		jpa1 = new JPanel();
		jpa2 = new JPanel();
		jpa3 = new JPanel();
		jlb1 = new JLabel("��������:");
		jb1 = new JButton("��Ǯ");
		jb1.addActionListener(this);  //��"��Ǯ"��ť���м���
		jb2 = new JButton("ȡǮ");
		jb2.addActionListener(this);  //��"ȡǮ"��ť���м���
		jb3 = new JButton("��ѯ���");
		jb3.addActionListener(this);  //��"��ѯ���"��ť���м���  
		jtf1 = new JTextField(10);  //�������������
		
		this.username = s1;
		this.userpwd = s2;
		
		//���ñ��  
        String[] coltea = {"�˻�","���","���ʽ","���","ʱ��"};  
        model = new DefaultTableModel(coltea, 10);  
        jtable1 = new JTable(model);  
		jscrollPane1 = new JScrollPane(jtable1);  //���ñ������� 
		
		// ���ò��ֹ���
		this.setLayout(new GridLayout(4, 1));
		
		// ����������
		jpa1.add(jlb1);
		jpa1.add(jtf1);
		jpa2.add(jb1);
		jpa2.add(jb2);
		jpa2.add(jb3);
		jpa3.add(jscrollPane1);

		this.add(jpa1);
		this.add(jpa2);
		this.add(jpa3);

		this.setLayout(new GridLayout(6, 1));
		this.setTitle("�û��˻�����ϵͳ");
		this.setSize(600, 600);
		this.setLocationRelativeTo(null); // ���ô���Ϊ��Ļ������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "��Ǯ") {
			double depmoney = Double.valueOf(jtf1.getText());			
			try {
				mimp.depositMoney(this.username, this.userpwd, depmoney);
			} catch (InvalidDepositException e1) {
				e1.printStackTrace();
			}
			insertTable("+","��Ǯ");
		}else if (e.getActionCommand() == "ȡǮ") {
			double withmoney = Double.valueOf(jtf1.getText());	
			try {
				mimp.withdrawals(this.username, this.userpwd, withmoney);
			} catch (AccountOverDrawnException e1) {
				e1.printStackTrace();
			}			
			insertTable("-","ȡǮ");
		}else if (e.getActionCommand() == "��ѯ���") {
			mimp.inquiry(username,userpwd);
			insertTable("","��ѯ");
		}
	}
	
	
	public void insertTable(String s1, String s2) {
		// ������������    ,"�˻�","���","���ʽ","���","ʱ��"
        jtable1.setValueAt(rwprops.readUserName(username, userpwd), 0, 0);  
        jtable1.setValueAt(s1+jtf1.getText(), 0, 1);    
        jtable1.setValueAt(s2, 0, 2); 
        jtable1.setValueAt(rwprops.readUserMoney(username, userpwd), 0, 3);  
        jtable1.setValueAt(rwprops.readDate(username, userpwd), 0, 4);  
	}

	/*
   public static void main(String []args) {
   	 UserFrame lFrame = new UserFrame();
   	 lFrame.userFrame("zs", "123");
    }
*/


}
