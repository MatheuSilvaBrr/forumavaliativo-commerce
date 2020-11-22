package matheus.financeiro.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import matheus.financeiro.exception.ProdutoNaoExisteNoEstoqueException;

@Entity
public class Estoque extends BaseEntity{
	
	@OneToMany
	private List<Produto> produtos;
	@Column(unique = true)
	private String codigo;
	
	public Estoque(){}
	
	public void adicionarProduto(Produto produto){
		this.produtos.add(produto);
	}
	
	public void removerProduto(Produto produto){
		List<Produto> produtosAhSerRemovido = produtos.stream().filter(produtoEstoque -> produtoEstoque.getId().equals(produto.getId())).collect(Collectors.toList());
		
		if(produtosAhSerRemovido.isEmpty()) {
			throw new ProdutoNaoExisteNoEstoqueException();
		}
		
		Produto produtoAhSerRemovido = produtosAhSerRemovido.get(0);
		if(produtoAhSerRemovido.getQuantidade() <= 1) {
			this.produtos.remove(produtosAhSerRemovido.get(0));
			return;
		}
		produtoAhSerRemovido.setQuantidade(produtoAhSerRemovido.getQuantidade() - 1);
	}
	
	public List<Produto> getProdutos() {
		return Collections.unmodifiableList(produtos);
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
