
public abstract class Plano {
	protected String nome;	
	
	public Plano (String nome) {
		this.nome = nome;
	}
	
	public String getNome(String nome) {
		return nome;
	}
		
	public abstract int limiteCurtidas();

}
