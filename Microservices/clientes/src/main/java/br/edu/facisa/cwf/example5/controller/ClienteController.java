package br.edu.facisa.cwf.example5.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.facisa.cwf.example5.domain.Cliente;
import br.edu.facisa.cwf.example5.service.ClienteService;

@RestController
public class ClienteController {

	private final ClienteService ClienteService;

	@Autowired
	public ClienteController(final ClienteService ClienteService) {
		this.ClienteService = ClienteService;
	}

    //Método para listar todos os clientes
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ResponseEntity< List<Cliente> > listAllClientesSimples() {
		return new ResponseEntity< List<Cliente> >
		(ClienteService.listAllClientes(), HttpStatus.OK);
	}	
	
	
    //Método para buscar cliente específico
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Cliente> getCliente(@PathVariable String id) {
		
		Cliente Cliente = ClienteService.getById(id);
		
		return Cliente == null ? 
				new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Cliente>(Cliente, HttpStatus.OK);
	}
	
	//Método para salvar cliente
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ResponseEntity<String> createCliente(@RequestBody Cliente Cliente) {

		try {
			ClienteService.save(Cliente);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ClienteService getClienteService() {
		return ClienteService;
	}


	//Método para atualizar valores de Cliente
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> putCliente(@PathVariable String id, @RequestBody Cliente Cliente){

		try {
			ClienteService.save(Cliente);
			return new ResponseEntity<String>(HttpStatus.OK);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

	//Método para apagar cliente
	
	 @RequestMapping(value= "/{id}", method=RequestMethod.DELETE)
	  public void delete(@PathVariable String id) {

		 Cliente cliente = ClienteService.getById(id);
		 ClienteService.delete(cliente);
		 
	  }
	


	 
		// Método usado para comunicação com o serviço de Compras via Feign, ele devolve o cliente associado com a compra em questão.

		@RequestMapping("/compras/{id}")
		public Cliente getClienteLoja(@PathVariable String id) {
            Cliente aprovado = null;
			List<Cliente> clientes = ClienteService.listAllClientes();
		    System.out.println("testANDO");
			for (Cliente cliente : clientes) {
				if(cliente.getId_compra().equals(id)){
				    System.out.println(cliente.getId_compra());
					
				    aprovado = cliente;
				  
				}
			
				
			}
			if(aprovado == null){
			return null;
			}
			
			else return aprovado;
		}
	
		

}
	 
	

