package Models;

public class Totem {
	
	private String id;
	private int numero;
	
	public Totem(String id, int numero) {
		this.id = id;
		this.numero = numero;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
}
