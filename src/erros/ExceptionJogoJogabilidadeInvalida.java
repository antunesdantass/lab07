/* 115110295 - Antunes Dantas da Silva: LAB 7 - Turma 1 */

package erros;

public class ExceptionJogoJogabilidadeInvalida extends ExceptionJogo {
	
	public ExceptionJogoJogabilidadeInvalida(){
		super("Jogabilidade invalida: nao pode ser null");
	}
	
	public ExceptionJogoJogabilidadeInvalida(String mensagem){
		super(mensagem);
	}
}
