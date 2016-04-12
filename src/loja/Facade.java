/* 115110295 - Antunes Dantas da Silva: LAB 7 - Turma 1 */

package loja;

import java.util.HashSet;

import jogo.Jogabilidade;

public class Facade {

	private LojaController loja;
	private static final double NAO_HA_USUARIO_PROCURADO = -1;

	public Facade() {
		loja = new LojaController();
	}

	public void criaUsuario(String nomeDoUsuario, String login, String tipo) {
		try {
			loja.criaUsuario(nomeDoUsuario, login);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void adicionaDinheiroAoUsuario(String login, double valor) {
		try {
			loja.adicionaDinheiroAoUsuario(login, valor);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public double getSaldoUsuario(String login) {
		try {
			double saldo = loja.getSaldoUsuario(login);
			return saldo;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return NAO_HA_USUARIO_PROCURADO;
		}
	}

	public void vendaDeJogos(String login, String tituloDoJogo, String tipoDoJogo, double precoDoJogo,
			HashSet<Jogabilidade> jogabilidades) {
		try {
			loja.vendaDeJogos(login, tituloDoJogo, tipoDoJogo, precoDoJogo, jogabilidades);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public boolean usuarioTemJogo(String login, String tituloDoJogo) {
		try {
			return loja.usuarioTemJogo(login, tituloDoJogo);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
}
