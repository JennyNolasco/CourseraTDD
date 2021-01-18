package classes;

import exceptions.UsuarioJaCadastradoException;
import exceptions.UsuarioSemPontosRegistradosException;

public class Placar {
	private ArmazenamentoI armazenamento;
	public Placar(ArmazenamentoI armazenamento) {
		this.armazenamento = armazenamento;
	}

	public String registrarPontos(Usuario usuario, int quantidade, String tipoponto) throws UsuarioJaCadastradoException, Exception {
		usuario.adicionarPontos(tipoponto, quantidade);
		armazenamento.registrarNovoUsuario(usuario);
		return "Usuario " + usuario.getNome() + " recebeu " + quantidade + " pontos do tipo " + tipoponto;
	}

	public String retornarPontosPorUsuario(Usuario usuario) {
		return "O usuario " + usuario.getNome() + " possui " + armazenamento.retornarTodosPontosPorUsuario(usuario);
	}

	public String retornarRanking() throws UsuarioSemPontosRegistradosException, Exception {
		return armazenamento.retornarTodosTiposEValores();
	}

	public void registrarNovoUsuarioNoPlacar(Usuario usuario) throws UsuarioJaCadastradoException, Exception {
		this.armazenamento.registrarNovoUsuario(usuario);
	}
}
