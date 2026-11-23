
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
    protected int quantidadeInteresse = 0;
    
    public Perfil(String nome, String email, int idade, String cidade, Plano plano){
    	contador++;
    	this.id = contador;
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
    	return interesses.clone();
    }
    
    public int getQtdInteresse() {
    	return quantidadeInteresse;
    }  
    
    public void adicionarInteresse(Interesse interesse) throws NegocioException {
    	
    	if (interesse == null) {
    		throw new NegocioException("Nenhum interesse escolhido.");
    	}
    	
    	if (quantidadeInteresse >= MAX_INTERESSES) {
			throw new NegocioException("Só pode escolher " + MAX_INTERESSES + " interesses.");
		}
    	
    	for (int i = 0; i < quantidadeInteresse; i++) {    		
    		
    		if (interesses[i].getNomeDoInteresse().equalsIgnoreCase(interesse.getNomeDoInteresse())) {
    			throw new NegocioException("Esse interesse já foi escolhido.");
    		}
    		
    	}    	
    			
		interesses[quantidadeInteresse] = interesse;
		quantidadeInteresse++;
    }
    
        
    @Override
    public String toString() {
    	String textoInteresse = "";
    	for (int i = 0; i < quantidadeInteresse; i++) {
    	    textoInteresse += " - " + interesses[i].getNomeDoInteresse() + "\n";	//tirar \n devido a quebra de linha?
    	}
    	
    	return """                
               --- PERFIL --- 
               Nome: %s
               Email: %s
               Idade: %d
               Cidade: %s
               Plano: %s
               Interesses: 
               %s
               --------------------""".formatted(nome, email, idade, cidade, plano, textoInteresse);    	
    		// 
    }
    
}   
