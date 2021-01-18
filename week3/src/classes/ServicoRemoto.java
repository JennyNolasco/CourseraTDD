package classes;

public interface ServicoRemoto {
	public ContaCorrente recuperarConta(String numeroConta);
	public void persistirConta(String numeroConta, double valorSaldo);
}
