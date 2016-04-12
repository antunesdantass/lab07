/* 115110295 - Antunes Dantas da Silva: LAB 6 - Turma 1 */

package tests;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import jogo.Jogabilidade;
import jogo.Plataforma;
import jogo.RPG;
import loja.LojaController;

public class LojaTest {

	@Test
	public void testNovoUsuario() {
		try {
			LojaController loja = new LojaController();
			loja.novoUsuario("Antunes Dantas", "antunesdantas");
			loja.novoUsuario("Vinicius Lucena", "viniciusucena");
			loja.novoUsuario("", "erro null");
		} catch (Exception e) {
			assertEquals("Nome invalido: nao pode ser null ou vazio.", e.getMessage());
		}
		
		try {
			LojaController loja = new LojaController();
			loja.novoUsuario("Antunes Dantas", "antunesdantas");
			loja.novoUsuario("Vinicius Lucena", "viniciusucena");
			loja.novoUsuario("Ivyna Santino", "");
		} catch (Exception e) {
			assertEquals("Nome invalido: nao pode ser null ou vazio.", e.getMessage());
		}
		
		try {
			LojaController loja = new LojaController();
			loja.novoUsuario("Antunes Dantas", "antunesdantas");
			loja.novoUsuario("Vinicius Lucena", "viniciusucena");
			loja.novoUsuario("Antunes Dantas", "antunesdantass");
		} catch (Exception e) {
			fail();
		}
		
		try {
			LojaController loja = new LojaController();
			loja.novoUsuario("Antunes Dantas", "antunesdantas");
			loja.novoUsuario("Vinicius Lucena", "viniciusucena");
			loja.novoUsuario("Antunes Dantas", "antunesdantas");
		} catch (Exception e) {
			assertEquals("Nao eh possivel adicionar o novo usuario pois o login ja esta sendo utilizado.", e.getMessage());
		}
	}

	@Test
	public void testAdicionaDinheiroAoUsuario() {
		try {
			LojaController loja = new LojaController();
			loja.novoUsuario("Antunes Dantas", "antunesdantas");
			loja.novoUsuario("Vinicius Lucena", "viniciuslucena");
			loja.adicionaDinheiroAoUsuario("antunesdantas", 20);
			loja.adicionaDinheiroAoUsuario("antunesdantas", 20.4);
			assertEquals(40.4, loja.getSaldoUsuario("antunesdantas"), 0.05);
			assertEquals(0.0, loja.getSaldoUsuario("viniciuslucena"), 0.05);
			loja.adicionaDinheiroAoUsuario("viniciuslucena", -5);
		} catch (Exception e) {
			assertEquals("Nao pode adicionar valor menor que 0 ao usuario.", e.getMessage());
		}
	}

	@Test
	public void testVendaDeJogos() {
		try {
			LojaController loja = new LojaController();
			HashSet<Jogabilidade> jogabilidades = new HashSet<Jogabilidade>();
			jogabilidades.add(Jogabilidade.COMPETITIVO);
			jogabilidades.add(Jogabilidade.OFFLINE);
			RPG paperMario = new RPG("Paper Mario", 20, jogabilidades);
			Plataforma superMarioWorld = new Plataforma("Super Mario World", 20, jogabilidades);
			loja.novoUsuario("Antunes Dantas", "antunesdantas");
			loja.adicionaDinheiroAoUsuario("antunesdantas", 40);
			assertTrue(loja.vendaDeJogos("antunesdantas", paperMario));
			assertTrue(loja.vendaDeJogos("antunesdantas", superMarioWorld));
			assertTrue(loja.usuarioTemJogo("antunesdantas", "Paper Mario"));
		} catch (Exception e) {
			fail();
		}
		
		try {
			LojaController loja = new LojaController();
			HashSet<Jogabilidade> jogabilidades = new HashSet<Jogabilidade>();
			jogabilidades.add(Jogabilidade.COMPETITIVO);
			jogabilidades.add(Jogabilidade.OFFLINE);
			RPG paperMario = new RPG("Paper Mario", 20, jogabilidades);
			Plataforma superMarioWorld = new Plataforma("Super Mario World", 20, jogabilidades);
			RPG paperLuigi = new RPG("Paper Luigi", 20, jogabilidades);
			loja.novoUsuario("Antunes Dantas", "antunesdantas");
			loja.adicionaDinheiroAoUsuario("antunesdantas", 40);
			assertTrue(loja.vendaDeJogos("antunesdantas", paperMario));
			assertTrue(loja.usuarioTemJogo("antunesdantas", "Paper Mario"));
			assertTrue(loja.vendaDeJogos("antunesdantas", superMarioWorld));
			loja.vendaDeJogos("antunesdantas", paperLuigi);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testUpgradeUsuario() {
		try {
			LojaController loja = new LojaController();
			loja.novoUsuario("Antunes Dantas", "antunesdantas");
			loja.novoUsuario("Vinicius Lucena", "viniciuslucena");
			
		} catch (Exception e) {
			
		}
	}

}
