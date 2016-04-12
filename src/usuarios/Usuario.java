/* 115110295 - Antunes Dantas da Silva: LAB 6 - Turma 1 */

package usuarios;

/**
 * Classe que contem os principais atributos e comportamentos do tipo usuario.
 */

import jogo.Jogo;
import java.util.ArrayList;
import erros.ExceptionJogoInvalido;
import erros.ExceptionJogoNomeInvalido;
import erros.ExceptionJogoScoreInvalido;
import erros.ExceptionUsuario;
import erros.ExceptionUsuarioEntradaInvalida;
import erros.ExceptionUsuarioJogoRepetido;
import erros.ExceptionUsuarioListaInvalida;
import erros.ExceptionUsuarioX2pInvalido;

public class Usuario {

	private String nome;
	private String login;
	private double saldo;
	private ArrayList<Jogo> listaDeJogos;
	private int x2p;
	private TipoDeUsuarioIF statusDeUsuario;
	private static final int X2P_MINIMO_PARA_VETERANO = 1000;

	public Usuario(String nome, String login) throws ExceptionUsuario {
		setNome(nome);
		setLogin(login);
		this.saldo = 0;
		listaDeJogos = new ArrayList<Jogo>();
		statusDeUsuario = new Noob();

	}
	
	/**
	 * Metodo que retorna o nome do usuario
	 * @return String nome
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Metodo que define um novo nome para o usuario
	 * @param novoNome
	 * @throws ExceptionUsuarioEntradaInvalida
	 */
	public void setNome(String novoNome) throws ExceptionUsuarioEntradaInvalida {
		if (novoNome == null || novoNome.trim().isEmpty()) {
			throw new ExceptionUsuarioEntradaInvalida();
		}
		this.nome = novoNome;
	}
	
	public void mudaStatusParaVeterano() {
		statusDeUsuario = new Veterano();
	}
	
	public void mudaStatusParaNoob() {
		statusDeUsuario = new Noob();
	}
	
	/**
	 * Metodo que informa o login de um usuario
	 * @return String login
	 */
	public String getLogin() {
		return this.login;
	}
	
	/**
	 * Metodo que define o login do usuario
	 * @param login
	 * @throws ExceptionUsuario
	 */
	public void setLogin(String login) throws ExceptionUsuario{
		if (login == null || login.trim().isEmpty()) {
			throw new ExceptionUsuarioEntradaInvalida();
		}
		this.login = login;
	}
	
	
	/**
	 * Metodo que define uma nova lista de jogos para o usuario
	 * @param novaLista
	 * @throws ExceptionUsuarioListaInvalida
	 */
	public void setListaDeJogos(ArrayList<Jogo> novaLista) throws ExceptionUsuarioListaInvalida {
		if (novaLista == null) {
			throw new ExceptionUsuarioListaInvalida();
		}
		this.listaDeJogos = novaLista;
	}
	
	/**
	 * Metodo que informa a quantidade de pontos de experiencia do usuario
	 * @return int x2p
	 */
	public int getX2p() {
		return this.x2p;
	}
	
	/**
	 * Metodo que acrescenta uma quantidade x de x2p ao usuario
	 * Caso o usuario alcance a quantidade minima de x2p para garantir um upgrade, este é realizado
	 * @param quantidadeDeX2p
	 * @throws ExceptionUsuarioX2pInvalido
	 */
	public void aumentaX2p(int quantidadeDeX2p) throws ExceptionUsuarioX2pInvalido {
		if (quantidadeDeX2p < 0) {
			throw new ExceptionUsuarioX2pInvalido();
		}
		this.x2p += quantidadeDeX2p;
		if (this.getX2p() > X2P_MINIMO_PARA_VETERANO) {
			mudaStatusParaVeterano();
		}
	}
	
	/**
	 * Metodo que diminui uma quantidade x de x2p ao usuario
	 * Caso o usuario fique abaixo da quantidade minima de x2p para ser veterano, o downgrade é realizado
	 * @param quantidadeDeX2p
	 * @throws ExceptionUsuarioX2pInvalido
	 */
	public void diminuiX2p(int quantidadeDeX2p) throws ExceptionUsuarioX2pInvalido {
		if (quantidadeDeX2p < 0) {
			throw new ExceptionUsuarioX2pInvalido();
		}
		this.x2p -= quantidadeDeX2p;
		if (this.getX2p() < X2P_MINIMO_PARA_VETERANO) {
			mudaStatusParaNoob();
		}
	}
	
	/**
	 * Metodo que informa o saldo do usuario
	 * @return double Saldo
	 */
	public double getSaldo() {
		return this.saldo;
	}
	
	/**
	 * Metodo que informa a quantidade de jogos que o usuario possui
	 * @return int quantidadeDeJogos
	 */
	public int getQuantidadeDeJogos() {
		return this.listaDeJogos.size();
	}
	
	/**
	 * Metodo que retorna um jogo da lista do usuario, retornando null caso o usuario nao possua o jogo
	 * @param titulo
	 * @return Jogo jogo
	 */
	public Jogo getJogo(String titulo) {
		for (int i = 0; i < listaDeJogos.size(); i++) {
			if (listaDeJogos.get(i).getNomeDoJogo().equals(titulo)) {
				return listaDeJogos.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Metodo que adiciona um jogo na lista de jogos do usuario, caso esse jogo ainda nao tenha sido adicionado antes
	 * @param jogo
	 * @return boolean
	 * @throws Exception
	 */
	public boolean addJogoNaLista(Jogo jogo) throws Exception {
		if (jogo == null) {
			throw new ExceptionJogoInvalido();
		}
		if (listaDeJogos.contains(jogo)) {
			throw new ExceptionUsuarioJogoRepetido();
		}
		listaDeJogos.add(jogo);
		return true;
	}
	
	/**
	 * Metodo que verifica se um usuario possui um determinado jogo
	 * @param tituloDoJogo
	 * @return boolean
	 */
	public boolean temJogo(String tituloDoJogo) {
		for (int i = 0; i < getQuantidadeDeJogos(); i++) {
			if (listaDeJogos.get(i).getNomeDoJogo().equals(tituloDoJogo)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo que retira uma quantidade x de dinheiro do saldo do usuario
	 * @param valor
	 * @throws Exception
	 */
	public void retiraDinheiro(double valor) throws Exception {
		if (valor < 0) {
			throw new Exception("Valor a ser retirado nao pode ser menor que zero.");
		}
		this.saldo -= valor;
	}
	
	/**
	 * Metodo que adiciona uma quantidade x de dinheiro no saldo do usuario
	 * @param valor
	 * @throws Exception
	 */
	public void adicionaDinheiro(double valor) throws Exception {
		if (valor < 0 ) {
			throw new Exception("Valor a ser creditado ao usuario nao pode ser menor que zero.");
		}
		this.saldo += valor;
	}
	
	public void recompensar(String nomeDoJogo,int scoreObtido,boolean zerou) throws Exception {
		if (nomeDoJogo == null || nomeDoJogo.trim().isEmpty()) {
			throw new ExceptionJogoNomeInvalido();
		}
		if (scoreObtido < 0) {
			throw new ExceptionJogoScoreInvalido();
		}
		Jogo jogo = getJogo(nomeDoJogo);
		int x2pGanho = 0;
		x2pGanho += jogo.registraJogada(scoreObtido, zerou);
		x2pGanho += statusDeUsuario.recompensar(jogo.getJogabilidades());
		aumentaX2p(x2pGanho);	
	}
	
	public void punir(String nomeDoJogo, int scoreObtido, boolean zerou) throws Exception {
		if (nomeDoJogo == null || nomeDoJogo.trim().isEmpty()) {
			throw new ExceptionJogoNomeInvalido();
		}
		if (scoreObtido < 0) {
			throw new ExceptionJogoScoreInvalido();
		}
		Jogo jogo = getJogo(nomeDoJogo);
		int x2pGanho = 0;
		x2pGanho += jogo.registraJogada(scoreObtido, zerou);
		x2pGanho += statusDeUsuario.punir(jogo.getJogabilidades());
		aumentaX2p(x2pGanho);	
	}
	
	/**
	 * Metodo abstrato para a compra de jogo
	 * @param jogo
	 * @return
	 * @throws Exception
	 */
	public void compraJogo(Jogo jogo) throws Exception {
		
		if (jogo == null) {
			throw new Exception("Jogo nao pode ser null");
		}
		
		if (jogo.getPreco()*statusDeUsuario.getDesconto() > this.getSaldo()) {
			throw new Exception("Usuario nao possui dinheiro suficiente para comprar novo jogo");
		}
		
		if (listaDeJogos.contains(jogo)) {
			throw new Exception("Usuario ja possui este jogo");
		}
		
		double precoDoJogo = jogo.getPreco() * statusDeUsuario.getDesconto();
		retiraDinheiro(precoDoJogo);
		listaDeJogos.add(jogo);
		int x2pGanho = (int) (jogo.getPreco() * statusDeUsuario.compraJogo(jogo));
		aumentaX2p(x2pGanho);
		
	}
	
	private ArrayList<Jogo> criaCopiaDeListaDeJogos() {
		ArrayList<Jogo> copia = new ArrayList<Jogo>();
		for (int i = 0; i < listaDeJogos.size(); i++) {
			copia.add(listaDeJogos.get(i));
		}
		return copia;
	}
	
	public String toString() {
		return statusDeUsuario.imprimeDadosDoUsuario(this.getNome(), criaCopiaDeListaDeJogos());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
}
