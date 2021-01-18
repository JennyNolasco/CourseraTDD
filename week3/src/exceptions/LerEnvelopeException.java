package exceptions;

public class LerEnvelopeException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public String toString(){
		return "Não foi possível receber o envelope.";
	}
}
