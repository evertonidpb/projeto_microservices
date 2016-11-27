package br.com.cloud.netflix.exemplo.loja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cloud.netflix.exemplo.loja.domain.Loja;
import br.com.cloud.netflix.exemplo.loja.domain.LojaComClientes;
import br.com.cloud.netflix.exemplo.loja.hystrix.ClientesBean;

@RestController
public class LojaController {

	@Autowired
	private ClientesBean clientesBean;

	private static List<Loja> lojas = new ArrayList<Loja>();

	public LojaController() {
		lojas.add(new Loja("123", "Loja A"));
		lojas.add(new Loja("456", "Loja B"));
	}

	@RequestMapping("/")
	public List<Loja> getLojas() {
		return lojas;
	}

	@RequestMapping("/clientes")
	public List<LojaComClientes> getLojasComClientes() {
		List<LojaComClientes> returnLojas = new ArrayList<LojaComClientes>();

		for (Loja loja : lojas) {
			returnLojas.add(new LojaComClientes(loja, clientesBean.getClientes(loja.getId())));
		}

		return returnLojas;
	}
}
