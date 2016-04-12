/* 115110295 - Antunes Dantas da Silva: LAB 6 - Turma 1 */

package erros;

public class ExceptionLojaAdicionaUsuario extends ExceptionLoja {
	
	public ExceptionLojaAdicionaUsuario(){
		super("Nao eh possivel adicionar o novo usuario pois o login ja esta sendo utilizado.");
	}
	
	public ExceptionLojaAdicionaUsuario(String mensagem){
		super(mensagem);
	}

}
