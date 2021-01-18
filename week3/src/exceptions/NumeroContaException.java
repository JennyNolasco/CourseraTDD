package exceptions;

public class NumeroContaException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public String toString(){
		return "Número de conta inválido.";
	}
}
