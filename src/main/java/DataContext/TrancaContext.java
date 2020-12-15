package DataContext;
import java.util.ArrayList;
import Models.Tranca;

public class TrancaContext {
	
	public static ArrayList<Tranca> trancas = new ArrayList<Tranca>();
	
	public static void CriarDados() {
		TrancaContext.trancas.add(new Tranca("a6070aeb-853f-4a6f-9a1b-d2688f2e7ced", 123, false));
		TrancaContext.trancas.add(new Tranca("6a796986-b429-479b-a270-340a9f10610f", 124, false));
		TrancaContext.trancas.add(new Tranca("0b434dc6-b3c2-4f77-a38d-25a4c674f2e6", 125, false)); 
	}
	
	public Tranca getTrancaById(String id) {
		for (Tranca tranca : trancas) {
			 if(tranca.getId().equals(id))
				 return tranca;
		}
		return null;
	}
	
	public void addTranca(Tranca tranca) {
		trancas.add(tranca);
	}
	
	public void removerTranca(String id) {
		Tranca tranca = this.getTrancaById(id);
		trancas.remove(tranca);
	}

	public Tranca getTrancaByNumero(int num) {
		for (Tranca tranca : trancas) {
			 if(tranca.getNumero() == num)
				 return tranca;
		}
		return null;
	}

	public ArrayList<Tranca> getAll() {
		return trancas;
	}

	public void AlterarStatus(Tranca trancaAlteracao) {
		Tranca tranca = this.getTrancaById(trancaAlteracao.getId());
		if(tranca != null)
			tranca.setOcupada(trancaAlteracao.isOcupada()); 
	}
}
