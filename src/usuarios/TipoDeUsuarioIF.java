package usuarios;

import java.util.ArrayList;
import java.util.HashSet;
import jogo.Jogabilidade;
import jogo.Jogo;

public interface TipoDeUsuarioIF {

	public double getDesconto(Jogo jogo);

	public int compraJogo(Jogo jogo);

	public String imprimeDadosDoUsuario(String nome, ArrayList<Jogo> jogos);

	public int punir(HashSet<Jogabilidade> jogabilidades);

	public int recompensar(HashSet<Jogabilidade> jogabilidades);

}
