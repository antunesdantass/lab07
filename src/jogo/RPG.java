/* 115110295 - Antunes Dantas da Silva: LAB 7 - Turma 1 */

package jogo;

/**
 *  Classe para representar o tipo de jogo RPG. Herda o tipo jogo.
 */

import java.util.HashSet;

import erros.ExceptionJogo;

public class RPG extends Jogo {
	
	final int PONTOS_DE_EXPERIENCIA = 10;
	private final String NEWLINE = System.getProperty("line.separator");
	
	/**
	 * Sobrescreve o metodo registra jogada da classe Jogo, informa os dados de execucao do jogo 
	 */
	public RPG(String nome, double preco, HashSet<Jogabilidade> jogabilidades) throws ExceptionJogo {
		super(nome, preco, jogabilidades);
	}

	@Override
	public int registraJogada(int score, boolean zerou) throws Exception {
		if (score > super.getMaiorScore()) {
			super.setMaiorScore(score);
		}
		
		if (zerou){
			super.zerou();
		}
		
		super.jogou();
		return PONTOS_DE_EXPERIENCIA;
	}
	
	public String toString(){
		String saida = "+ " + this.getNomeDoJogo() + " - RPG:" + NEWLINE + 
				"==> Jogou " + this.getVezesJogadas() +"vez(es)" + NEWLINE +
				"==> Zerou " + this.getVezesZeradas() + "vez(es)" + NEWLINE +
				"==> Maior score: " + this.getMaiorScore();
		return saida;
	}

}
