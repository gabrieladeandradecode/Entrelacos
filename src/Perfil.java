
public class Perfil {
    private static int contador = 0;
    private int id;
    private String nome;
    private String email;
    private int idade;
    private String cidade;
    private Plano plano;
    public static final int MAX_INTERESSES = 3;
    private Interesse[] interesses = new Interesse[MAX_INTERESSES];   
    private int quantidadeInteresses;
    
    public Perfil(String nome, String email, int idade, String cidade, Plano plano, Interesse[] interesses){
        //this.id = contador++;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.cidade = cidade;
        this.plano = plano;
        this.interesses = interesses;
    }
    
    public int getId() {
    	return id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getEmail(){
        return email;
    }
    
    public int getIdade(){
        return idade;
    }
    
    public String getCidade(){
        return cidade;
    }
    
    public Plano getPlano(){
        return plano;				
    }
    
    public Interesse[] getInteresses() {
    	return interesses;
    }
    
    public void adicionarInteresse(Interesse[] interesses) {
    	for (int i = 0; i < MAX_INTERESSES && i < interesses.length; i++) {
    		this.interesses[i] = interesses[i]; 
    	}
    	
    	//3 posições verificando duplicidade.
    }
    
    @Override
    public String toString() {
    	return """                
                --- PERFIL --- 
               Nome: %s
               Email: %s
               Idade: %d
               Cidade: %s
               Plano: %s
               --------------------""".formatted(nome, email, idade, cidade, plano);
    }
    
}   
