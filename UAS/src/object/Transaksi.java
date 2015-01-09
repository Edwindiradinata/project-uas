package object;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class Transaksi {
	private int noTransaksi;
	private Vector<DetilTransaksi> detilTransaksi = new Vector<DetilTransaksi>();
	private Date tgl;
	private User username;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh:ss");

	public Transaksi(int no_transaksi, Vector<DetilTransaksi> detilTransaksi, Date tgl,
			User username) {
		this.noTransaksi = no_transaksi;
		this.detilTransaksi = detilTransaksi;
		this.tgl = tgl;
		this.username = username;
	}

	public Transaksi(Date tgl, User username) {
		this.tgl = tgl;
		this.username = username;
	}

	public Transaksi(int noTransaksi) {
		this.noTransaksi = noTransaksi;
	}

	public int getno_transaksi() {
		return noTransaksi;
	}

	public Vector<DetilTransaksi> getDetilTransaksi() {
		return detilTransaksi;
	}

	public Date getTgl() {
		return tgl;
	}

	public String getTglAsString() {
		return formatter.format(tgl.getTime());
	}

	public User getUsername() {
		return username;
	}

	public int getTotalItem() {
		int total = 0;
		for (int i = 0; i < detilTransaksi.size(); i++) {
			total += detilTransaksi.get(i).getquantity();
		}
		return total;
	}

	public int getTotalHrg() {
		int total = 0;
		for (int i = 0; i < detilTransaksi.size(); i++) {
			total += detilTransaksi.get(i).getBarang().getHarga()
					* detilTransaksi.get(i).getquantity();
		}
		return total;
	}

	public void addDetilTransaksi(DetilTransaksi dt) {
		detilTransaksi.add(dt);
	}
}
