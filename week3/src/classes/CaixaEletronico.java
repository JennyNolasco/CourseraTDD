package classes;

import classes.ServicoRemoto;;

public class CaixaEletronico {
	private ContaCorrente contaCorrente;
	
	public String valorSaldo(String numeroConta, ServicoRemoto servico) {
		contaCorrente = servico.recuperarConta(numeroConta);
		if(contaCorrente == null) return "Nenhuma Conta localizada";
	
		return "O saldo é R$" + contaCorrente.getSaldo();
	}		

	public String sacar(String numeroConta, ServicoRemoto servico, double valorSaldo) {
		contaCorrente = servico.recuperarConta(numeroConta);
		if(contaCorrente == null) return "Nenhuma Conta localizada";
		if((contaCorrente.getSaldo() - valorSaldo) < 0) return "Saldo insuficiente";
		
		servico.persistirConta(numeroConta, contaCorrente.getSaldo() - valorSaldo);
			
		return "Retire seu dinheiro";
		
	}

	public String depositar(String numeroConta, ServicoRemoto servico, double valorSaldo) {
		contaCorrente = servico.recuperarConta(numeroConta);
		if(contaCorrente == null) return "Nenhuma Conta localizada";
		
		servico.persistirConta(numeroConta, contaCorrente.getSaldo() + valorSaldo);
		
		return "Depósito recebido com sucesso";
	}

	public String logar(String numeroConta, ServicoRemoto servico) {
		contaCorrente = servico.recuperarConta(numeroConta);
		if(contaCorrente == null) return "Não foi possível autenticar o usuário";
		
		return "Usuário Autenticado";
	}
}
