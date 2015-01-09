package ui;

import java.awt.Container;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

import object.Barang;
import system.*;
import ui.listener.CustActionListener;
import ui.listener.CustKeyListener;
import java.awt.SystemColor;

public class WindowFormBarang extends JFrame {
	private Core core;

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JTextField tfId, tfNama, tfidSupp, tfHarga, tfStok;
	private JTable tbl;
	private JLabel lbId, lbNama, lbIdSupp, lbHarga, lbStok;

	private Vector<Barang> barang = new Vector<Barang>();
	private Vector<String> nmBarang = new Vector<String>();

	private JMenuItem fapi;

	public WindowFormBarang(final Core core) {
		super("Formulir Barang");
		this.core = core;
		setResizable(false);

		setSize(526, 360);
		setLocation((screenSize.width - getWidth()) / 2,
				(screenSize.height - getHeight()) / 2);
		getContentPane().setLayout(null);
		Container container = this.getContentPane();
		container.setBackground(SystemColor.inactiveCaption);
		JMenuBar menu = new JMenuBar();
		this.setJMenuBar(menu);
		
	
		
		JMenu menuUser = new JMenu(
				core.getLoggedInUser().isAdmin() ? "Admin " : "Edwin "
						+ core.getLoggedInUser().getUsername());
		JMenuItem miLogOut = new JMenuItem("Log Out");
		miLogOut.addActionListener(new CustActionListener(core, this, miLogOut,
				CustActionListener.LOGOUT));

		JMenu menuTrans = new JMenu("Transaksi");
		JMenuItem miTransData = new JMenuItem("Data Transaksi");
		miTransData.addActionListener(new CustActionListener(core, this,
				miTransData, CustActionListener.SHOW_DATA_TRANSAKSI));
		/*
		 * JMenuItem miTransCetak = new JMenuItem("Cetak Transaksi");
		 */
		JMenu menuBarang = new JMenu("Barang");
		JMenuItem miBarangCetak = new JMenuItem("Cetak Barang");
		miBarangCetak.addActionListener(new CustActionListener(core, this,
				miBarangCetak, CustActionListener.CETAK_BARANG));
		
		JMenu mnUser = new JMenu("User");
		JMenuItem mnUsers = new JMenuItem("Data User");
		mnUsers.addActionListener(new CustActionListener(core, this,
				mnUsers, CustActionListener.SHOW_DATA_USER));
		
		
		
		
		menu.add(mnUser);
		menuUser.add(miLogOut);

		menu.add(menuTrans);
		// menuTrans.add(miTransCetak);
		menuTrans.add(miTransData);
		menu.add(menuBarang);
		// menuBarang.add(miBarangData);
		menuBarang.add(miBarangCetak);

		ResultSet rs = Operator.getListBarang(core.getConnection());
		try {
			while (rs.next()) {
				barang.add(new Barang(rs.getString(1), rs.getString(2), rs
						.getString(3), rs.getInt(4), rs.getInt(5)));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}

		tbl = new JTable(Operator.resultSetToTableModel(Operator
				.getListBarang(core.getConnection())));
		Operator.disableTableEdit(tbl);
		JPanel panTbl = new JPanel();

		panTbl.setLayout(new BorderLayout());
		panTbl.setBackground(Color.white);
		panTbl.add(new JScrollPane(tbl), BorderLayout.CENTER);
		tfId = new JTextField();
		tfNama = new JTextField();
		tfidSupp = new JTextField();
		tfHarga = new JTextField();
		tfStok = new JTextField();

		tfId.setBounds(95,225, 170, 20);
		tfNama.setBounds(360, 225, 150, 20);
		tfidSupp.setBounds(95, 250, 170, 20);
		
		tfHarga.setBounds(360, 250, 150, 20);
		tfStok.setBounds(95, 275, 170, 20);
		tfStok.addKeyListener(new CustKeyListener(core, this, tfStok,
				CustKeyListener.NUMBER_ONLY));

		panTbl.setBounds(10, 10, 500, 200);

		lbId = new JLabel("Id Barang");
		lbNama = new JLabel("Nama Barang");
		lbIdSupp = new JLabel("IdSupp Barang");
		lbHarga = new JLabel("Harga Barang");
		lbStok = new JLabel("Stok satuan");

		lbId.setBounds(10, 225, 100, 20);
		lbId.setHorizontalAlignment(JLabel.LEFT);
		lbNama.setBounds(280, 225, 100, 20);
		lbNama.setHorizontalAlignment(JLabel.LEFT);
		lbIdSupp.setBounds(10, 250, 100, 20);
		lbIdSupp.setHorizontalAlignment(JLabel.LEFT);
		lbHarga.setBounds(280, 250, 100, 20);
		lbHarga.setHorizontalAlignment(JLabel.LEFT);
		lbStok.setBounds(10, 275, 100, 20);
		lbStok.setHorizontalAlignment(JLabel.LEFT);

		JButton buttonTambah = new JButton("Tambah");
		JButton buttonDelete = new JButton("Delete");

		buttonTambah.setBounds(280, 275, 80, 20);
		buttonTambah.addActionListener(new CustActionListener(core, this,tbl,
				buttonTambah, CustActionListener.TAMBAH_BARANG));
		buttonDelete.setBounds(370, 275, 80, 20);
		buttonDelete.addActionListener(new CustActionListener(core, this,tbl,
				buttonDelete, CustActionListener.HAPUS_BARANG));
		// Add Content
		container.add(tfId);
		container.add(tfNama);
		container.add(tfidSupp);
		container.add(tfHarga);
		container.add(tfStok);
		container.add(panTbl);
		container.add(lbId);
		container.add(lbNama);
		container.add(lbIdSupp);
		container.add(lbHarga);
		container.add(lbStok);

		container.add(buttonDelete);
		container.add(buttonTambah);
	}

	public Vector<Barang> getListBarang() {
		return barang;
	}

	public Barang getSelectedBarang() {
		return barang.get(tbl.getSelectedRow());
	}

	public void submitToDB() {
		if (Operator.tambahBarang(getBarang(), core.getConnection())) {
			JOptionPane.showMessageDialog(this, "Data telah ditambahkan!");
		} else {
			JOptionPane.showMessageDialog(this, "Terjadi kesalahan!");
		}
		
		((DefaultTableModel)tbl.getModel()).addRow(new Object[]{tfId.getText(),tfNama.getText(),tfidSupp.getText(),tfHarga.getText(),tfStok.getText()});

		tfId.setText("");
		tfNama.setText("");
		tfidSupp.setText("");
		tfHarga.setText("");
		tfStok.setText("");
	}

	public void resetForm() {
		tfId.setText("");
		tfNama.setText("");
		tfidSupp.setText("");
		tfHarga.setText("");
		tfStok.setText("");

		if (tbl.getSelectedRow() >= 0) {
			((DefaultTableModel) tbl.getModel())
					.removeRow(tbl.getSelectedRow());
		}
	}


	public Barang getBarang() {
		return new Barang(tfId.getText(),tfNama.getText(),tfidSupp.getText(),Integer.parseInt(tfHarga.getText()),Integer.parseInt(tfStok.getText()));
	}
}
