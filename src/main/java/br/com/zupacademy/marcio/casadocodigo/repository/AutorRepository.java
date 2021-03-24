package br.com.zupacademy.marcio.casadocodigo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.marcio.casadocodigo.model.Autor;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long>{

	Autor findByEmail(String email);
	
}





