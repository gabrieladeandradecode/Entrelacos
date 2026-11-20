import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cadastro {
	
	private List<Perfil> listaPerfis = new ArrayList<>();
    
	
	public boolean emailExistente(String email) {
		for (Perfil perfil: listaPerfis) {
			if (perfil.getEmail().equalsIgnoreCase(email)) {
				return true;
			}						
		}
		return false;		
	}
    																				//Interesse[] interesses
	public void cadastrar(String nome, String email, int idade, String cidade, Plano plano) throws NegocioException {		

		if (nome.trim().isEmpty()){                            
			throw new NegocioException("Nome não pode ser vazio!");
		}
		
		if (!Validacao.validacaoEmail(email)){
			throw new NegocioException("Email inválido!");
		}
		
		if (emailExistente(email)) {
			throw new NegocioException("Email não pode se repetir.");		// testar email depois de corrigir interesses
		}
		
		if (idade < 18) {
			throw new NegocioException("Idade mínima para se cadastrar é de 18 anos.");
	    }
		
		if (cidade.trim().isEmpty()){                            
			throw new NegocioException("Cidade não pode ser vazio!");
        }
		
        //System.out.println("0 = concluir interesses \nC = cancelar cadastro \nEnter = salvar perfil e entrar");

        //Perfil perfil = new Perfil(nome, email, idade, cidade, plano, interesses);

        //listaPerfis.add(perfil);
    }
	
	public void listarPerfis() {
		System.out.println("--- LISTA DE PERFIS ---");
		
		if (listaPerfis.isEmpty()) {
			System.out.println("Nenhum perfil cadastrado!\n");
			return;
		} 
		
		Collections.sort(listaPerfis, Comparator.comparing(Perfil::getNome));
		
		for (Perfil perfil: listaPerfis) {
			System.out.println(perfil);			
		}
				
	}
		
	
}
