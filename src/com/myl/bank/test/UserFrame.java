package com.myl.bank.test;

//引入java的包
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
//引入自定义包
import com.myl.bank.manager.ManagerImpl;
import com.myl.bank.util.AccountOverDrawnException;
import com.myl.bank.util.InvalidDepositException;
import com.myl.bank.util.ReadWriteProperties;

/**
 * @author MaoYuLu
 * 银行系统的用户界面设计
 */
public class UserFrame extends JFrame implements ActionListener{
	
	// 定义组件
	JPanel jpa1, jpa2, jpa3;
	JLabel jlb1, jlb2;
	JButton jb1, jb2, jb3, jb4;
	JTextField jtf1;
	JScrollPane jscrollPane1;   //设置带滚动条的容器
	JTable jtable1;
	DefaultTableModel model;   //设置表格
	//新建功能管理的引用
	ManagerImpl mimp = new ManagerImpl();
	ReadWriteProperties rwprops = new ReadWriteProperties();

	String username = "";
	String userpwd = "";
	
	public void userFrame(String s1, String s2) {
		jpa1 = new JPanel();
		jpa2 = new JPanel();
		jpa3 = new JPanel();
		jlb1 = new JLabel("请输入金额:");
		jb1 = new JButton("存钱");
		jb1.addActionListener(this);  //对"存钱"按钮进行监听
		jb2 = new JButton("取钱");
		jb2.addActionListener(this);  //对"取钱"按钮进行监听
		jb3 = new JButton("查询余额");
		jb3.addActionListener(this);  //对"查询余额"按钮进行监听  
		jtf1 = new JTextField(10);  //设置文字输入框
		
		this.username = s1;
		this.userpwd = s2;
		
		//设置表格  
        String[] coltea = {"账户","金额","款项方式","余额","时间"};  
        model = new DefaultTableModel(coltea, 10);  
        jtable1 = new JTable(model);  
		jscrollPane1 = new JScrollPane(jtable1);  //设置表格滚动条 
		
		// 设置布局管理
		this.setLayout(new GridLayout(4, 1));
		
		// 加入各个组件
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
		this.setTitle("用户账户管理系统");
		this.setSize(600, 600);
		this.setLocationRelativeTo(null); // 设置窗口为屏幕的中央
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "存钱") {
			double depmoney = Double.valueOf(jtf1.getText());			
			try {
				mimp.depositMoney(this.username, this.userpwd, depmoney);
			} catch (InvalidDepositException e1) {
				e1.printStackTrace();
			}
			insertTable("+","存钱");
		}else if (e.getActionCommand() == "取钱") {
			double withmoney = Double.valueOf(jtf1.getText());	
			try {
				mimp.withdrawals(this.username, this.userpwd, withmoney);
			} catch (AccountOverDrawnException e1) {
				e1.printStackTrace();
			}			
			insertTable("-","取钱");
		}else if (e.getActionCommand() == "查询余额") {
			mimp.inquiry(username,userpwd);
			insertTable("","查询");
		}
	}
	
	
	public void insertTable(String s1, String s2) {
		// 将数据填入表格    ,"账户","金额","款项方式","余额","时间"
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
