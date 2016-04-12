/* 115110295 - Antunes Dantas da Silva: LAB 6 - Turma 1 */

package usuarios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import erros.ExceptionJogo;
import erros.ExceptionUsuario;
import jogo.Jogabilidade;
import jogo.Jogo;

public class Veterano implements TipoDeUsuarioIF {

	private final double DESCONTO = 0.8;
	private final int PONTOS_X2P = 15;
	private final int OFFLINE = -20;
	private final int ONLINE = 10;
	private final int COMPETITIVO = -20;
	private final int COOPERATIVO = 20;
	private final String NEWLINE = System.getProperty("line.separator");
	
	/**
	 * Metodo que informa a quantidade de pontos X2p ganhos pelo usuario
	 * a partir da compra de um jogo.
	 */

	public int compraJogo(Jogo jogo) {
		return (int)(jogo.getPreco() * PONTOS_X2P);
	}
	
	public int recompensar(HashSet<Jogabilidade> jogabilidades) {
		int x2pGanho = 0;
		for (Iterator<Jogabilidade> iter = jogabilidades.iterator(); iter.hasNext();) {
			if (iter.next() == Jogabilidade.ONLINE) {
				x2pGanho += ONLINE;
			} else if (iter.next() == Jogabilidade.COOPERATIVO) {
				x2pGanho += COOPERATIVO;
			}
		}
		return x2pGanho;
	}
	
	public int punir(HashSet<Jogabilidade> jogabilidades){
		int x2pGanho = 0;
		for (Iterator<Jogabilidade> iter = jogabilidades.iterator(); iter.hasNext();) {
			if (iter.next() == Jogabilidade.OFFLINE) {
				x2pGanho += OFFLINE;
			} else if (iter.next() == Jogabilidade.COMPETITIVO) {
				x2pGanho += COMPETITIVO;
			}
		}
		return x2pGanho;
	}
	
	/**
	 * Metodo que informa a quantidade de desconto que o usuario tera ao comprar um jogo
	 */
	public double getDesconto() {
		return DESCONTO;
	}

	/**
	 * Metodo que imprime as infomacoes do usuario, como nome, lista de jogos e dados dos jogos.
	 */
	public String imprimeDadosDoUsuario(String nome, ArrayList<Jogo> jogos) {
		double totalGastoEmJogos = 0;
		String saida = nome + " - Jogador Veterano" + NEWLINE + "Lista de jogos:" + NEWLINE;
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
