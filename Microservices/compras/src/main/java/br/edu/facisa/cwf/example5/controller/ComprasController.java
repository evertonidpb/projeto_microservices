package br.edu.facisa.cwf.example5.controller;

import java.util.ArrayList;
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

import br.edu.facisa.cwf.example5.domain.Compras;
import br.edu.facisa.cwf.example5.domain.ComprascomCliente;
import br.edu.facisa.cwf.example5.feign.ClientesClient;
import br.edu.facisa.cwf.example5.service.ComprasService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ComprasController {

	
	private static List<Compras> compras = new ArrayList<Compras>();
	
	
	@Autowired
	public ClientesClient clientesClient;
	
	
	@Autowired
	public  ComprasService comprasService;
	
	

	@RequestMapping("/clientes")
	public List<ComprascomCliente> getComprascomClientes() {
		List<ComprascomCliente> returnCompras = new ArrayList<ComprascomCliente>();
		List<Compras> compras = comprasService.listAllCompras();
		
		for (Compras compra : compras) {
			returnCompras.add(new ComprascomCliente(compra, clientesClient.getClienteLoja(compra.getId())));
		}
		return returnCompras;
	}

	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ResponseEntity< List<Compras> > listAllComprasSimples() {
		return new ResponseEntity< List<Compras> >
		(comprasService.listAllCompras(), HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Compras> getCompras(@PathVariable String id) {
		
		Compras compras = comprasService.getById(id);
		
		return compras == null ? 
				new ResponseEntity<Compras>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Compras>(compras, HttpStatus.OK);
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ResponseEntity<String> createCompras(@RequestBody Compras compras) {

		try {
			comprasService.save(compras);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ComprasService getComprasService() {
		return comprasService;
	}


	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> putCompras(@PathVariable String id, @RequestBody Compras compras){

		try {
			comprasService.save(compras);
			return new ResponseEntity<String>(HttpStatus.OK);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
		
	}

	
	 @RequestMapping(value= "/{id}", method=RequestMethod.DELETE)
	  public void delete(@PathVariable String id) {

		 Compras compras = comprasService.getById(id);
		 comprasService.delete(compras);
		 
	  }
	
	
	

}