/* 115110295 - Antunes Dantas da Silva: LAB 6 - Turma 1 */
package jogo;

/**
 *  Classe para representar o tipo de jogo Luta. Herda o tipo jogo.
 */

import java.util.HashSet;

import erros.ExceptionJogo;
import erros.ExceptionJogoScoreInvalido;

public class Luta extends Jogo {
	
	private final int QUANTIDADE_DE_SCORE_PARA_1_X2P = 1000;
	private final String NEWLINE = System.getProperty("line.separator");

	public Luta(String nome, double preco, HashSet<Jogabilidade> jogabilidades) throws ExceptionJogo {
		super(nome, preco, jogabilidades);
	}
	
	/**
	 * Sobrescreve o metodo registra jogada da classe Jogo, informa os dados de execucao do jogo 
	 */
	public int registraJogada(int score, boolean zerou) throws ExceptionJogo {
		int x2pGanho = 0;
		if (score < 0 || score > 100000){
			throw new ExceptionJogoScoreInvalido();
		}
		if (score > super.getMaiorScore()){
			super.setMaiorScore(score);
			x2pGanho = score/QUANTIDADE_DE_SCORE_PARA_1_X2P;
		}
		if (zerou){
			super.zerou();
		}
		super.jogou();
		return x2pGanho;
	}
	
	public String toString(){
		String saida = "+ " + this.getNomeDoJogo() + " - Luta:" + NEWLINE + 
				"==> Jogou " + this.getVezesJogadas() +"vez(es)" + NEWLINE +
				"==> Zerou " + this.getVezesZeradas() + "vez(es)" + NEWLINE +
				"==> Maior score: " + this.getMaiorScore();
		return saida;
	}

}
