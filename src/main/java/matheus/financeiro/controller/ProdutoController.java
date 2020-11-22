package matheus.financeiro.controller;

import java.util.List;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import matheus.financeiro.domain.Produto;
import matheus.financeiro.exception.RegistroNaoExisteException;
import matheus.financeiro.repository.ProdutoRepository;

public class ProdutoController extends BaseController<Produto, ProdutoRepository>{
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/codigo/{codigo}")
	public Produto findByCodigo(@PathVariable String codigo) {
		
		List<Produto> produtos = produtoRepository.findByCodigo(codigo);
		if(produtos.isEmpty()) {
			throw new RegistroNaoExisteException();
		}
		return produtos.get(0);
	}

}
