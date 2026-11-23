
public class Interesse {
	
	protected String nomeDoInteresse;
		
	
	public Interesse(String nomeDoInteresse) {
		this.nomeDoInteresse = nomeDoInteresse;
	}
    
	public String getNomeDoInteresse() {
		return nomeDoInteresse;
	}
	
	protected static final Interesse[] CATALOGO_INTERESSES = {
			new Interesse("Música"),
			new Interesse("Cinema"),
			new Interesse("Leitura"),
			new Interesse("Esporte"),
			new Interesse("Tecnologia"),
			new Interesse("Culinária"),
			new Interesse("Jardinagem"),
			new Interesse("Religioso")			
	};
	
	@Override
	public String toString() {
    	return """                                
               - %s
               """.formatted(nomeDoInteresse);
    }
	
	
	
    
	
}
