
public class Mensagem {
	int id;
	private Perfil remetente;
	private String texto;
	
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

}
