package exceptions;


public class UsuarioSemPontosRegistradosException extends Exception {

    private static final long serialVersionUID = 1L;

    public UsuarioSemPontosRegistradosException(String msg) {
		super(msg);
	}
}
