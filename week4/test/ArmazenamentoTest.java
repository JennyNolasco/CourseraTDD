import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import classes.Armazenamento;
import classes.Usuario;
import exceptions.UsuarioJaCadastradoException;

public class ArmazenamentoTest {

	private Armazenamento armazenamento;
	private ArrayList<Usuario> usuarios;
	private String caminhoarquivo;

	@Before
	public void setUp() throws Exception {
		caminhoarquivo = "test/fileTestArmazenamento.txt";
		armazenamento = new Armazenamento(caminhoarquivo);
	}

	@Test
	public void testLeitura() throws Exception {
		usuarios = armazenamento.getUsuarios();
		assertEquals("Jenny", usuarios.get(0).getNome());
		assertEquals("Ferreira", usuarios.get(1).getNome());
		assertEquals("Iris", usuarios.get(2).getNome());
	}

	@Test
	public void armazenarNovoUsuarioTestSucesso() throws Exception {
		Usuario usuario = new Usuario("UsuarioTest");
		usuario.adicionarPontos("moeda", 600);
		armazenamento.registrarNovoUsuario(usuario);
		usuarios = armazenamento.getUsuarios();
		assertEquals("UsuarioTest", usuarios.get(4).getNome());
	}
	
	@Test
	public void adicionarPontosUsuarioTestSucesso() throws UsuarioJaCadastradoException, Exception {
		Usuario usuario = new Usuario("Jeferson");
		usuario.adicionarPontos("estrela", 100);
		usuario.adicionarPontos("moeda", 200);
		armazenamento.registrarNovoUsuario(usuario);
		assertEquals("O usuario Jeferson possui 100 pontos do tipo estrela", armazenamento.retornarPontosPorUsuarioETipo(usuario, "estrela"));
		assertEquals("O usuario Jeferson possui 200 pontos do tipo moeda", armazenamento.retornarPontosPorUsuarioETipo(usuario, "moeda"));
	}
	
	@Test
	public void recuperaPontosEstrelaUsuarioTestSucesso() throws Exception {
		usuarios = armazenamento.getUsuarios();
		usuarios.get(0).adicionarPontos("estrela", 100);
		armazenamento.armazenarUsuario(usuarios.get(0));
		assertEquals("O usuario Jenny possui 200 pontos do tipo estrela", armazenamento.retornarPontosPorUsuarioETipo(usuarios.get(0), "estrela"));
	}
	
	@Test
	public void recuperaPontosMoedaUsuarioTestSucesso() throws Exception {
		usuarios = armazenamento.getUsuarios();
		usuarios.get(0).adicionarPontos("moeda", 200);
		armazenamento.armazenarUsuario(usuarios.get(0));
		assertEquals("O usuario Jenny possui 400 pontos do tipo moeda", armazenamento.retornarPontosPorUsuarioETipo(usuarios.get(0), "moeda"));
	}
	
}
