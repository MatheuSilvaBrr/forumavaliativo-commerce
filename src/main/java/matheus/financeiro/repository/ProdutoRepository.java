package matheus.financeiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import matheus.financeiro.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String>{
	
	@Query(value = "select * from produto where codigo = :codigo", nativeQuery = true)
	public List<Produto> findByCodigo(@Param(value = "codigo") String codigo);		

}
