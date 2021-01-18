package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import exceptions.UsuarioSemPontosDeUmTipoException;
import exceptions.UsuarioSemPontosRegistradosException;

public class Usuario {

	private String _nome;
	private HashMap<String, Integer> _pontos;
	
	public Usuario(String nome) {
		this._nome = nome;
		this._pontos = new HashMap<String, Integer>();
	}
	
	public void registrarTipoPonto(String tipoPonto) {
		if(_pontos.containsKey(tipoPonto)) return;
		else _pontos.put(tipoPonto, 0);
	}
	
	public String getNome() {
		return this._nome;
	}

	public void adicionarPontos(String tipoPonto, int quantidaDePontos) {
		if(!_pontos.containsKey(tipoPonto)) {
			_pontos.put(tipoPonto, quantidaDePontos);
		}
		else {
			Integer novapontuacao = _pontos.get(tipoPonto) + quantidaDePontos;
			_pontos.replace(tipoPonto, novapontuacao);
		}
	}
	
	public boolean temAlgumPonto() {
		Set set = _pontos.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			Map.Entry elemento = (Map.Entry) iterator.next();
			if(_pontos.get(elemento.getKey()) > 0) return true;
		}
		return false;
	}
	
	public int retornarQuantosPontosTemDeUmTipo(String tipoPonto) throws UsuarioSemPontosDeUmTipoException{
		if(_pontos.containsKey(tipoPonto)) return _pontos.get(tipoPonto);
		else throw new UsuarioSemPontosDeUmTipoException("Usuario nao possui pontos do tipo " + tipoPonto);
	}
	
	public ArrayList<String> retornarTodosTiposPontosRegistrados() throws UsuarioSemPontosRegistradosException {
		if(_pontos.isEmpty()) throw new UsuarioSemPontosRegistradosException("Usuario nao possui pontos registrados!!");
		else {
			ArrayList<String> tiposdepontosencontrados = new ArrayList<>();
			Set set = _pontos.entrySet();
			Iterator iterator = set.iterator();
			while(iterator.hasNext()) {
				Map.Entry elemento = (Map.Entry) iterator.next();
				tiposdepontosencontrados.add(elemento.getKey().toString());
			}
			return tiposdepontosencontrados;
		}
	}
	
	public String retornarTodosTiposEValores() {
		if(_pontos.isEmpty()) return "";
		String aux = "";
		Set set = _pontos.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			Map.Entry elemento = (Map.Entry) iterator.next();
			aux += elemento.getValue() + " pontos do tipo " + elemento.getKey().toString();
		}
		return aux.trim();
	}
	
	public HashMap<String, Integer> getPontos(){
		return _pontos;
	}

	public boolean temPontosPorTipo(String tipoPontos) {
		if(_pontos.containsKey(tipoPontos)) return true;
		return false;
	}

}
