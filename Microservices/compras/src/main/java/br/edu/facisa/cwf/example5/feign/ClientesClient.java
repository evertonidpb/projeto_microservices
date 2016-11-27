package br.edu.facisa.cwf.example5.feign;


import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.edu.facisa.cwf.example5.domain.Cliente;


@FeignClient("clientes")
public interface ClientesClient {

	
	@RequestMapping(value = "/compras/{id}", method = RequestMethod.GET)
	public Cliente getClienteLoja(@PathVariable("id") String id);

	/*@RequestMapping(value="/lista", method = RequestMethod.GET)
	public List<Cliente> listAll();
*/
}
