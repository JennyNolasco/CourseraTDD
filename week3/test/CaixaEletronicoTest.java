import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import mock.MockServicoRemoto;
import classes.CaixaEletronico;
import classes.ContaCorrente;

public class CaixaEletronicoTest {
	CaixaEletronico caixaEletronico;
	ContaCorrente contaCorrente, contaCorrente2;
	MockServicoRemoto servicoRemoto;
	
	@Before
	public void inicializar() {
		servicoRemoto = new MockServicoRemoto();
		caixaEletronico = new CaixaEletronico();
		contaCorrente = new ContaCorrente("100.000", 500);
		servicoRemoto.setConta(contaCorrente);
		contaCorrente2 = new ContaCorrente("500.000", 150);
		servicoRemoto.setConta(contaCorrente2);
		
	}
	
	@Test
	public void recuperarUmaContaTest(){
		ContaCorrente rec;
		rec = servicoRemoto.recuperarConta("100.000");
		assertEquals(contaCorrente, rec);
	}
	
	@Test
	public void recuperarDuasContasTest(){
		ContaCorrente rec;
		rec = servicoRemoto.recuperarConta("500.000");
		assertEquals(contaCorrente2, rec);
		
	}
	
	@Test
	public void saldoSucessoTest(){
		assertEquals(caixaEletronico.valorSaldo("100.000", servicoRemoto), "O saldo é R$500.0");
	}
	
	@Test
	public void saldoFalhaTest(){
		assertEquals(caixaEletronico.valorSaldo("300.000", servicoRemoto), "Nenhuma Conta localizada");
	}
	
	@Test
	public void sacarSucessoTest(){
		assertEquals(caixaEletronico.sacar("100.000", servicoRemoto, 100), "Retire seu dinheiro");
	}
	
	@Test
	public void sacarFalhaTest(){
		assertEquals(caixaEletronico.sacar("100.000", servicoRemoto, 800), "Saldo insuficiente");
	}
	
	@Test
	public void depositarSucessoTest(){
		assertEquals(caixaEletronico.depositar("100.000", servicoRemoto, 100), "Depósito recebido com sucesso");
	}
	
	@Test
	public void logarSucessoTest(){
		assertEquals(caixaEletronico.logar("100.000", servicoRemoto), "Usuário Autenticado");
	}
	
	@Test
	public void logarFalhaTest(){
		assertEquals(caixaEletronico.logar("200.000", servicoRemoto), "Não foi possível autenticar o usuário");
	}
}
