package object;

public class Barang {
	private int stok, harga;
	private String nama_product, id_product, idSupp;

	public Barang(String id, String nama, String idSupp, int harga, int stok){
		this.id_product=id;
		this.nama_product=nama;
		this.idSupp=idSupp;
		this.stok=stok;
		this.harga=harga;
	}
	
	public Barang(String nama, String idSupp, int harga, int stok){
		this.nama_product=nama;
		this.idSupp=idSupp;
		this.stok=stok;
		this.harga=harga;
	}

	public String getId() {
		return id_product;
	}

	public int getStok() {
		return stok;
	}

	public int getHarga() {
		return harga;
	}

	public String getNama() {
		return nama_product;
	}

	public String getidSupp() {
		return idSupp;
	}
}
