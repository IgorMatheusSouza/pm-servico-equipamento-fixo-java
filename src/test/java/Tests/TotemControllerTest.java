package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import DataContext.TotemContext;
import Models.Totem;

public class TotemControllerTest {

	private static TotemContext totemContext = new TotemContext();
	
	@Test
	public void fetchAllTotemsTest() {
		TotemContext totemContext2 = new TotemContext();
		assertTrue(totemContext2.getAll().size() > 0);
	}
	
	@Test
	public void fetchTotemTest() {
		Totem totem = totemContext.getTotemById("a37e6942-3543-486e-9a54-1a75588c4d26");
		assertEquals(153, totem.getNumero());
	}
	
	@Test
	public void deleteTotemTest() {
		totemContext.removerTotem("6976238c-0f00-4297-b03d-00bafb5441af");
		Totem totem = totemContext.getTotemById("6976238c-0f00-4297-b03d-00bafb5441af");
		assertNull(totem);
	}
	
	@Test
	public void adicionarTotemTest() {
		Totem totem = new Totem("a3815d84-38d4-4ba9-9275-a4313df1b35c", 252);
		totemContext.addTotem(totem);
		Totem totemAdicionado = totemContext.getTotemById("6976238c-0f00-4297-b03d-00bafb5441af");
		assertEquals(totem.getId(), totemAdicionado.getId());
	}
}
