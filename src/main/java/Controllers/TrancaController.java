package Controllers;
import io.javalin.http.Context;
import java.util.ArrayList;

import DataContext.TrancaContext;
import Models.Tranca;

public class TrancaController {
	
	private static TrancaContext trancaContext = new TrancaContext();
	
	public static void fetchTranca(Context ctx) {
		String id = ctx.queryParam("id");
		String num = ctx.queryParam("numero");
		
		ArrayList<Tranca> trancas = new ArrayList<Tranca>();
		
		if(id != null)
			trancas.add(trancaContext.getTrancaById(id));
		
		else if(num != null)
			trancas.add(trancaContext.getTrancaByNumero(Integer.parseInt(num)));
		
		else
			trancas = trancaContext.getAll();
			
		ctx.json(trancas);
	}
	
	
	public static void adicionarTranca(Context ctx) {
		Tranca tranca = ctx.bodyAsClass(Tranca.class);
		trancaContext.addTranca(tranca);
		ctx.status(201);
	}
	
	public static void deleteTranca(Context ctx) {
		String id = ctx.queryParam("id");
		id = String.valueOf(id);
		trancaContext.removerTranca(id);
		ctx.status(200);
	}
	
	public static void fetchTrancaStatus(Context ctx) {
		String id = ctx.queryParam("id");
		String num = ctx.queryParam("numero");
		
		Tranca tranca = null;
		
		if(id != null)
			tranca = trancaContext.getTrancaById(id);
		
		else if(num != null)
			tranca = trancaContext.getTrancaByNumero(Integer.parseInt(num));
		
		if(tranca == null)
			ctx.json("Informe um id ou numero de tranca cadastrada");
		else
			ctx.json(tranca.isOcupada());
	}
	
	public static void alterarTrancaStatus(Context ctx) {
		Tranca tranca = ctx.bodyAsClass(Tranca.class);
		trancaContext.AlterarStatus(tranca);
		ctx.status(200);
	}
}
