package mock;


import java.util.ArrayList;

import classes.ArmazenamentoI;
import classes.Usuario;
import exceptions.UsuarioJaCadastradoException;
import exceptions.UsuarioSemPontosDeUmTipoException;
import exceptions.UsuarioSemPontosRegistradosException;

public class ArmazenamentoMock implements ArmazenamentoI {
	private ArrayList<Usuario> usuarios;

	public ArmazenamentoMock() {
		this.usuarios = new ArrayList<Usuario>();
	}

	public void registrarNovoUsuario(Usuario user) throws UsuarioJaCadastradoException {
		if (usuarios.contains(user))
			return;
		else
			this.usuarios.add(user);
	}

	@Override
	public String retornarPontosPorUsuarioETipo(Usuario usuario, String tipo) throws UsuarioSemPontosDeUmTipoException {
		if(usuarios.contains(usuario))
			return "O usuario " + usuario.getNome() + " possui " + usuario.retornarQuantosPontosTemDeUmTipo(tipo) + " pontos do tipo " + tipo;
		return "Usuario nao contem pontos deste tipo";
	}
	
	@Override
	public String retornarTodosPontosPorUsuario(Usuario usuario) {
		if(usuarios.contains(usuario))
			return usuario.retornarTodosTiposEValores();
		return "usuario nao encontrado";
	}

	@Override
	public String retornarTodosTiposEValores() throws UsuarioSemPontosRegistradosException {
		String aux = "";
		for(int i = 0; i < usuarios.size(); i++) {
			Usuario usuario = usuarios.get(i);
			aux += usuario.getNome() + " possui " + usuario.retornarTodosTiposEValores() + " ";
		}
		return aux.trim();
	}

}
