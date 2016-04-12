/* 115110295 - Antunes Dantas da Silva: LAB 7 - Turma 1 */

package jogo;

/**
 *  Classe para representar o tipo de jogo Plataforma. Herda o tipo jogo.
 */

import java.util.HashSet;

import erros.ExceptionJogo;
import erros.ExceptionJogoScoreInvalido;

public class Plataforma extends Jogo {

	private final int PONTOS_GANHOS_POR_ZERAR = 20;
	private final String NEWLINE = System.getProperty("line.separator");

	public Plataforma(String nome, double preco, HashSet<Jogabilidade> jogabilidades) throws ExceptionJogo {
		super(nome, preco, jogabilidades);
	}

	/**
	 * Sobrescreve o metodo registra jogada da classe Jogo, informa os dados de execucao do jogo 
	 */
	public int registraJogada(int score, boolean zerou) throws ExceptionJogoScoreInvalido {
		int x2pGanho = 0;
		if (score < 0) {
			throw new ExceptionJogoScoreInvalido();
		}

		if (zerou) {
			super.zerou();
			x2pGanho = PONTOS_GANHOS_POR_ZERAR;
		}
		super.jogou();
		return x2pGanho;
	}
	
	public String toString(){
		String saida = "+ " + this.getNomeDoJogo() + " - Plataforma:" + NEWLINE + 
				"==> Jogou " + this.getVezesJogadas() +"vez(es)" + NEWLINE +
				"==> Zerou " + this.getVezesZeradas() + "vez(es)" + NEWLINE +
				"==> Maior score: " + this.getMaiorScore();
		return saida;
	}
}
