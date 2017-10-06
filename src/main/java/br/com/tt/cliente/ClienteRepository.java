package br.com.tt.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query("select c from Cliente c ORDER BY nome")
	List<Cliente> clientesOrdenadoNome();
	
	List<Cliente> findByNomeLike(String nome);

}
