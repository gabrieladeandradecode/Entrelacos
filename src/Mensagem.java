
public class Mensagem {
	protected Perfil remetente;
	protected String texto;
	
	public Mensagem(Perfil remetente, String texto) {
		this.remetente = remetente;
		this.texto = texto;
	}
	
	public Perfil getRemetente() {
		return remetente;
	}
	
	public String getTexto() {
		return texto;
	}

	@Override
	public String toString() {
		return "Mensagem [remetente=" + remetente + ", texto=" + texto + "]";
	}
	
	

}
