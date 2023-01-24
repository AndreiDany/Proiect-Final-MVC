package ro.emanuel.java.pojo;

public class ProdusCulinar {

	int id;
	String numeProdusCulinar;
	String pret;
	String descriereProdus;
	
	
	public ProdusCulinar(String numeProdusCulinar, String pret, String descriereProdus) {
		this.numeProdusCulinar = numeProdusCulinar;
		this.pret = pret;
		this.descriereProdus = descriereProdus;
	}
	
	public ProdusCulinar() {

	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNumeProdusCulinar() {
		return numeProdusCulinar;
	}

	public void setNumeProdusCulinar(String numeProdusCulinar) {
		this.numeProdusCulinar = numeProdusCulinar;
	}

	public String getPret() {
		return pret;
	}

	public void setPret(String pret) {
		this.pret = pret;
	}

	public String getDescriereProdus() {
		return descriereProdus;
	}

	public void setDescriereProdus(String descriereProdus) {
		this.descriereProdus = descriereProdus;
	}


}
