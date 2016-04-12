/* 115110295 - Antunes Dantas da Silva: LAB 7 - Turma 1 */

package erros;

public class ExceptionJogoNomeInvalido extends ExceptionJogo{
	public ExceptionJogoNomeInvalido (){
		super("Nome do jogo invalido: nao pode ser null ou vazio.");
	}
	
	public ExceptionJogoNomeInvalido (String mensagem){
		super(mensagem);
	}
}
