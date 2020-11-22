package matheus.financeiro.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import matheus.financeiro.domain.Estoque;
import matheus.financeiro.domain.Produto;
import matheus.financeiro.exception.RegistroNaoExisteException;
import matheus.financeiro.repository.EstoqueRepository;

public class EstoqueController extends BaseController<Estoque, EstoqueRepository>{
	
	@Autowired
	EstoqueRepository estoqueRepository;
	
	@PostMapping("/{idEstoque}/adiciona-produto")
	public void adicionaProduto(@PathVariable String idEstoque, @RequestBody Produto produto) {
		Optional<Estoque> estoqueOptional = estoqueRepository.findById(idEstoque);
		
		if(!estoqueOptional.isPresent()) {
			throw new RegistroNaoExisteException();
		}
		
		estoqueOptional.get().adicionarProduto(produto);
	}
	
	@PostMapping("/{idEstoque}/remove-produto")
	public void removeProduto(@PathVariable String idEstoque, @RequestBody Produto produto) {
		Optional<Estoque> estoqueOptional = estoqueRepository.findById(idEstoque);
		
		if(!estoqueOptional.isPresent()) {
			throw new RegistroNaoExisteException();
		}
		
		estoqueOptional.get().removerProduto(produto);
	}
	
	@GetMapping("/codigo/{codigo}")
	public Estoque findByCodigo(@PathVariable String codigo){
		List<Estoque> estoques = estoqueRepository.findByCodigo(codigo);
		
		if(estoques.isEmpty()) {
			throw new RegistroNaoExisteException();
		}
		return estoques.get(0);
	}
	
	@GetMapping("{idEstoque}/obter-valor-produto")
	public BigDecimal obterValorTotalProdutoEmEstoque(@PathVariable String idEstoque) {
		Optional<Estoque> estoques = estoqueRepository.findById(idEstoque);
		
		if(!estoques.isPresent()) {
			throw new RegistroNaoExisteException();
		}
		return estoques.get().getProdutos().stream().map(produto -> produto.obterTotal()).reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
