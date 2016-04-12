/* 115110295 - Antunes Dantas da Silva: LAB 7 - Turma 1 */

package erros;

public class ExceptionLojaUpgrade extends ExceptionLoja {
	
	public ExceptionLojaUpgrade(){
		super("Usuario ja eh Veterano, nao eh necessario upgrade.");
	}
	
	public ExceptionLojaUpgrade(String mensagem){
		super(mensagem);
	}

}
