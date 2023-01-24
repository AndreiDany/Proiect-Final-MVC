package ro.emanuel.java.pojo;

public class Masa {

	int id;
	int	numarLocuri;
	
	
	public Masa(int id, int numarLocuri) {
		this.id = id;
		this.numarLocuri = numarLocuri;
	}
	
	public Masa() {

	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getNumarLocuri() {
		return numarLocuri;
	}

	public void setNumarLocuri(int numarLocuri) {
		this.numarLocuri = numarLocuri;
	}

}
