package ro.emanuel.java.pojo;

public class Client {

	int id;
	String nume;
	String prenume;
	String numarDeTelefon;
	String email;
	
	public Client() {

	}
	
	public Client(String nume, String prenume, String numarDeTelefon, String email) {
		this.nume = nume;
		this.prenume = prenume;
		this.numarDeTelefon = numarDeTelefon;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getNumarDeTelefon() {
		return numarDeTelefon;
	}

	public void setNumarDeTelefon(String numarDeTelefon) {
		this.numarDeTelefon = numarDeTelefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
