package br.com.cloud.netflix.exemplo.loja.domain;

public class Loja {

	private String id;
	private String name;

	public Loja() {

	}

	public Loja(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
