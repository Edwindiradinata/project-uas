package object;

public class DetilTransaksi {
	private Barang barang;
	private int kuantitas;
	private Transaksi transaksi;

	public DetilTransaksi(Transaksi transaksi, Barang barang, int quantity) {
		this.transaksi = transaksi;
		this.barang = barang;
		this.kuantitas = quantity;
	}

	public DetilTransaksi(Barang barang, int quantity) {
		this.barang = barang;
		this.kuantitas = quantity;
	}

	public Barang getBarang() {
		return barang;
	}

	public int getquantity() {
		return kuantitas;
	}

	public Transaksi getTransaksi() {
		return transaksi;
	}

}
