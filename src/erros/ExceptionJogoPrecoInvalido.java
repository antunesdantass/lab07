/* 115110295 - Antunes Dantas da Silva: LAB 6 - Turma 1 */

package erros;


public class ExceptionJogoPrecoInvalido extends ExceptionJogo {
	public ExceptionJogoPrecoInvalido() {
		super("Preco invalido: nao pode ser menor que zero");
	}
	
	public ExceptionJogoPrecoInvalido(String mensagem){
		super(mensagem);
	}

}
