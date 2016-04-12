/* 115110295 - Antunes Dantas da Silva: LAB 6 - Turma 1 */

package erros;

public class ExceptionLoja extends Exception {
	
	public ExceptionLoja(){
		super("Erro nao especificado");
	}
	
	public ExceptionLoja(String mensagem){
		super(mensagem);
	}
}
