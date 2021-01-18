package classes;

import exceptions.UsuarioSemPontosRegistradosException;

public interface ArmazenamentoI {
	public String retornarPontosPorUsuarioETipo(Usuario usuario, String tipo) throws UsuarioSemPontosRegistradosException, Exception;
	public String retornarTodosPontosPorUsuario(Usuario usuario);
	public void registrarNovoUsuario(Usuario user) throws Exception;
	public String retornarTodosTiposEValores() throws UsuarioSemPontosRegistradosException, Exception;
}
