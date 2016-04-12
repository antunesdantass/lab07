/* 115110295 - Antunes Dantas da Silva: LAB 6 - Turma 1 */

package tests;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import jogo.Jogabilidade;
import jogo.Jogo;
import jogo.Plataforma;
import jogo.RPG;
import usuarios.Usuario;
import usuarios.Veterano;

public class JogoTest {

	@Test
	public void testSetNomeDoJogo() {
		try {
			HashSet<Jogabilidade> jogabilidades = new HashSet<Jogabilidade>();
			jogabilidades.add(Jogabilidade.COMPETITIVO);
			jogabilidades.add(Jogabilidade.OFFLINE);
			Jogo nomeInvalida = new RPG("", 10, jogabilidades);
			fail();
		} catch (Exception e) {
			assertEquals("Nome do jogo invalido: nao pode ser null ou vazio.", e.getMessage());
		}
		
		try {
			HashSet<Jogabilidade> jogabilidades = new HashSet<Jogabilidade>();
			jogabilidades.add(Jogabilidade.COMPETITIVO);
			jogabilidades.add(Jogabilidade.OFFLINE);
			Jogo precoInvalido = new RPG("teste", -10, jogabilidades);
			fail();
		} catch (Exception e) {
			assertEquals("Preco invalido: nao pode ser menor que zero", e.getMessage());
		}
		
		try {
			HashSet<Jogabilidade> jogabilidades = new HashSet<Jogabilidade>();
			jogabilidades.add(Jogabilidade.COMPETITIVO);
			jogabilidades.add(Jogabilidade.OFFLINE);
			Jogo jogabilidadeInvalida = new RPG("teste", 10, null);
			fail();
		} catch (Exception e) {
			assertEquals("Jogabilidade invalida: nao pode ser null", e.getMessage());
		}
	}

	@Test
	public void testSetPreco() {
		try {
			HashSet<Jogabilidade> jogabilidades = new HashSet<Jogabilidade>();
			jogabilidades.add(Jogabilidade.COMPETITIVO);
			jogabilidades.add(Jogabilidade.OFFLINE);
			Jogo precoInvalido = new RPG("teste", -10, jogabilidades);
			fail();
		} catch (Exception e) {
			assertEquals("Preco invalido: nao pode ser menor que zero", e.getMessage());
		}
	}

	@Test
	public void testSetMaiorScore() {
		try {
			HashSet<Jogabilidade> jogabilidades = new HashSet<Jogabilidade>();
			jogabilidades.add(Jogabilidade.COMPETITIVO);
			jogabilidades.add(Jogabilidade.OFFLINE);
			Jogo scoreInvalido = new RPG("teste", 10, jogabilidades);
			scoreInvalido.setMaiorScore(-10);
			fail();
		} catch (Exception e) {
			assertEquals("O score nao pode ser menor que 0 ou maior que 100.000.", e.getMessage());
		}
	}

	@Test
	public void testGetVezesZeradas() {
		try {
			Usuario teste = new Usuario("Antunes", "antunes");
			HashSet<Jogabilidade> jogabilidades = new HashSet<Jogabilidade>();
			jogabilidades.add(Jogabilidade.COMPETITIVO);
			jogabilidades.add(Jogabilidade.OFFLINE);
			RPG paperMario = new RPG("Paper Mario", 20, jogabilidades);
			Plataforma superMarioWorld = new Plataforma("Super Mario World", 20, jogabilidades);
			teste.addJogoNaLista(paperMario);
			teste.addJogoNaLista(superMarioWorld);
			teste.recompensar("Super Mario World", 200, true);
			teste.recompensar("Super Mario World", 200, true);
			teste.recompensar("Super Mario World", 200, true);
			teste.recompensar("Super Mario World", 200, true);
			assertEquals(superMarioWorld.getVezesZeradas(), 4);
		} catch (Exception e) {
			fail();
		}
	}

}
