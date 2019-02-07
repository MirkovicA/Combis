package webapp;

public class StockRecord {
	public String ime, prezime, postanskiBroj, grad, telefon;
	
	public StockRecord(String ime, String prezime, String postanskiBroj, String grad, String telefon) {
		this.ime = ime;
		this.prezime = prezime;
		this.postanskiBroj = postanskiBroj;
		this.grad = grad;
		this.telefon = telefon;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getPostanskiBroj() {
		return postanskiBroj;
	}

	public void setPostanskiBroj(String postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
}