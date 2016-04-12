/* 115110295 - Antunes Dantas da Silva: LAB 7 - Turma 1 */

package jogo;

import java.util.HashSet;

/**
 * Classe responsavel por criar instancias do tipo jogo, recebendo os parametros necessarios para tal fim
 * @author Antunes Silva
 */
public class GameFactory {
	
	public GameFactory(){}
	
	/**
	 * Metodo responsavel por criar os jogos.
	 * @param tituloDoJogo
	 * @param precoDoJogo
	 * @param tipoDoJogo
	 * @param jogabilidades
	 * @return Jogo
	 */
	public Jogo criaJogo(String tituloDoJogo, double precoDoJogo, String tipoDoJogo, HashSet<Jogabilidade> jogabilidades) throws Exception {
		
		if (tipoDoJogo == null || tipoDoJogo.trim().isEmpty()) {
			throw new Exception ("Tipo de jogo invalido: nao pode ser null ou vazio");
		}
		
		if (tipoDoJogo.equals("RPG")) {
			return criaRPG(tituloDoJogo, precoDoJogo, jogabilidades);
		} else if (tipoDoJogo.equals("Plataforma")) {
			return criaPlataforma(tituloDoJogo, precoDoJogo, jogabilidades);
		} else {
			return criaLuta(tituloDoJogo, precoDoJogo, jogabilidades);
		}
		
	}
	
	/**
	 * Metodo privado que cria jogos do tipo RPG
	 * @param tituloDoJogo
	 * @param precoDoJogo
	 * @param jogabilidades
	 * @return RPG
	 * @throws Exception
	 */
	private RPG criaRPG(String tituloDoJogo, double precoDoJogo, HashSet<Jogabilidade> jogabilidades) throws Exception {
		return new RPG(tituloDoJogo, precoDoJogo, jogabilidades);
	}
	
	/**
	 * Metodo privado que cria jogos do tipo Luta
	 * @param tituloDoJogo
	 * @param precoDoJogo
	 * @param jogabilidades
	 * @return Luta
	 * @throws Exception
	 */
	private Luta criaLuta(String tituloDoJogo, double precoDoJogo, HashSet<Jogabilidade> jogabilidades) throws Exception {
		return new Luta(tituloDoJogo, precoDoJogo, jogabilidades);
	}
	
	/**
	 * Metodo privado que cria jogos do tipo Plataforma
	 * @param tituloDoJogo
	 * @param precoDoJogo
	 * @param jogabilidades
	 * @return Plataforma
	 * @throws Exception
	 */
	private Plataforma criaPlataforma (String tituloDoJogo, double precoDoJogo, HashSet<Jogabilidade> jogabilidades) throws Exception {
		return new Plataforma(tituloDoJogo, precoDoJogo, jogabilidades);
	}

}
