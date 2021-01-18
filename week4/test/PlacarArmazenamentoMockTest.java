import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classes.Placar;
import classes.Usuario;
import mock.ArmazenamentoMock;
import exceptions.*;

public class PlacarArmazenamentoMockTest {

	private Placar placar;
	private Usuario usuario1;
	private Usuario usuario2;
	
	@Before
	public void setUp() throws UsuarioJaCadastradoException {
		ArmazenamentoMock armazenamentomock = new ArmazenamentoMock();
		usuario1 = new Usuario("guerra");
		usuario2 = new Usuario("Ferreira");
		armazenamentomock.registrarNovoUsuario(usuario1);
		armazenamentomock.registrarNovoUsuario(usuario2);
		placar = new Placar(armazenamentomock);
	}
	
	@Test
	public void registrarPontosTestSucesso() throws UsuarioJaCadastradoException, Exception {
		int quantidade = 10;
		String tipoponto = "estrela";
		assertEquals("Usuario guerra recebeu 10 pontos do tipo estrela", placar.registrarPontos(usuario1, quantidade, tipoponto));
	}
	
	@Test
	public void retornarPontosUsuarioTestSucesso() throws UsuarioJaCadastradoException, Exception {
		int quantidade = 10;
		String tipoponto = "estrela";
		placar.registrarPontos(usuario1, quantidade, tipoponto);
		assertEquals("O usuario guerra possui 10 pontos do tipo estrela", placar.retornarPontosPorUsuario(usuario1));
	}
	
	@Test
	public void retornaRankingTestSucesso() throws UsuarioJaCadastradoException, Exception {
		int quantidade = 20;
		String tipoponto = "estrela";
		placar.registrarPontos(usuario2, quantidade, tipoponto);
		placar.registrarPontos(usuario1, quantidade, tipoponto);
		String aux = placar.retornarRanking();
		assertEquals("guerra possui 20 pontos do tipo estrela Ferreira possui 20 pontos do tipo estrela", aux);
	}

}
