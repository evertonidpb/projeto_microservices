package br.com.cloud.netflix.exemplo.loja.hystrix;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.cloud.netflix.exemplo.loja.domain.Cliente;
import br.com.cloud.netflix.exemplo.loja.feign.ClientesClient;

@Component
public class ClientesBean {

	@Autowired
	private ClientesClient clientesClient;

	@HystrixCommand(fallbackMethod = "cacheClientes")
	public List<Cliente> getClientes(String id) {
		return clientesClient.getClientes(id);
	}

	public List<Cliente> cacheClientes(String id) {
		return Arrays.asList(new Cliente("Cliente cache", Arrays.asList("123", "456", "789")));
	}
}
