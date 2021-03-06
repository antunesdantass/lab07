/* 115110295 - Antunes Dantas da Silva: LAB 7 - Turma 1 */

package usuarios;

import java.util.ArrayList;
import java.util.HashSet;
import jogo.Jogabilidade;
import jogo.Jogo;

public interface TipoDeUsuarioIF {

	public double getDesconto();

	public int compraJogo(double precoDoJogo);

	public String imprimeDadosDoUsuario(String nome, ArrayList<Jogo> jogos);

	public int punir(HashSet<Jogabilidade> jogabilidades);

	public int recompensar(HashSet<Jogabilidade> jogabilidades);

}
