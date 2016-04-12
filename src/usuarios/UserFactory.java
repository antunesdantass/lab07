package usuarios;

import erros.ExceptionUsuarioEntradaInvalida;

/**
 * Classe usada para criar usuarios de qualquer tipo, recebendo os dados
 * necessarios e retornando a instancia do novo usuario criado.
 * @author Antunes Silva
 */

public class UserFactory {

	public UserFactory() {
	}

	/**
	 * Metodo responsavel pela criacao dos usuarios.
	 * @param nome
	 * @param login
	 * @param tipo
	 * @return Usuario
	 * @throws Exception
	 */
	public Usuario criaUsuario(String nome, String login, String tipo)
			throws Exception {

		if (nome == null || nome.trim().isEmpty()) {
			throw new ExceptionUsuarioEntradaInvalida();
		}

		if (login == null || login.trim().isEmpty()) {
			throw new ExceptionUsuarioEntradaInvalida();
		}

		if (tipo == null || tipo.trim().isEmpty()) {
			throw new ExceptionUsuarioEntradaInvalida();
		}

		if (!tipo.equals("Noob")) {
			throw new ExceptionUsuarioEntradaInvalida("Nao pode criar usuario Veterano, apenas Noob");
		}

		if (tipo.equals("Noob")) {
			Noob novoUsuario = new Noob(nome, login);
			return novoUsuario;
		} else {
			Veterano novoUsuario = new Veterano(nome, login);
			return novoUsuario;
		}
	}

}
