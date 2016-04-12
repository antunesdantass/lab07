/* 115110295 - Antunes Dantas da Silva: LAB 6 - Turma 1 */

package jogo;
import java.util.HashSet;
import erros.ExceptionJogo;
import erros.ExceptionJogoJogabilidadeInvalida;
import erros.ExceptionJogoNomeInvalido;
import erros.ExceptionJogoPrecoInvalido;
import erros.ExceptionJogoScoreInvalido;

/** Classe abstrata para o tipo jogo, que contera valores e metodos para o mesmo
 * @author Antunes Silva
 * @version 1.0
*/

public abstract class Jogo {

	private String nomeDoJogo;
	private double preco;
	private int maiorScore;
	private int qtdVezesJogadas;
	private int qtdZeradas;
	private HashSet<Jogabilidade> jogabilidades;

	public Jogo(String nome, double preco, HashSet<Jogabilidade> jogabilidades) throws ExceptionJogo {
		if (nome == null || nome.trim().isEmpty()) {
			throw new ExceptionJogoNomeInvalido();
		}

		if (preco < 0) {
			throw new ExceptionJogoPrecoInvalido();
		}

		if (jogabilidades == null) {
			throw new ExceptionJogoJogabilidadeInvalida();
		}

		this.nomeDoJogo = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.qtdVezesJogadas = 0;
		this.qtdZeradas = 0;
		this.jogabilidades = jogabilidades;

	}

	/** Metodo para retorno do nome do jogo
	  * @return String - Nome do Jogo
	 */
	public String getNomeDoJogo() {
		return this.nomeDoJogo;
	}
	
	/** Metodo que muda o nome do jogo
	 * @param novoNome
	 * @throws ExceptionJogoNomeInvalido
	 */
	public void setNomeDoJogo(String novoNome) throws ExceptionJogoNomeInvalido {
		if (novoNome == null || novoNome.trim().isEmpty()) {
			throw new ExceptionJogoNomeInvalido();
		}
		this.nomeDoJogo = novoNome;
	}

	/** Metodo para retorno do preco do jogo
	  * @return double - Preco do Jogo
	 */
	public double getPreco(){
		return this.preco;
	}
	
	/** Metodo que muda o preco do jogo
	 * @param novoPreco
	 * @throws ExceptionJogoPrecoInvalido
	 */
	public void setPreco(int novoPreco) throws ExceptionJogoPrecoInvalido {
		if (novoPreco < 0){
			throw new ExceptionJogoPrecoInvalido();
		}
		this.preco = novoPreco;
	}
	/** Metodo para retorno do maior score do jogo
	  * @return int - Maior score do Jogo
	 */
	public int getMaiorScore(){
		return this.maiorScore;
	}
	
	/** Metodo para definir o maior score em um jogo
	 * @param novoScore
	 * @throws ExceptionJogoScoreInvalido
	 */
	public void setMaiorScore(int novoScore) throws ExceptionJogoScoreInvalido {
		if (novoScore < 0){
			throw new ExceptionJogoScoreInvalido();
		}
		this.maiorScore = novoScore;
	}
	
	/** Metodo para retorno da quantidade de vezes que o jogo foi zerado
	  * @return int - qtdZeradas
	 */
	public int getVezesZeradas(){
		return this.qtdZeradas;
	}
	
	/** Metodo que incrementa em 1 o numero de vezes que um jogo foi zerado
	 */
	public void zerou(){
		qtdZeradas++;
	}
	
	/** Metodo para retorno da quantidade de vezes que o jogo foi jogado
	  * @return int - QtdVezesJogadas
	 */
	public int getVezesJogadas(){
		return this.qtdVezesJogadas;
	}
	
	public HashSet<Jogabilidade> getJogabilidades() {
		return this.jogabilidades;
	}
	
	/** Metodo que incrementa em 1 o numero de vezes que um jogo foi jogado a cada execucao do mesmo
	 */
	public void jogou(){
		qtdVezesJogadas++;
	}
	
	/** Metodo abstrato que registra cada vez que o usuario jogou
	 * @param score
	 * @param zerou
	 * @return int
	 * @throws Exception
	 */
	public abstract int registraJogada(int score, boolean zerou) throws Exception;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jogabilidades == null) ? 0 : jogabilidades.hashCode());
		result = prime * result + ((nomeDoJogo == null) ? 0 : nomeDoJogo.hashCode());
		result = (int) (prime * result + preco);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogo other = (Jogo) obj;
		if (jogabilidades == null) {
			if (other.jogabilidades != null)
				return false;
		} else if (!jogabilidades.equals(other.jogabilidades))
			return false;
		if (nomeDoJogo == null) {
			if (other.nomeDoJogo != null)
				return false;
		} else if (!nomeDoJogo.equals(other.nomeDoJogo))
			return false;
		if (preco != other.preco)
			return false;
		return true;
	}
}