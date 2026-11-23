
public class Perfil {
	public static final int MAX_INTERESSES = 3;
	protected static int contador = 0;
	protected int id;
	protected String nome;
	protected String email;
	protected int idade;
    protected String cidade;
    protected Plano plano;    
    protected Interesse[] interesses = new Interesse[MAX_INTERESSES];   
    protected int quantidadeInteresses = 0;
    
    public Perfil(String nome, String email, int idade, String cidade, Plano plano){
        this.id = contador++;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.cidade = cidade;
        this.plano = plano;
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
