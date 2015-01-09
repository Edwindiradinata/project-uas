package ui;

import java.awt.*;

import javax.swing.*;

import system.*;
import ui.listener.CustActionListener;

public class WindowLogin extends JFrame {

	final private Core core;

	private JButton btnLogin;
	private JTextField txUsr;
	private JPasswordField txPsw;
	private JLabel lblUsr, lblPsw;

	private Container container;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	public WindowLogin(Core core) {
		super("Login");
		this.core = core;

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(341, 165);
		setLocation((screenSize.width - getWidth()) / 2,
				(screenSize.height - getHeight()) / 2);
		setResizable(false);
		JLabel labelHeader = new JLabel("Casir Machine Obat Herbal");
		labelHeader.setBounds(15,0,250,20);
		
		JLabel img = new JLabel();
		img.setBounds(10, 0, 70, 25);
		getContentPane().add(img);
		
		ImageIcon gbr = new ImageIcon(WindowLogin.class.getResource("/images/asmara.jpg"));
		img.setIcon(gbr);
		
		
		container = this.getContentPane();
		container.setLayout(null);
		container.setBackground(SystemColor.inactiveCaption);
		btnLogin = new JButton("Login");
		txUsr = new JTextField(15);
		txPsw = new JPasswordField(15);
		lblUsr = new JLabel("Username");
		lblPsw = new JLabel("Password");

		lblUsr.setHorizontalAlignment(JLabel.RIGHT);
		lblPsw.setHorizontalAlignment(JLabel.RIGHT);

		lblUsr.setBounds(10, 25, 60, 35);
		txUsr.setBounds(75, 30, 100, 25);
		lblPsw.setBounds(10, 62, 60, 35);
		txPsw.setBounds(75, 65, 100, 25);
		btnLogin.setBounds(105, 100, 70, 25);

		btnLogin.addActionListener(new CustActionListener(core, this, btnLogin));
		container.add(labelHeader);
		container.add(lblUsr);
		container.add(txUsr);
		container.add(lblPsw);
		container.add(txPsw);
		container.add(btnLogin);
		
	
	}
	
	public String getUser() {
		return txUsr.getText();
	}

	public String getPass() {
		return txPsw.getText();
	}
}
