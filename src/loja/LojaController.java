/* 115110295 - Antunes Dantas da Silva: LAB 7 - Turma 1 */

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
import usuarios.Usuario;
import usuarios.Veterano;

public class LojaController {

	private final int PONTUACAO_MINIMA_UPGRADE = 1000;
	private final static String NEWLINE = System.getProperty("line.separator");
	private HashMap<String, Usuario> usuarios;
	private GameFactory gameFactory;

	public LojaController() {
		usuarios = new HashMap<String, Usuario>();
		gameFactory = new GameFactory();
	}
	
	/**
	 * Metodo que cadastra um novo usuario.
	 * @param nomeDoUsuario: String com o nome do usuario 
	 * @param login: login do usuario, utilizado como chave no HashMap
	 */
	public void criaUsuario(String nomeDoUsuario, String login) throws Exception {
		Usuario newUser = new Usuario(nomeDoUsuario, login);
		usuarios.put(login, newUser);
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
	 * @param login: usado para procurar o usuario no HashMap
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
		Jogo novoJogo = gameFactory.criaJogo(tituloDoJogo, precoDoJogo, tipoDoJogo, jogabilidades); // chamada polimorfica
		Usuario usuario = usuarios.get(login);
		usuario.compraJogo(novoJogo);
		usuarios.get(login).compraJogo(gameFactory.criaJogo(tituloDoJogo, precoDoJogo, tipoDoJogo, jogabilidades));
	} 
	
	/**
	 * Metodo que informa se um usuario ja possui algum jogo passado como parametro
	 * @param login
	 * @param tituloDoJogo
	 * @return
	 */
	public boolean usuarioTemJogo(String login, String tituloDoJogo){
		return usuarios.get(login).temJogo(tituloDoJogo);
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
