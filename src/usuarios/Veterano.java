/* 115110295 - Antunes Dantas da Silva: LAB 6 - Turma 1 */

package usuarios;

import java.util.ArrayList;

import erros.ExceptionJogo;
import erros.ExceptionUsuario;
import jogo.Jogo;

public class Veterano implements TipoDeUsuarioIF {

	private final double DESCONTO = 0.8;
	private final int PONTOS_X2P = 15;
	private final String NEWLINE = System.getProperty("line.separator");
	
	/**
	 * Metodo que informa a quantidade de pontos X2p ganhos pelo usuario
	 * a partir da compra de um jogo.
	 */

	public int compraJogo(Jogo jogo) {
		return (int)(jogo.getPreco() * PONTOS_X2P);
	}
	
	/**
	 * Metodo que informa a quantidade de desconto que o usuario tera ao comprar um jogo
	 */
	public double getDesconto(Jogo jogo) {
		return jogo.getPreco() * DESCONTO;
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
