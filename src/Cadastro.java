import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cadastro {
	
	protected List<Perfil> listaPerfis = new ArrayList<>();
    
	protected List<Interesse> listaInteresses = new ArrayList<>();
	
	public static final int IDADE_MINIMA = 18;
	
	//public void adicionarInteresses - mas interesse tem que existir antes do cadstro
	
	public boolean emailExistente(String email) {
		for (Perfil perfil: listaPerfis) {
			if (perfil.getEmail().equalsIgnoreCase(email)) {
				return true;
			}						
		}
		return false;		
	}
    																				
	public void cadastrar(String nome, String email, int idade, String cidade, Plano plano, Interesse[] interesses) throws NegocioException {		

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
		
        //System.out.println("0 = concluir interesses \nC = cancelar cadastro \nEnter = salvar perfil e entrar");

        Perfil perfil = new Perfil(nome, email, idade, cidade, plano, interesses);

        //listaPerfis.add(perfil);
    }
	
	public boolean conferirListaVazia() {
		if (listaPerfis.isEmpty()) {
			System.out.println("Nenhum perfil cadastrado!\n");
			return true;
		}		
		
		return false;
	}
	/*
	 * Sem System.out.println na regra de negócio: Os métodos 
	 * listarPerfis() e pesquisar(...) estão imprimindo direto no 
	 * console. Para cumprir "Separe o menu das regras em classes", 
	 * o ideal é que esses métodos retornem uma List<Perfil> com os 
	 * resultados, e o Main (menu) faça o for para imprimir na tela 
	 * (ou avise que não encontrou ninguém).
	 * */ 
	
	public void listarPerfis() {
		System.out.println("--- LISTA DE PERFIS ---");
		if (conferirListaVazia()){
			return;
		}
				
		Collections.sort(listaPerfis, Comparator.comparing(Perfil::getNome));
		
		for (Perfil perfil: listaPerfis) {
			System.out.println(perfil);			
		}				
	}
	
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
	
	public void pesquisar(String nome, String cidade) {
		if (conferirListaVazia()){
			return;
		};
		
		for (Perfil perfil: listaPerfis) {
			if (perfil.getNome().equalsIgnoreCase(nome) && perfil.getCidade().equalsIgnoreCase(cidade)) {
				System.out.println(perfil);
			}						
		}
	}
		
	
}
