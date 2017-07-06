package com.myl.bank.test;

//引入java的包
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File.*;
import javax.swing.*;
//引入自定义包
import com.myl.bank.manager.ManagerImpl;

/**
 * @author MaoYulu
 * 银行系统的界面设计
 */
public class LoginFrame extends JFrame implements ActionListener {

	// 定义组件
	JPanel jpa1, jpa2, jpa3;
	JLabel jlb1, jlb2;
	JButton jb1, jb2, jb3;
	JTextField jtf1;
	JPasswordField jpf;
	//新建功能管理的引用
	ManagerImpl mimp = new ManagerImpl();
	
	public void loginFrame() {
		jpa1 = new JPanel();
		jpa2 = new JPanel();
		jpa3 = new JPanel();

		jlb1 = new JLabel("账号:");
		jlb2 = new JLabel("密码:");
		jb1 = new JButton("注册");
		jb1.addActionListener(this); //对"注册"按钮进行监听
		jb2 = new JButton("登录"); 
		jb2.addActionListener(this); //对"登录"按钮进行监听
		jb3 = new JButton("重置"); 
		jb3.addActionListener(this); //对"重置"按钮进行监听
		jtf1 = new JTextField(10);  //设置文字输入框
		jpf = new JPasswordField(10);  //设置密码框

		// 设置布局管理
		this.setLayout(new GridLayout(4, 1));

		// 加入各个组件
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

		this.setTitle("银行登录系统");
		this.setSize(200, 300);
		this.setLocationRelativeTo(null); // 设置窗口为屏幕的中央
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "登录") {
			mimp.login(jtf1.getText(), jpf.getText());
		} else if (e.getActionCommand() == "注册") {
			mimp.register(jtf1.getText(), jpf.getText());
		} else if (e.getActionCommand() == "重置") {
			clear();
		}
	}
	
	/*
	 * 账号框和密码框清除函数
	 */
	public void clear() {
		jtf1.setText("");
		jpf.setText("");
	}
}