package br.com.cloud.netflix.exemplo.loja.domain;

import java.util.List;

public class Cliente {

	private String name;
	private List<String> lojas;

	public Cliente() {

	}
	
	public Cliente(String name, List<String> lojas) {
		this.name = name;
		this.lojas = lojas;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getLojas() {
		return lojas;
	}

	public void setLojas(List<String> lojas) {
		this.lojas = lojas;
	}
}
