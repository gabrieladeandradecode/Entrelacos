import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cadastro {
	
	protected List<Perfil> listaPerfis = new ArrayList<>();
	
	protected List<Curtida> curtidas = new ArrayList<>();
	
	protected List<Match> matches = new ArrayList<>();
	
	public static final int IDADE_MINIMA = 18;
		
	boolean listaVazia = false;
	
	
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
	
	public List<Perfil> listarOutrosPerfis(Perfil perfilId){	
				
		List<Perfil> copiaListaOutrosPerfis = new ArrayList<>(listaPerfis);
		
		copiaListaOutrosPerfis.removeIf(perfil -> perfil.getId() == perfilId.getId());
		
		Collections.sort(copiaListaOutrosPerfis, Comparator.comparing(Perfil::getNome, String.CASE_INSENSITIVE_ORDER));				
		
		return copiaListaOutrosPerfis;
		
	}
	
	
	public List<Perfil> pesquisar(String nome) {
				
		if (conferirListaVazia()){
			return Collections.emptyList();
		};
		
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
		
		if (conferirListaVazia()){
			return Collections.emptyList();
		};
		
		for (Perfil perfil: listaPerfis) {
			if (perfil.getNome().equalsIgnoreCase(nome) && perfil.getCidade().equalsIgnoreCase(cidade)) {
				listaNomesCidades.add(perfil);
			}						
		}
		
		return listaNomesCidades;
	}
	
	
	
	public void curtir(Perfil origem, Perfil destino) throws NegocioException {
		if (origem.id == destino.id) {
			throw new NegocioException("Não pode curtir a si mesmo.");
		}		
				
	}
	
	private boolean conferirCurtida(Perfil origem, Perfil destino) {
		for (Curtida curtidaRepetida: curtidas) {
			if (curtidaRepetida.id == .id) verificar duplicidade
			return true;
		}
		return false;
		
	}
	
	private int contarCurtidas(Perfil origem) {
		int quantidade = 0;
		for (Curtida curtida: curtidas) {
			if (curtida.origem == origem) {
				quantidade++;
			}
		}
		return quantidade;
	}
	
	/*public listarMatches() {
		
	}
	
	public enviarMensagem() {
		
	}
	
	public listarMensagens() {
		
	}*/
		
	
}
