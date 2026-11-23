import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {		
						
		int opcaoTela = 0;        
        
		Cadastro cadastro = new Cadastro();
                        
        while (opcaoTela != 3){
        	System.out.println("""
        			--- TELA INICIAL ---
        			1. Usuário existente
        			2. Cadastrar usuário
        			3. Sair
        			""");
        	
            opcaoTela = lerInteiro("Escolha uma opção: ");
            
            switch (opcaoTela){
                case 1:
                	int opcaoMenu = 0;
                	
                    while (opcaoMenu != 6){
                    	System.out.println("""
                    			--- MENU PRINCIPAL ---
                    			1. Listar perfis
                    			2. Pesquisar perfis por nome
                    			3. Pesquisar perfis por nome e cidade
                    			4. Matches e conversas
                    			5. Meu perfil
                    			6. Voltar à tela inicial
                    			Escolha uma opção: 
                    			""");
                    	
                    	opcaoMenu = lerInteiro("Escolha uma opção: ");                    		            
                        
                        switch (opcaoMenu) {                        	
                        	case 1:  
                        		cadastro.listarPerfis();
                        		break;
                        	case 2:                        		
                        		System.out.println("Digite o nome a ser pesquisado: ");
                        		String pesquisaNome = entrada.nextLine();
                        		System.out.println("""
                            			--- LISTA DE PERFIS ---
                            			
                            			
                            			""");
                        		
                        		cadastro.pesquisar(pesquisaNome);                        		
                        		break;
                        	case 3:
                        		System.out.println("Digite o nome a ser pesquisado: ");
                        		String pesquisasNome = entrada.nextLine();
                        		
                        		System.out.println("Digite o nome da cidade a ser pesquisada: ");                        		
                        		String pesquisasCidade = entrada.nextLine();
                        		System.out.println("""
                            			--- LISTA DE PERFIS ---
                            			
                            			
                            			""");
                        		
                        		//cadastro.pesquisar(pesquisasNome, pesquisasCidade);   
                        		break;                        		
                        	case 6:
                        		break;
                        		
                        	default:
                        		System.out.println("Entrada inválida! Digite novamente uma opção dentre as apresentadas na Menu Inicial.");
                        }
                    }
                    break;
                    
                case 2:
					try {
						cadastrar(cadastro);
						System.out.println("Perfil cadastrado!");
					} catch (NegocioException e) {
						System.out.println(e.getMessage());
					}
                	/*try {
                		
                	} catch () {
                		
                	}*/
                	
                    break;
                case 3:
                    System.out.println("...Programa encerrado");
                    break;
                default:
                    System.out.println("Entrada inválida! Digite novamente uma opção dentre as apresentadas na Tela Inicial.");

            }   

        }		
		
		
        entrada.close();
	}
	
	private static int lerInteiro(String mensagem) {
		boolean invalido = true; 
		int inteiro = 0;
		while (invalido) {
        	System.out.println(mensagem);
    	    String textoDigitado = entrada.nextLine();    	    
    	    try {
    	    	inteiro = Integer.parseInt(textoDigitado.trim());
    	    	invalido = false; 
    	    } catch (NumberFormatException e) {
    	    	System.out.println("Entrada inválida! Digite números.");    	    	
    	    }    	    	    
        }
		return inteiro;		
	}
		
	private static void cadastrar(Cadastro cadastro) throws NegocioException {		  
	    
		System.out.println("TELA DE CADASTRO");   
	    
	    System.out.println("Nome: ");
	    String nome = entrada.nextLine();        	    
            
        System.out.println("E-mail: ");
        String email = entrada.nextLine();     
        
	    int idade = lerInteiro("Idade (mínimo 18): ");   
	    
        System.out.println("Cidade: ");
        String cidade = entrada.nextLine();	                               

	    System.out.println("""
    			Plano
    			1. Essencial
    			2. Conexão    			
    			""");
	    int opcaoPlano = lerInteiro("Escolha o plano e digite 1 ou 2:");
	    
	    while (opcaoPlano != 1 && opcaoPlano != 2) {
	    	opcaoPlano = lerInteiro("Digite 1 ou 2!");
	    }
	    
	    Plano plano ;
	    if (opcaoPlano == 1) {
	    	plano = new PlanoEssencial("Essencial");
	    } else {
	    	plano = new PlanoConexao("Conexão");
	    }	    
	   
	    Perfil perfil = cadastro.cadastrar(nome, email, idade, cidade, plano);
	    	    
	    escolherInteresses(cadastro, perfil);
	    
	} // fechamento do método cadastrar()
	
	public static void escolherInteresses(Cadastro cadastro, Perfil perfil) {
		int numero = -1;				
		
		while (perfil.getQtdInteresse() < Perfil.MAX_INTERESSES && numero != 0) {
			System.out.println("Número do interesse: ");
			
			for(int i = 0; i < Interesse.quantidadeInteresseCatalogo(); i++) {
				System.out.println((i+1) + " - " + Interesse.getInteresse(i));
			}
			
			numero = lerInteiro("Digite 0 para terminar.");
			
			if(numero >= 1 && numero <= Interesse.quantidadeInteresseCatalogo()) {
				try {
					cadastro.adicionarInteressePerfil(perfil, Interesse.getInteresse(numero - 1));
				} catch (NegocioException e) {
					System.out.println(e.getMessage());
				}				
			} else if (numero != 0) {
				System.out.println("Entrada inválida!");
			}			
						
		}
				
	}
	  	    
	        		
}	 // fechamento do Main()




