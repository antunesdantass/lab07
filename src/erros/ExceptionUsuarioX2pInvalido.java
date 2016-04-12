/* 115110295 - Antunes Dantas da Silva: LAB 6 - Turma 1 */

package erros;

public class ExceptionUsuarioX2pInvalido extends ExceptionUsuario {
	
	public ExceptionUsuarioX2pInvalido() {
		super("X2p a ser creditado nao pode ser menor que zero.");
	}
	
	public ExceptionUsuarioX2pInvalido(String mensagem) {
		super(mensagem);
	}

}
