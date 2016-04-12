/* 115110295 - Antunes Dantas da Silva: LAB 6 - Turma 1 */

package tests;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import jogo.Jogabilidade;
import jogo.Plataforma;
import jogo.RPG;
import usuarios.Veterano;
import usuarios.Veterano;

public class VeteranoTest {

	@Test
	public void testCompraJogo() {
		try {
			Veterano antunes = new Veterano("Antunes Dantas", "antunesdantas");
			HashSet<Jogabilidade> jogabilidades = new HashSet<Jogabilidade>();
			jogabilidades.add(Jogabilidade.COMPETITIVO);
			jogabilidades.add(Jogabilidade.OFFLINE);
			RPG paperMario = new RPG("Paper Mario", 20, jogabilidades);
			Plataforma superMarioWorld = new Plataforma("Super Mario World", 20, jogabilidades);
			RPG paperLuigi = new RPG("Paper Luigi", 20, jogabilidades);
			antunes.adicionaDinheiro(40);
			assertTrue(antunes.compraJogo(paperMario));
			assertFalse(antunes.compraJogo(paperMario));
			assertTrue(antunes.compraJogo(superMarioWorld));
			assertFalse(antunes.compraJogo(paperLuigi));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void testVeterano() {
		try {
			Veterano nomeNull = new Veterano(null, "teste");
			fail();
		} catch (Exception e) {
			assertEquals("Nome invalido: nao pode ser null ou vazio.", e.getMessage());
		}
		
		try {
			Veterano loginNull = new Veterano("teste", null);
			fail();
		} catch (Exception e) {
			assertEquals("Nome invalido: nao pode ser null ou vazio.", e.getMessage());
		}
		
		try {
			Veterano nomeVazio = new Veterano("", "teste");
			fail();
		} catch (Exception e) {
			assertEquals("Nome invalido: nao pode ser null ou vazio.", e.getMessage());
		}
		
		try {
			Veterano loginVazio = new Veterano("teste", "");
			fail();
		} catch (Exception e) {
			assertEquals("Nome invalido: nao pode ser null ou vazio.", e.getMessage());
		}
	}

}
