/* 115110295 - Antunes Dantas da Silva: LAB 7 - Turma 1 */

package erros;

public class ExceptionUsuarioEntradaInvalida extends ExceptionUsuario{
	public ExceptionUsuarioEntradaInvalida(){
		super("Nome invalido: nao pode ser null ou vazio.");
	}
	
	public ExceptionUsuarioEntradaInvalida(String mensagem){
		super(mensagem);
	}
}
