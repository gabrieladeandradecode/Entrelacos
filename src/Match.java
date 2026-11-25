import java.util.ArrayList;
import java.util.List;

public class Match {
	protected Perfil usuario1;
	protected Perfil usuario2;
	protected List<Mensagem> mensagens;
	
	public Match (Perfil usuario1, Perfil usuario2) {
		this.usuario1 = usuario1;
		this.usuario2 = usuario2;
		this.mensagens = new ArrayList<>();
	}
	
	public Perfil getUsuario1() {
		return usuario1;
	}

	public Perfil getUsuario2() {
		return usuario2;
	}
		
	public boolean envolve(Perfil usuario) { //ajuda a checar se o usuário pertence ao match antes de permitir a conversa
		if (usuario.getId() == this.usuario1.getId() || usuario.getId() == this.usuario2.getId()) {
			return true;		
		}								
				
		return false;
		
	}
	
	public void adicionarMensagem(Mensagem mensagem) {
		mensagens.add(mensagem);
		
	}
	
	public List<Mensagem> getMensagens() {
		return mensagens;
	}
	
	public Perfil parMatch(Perfil usuario) {	// Main usa esse método para escrever "Match com nome" na lista de matches 
		if (usuario.getId() == usuario1.getId()) {
			return usuario2;
		} else {
			return usuario1;
		}
		
	}
	
}
