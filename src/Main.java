import java.util.List;
import java.util.Scanner;

public class Main {
	
	static Scanner entrada = new Scanner(System.in);
	
	
	public static void main(String[] args) {
	
	    int opcaoTela = -1;	    
	    
	    Cadastro cadastro = new Cadastro();
	
	    while (opcaoTela != 0) {
	
	    	opcaoTela = menuTelaInicial();
	
	        switch (opcaoTela) {
		        case 1 -> {
		        	
		        	try {
	                    cadastrar(cadastro);
	                    System.out.println("Perfil cadastrado!");
	
	                } catch (NegocioException e) {
	                    System.out.println(e.getMessage());
	                }
		        	
		        }
		        
	            case 2 -> {	   
	            	
	            	
                	
                	for (Perfil perfil: cadastro.listarPerfis()) {
                		System.out.println(perfil.getId() + " - "+ perfil.getNome());
                	}
                	
                	int id = lerInteiro("Digite o seu id de perfil: ");
                	Perfil usuarioSelecionado = cadastro.buscarPorId(id);
                	if (usuarioSelecionado == null) {
                		System.out.println("Perfil não encontrado.");
                		continue;
                	}
                	
                	menuUsuario(cadastro, usuarioSelecionado);	
	                
	            }
	
	            case 0 -> System.out.println("...Programa encerrado");
	
	            default -> System.out.println(
	                    "Entrada inválida! Digite uma opção dentre as apresentadas na tela inicial."
	            );
	        }
	    }
	
	    entrada.close();
	}
	
	
	private static int menuTelaInicial() {	
		System.out.println("""
                --- TELA INICIAL ---

                1. Cadastrar perfil 
                2. Entrar como usuário
                0. Sair
                """);
		
		return lerInteiro("Escolha uma opção: ");			
		
	}
	
	private static int menuPrincipal() {
		System.out.println("""
                --- MENU PRINCIPAL ---
                1. Listar perfis
                2. Pesquisar perfis por nome
                3. Pesquisar perfis por nome e cidade
                4. Curtir alguém
                5. Meus matches
                6. Conversar
                7. Meu perfil
                0. Trocar de usuário
                """);
		
		return lerInteiro("Escolha uma opção: ");
		
	}
	
	private static void menuUsuario(Cadastro cadastro, Perfil usuarioSelecionado) {
		int opcaoMenu = -1;
		
		while (opcaoMenu != 0) {		         
			System.out.println("\n Olá, " + usuarioSelecionado.getNome() + ".");
			
            opcaoMenu = menuPrincipal();

            switch (opcaoMenu) {

                case 1 -> {               	
                	
                	mostrarPerfis(cadastro.listarOutrosPerfis(usuarioSelecionado));                	
                	                	                	
                }
                
                case 2 -> {                	               	
                	
                    System.out.println("Digite o nome a ser pesquisado: ");
                    String pesquisaNome = entrada.nextLine().trim();
                    
                    mostrarPerfis(cadastro.pesquisar(pesquisaNome));
                }

                case 3 -> {
                	                	                	
                    System.out.println("Digite o nome a ser pesquisado: ");
                    String pesquisaNome = entrada.nextLine().trim();

                    System.out.println("Digite o nome da cidade a ser pesquisada: ");
                    String pesquisaCidade = entrada.nextLine().trim();
                    
                    
                    mostrarPerfis(cadastro.pesquisar(pesquisaNome, pesquisaCidade));
                }
                
                case 4 -> {
                	System.out.println("Curtir");
                	//curtirPerfil(Cadastro, usuarioSelecionado);
                }

                case 5 -> {
                    System.out.println("Matches");
                    // Implementar funcionalidade
                }
                
                case 6 -> {
                	System.out.println("Conversar");
                	conversar();
                }

                case 7 -> {
                    System.out.println(usuarioSelecionado);
                }

                case 0 -> System.out.println("Voltando à tela inicial...");

                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }
		
		
		
	}	
	
	private static void mostrarPerfis(List<Perfil> listaPerfis) {
		
		if (listaPerfis.isEmpty()){
    		System.out.println("Nenhum resultado.");
    		return;
    	} 
		
		System.out.println("""
                --- LISTA DE PERFIS ---
                """);
		
		for (Perfil perfil : listaPerfis) {
			System.out.println(perfil);
		}				
		
	}
	

	private static void curtirPerfil() {
		// TODO Auto-generated method stub
		
	}
	
	private static void conversar() {
		// TODO Auto-generated method stub
		
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
        String cidade = entrada.nextLine();	 	//!!conferir leitura de cidade só string, nao aceitar int                              

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
	    
	} 
	
	
	private static void escolherInteresses(Cadastro cadastro, Perfil perfil) {
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




