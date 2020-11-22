package matheus.financeiro.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import matheus.financeiro.domain.BaseEntity;
import matheus.financeiro.exception.IdParametroDiferenteIdEntidadeException;
import matheus.financeiro.exception.RegistroDuplicadoException;
import matheus.financeiro.exception.RegistroNaoExisteException;

public class BaseController<ENTITY extends BaseEntity, REPOSITORY extends JpaRepository<ENTITY, String>> {
	
	@Autowired
    private REPOSITORY repo;

    @GetMapping
    public List<ENTITY> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public BaseEntity getById(@PathVariable String id) {
        Optional<ENTITY> entity = repo.findById(id);
        
        if(!entity.isPresent()) {
        	throw new NotFoundException("Registro não encontrado");
        }
        return entity.get();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        repo.deleteById(id);
    }
    
    @PutMapping("/{id}")
	public void put(@PathVariable String id, @RequestBody ENTITY entityUpdate) {
    	if(!id.equals(entityUpdate.getId())) {
    		throw new IdParametroDiferenteIdEntidadeException();
    	}
    	
		Optional<ENTITY> entityBuscado = repo.findById(id);
    	if(!entityBuscado.isPresent()) {
    		throw new RegistroNaoExisteException();
    	}
    	repo.save(entityUpdate);
	}
    
    @PostMapping
    public ENTITY post(@RequestBody ENTITY entity) {
    	if(Objects.nonNull(entity.getId())){
    		throw new RegistroDuplicadoException();
    	}
        return repo.save(entity);
    }
}
