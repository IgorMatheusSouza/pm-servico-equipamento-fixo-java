package Models;

public class Tranca {
	
	public  String id;
	public int numero;
	public boolean ocupada;
	
	public Tranca() {
		
	}
	
	public Tranca(String id, int num, boolean ocupado) {
		this.id = id;
		this.numero = num;
		this.ocupada = ocupado;
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
	
	public boolean isOcupada() {
		return ocupada;
	}
	
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	
}
