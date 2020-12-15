package DataContext;
import java.util.ArrayList;
import Models.Totem;

public class TotemContext {
	
	public static ArrayList<Totem> totens = new ArrayList<Totem>();
	
	public static void CriarDados() {
		TotemContext.totens.add(new Totem("a37e6942-3543-486e-9a54-1a75588c4d26", 153));
		TotemContext.totens.add(new Totem("6976238c-0f00-4297-b03d-00bafb5441af", 154));
		TotemContext.totens.add(new Totem("57b257d0-ccf2-4d73-9f36-09f5b531886b", 155)); 
	}
	
	public Totem getTotemById(String id) {
		for (Totem totem : totens) {
			 if(totem.getId() == id)
				 return totem;
		}
		return null;
	}
	
	public void addTotem(Totem totem) {
		totens.add(totem);
	}
	
	public void removerTotem(String id) {
		Totem totem = this.getTotemById(id);
		totens.remove(totem);
	}

	public Totem getTotemByNumero(int num) {
		for (Totem totem : totens) {
			 if(totem.getNumero() == num)
				 return totem;
		}
		return null;
	}

	public ArrayList<Totem> getAll() {
		return totens;
	}
}
