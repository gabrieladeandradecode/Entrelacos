
public abstract class ValidacaoEmail {    

	public static boolean validacaoEmail(String email) {
	
		if (email == null || email.trim().isEmpty () ) {
			return false;
		}
		
		if (!email.matches("^[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+$")){
			return false;
		}
		
		return true;
    
	}
    
}
