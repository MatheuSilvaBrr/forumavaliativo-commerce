package matheus.financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import matheus.financeiro.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, String> {

}
