import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class Teste {
	ArrayList<String> entrada1, entrada2, entrada3, entrada4, entrada5, entrada6, entradaInvalida1, entradaInvalida2;
	
	@Before
	public void inicializaTestes(){
		entrada1 = new ArrayList<>();
		entrada2 = new ArrayList<>();
		entrada3 = new ArrayList<>();
		entrada4 = new ArrayList<>();
		entrada5 = new ArrayList<>();
		entrada6 = new ArrayList<>();
		entradaInvalida1 = new ArrayList<>();
		entradaInvalida2 = new ArrayList<>();
		entrada1.add("nome");
		entrada2.add("nome");
		entrada2.add("composto");
		entrada3.add("CPF");
		entrada4.add("numero");
		entrada4.add("CPF");
		entrada5.add("numero");
		entrada5.add("CPF");
		entrada5.add("contribuinte");
		entrada6.add("recupera");
		entrada6.add("10");
		entrada6.add("primeiros");
		entradaInvalida1.add("10");
		entradaInvalida1.add("primeiros");
		entradaInvalida2.add("nome");
		entradaInvalida2.add("#");
		entradaInvalida2.add("composto");
	}
	
	@Test
	public void entradaSimples(){
		assertArrayEquals(entrada1.toArray(),CamelCase.changingCamelCase("nome").toArray());
		assertArrayEquals(entrada1.toArray(),CamelCase.changingCamelCase("Nome").toArray());
		assertArrayEquals(entrada3.toArray(),CamelCase.changingCamelCase("CPF").toArray());
	}
	

	@Test
	public void entradaComposta(){
		assertArrayEquals(entrada2.toArray(),CamelCase.changingCamelCase("nomeComposto").toArray());
		assertArrayEquals(entrada2.toArray(),CamelCase.changingCamelCase("NomeComposto").toArray());
		assertArrayEquals(entrada4.toArray(),CamelCase.changingCamelCase("numeroCPF").toArray());
		assertArrayEquals(entrada5.toArray(),CamelCase.changingCamelCase("numeroCPFContribuinte").toArray());
		assertArrayEquals(entrada6.toArray(),CamelCase.changingCamelCase("recupera10Primeiros").toArray());
	}
	
	@Test(expected=SpecialCharacterException.class)
	public void specialCharacter(){
		assertArrayEquals(entradaInvalida2.toArray(), CamelCase.changingCamelCase("nome#Composto").toArray());
	}

	@Test(expected=StartWithNumberException.class)
	public void startWithNumber(){
		assertArrayEquals(entradaInvalida1.toArray(), CamelCase.changingCamelCase("10Primeiros").toArray());
	}
}
	