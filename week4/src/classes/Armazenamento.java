package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import exceptions.UsuarioSemPontosRegistradosException;

public class Armazenamento implements ArmazenamentoI {

	private ArrayList<Usuario> listaDeUsuarios;
	private String caminhoDoArquivo;

	public Armazenamento(String caminhoDoArquivo) throws Exception {
		this.caminhoDoArquivo = caminhoDoArquivo;
		this.listaDeUsuarios = new ArrayList<Usuario>();
		listaDeUsuarios = this.lerArquivo();
	}

	public ArrayList<Usuario> retornarUsuariosComPontos() {
		ArrayList<Usuario> listaDeUsuariosComPontos = new ArrayList<Usuario>();
		for (Usuario usuario : listaDeUsuarios) {
			if (usuario.temAlgumPonto())
				listaDeUsuariosComPontos.add(usuario);
		}
		return listaDeUsuariosComPontos;
	}

	private ArrayList<Usuario> lerArquivo() throws Exception {
		ArrayList<Usuario> _listaDeUsuarios = new ArrayList<Usuario>();
		BufferedReader buff = new BufferedReader(new FileReader(this.caminhoDoArquivo));
		String linha = "";
		Usuario _usuario = new Usuario("Jenny");
		while (true) {
			if (linha != null) {
				String palavras[] = linha.split(" ");
				if (palavras[0].equals("Usuario")) {
					_usuario = new Usuario(palavras[1]);
					_listaDeUsuarios.add(_usuario);
				} else if (palavras[0].equals("Pontos")) {
					_usuario.adicionarPontos(palavras[1], Integer.parseInt(palavras[2]));
					_listaDeUsuarios.remove(_listaDeUsuarios.indexOf(_usuario));
					_listaDeUsuarios.add(_usuario);
				}
			} else
				break;
			linha = buff.readLine();
		}
		buff.close();
		return _listaDeUsuarios;
	}

	public void registrarNovoUsuario(Usuario usuario) throws Exception {
		this.listaDeUsuarios.clear();
		this.listaDeUsuarios = this.lerArquivo();
		boolean usuarioExiste = false;
		for (int i = 0; i < listaDeUsuarios.size(); i++) {
			if (listaDeUsuarios.get(i).getNome().equalsIgnoreCase(usuario.getNome())) {
				usuarioExiste = true;
				listaDeUsuarios.set(i, usuario);
				break;
			}
		}
		if(!usuarioExiste) {
			this.listaDeUsuarios.add(usuario);
		}	
		
		this.armazernarUsuariosNoArquivo();
	}

	private void armazernarUsuariosNoArquivo() throws Exception {
		FileWriter writer = new FileWriter(this.caminhoDoArquivo, false);
		PrintWriter printer = new PrintWriter(writer);
		for (int i = 0; i < listaDeUsuarios.size(); i++) {
			Usuario usuario = listaDeUsuarios.get(i);
			printer.printf("Usuario ");
			printer.printf(usuario.getNome() + "%n");
			HashMap<String, Integer> pontos = usuario.getPontos();
			Set set = pontos.entrySet();
			Iterator iterator = set.iterator();
			while (iterator.hasNext()) {
				Map.Entry elemento = (Map.Entry) iterator.next();
				printer.printf("Pontos ");
				printer.printf(elemento.getKey().toString() + " ");
				printer.printf(pontos.get(elemento.getKey()) + "%n");
			}
		}
		writer.close();
	}
	@Override
	public String retornarPontosPorUsuarioETipo(Usuario usuario, String tipo) throws UsuarioSemPontosRegistradosException, Exception {
		if(listaDeUsuarios.contains(usuario))
			return "O usuario " + usuario.getNome() + " possui " + usuario.retornarQuantosPontosTemDeUmTipo(tipo) + " pontos do tipo " + tipo;
		return "Usuario nao contem pontos deste tipo";	
	}

	public void armazenarUsuario(Usuario usuario) {
		this.listaDeUsuarios.add(usuario);
	}

	public ArrayList<Usuario> getUsuarios() throws Exception {
		this.listaDeUsuarios = lerArquivo();
		return this.listaDeUsuarios;
	}

	@Override
	public String retornarTodosPontosPorUsuario(Usuario usuario) {
		if(listaDeUsuarios.contains(usuario))
			return usuario.retornarTodosTiposEValores();
		return "usuario nao encontrado";
	}

	@Override
	public String retornarTodosTiposEValores() throws UsuarioSemPontosRegistradosException, Exception{
		listaDeUsuarios.clear();
		listaDeUsuarios = this.lerArquivo();
		String aux = "";
		for(int i = 0; i < listaDeUsuarios.size(); i++) {
			Usuario usuario = listaDeUsuarios.get(i);
			if(usuario.temAlgumPonto()) {
				aux += usuario.getNome() + " possui " + usuario.retornarTodosTiposEValores() + " ";	
			}
		}
		return aux.trim();
	}
	
}