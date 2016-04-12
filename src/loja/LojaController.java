/* 115110295 - Antunes Dantas da Silva: LAB 6 - Turma 1 */

package loja;

/**
 * Classe que representa a loja. Possui os metodos necessarios para cadastrar usuario, 
 * vender jogo, dentre outras operacoes.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import erros.ExceptionLojaUpgrade;
import erros.ExceptionUsuarioEntradaInvalida;
import jogo.GameFactory;
import jogo.Jogabilidade;
import jogo.Jogo;
import usuarios.UserFactory;
import usuarios.Usuario;
import usuarios.Veterano;

public class LojaController {

	private final int PONTUACAO_MINIMA_UPGRADE = 1000;
	private final static String NEWLINE = System.getProperty("line.separator");
	private HashMap<String, Usuario> usuarios;
	private UserFactory userFactory;
	private GameFactory gameFactory;

	public LojaController() {
		usuarios = new HashMap<String, Usuario>();
		userFactory = new UserFactory();
		gameFactory = new GameFactory();
	}
	
	/**
	 * Metodo que cadastra um novo usuario.
	 * @param nomeDoUsuario dizer o que eh esse parametro
	 * @param login
	 */
	public void criaUsuario(String nomeDoUsuario, String login, String tipo) throws Exception {
		usuarios.put(login, userFactory.criaUsuario(nomeDoUsuario, login, tipo));
	}
	
	/**
	 * Metodo que adiciona dinheiro na conta do usuario, acessado atraves do seu login
	 * @param login
	 * @param valor
	 */
	public void adicionaDinheiroAoUsuario(String login, double valor) {
		try {
			if (login == null || login.trim().isEmpty()) {
				throw new ExceptionUsuarioEntradaInvalida();
			}
			usuarios.get(login).adicionaDinheiro(valor);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Metodo que informa o saldo, em Reais, de determinado usuario atraves do login do usuario desejado
	 * @param login
	 * @return
	 */
	public double getSaldoUsuario(String login) throws Exception {
		if (login == null || login.trim().isEmpty()) {
			throw new ExceptionUsuarioEntradaInvalida();
		}
		return usuarios.get(login).getSaldo();
	}

	/**
	 * Metodo que realiza a venda de um jogo para o usuario. Recebe os dados de criacao do jogo e delega para
	 * a GameFactory criar o jogo.
	 * @param login
	 * @param jogo
	 * @return boolean
	 */
	public void vendaDeJogos(String login, String tituloDoJogo, String tipoDoJogo, double precoDoJogo, HashSet<Jogabilidade> jogabilidades) throws Exception {
		Jogo novoJogo = gameFactory.criaJogo(tituloDoJogo, precoDoJogo, tipoDoJogo, jogabilidades);
		Usuario usuario = usuarios.get(login);
		usuario.compraJogo(novoJogo);
		usuarios.get(login).compraJogo(gameFactory.criaJogo(tituloDoJogo, precoDoJogo, tipoDoJogo, jogabilidades));
	} // ajeitar seboseira 
	// venda vai criar o obj jogo e passar pro compra de usuario, o usuario vai mandar pro comprajgo que vai calcular o x2p
	// a interface vai ter um metodo que retorna o desconto para cada usuario
	// esse desconto vai ser pego por usuario
	
	/**
	 * Metodo que informa se um usuario ja possui algum jogo passado como parametro
	 * @param login
	 * @param tituloDoJogo
	 * @return
	 */
	public boolean usuarioTemJogo(String login, String tituloDoJogo){
		return usuarios.get(login).temJogo(tituloDoJogo);
	}
	
	/**
	 * Metodo que realiza o upgrade de usuario Noob para usuario Veterano de acordo com a sua pontuacao x2p
	 * @param login
	 */
	public void upgradeUsuario(String login) {
		try {
			Usuario usuario = usuarios.get(login);
			if (usuario.getClass() == Veterano.class) {
				throw new ExceptionLojaUpgrade();
			}

			if (usuario.getX2p() < PONTUACAO_MINIMA_UPGRADE) {
				throw new ExceptionLojaUpgrade("O usuario nao possui pontuacao necessaria para upgrade");
			}

			Veterano upgradedUser = new Veterano(usuarios.get(login).getNome(), login);
			upgradedUser.aumentaX2p(usuario.getX2p());
			upgradedUser.adicionaDinheiro(usuario.getSaldo());
			upgradedUser.setListaDeJogos(usuario.getListaDeJogos());
			usuarios.put(login, upgradedUser);
		} catch (Exception e) {
			System.err.print(e.getMessage());
		}

	}

	public String toString() {
		String saida = "=== Central P2-CG ===" + NEWLINE;
		Set<String> chaves = usuarios.keySet();
		for (String chave : chaves) {
			saida += usuarios.get(chave).toString();
		}
		return saida;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LojaController) {
			LojaController outraLoja = (LojaController) obj;
			Set<String> chaves = outraLoja.usuarios.keySet();
			for (String chave : chaves) {
				if (!outraLoja.usuarios.get(chave).equals(this.usuarios.get(chave))) {
					return false;
				}
				return true;
			}
		}
		return false;
	}
}
