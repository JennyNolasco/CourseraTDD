package mock;

import exceptions.EntregarDinheiroException;
import exceptions.LerEnvelopeException;
import exceptions.NumeroContaException;

import org.junit.Test;

import classes.Hardware;

public class MockHardware implements Hardware{
	private boolean falharNumConta = false;
	private boolean falharEntregarDinheiro = false;
	private boolean falharLerEnvelope = false;
	private String conta = "500.000";
	
	public boolean isFalharNumConta() {
		return falharNumConta;
	}

	public void setFalharNumConta(boolean falharNumConta) {
		this.falharNumConta = falharNumConta;
	}

	public boolean isFalharEntregarDinheiro() {
		return falharEntregarDinheiro;
	}

	public void setFalharEntregarDinheiro(boolean falharEntregarDinheiro) {
		this.falharEntregarDinheiro = falharEntregarDinheiro;
	}

	public boolean isFalharLerEnvelope() {
		return falharLerEnvelope;
	}

	public void setFalharLerEnvelope(boolean falharLerEnvelope) {
		this.falharLerEnvelope = falharLerEnvelope;
	}

	@Override
	public String pegarNumeroDaContaCartao() throws NumeroContaException{
		if(this.isFalharNumConta())
			throw new NumeroContaException();
		return this.conta;
	}

	@Override
	public void entregarDinheiro() throws EntregarDinheiroException{
		if(this.isFalharEntregarDinheiro())
			throw new EntregarDinheiroException();
		
	}

	@Override
	public void lerEnvelope() throws LerEnvelopeException{
		if(this.isFalharLerEnvelope())
			throw new LerEnvelopeException();
		
	}

	@Test(expected = NumeroContaException.class)
	public void numContaFalha() throws NumeroContaException{
		setFalharNumConta(true);
		pegarNumeroDaContaCartao();
	}
	
	@Test
	public void numContaSucesso() throws NumeroContaException  {
		setFalharNumConta(false);
		pegarNumeroDaContaCartao();
	}
	
	@Test(expected = EntregarDinheiroException.class)
	public void entregarDinheiroFalha() throws EntregarDinheiroException{
		setFalharEntregarDinheiro(true);
		entregarDinheiro();
	}
	
	@Test
	public void entregarDinheiroSucesso() throws EntregarDinheiroException{
		setFalharEntregarDinheiro(false);
		entregarDinheiro();
	}
	
	@Test(expected = LerEnvelopeException.class)
	public void lerEnvelopeFalha() throws LerEnvelopeException{
		setFalharLerEnvelope(true);
		lerEnvelope();
	}
	
	@Test
	public void lerEnvelopeSucesso() throws LerEnvelopeException{
		setFalharLerEnvelope(false);
		lerEnvelope();
	}
}
