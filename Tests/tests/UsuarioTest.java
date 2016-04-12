/* 115110295 - Antunes Dantas da Silva: LAB 6 - Turma 1 */

package tests;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import jogo.Jogabilidade;
import jogo.Plataforma;
import jogo.RPG;
import usuarios.Noob;
import usuarios.Veterano;

public class UsuarioTest {

	@Test
	public void testSetListaDeJogos() {
		try {
			Veterano teste = new Veterano("Antunes", "antunes");
			teste.setListaDeJogos(null);
			fail();
		} catch (Exception e) {
			assertEquals("Lista invalida: nao pode ser null", e.getMessage());
		}
	}

	@Test
	public void testAumentaX2p() {
		try {
			Veterano teste = new Veterano("Antunes", "antunes");
			teste.adicionaDinheiro(20);
			teste.adicionaDinheiro(-5);
			fail();
		} catch (Exception e) {
			assertEquals("Valor a ser creditado ao usuario nao pode ser menor que zero.", e.getMessage());
		}
	}

	@Test
	public void testAddJogoNaLista() {
		try {
			Veterano teste = new Veterano("Antunes", "antunes");
			HashSet<Jogabilidade> jogabilidades = new HashSet<Jogabilidade>();
			jogabilidades.add(Jogabilidade.COMPETITIVO);
			jogabilidades.add(Jogabilidade.OFFLINE);
			RPG paperMario = new RPG("Paper Mario", 20, jogabilidades);
			Plataforma superMarioWorld = new Plataforma("Super Mario World", 20, jogabilidades);
			teste.addJogoNaLista(paperMario);
			teste.addJogoNaLista(superMarioWorld);
			assertFalse(teste.addJogoNaLista(paperMario));
			teste.addJogoNaLista(null);
			fail();
		} catch (Exception e) {
			assertEquals("Jogo nao pode ser adicionado pois o usuario ja tem o mesmo.", e.getMessage());
		}
	}

	@Test
	public void testTemJogo() {
		try {
			Veterano teste = new Veterano("Antunes", "antunes");
			HashSet<Jogabilidade> jogabilidades = new HashSet<Jogabilidade>();
			jogabilidades.add(Jogabilidade.COMPETITIVO);
			jogabilidades.add(Jogabilidade.OFFLINE);
			RPG paperMario = new RPG("Paper Mario", 20, jogabilidades);
			Plataforma superMarioWorld = new Plataforma("Super Mario World", 20, jogabilidades);
			teste.addJogoNaLista(paperMario);
			teste.addJogoNaLista(superMarioWorld);
			assertTrue(teste.temJogo("Super Mario World"));
			assertFalse(teste.temJogo("teste"));
			assertTrue(teste.temJogo("Paper Mario"));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testRetiraDinheiro() {
		try {
			Veterano teste = new Veterano("Antunes", "antunes");
			teste.adicionaDinheiro(50);
			teste.retiraDinheiro(10);
			assertEquals(teste.getSaldo(), 40, 0.5);
			teste.retiraDinheiro(-10);
			fail();
		} catch (Exception e) {
			assertEquals("Valor a ser retirado nao pode ser menor que zero.", e.getMessage());
		}
	}

	@Test
	public void testAdicionaDinheiro() {
		try {
			Veterano teste = new Veterano("Antunes", "antunes");
			teste.adicionaDinheiro(50);
			teste.retiraDinheiro(10);
			assertEquals(teste.getSaldo(), 40, 0.5);
			teste.adicionaDinheiro(-10);
			fail();
		} catch (Exception e) {
			assertEquals("Valor a ser creditado ao usuario nao pode ser menor que zero.", e.getMessage());
		}
	}

	@Test
	public void testRegistraJogada() {
		try {
			Veterano teste = new Veterano("Antunes", "antunes");
			teste.adicionaDinheiro(200);
			HashSet<Jogabilidade> jogabilidades = new HashSet<Jogabilidade>();
			jogabilidades.add(Jogabilidade.COMPETITIVO);
			jogabilidades.add(Jogabilidade.OFFLINE);
			RPG paperMario = new RPG("Paper Mario", 75, jogabilidades);
			Plataforma superMarioWorld = new Plataforma("Super Mario World", 30, jogabilidades);
			//teste.compraJogo(paperMario);
			teste.compraJogo(superMarioWorld);
			teste.registraJogada("Super Mario World", 30, true);
			assertEquals(teste.getX2p(), 470);
		} catch (Exception e) {
			System.out.println(e.getMessage());;
		}
	}
}