package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import DataContext.TrancaContext;
import Models.Tranca;


public class TrancaControllerTest {
	
	private static TrancaContext trancaContext = new TrancaContext();
	
	@Test
	public void fetchAllTrancasTest() {
		assertTrue(trancaContext.getAll().size() > 0);
	}
	
	@Test
	public void fetchTrancaTest() {
		Tranca tranca = trancaContext.getTrancaById("a6070aeb-853f-4a6f-9a1b-d2688f2e7ced");
		assertEquals(123, tranca.getNumero());
	}
	
	@Test
	public void deleteTrancaTest() {
		trancaContext.removerTranca("6a796986-b429-479b-a270-340a9f10610f");
		Tranca tranca = trancaContext.getTrancaById("6a796986-b429-479b-a270-340a9f10610f");
		assertNull(tranca);
	}
	
	@Test
	public void adicionarTrancaTest() {
		Tranca tranca = new Tranca("a3815d84-38d4-4ba9-9275-a4313df1b35c", 252, true);
		trancaContext.addTranca(tranca);
		Tranca trancaAdicionado = trancaContext.getTrancaById("a3815d84-38d4-4ba9-9275-a4313df1b35c");
		assertEquals(tranca.getId(), trancaAdicionado.getId());
	}
	
	@Test
	public void alterarStatusTrancaTest() {
		Tranca tranca = new Tranca("a6070aeb-853f-4a6f-9a1b-d2688f2e7ced", 123, true);
		trancaContext.AlterarStatus(tranca);
		Tranca trancaStatusAlterada = trancaContext.getTrancaById("a6070aeb-853f-4a6f-9a1b-d2688f2e7ced");
		assertEquals(tranca.isOcupada(), trancaStatusAlterada.isOcupada());
	}
	
	@Test
	public void getStatusTranca() {
		Tranca trancaStatus = trancaContext.getTrancaById("a6070aeb-853f-4a6f-9a1b-d2688f2e7ced");
		assertEquals(trancaStatus.isOcupada(), trancaStatus.isOcupada());
	}
}
