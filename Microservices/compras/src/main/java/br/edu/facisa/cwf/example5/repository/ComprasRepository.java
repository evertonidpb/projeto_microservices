package br.edu.facisa.cwf.example5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.facisa.cwf.example5.domain.Compras;

public interface ComprasRepository extends JpaRepository<Compras, String> {

	public Compras findById(String id);
	
}
