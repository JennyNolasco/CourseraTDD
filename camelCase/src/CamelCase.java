import java.util.List;
import java.util.Arrays;

public class CamelCase{

	public static List<String> changingCamelCase(String original){
		if(!original.matches("(\\w)*"))
			throw new SpecialCharacterException("Caracteres especiais não são permitidos, somente letras e números");
		if(original.matches("^[0-9].*"))
			throw new StartWithNumberException("Não deve começar com números");
		return wordWrap(original);
	}

	private static String changingToLowecase(String palavra) {
		if(palavra.matches("^[A-Z][a-z].*"))
			palavra = palavra.substring(0,1).toLowerCase()+palavra.substring(1);
		return palavra;
	}

	private static List<String> wordWrap(String texto) {
		String palavras[] = texto.split("(?<!(^|[A-Z0-9]))(?=[A-Z0-9])|(?<!(^|[^A-Z]))(?=[0-9])|(?<!(^|[^0-9]))(?=[A-Za-z])|(?<!^)(?=[A-Z][a-z])");
		for(int i = 0; i < palavras.length; i++){
			palavras[i] = changingToLowecase(palavras[i]);
		}
		List<String> lista = Arrays.asList(palavras);
		return lista;
	}
	
}
	