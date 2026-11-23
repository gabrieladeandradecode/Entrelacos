
public class PlanoConexao extends Plano {
	public PlanoConexao(String nome) {
		super("Conexão");
	}

	public static final int LIMITE_CURTIDAS = 5;
	
	@Override
	public int limiteCurtidas() {
		return LIMITE_CURTIDAS;
	}
	
}
