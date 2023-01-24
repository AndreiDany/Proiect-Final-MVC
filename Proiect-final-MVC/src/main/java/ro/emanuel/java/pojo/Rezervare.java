package ro.emanuel.java.pojo;


public class Rezervare {

	int id;
	private String dataSiOra;
	private Client client = new Client();
	private int numarPersoane;
	
	public Rezervare() {
		
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDataSiOra() {
		return dataSiOra;
	}

	public void setDataSiOra(String dataSiOra) {
		this.dataSiOra = dataSiOra;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getNumarPersoane() {
		return numarPersoane;
	}

	public void setNumarPersoane(int numarPersoane) {
		this.numarPersoane = numarPersoane;
	}
	
}
