
public class Curtida {
	protected Perfil origem;
	protected Perfil destino;
	
	public Curtida (Perfil origem, Perfil destino) {
		this.origem = origem;
		this.destino = destino;
	}
	
	public Perfil getOrigem() {
		return origem;
	}
	
	public Perfil getDestino() {
		return destino;
	}
	
}
