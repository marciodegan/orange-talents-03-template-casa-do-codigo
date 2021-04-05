package br.com.zupacademy.marcio.casadocodigo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.marcio.casadocodigo.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

	Optional<Autor> findByEmail(String email);

	@Query(value = "SELECT a FROM Autor a WHERE a.email = :email")
	List<Autor> encontraDuplicadoEmail(String email);

}





