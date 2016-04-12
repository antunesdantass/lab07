/* 115110295 - Antunes Dantas da Silva: LAB 6 - Turma 1 */

package erros;

public class ExceptionJogoScoreInvalido extends ExceptionJogo {
	
	public ExceptionJogoScoreInvalido(){
		super("O score nao pode ser menor que 0 ou maior que 100.000.");
	}
	
	public ExceptionJogoScoreInvalido(String mensagem){
		super(mensagem);
	}
}
