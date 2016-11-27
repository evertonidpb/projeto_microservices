package br.edu.facisa.cwf.example5.service;

import java.util.List;

import br.edu.facisa.cwf.example5.domain.Compras;

public interface ComprasService {

	Compras save(Compras compras);

	Compras getById(String id);
	
	List<Compras> listAllCompras();

	 void delete(Compras compras);

}
