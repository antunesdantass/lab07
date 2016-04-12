/* 115110295 - Antunes Dantas da Silva: LAB 6 - Turma 1 */

package usuarios;

/**
 * Classe que representa o tipo de usuario Noob, iniciante na central de games
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import erros.ExceptionJogo;
import erros.ExceptionJogoNomeInvalido;
import erros.ExceptionUsuario;
import jogo.Jogabilidade;
import jogo.Jogo;

public class Noob implements TipoDeUsuarioIF {
	
	private final double DESCONTO = 0.9;
	private final int PONTOS_X2P = 10;
	private final int OFFLINE = 30;
	private final int MULTIPLAYER = 10;
	private final int ONLINE = -10;
	private final int COMPETITIVO = -20;
	private final int COOPERATIVO = -50;
	private final String NEWLINE = System.getProperty("line.separator");
	
	public int recompensar(HashSet<Jogabilidade> jogabilidades) {
		int x2pGanho = 0;
		for (Iterator<Jogabilidade> iter = jogabilidades.iterator(); iter.hasNext();) {
			if (iter.next() == Jogabilidade.OFFLINE) {
				x2pGanho += OFFLINE;
			} else if (iter.next() == Jogabilidade.MULTIPLAYER) {
				x2pGanho += MULTIPLAYER;
			}
		}
		return x2pGanho;
	}
	
	public int punir(HashSet<Jogabilidade> jogabilidades){
		int x2pGanho = 0;
		for (Iterator<Jogabilidade> iter = jogabilidades.iterator(); iter.hasNext();) {
			if (iter.next() == Jogabilidade.ONLINE) {
				x2pGanho += ONLINE;
			} else if (iter.next() == Jogabilidade.COMPETITIVO) {
				x2pGanho += COMPETITIVO;
			} else if (iter.next() == Jogabilidade.COOPERATIVO) {
				x2pGanho += COOPERATIVO;
			}
		}
		return x2pGanho;
	}
	
	public double getDesconto(Jogo jogo) {
		return DESCONTO * jogo.getPreco();
	}
	
	public int compraJogo(Jogo jogo) {
		return (int)(PONTOS_X2P * jogo.getPreco());
	}

	public String imprimeDadosDoUsuario(String nome, ArrayList<Jogo> jogos) {
		double totalGastoEmJogos = 0;
		String saida = nome + " - Jogador Noob" + NEWLINE + "Lista de jogos:" + NEWLINE;
		for (int i = 0; i < jogos.size(); i++) {
			saida += jogos.get(i);
			saida += NEWLINE;
			totalGastoEmJogos += jogos.get(i).getPreco();
		}
		saida += "Total de preco dos jogos: R$ " + totalGastoEmJogos + NEWLINE
				+ "--------------------------------------------";
		return saida;
	}
}
