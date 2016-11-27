package br.edu.facisa.cwf.example5.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.edu.facisa.cwf.example5.domain.Compras;
import br.edu.facisa.cwf.example5.repository.ComprasRepository;

@Service
@Validated
public class ComprasServiceImpl implements ComprasService {

    private final ComprasRepository repository;

    @Autowired
    public ComprasServiceImpl(final ComprasRepository repository) {
        this.repository = repository;
    }
    
    public Compras getById(String id) {    
    	return repository.findOne(id);
    }
    
	public List<Compras> listAllCompras() {
		return repository.findAll();
	}
	
    @Transactional
    public Compras save(@NotNull @Valid final Compras participant) {
    	
        Compras existing = repository.findOne(participant.getId());
/*        
        if (existing != null) {
            throw new ComprasAlreadyExistsException(String.format("There already exists a participant with email=%s", participant.getName()));
        }
 */
        
        return repository.save(participant);
    }

    
    public void delete(Compras Compras) {    
       repository.delete(Compras);
    }
    
    
    
	public ComprasRepository getRepository() {
		return repository;
	}


   

}