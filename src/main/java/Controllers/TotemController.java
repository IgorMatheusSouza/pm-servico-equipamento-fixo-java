package Controllers;

import java.util.ArrayList;
import DataContext.TotemContext;
import Models.Totem;
import io.javalin.http.Context;

public class TotemController {
	
	private static TotemContext totemContext = new TotemContext();
	
	public static void fetchTotem(Context ctx) {
		String id = ctx.queryParam("id");
		String num = ctx.queryParam("numero");
		
		ArrayList<Totem> totems = new ArrayList<Totem>();
		
		if(id != null)
			totems.add(totemContext.getTotemById(id));
		else if(num != null)
			totems.add(totemContext.getTotemByNumero(Integer.parseInt(num)));
		else
			totems = totemContext.getAll();
			
		ctx.json(totems);
	}
	
	public static void adicionarTotem(Context ctx) {
		Totem totem = ctx.bodyAsClass(Totem.class);
		totemContext.addTotem(totem);
		ctx.status(201);
	}

	public static void deleteTotem(Context ctx) {
		String id = ctx.queryParam("id");
		id = String.valueOf(id);
		totemContext.removerTotem(id);
	}
}



