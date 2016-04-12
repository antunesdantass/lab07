/* 115110295 - Antunes Dantas da Silva: LAB 6 - Turma 1 */

package erros;

public class ExceptionUsuarioListaInvalida extends ExceptionUsuario {
	
	public ExceptionUsuarioListaInvalida(){
		super("Lista invalida: nao pode ser null");
	}
	
	public ExceptionUsuarioListaInvalida(String mensagem){
		super(mensagem);
	}

}
