import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cadastro {
	
	public static final int IDADE_MINIMA = 18;
	
	protected List<Perfil> listaPerfis = new ArrayList<>();
	
	protected List<Curtida> curtidas = new ArrayList<>();
	
	protected List<Match> matches = new ArrayList<>();
		
		
	public boolean emailExistente(String email) {
		for (Perfil perfil: listaPerfis) {
			if (perfil.getEmail().equalsIgnoreCase(email)) {
				return true;
			}						
		}
		return false;		
	}
	
    																				
	public Perfil cadastrar(String nome, String email, int idade, String cidade, Plano plano) throws NegocioException {		

		if (nome == null || nome.trim().isEmpty()){                            
			throw new NegocioException("Nome não pode ser vazio!");
		}
		
		if (!ValidacaoEmail.validacaoEmail(email)){
			throw new NegocioException("Email inválido! Exemplo de email válido: nome@gmail.com");
		}
		
		if (emailExistente(email)) {
			throw new NegocioException("Esse email já existe.");
		}
		
		if (idade < IDADE_MINIMA) {
			throw new NegocioException("Idade mínima para se cadastrar é de " + IDADE_MINIMA + ".");
	    }
		
		if (cidade == null || cidade.trim().isEmpty()){                            
			throw new NegocioException("Cidade não pode ser vazia!");
        }				         

        Perfil perfil = new Perfil(nome, email, idade, cidade, plano);        
                        
        listaPerfis.add(perfil);
        return perfil;
    }
	
	
	public void adicionarInteressePerfil(Perfil perfil, Interesse interesse) throws NegocioException {
		perfil.adicionarInteresse(interesse);
	}
	
	
	public Perfil buscarPorId(int id) {
		for (Perfil perfil: listaPerfis) {
			if (perfil.getId() == id) {
				return perfil;
			}						
		}
		return null;
	}
	
	
	public boolean conferirListaVazia() {		
		return listaPerfis == null || listaPerfis.isEmpty();
	}
	
	
	public List<Perfil> listarPerfis() {	// para todos usuários inclusive o selecionado
				
		if (conferirListaVazia()){
			return Collections.emptyList();
		}
		
		List<Perfil> copiaListaPerfis = new ArrayList<>(listaPerfis);
				
		Collections.sort(copiaListaPerfis, Comparator.comparing(Perfil::getNome, String.CASE_INSENSITIVE_ORDER));
				
		return copiaListaPerfis;			
						
	}
	
	public List<Perfil> listarOutrosPerfis(Perfil usuario){	
				
		List<Perfil> copiaListaOutrosPerfis = new ArrayList<>(listaPerfis);
		
		copiaListaOutrosPerfis.removeIf(perfil -> perfil.getId() == usuario.getId());
		
		Collections.sort(copiaListaOutrosPerfis, Comparator.comparing(Perfil::getNome, String.CASE_INSENSITIVE_ORDER));				
		
		return copiaListaOutrosPerfis;
		
	}
	
	
	public List<Perfil> pesquisar(String nome) {			
		
		List<Perfil> listaNomes = new ArrayList<>();
		
		for (Perfil perfil: listaPerfis) {
			if (perfil.getNome().equalsIgnoreCase(nome)) {
				listaNomes.add(perfil);
			}						
		}
		
		return listaNomes;
	}
	
	
	public List<Perfil> pesquisar(String nome, String cidade) {
		
		List<Perfil> listaNomesCidades = new ArrayList<>();
				
		for (Perfil perfil: listaPerfis) {
			if (perfil.getNome().equalsIgnoreCase(nome) && perfil.getCidade().equalsIgnoreCase(cidade)) {
				listaNomesCidades.add(perfil);
			}						
		}
		
		return listaNomesCidades;
	}
	
	
	
	public boolean curtir(Perfil origem, Perfil destino) throws NegocioException {
		if (origem.getId() == destino.getId()) {
			throw new NegocioException("Não pode curtir a si mesmo.");
		}		
		
		if (jaCurtiu(origem, destino)) {
			throw new NegocioException("Já curtiu essa pessoa.");
		}
		
		if(contarCurtidas(origem) >= origem.getPlano().limiteCurtidas()) {
			throw new NegocioException("Atingiu o limite de curtidas do plano escolhido: " + origem.getPlano().limiteCurtidas());
		}										//pôr nome? origem.getPlano().getNome() - consertar classe Plano nome 
		
		Curtida curtida = new Curtida(origem, destino);
		
		curtidas.add(curtida);
		
		if ((jaCurtiu(destino, origem)) && (!existeMatch(origem, destino))) {
			criarMatch(origem, destino);
			return true;
		}
		
		return false;
				
						
	}
	
	private boolean jaCurtiu(Perfil origem, Perfil destino) {
		for (Curtida curtida: curtidas) {
			if (curtida.getOrigem().getId() == origem.getId() &&  curtida.getDestino().getId() == destino.getId()) {
				return true;
			}
			
		}
		
		return false;
		
	}
	
	
	private int contarCurtidas(Perfil origem) {
		int quantidade = 0;
		for (Curtida curtida: curtidas) {
			if (curtida.getOrigem().getId() == origem.getId()) {
				quantidade++;
			}
		}
		return quantidade;
	}
	
	public List<Match> listarMatches(Perfil usuario) {
		List<Match> listaMatchesDoUsuario = new ArrayList<>();
		
		for (Match match: matches) {
			if (match.envolve(usuario)) {
				listaMatchesDoUsuario.add(match);
			}
			
			
		}
		
		return listaMatchesDoUsuario;
		
	}		
			
	
	private void criarMatch(Perfil p1, Perfil p2) {
		Match match = new Match(p1, p2);
		
		matches.add(match);
		
	}
	
	private boolean existeMatch(Perfil p1, Perfil p2) {
		
		for(Match match: matches) {			
			if (match.envolve(p2) && match.envolve(p1)) {
				return true;
			}						
			
		}
		
		return false;
	}
	
	private Match buscarMatch(Perfil p1, Perfil p2) {
				
		for (Match match: matches) {
			if (match.envolve(p1) && match.envolve(p2)) {
				return match;
			}			
		}
		
		return null;
	}
	
	
	
	public void enviarMensagem(Perfil remetente, Perfil destinatario, String texto) throws NegocioException {
		
		if (remetente.getId() == destinatario.getId()) {
			throw new NegocioException("Não pode enviar mensagem para si mesmo.");
		}
		
		if (texto == null || texto.trim().isEmpty()) {
			throw new NegocioException("Texto não pode ser vazio!");
		}
		
		Match matchCheck = buscarMatch(remetente, destinatario);
		
		if(matchCheck == null) {
			throw new NegocioException("Não há match entre vocês para iniciar conversa.");
		}
		
		Mensagem mensagem = new Mensagem(remetente, texto);
		
		matchCheck.adicionarMensagem(mensagem);
			
	}
	
	
	public List<Mensagem> listarMensagens(Perfil p1, Perfil p2) {
		
		Match matchMensagem = buscarMatch(p1, p2);
		
		if (matchMensagem == null) {
			return Collections.emptyList();
		} 
		
		return matchMensagem.getMensagens();	
	
		
	}
		
	
}
