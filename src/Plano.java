
public abstract class Plano {
	protected String nome;	
	
	public Plano (String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
		
	public abstract int limiteCurtidas();
	
	@Override
	public String toString() {
		return nome;
		
	}

}
