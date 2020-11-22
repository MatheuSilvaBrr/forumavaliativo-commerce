package matheus.financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import matheus.financeiro.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {

}
