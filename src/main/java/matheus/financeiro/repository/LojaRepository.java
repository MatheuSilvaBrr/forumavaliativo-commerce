package matheus.financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import matheus.financeiro.domain.Loja;

public interface LojaRepository extends JpaRepository<Loja, String>{

}
