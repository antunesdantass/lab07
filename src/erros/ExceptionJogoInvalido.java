/* 115110295 - Antunes Dantas da Silva: LAB 7 - Turma 1 */

package erros;

public class ExceptionJogoInvalido extends ExceptionJogo {

	public ExceptionJogoInvalido() {
		super("Jogo nao pode ser null");
	}

	public ExceptionJogoInvalido(String mensagem) {
		super(mensagem);
	}

}
