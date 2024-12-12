package model;

public class Costumer {
	private String id,nama,email, alamat, nohp;
	
	public Costumer(String id, String nama, String email, String alamat, String nohp) {
		this.id = id;
		this.nama = nama;
		this.email = email;
		this.alamat = alamat;
		this.nohp = nohp;
	}

	public String getId() {
		return id;
	}

	public String getNama() {
		return nama;
	}

	public String getEmail() {
		return email;
	}

	public String getAlamat() {
		return alamat;
	}

	public String getNohp() {
		return nohp;
	}
	
	
	 
	

}
