
public abstract class Validacao {
    
	public void verificarIdade (int idade) {
		//String mensagem;
		
	}

	public static boolean validacaoEmail(String email) {
	
		if (email == null || email. trim() .isEmpty () ) {
			System. out.println ("Email nao pode ser vazio!");
			return false;
		}
		
		if (email.matches("^[\\w.+-]+@[\\w-]+(\\-[\\w-]+) +$") ) {
			System. out.println ("Email invalido!");
			return true;
		}
		return true;
    
	}
    	    	
    
}
