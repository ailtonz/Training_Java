import java.util.ArrayList;
import java.util.Collections;

public class OrdenaStrings {
	public static void main(String[] args) {
		ArrayList<String> palavras = new ArrayList<String>();
		
		palavras.add("aula online");
		palavras.add("editora casa");
		palavras.add("caelum");
		
		
		Collections.sort(palavras);
		System.out.println(palavras);

		palavras.remove(0);
		
		System.out.println(palavras);

		
		
		
		palavras.forEach(palavra -> {
			System.out.println("Palavra:");
			System.out.println(palavra);
		});
		
		
	}
}

