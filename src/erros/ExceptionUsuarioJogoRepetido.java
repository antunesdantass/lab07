/* 115110295 - Antunes Dantas da Silva: LAB 6 - Turma 1 */

package erros;

public class ExceptionUsuarioJogoRepetido extends ExceptionUsuario {

	public ExceptionUsuarioJogoRepetido(){
		super("Jogo nao pode ser adicionado pois o usuario ja tem o mesmo.");
	}
	
	public ExceptionUsuarioJogoRepetido(String mensagem) {
		super(mensagem);
	}
	
}
