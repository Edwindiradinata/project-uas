package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import system.*;

public class DataUser extends JFrame {
	private Core core;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JTable tbl;

	public DataUser(Core core) {
		super("Data User");
		this.core = core;

		this.core = core;
		setResizable(false);
		setSize(480, 360);
		setLocation((screenSize.width - getWidth()) / 2,
				(screenSize.height - getHeight()) / 2);
		JTable tbl = new JTable(Operator.resultSetToTableModel(Operator
				.getListBarang(core.getConnection())));
		Operator.disableTableEdit(tbl);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		JPanel pan = new JPanel();
		pan.setBackground(Color.WHITE);
		pan.setBounds(0, 0, 480, 320);
		pan.setLayout(new BorderLayout());
		pan.add(tbl, BorderLayout.CENTER);
		pan.add(tbl.getTableHeader(), BorderLayout.NORTH);

		getContentPane().add(pan);
	}
}
