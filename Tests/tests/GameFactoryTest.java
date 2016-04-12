package tests;

import static org.junit.Assert.*;

import java.util.HashSet;

import jogo.GameFactory;
import jogo.Jogabilidade;

import org.junit.Test;

public class GameFactoryTest {

	@Test
	public void testCriaJogo() {
		GameFactory gameFactory = new GameFactory();
		HashSet<Jogabilidade> jogabilidades = new HashSet<Jogabilidade>();
		jogabilidades.add(Jogabilidade.COMPETITIVO);
		jogabilidades.add(Jogabilidade.OFFLINE);
		
		try {
			gameFactory.criaJogo("teste", 10, "RPG", jogabilidades);
			gameFactory.criaJogo("teste", 10, "Luta", jogabilidades);
			gameFactory.criaJogo("teste", 10, "Plataforma", jogabilidades);
			gameFactory.criaJogo("teste", 10, "", jogabilidades);
			fail();
		} catch (Exception e) {
			assertEquals("Tipo de jogo invalido: nao pode ser null ou vazio", e.getMessage());
		}
		
		try {
			gameFactory.criaJogo("teste", 10, null, jogabilidades);
			fail();
		} catch (Exception e) {
			assertEquals("Tipo de jogo invalido: nao pode ser null ou vazio", e.getMessage());
		}
	}

}
