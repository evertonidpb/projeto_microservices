package br.edu.facisa.cwf.example5.domain;

import java.util.List;

public class ComprascomCliente extends Compras {

	private static final long serialVersionUID = 1L;
	private Cliente cliente;

	public ComprascomCliente(Compras compras, Cliente cliente) {
		super(compras.getId(), compras.getProduto(), compras.getValor());
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	
	
	
	
}

	
	

