package br.com.cloud.netflix.exemplo.loja.domain;

import java.util.List;

public class LojaComClientes extends Loja {

	private List<Cliente> clientes;

	public LojaComClientes(Loja loja, List<Cliente> clientes) {
		super(loja.getId(), loja.getName());
		this.clientes = clientes;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
