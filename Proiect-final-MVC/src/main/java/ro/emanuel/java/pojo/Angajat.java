package ro.emanuel.java.pojo;

public class Angajat {

	int id;
	String nume;
	String prenume;
	String CNP;
	String postOcupat;
	String numarDeTelefon;
	String email;
	
	
	public Angajat(String nume, String prenume, String cNP, String postOcupat,
			String numarDeTelefon, String email) {
		this.nume = nume;
		this.prenume = prenume;
		this.CNP = cNP;
		this.postOcupat = postOcupat;
		this.numarDeTelefon = numarDeTelefon;
		this.email = email;
	}

	public int getId() {
		return id;
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

	public String getCNP() {
		return CNP;
	}

	public String getPostOcupat() {
		return postOcupat;
	}

	public void setPostOcupat(String postOcupat) {
		this.postOcupat = postOcupat;
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
