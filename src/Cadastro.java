import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cadastro {
	
	protected List<Perfil> listaPerfis = new ArrayList<>();
    
	//protected List<Interesse> listaInteresses = new ArrayList<>();
	
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
    																				
	public void cadastrar(String nome, String email, int idade, String cidade, Plano plano) throws NegocioException {		

		if (nome == null || nome.trim().isEmpty()){                            
			throw new NegocioException("Nome não pode ser vazio!");
		}
		
		if (!Validacao.validacaoEmail(email)){
			throw new NegocioException("Email inválido!");
		}
		
		if (emailExistente(email)) {
			throw new NegocioException("Email não pode se repetir.");		// testar email depois de corrigir interesses
		}
		
		if (idade < IDADE_MINIMA) {
			throw new NegocioException("Idade mínima para se cadastrar é de 18 anos.");
	    }
		
		if (cidade == null || cidade.trim().isEmpty()){                            
			throw new NegocioException("Cidade não pode ser vazio!");
        }				         

        Perfil perfil = new Perfil(nome, email, idade, cidade, plano);
        
        //interesses
        
        //perfil.adicionarInteresse(Interesse[] interesse);
        
        	//listaPerfis.add(perfil);
    }
	
	public boolean conferirListaVazia() {		
		return listaPerfis.isEmpty();
	}
	
	/*
	 * Sem System.out.println na regra de negócio: Os métodos 
	 * listarPerfis() e pesquisar(...) estão imprimindo direto no console. Para cumprir "Separe o menu das regras em classes", 
	 * o ideal é que esses métodos retornem uma List<Perfil> com os 
	 * resultados, e o Main (menu) faça o for para imprimir na tela 
	 * (ou avise que não encontrou ninguém).
	 * */ 
	
	public void listarPerfis() {
		
		if (conferirListaVazia()){
			return;
		}
				
		Collections.sort(listaPerfis, Comparator.comparing(Perfil::getNome));
		
		for (Perfil perfil: listaPerfis) {
			System.out.println(perfil);			
		}				
	}
	
	/*public List<Perfil> listarPerfis(){
	 * return perfil;
	 * 
	 * 
	 */
	
	public void pesquisar(String nome) {
		if (conferirListaVazia()){
			return;
		};
		
		for (Perfil perfil: listaPerfis) {
			if (perfil.getNome().equalsIgnoreCase(nome)) {
				System.out.println(perfil);
			}						
		}
	}
	
	public Perfil pesquisar(String nome, String cidade) {
		if (conferirListaVazia()){
			return;
		};
		
		for (Perfil perfil: listaPerfis) {
			if (perfil.getNome().equalsIgnoreCase(nome) && perfil.getCidade().equalsIgnoreCase(cidade)) {
				return perfil;
			}						
		}
	}
	
	
	
	/*public void curtir(Perfil origem, Perfil destino) throws NegocioException {
		if (origem.id == destino.id) {
			throw new NegocioException("Não pode curtir a si mesmo.");
		}
			
				
	}
	
	private boolean conferirCurtida(Perfil origem, Perfil destino) {
		for (Curtida curtida: curtidas) {
			// if (curtidaRepetida.id == .id) verificar duplicidade
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
	
	public listarMatches() {
		
	}
	
	public enviarMensagem() {
		
	}
	
	public listarMensagens() {
		
	}*/*/
		
	
}
