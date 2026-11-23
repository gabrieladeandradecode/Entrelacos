
public class PlanoEssencial extends Plano {
	public PlanoEssencial(String nome) {
		super("Essencial");
	}

	public static final int LIMITE_CURTIDAS = 2;
	
	@Override
	public int limiteCurtidas() {
		return LIMITE_CURTIDAS;
	}
	
}
