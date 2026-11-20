
public class Interesse {
	
	private static String[] interesses = {
			"Música", "Cinema", "Esportes", "Tecnologia", "Leitura", "Culinária"
	};
	
	/*private Interesse() {
    }*/
	
	public static void exibirInteresses() {
		System.out.println("-- Catálogo de Interesses --");
		for (int c = 0; c <= interesses.length; c++) {
			System.out.println((c + 1) + " - " + interesses[c]);
		}
	}

}
