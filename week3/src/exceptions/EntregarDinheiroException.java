package exceptions;

public class EntregarDinheiroException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public String toString(){
		return "Não foi possível entregar o dinheiro.";
	}
}
