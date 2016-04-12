package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import usuarios.UserFactory;

public class UserFactoryTest {

	@Test
	public void testCriaUsuario() {
		UserFactory userFactory = new UserFactory();
		try {
			userFactory.criaUsuario("", "teste", "Noob");
			fail();
		} catch (Exception e) {
			assertEquals("Nome invalido: nao pode ser null ou vazio.", e.getMessage());
		}
		
		try {
			userFactory.criaUsuario("teste", "", "Noob");
			fail();
		} catch (Exception e) {
			assertEquals("Nome invalido: nao pode ser null ou vazio.", e.getMessage());
		}
		
		try {
			userFactory.criaUsuario("teste", "teste", "");
			fail();
		} catch (Exception e) {
			assertEquals("Nome invalido: nao pode ser null ou vazio.", e.getMessage());
		}
		
		try {
			userFactory.criaUsuario("teste", "teste", "");
			fail();
		} catch (Exception e) {
			assertEquals("Nome invalido: nao pode ser null ou vazio.", e.getMessage());
		}
		
		try {
			userFactory.criaUsuario("teste", "teste", "Noob");
		} catch (Exception e) {
			fail();
		}
		
		try {
			userFactory.criaUsuario("teste", "teste", "Veterano");
			fail();
		} catch (Exception e) {
			assertEquals("Nao pode criar usuario Veterano, apenas Noob", e.getMessage());
		}
		
	}

}
