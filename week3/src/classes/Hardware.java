package classes;

import exceptions.EntregarDinheiroException;
import exceptions.LerEnvelopeException;
import exceptions.NumeroContaException;

public interface Hardware {
	public String pegarNumeroDaContaCartao() throws NumeroContaException;
	public void entregarDinheiro() throws EntregarDinheiroException;
	public void lerEnvelope() throws LerEnvelopeException;
}
