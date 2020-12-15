package App;
import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;

import Controllers.TotemController;
import Controllers.TrancaController;
import DataContext.TotemContext;
import DataContext.TrancaContext;

public class ApplicationMain {

	public static void main(String[] args) {
		
    	 @SuppressWarnings("unused")
		Javalin app = Javalin.create(config -> {
             config.defaultContentType = "application/json";
         })
		.routes(() -> {
         	path("", () -> {
         		get(ctx -> ctx.result("Hello World"));
         	});
         	path("/tranca", () -> {
         		get(TrancaController::fetchTranca);
         		post(TrancaController::adicionarTranca);
         		delete(TrancaController::deleteTranca);
         	});
         	path("/totem", () -> {
         		get(TotemController::fetchTotem);
         		post(TotemController::adicionarTotem);
         		delete(TotemController::deleteTotem);
         	});
         	path("/statusTranca", () -> {
         		get(TrancaController::fetchTrancaStatus);
         		post(TrancaController::alterarTrancaStatus);
         	});
         }).start(getHerokuAssignedPort());
    	 
    	 TotemContext.CriarDados();
    	 TrancaContext.CriarDados();
	}
	
	private static int getHerokuAssignedPort() {
	    String herokuPort = System.getenv("PORT");
	    if (herokuPort != null) {
	      return Integer.parseInt(herokuPort);
	    }
	    return 7000;
	  }
}