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
            
        	try {
        		System.out.println("Escolha uma opção: ");
                opcaoTela = entrada.nextInt();
        	} catch (InputMismatchException e) {
        		System.out.println("Entrada inválida! Digite apenas números.");
        		entrada.nextLine();
        		continue;
        	}            
        	entrada.nextLine();
            
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
                    	try {
                    		System.out.println("Escolha uma opção: ");
                    		opcaoMenu = entrada.nextInt();
                    		entrada.nextLine();
                    	} catch (InputMismatchException e) {
                    		System.out.println("Entrada inválida! Digite apenas números.");
                    		entrada.nextLine();
                    		continue;
                    	}                      
                        
                        switch (opcaoMenu) {                        	
                        	case 1:  
                        		cadastro.listarPerfis();
                        		break;
                        	case 2:                        		
                        		System.out.println("Digite o nome a ser pesquisado: ");
                        		String pesquisaNome = entrada.nextLine();
                        		System.out.println("--- LISTA DE PERFIS ---");
                        		
                        		cadastro.pesquisar(pesquisaNome);                        		
                        		break;
                        	case 3:
                        		System.out.println("Digite o nome a ser pesquisado: ");
                        		String pesquisasNome = entrada.nextLine();
                        		
                        		System.out.println("Digite o nome da cidade a ser pesquisada: ");                        		
                        		String pesquisasCidade = entrada.nextLine();
                        		System.out.println("--- LISTA DE PERFIS ---");
                        		
                        		cadastro.pesquisar(pesquisasNome, pesquisasCidade);   
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
	
	private static void cadastrar(Cadastro cadastro) throws NegocioException {
		int idade = 0;
        boolean idadeString = true; 	    
	    
		System.out.println("TELA DE CADASTRO");   
	    
	    System.out.println("Nome: ");
	    String nome = entrada.nextLine();        	    
            
        System.out.println("E-mail: ");
        String email = entrada.nextLine();       
                
        while (idadeString) {
        	System.out.println("Idade (mínimo 18): ");
    	    String idadeDigitada = entrada.nextLine();    	    
    	    try {
    	    	idade = Integer.parseInt(idadeDigitada);
    	    	idadeString = false;    	    	
    	    } catch (NumberFormatException e) {
    	    	System.out.println("Entrada inválida! Digite números.");    	    	
    	    }    	
        }    
	    
        System.out.println("Cidade: ");
        String cidade = entrada.nextLine();	                               

	    System.out.println("""
    			Plano
    			1. Essencial
    			2. Conexão
    			Escolha o plano e digite 1 ou 2:
    			""");
	    int opcaoPlano = entrada.nextInt();
	    entrada.nextLine();
	    
	    while (opcaoPlano != 1 && opcaoPlano != 2) {	    	// conferir espaços em brancos tambem 
	    	System.out.println("Digite 1 ou 2!");
	    	opcaoPlano = entrada.nextInt();
	    	entrada.nextLine();
	    }
	    
	    Plano plano ;
	    if (opcaoPlano == 1) {
	    	plano = new PlanoEssencial();
	    } else {
	    	plano = new PlanoConexao();
	    }

	    System.out.println("Interesses (até 3): "); //\nCaso seja menor que 3, digite 0 para finalizar?
	    
	    
	    //int[] interesses = new int[3];						// usar exception para tratar array?
	    
	    for (int i = 0; i < CATA; i++){
	        System.out.println("Número do interesse: ");
	        interesses[i] = entrada.nextInt();
	        /*interesse = entrada.nextInt();
	        for (int j = 0; i < )
	        if ()	    
	         */
	    }
	   
	    cadastro.cadastrar(nome, email, idade, cidade, plano);
	  //?System.out.println("0 = concluir interesses \nC = cancelar cadastro \nEnter = salvar perfil e entrar");
	    
	} // fechamento do método cadastrar()
	  	    
	        		
}	 // fechamento do Main()




