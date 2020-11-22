package matheus.financeiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import matheus.financeiro.domain.Estoque;


public interface EstoqueRepository extends JpaRepository<Estoque, String> {
	
	@Query(value = "select * from estoque where codigo = :codigo", nativeQuery = true)
	public List<Estoque> findByCodigo(@Param(value = "codigo") String codigo);
}
