package matheus.financeiro.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Loja extends BaseEntity{
	
	private String nome;
	@ManyToOne
	private Endereco endereco;
	
	@OneToMany
	private List<Estoque> estoque;

	public Loja() {}
	public Loja(String nome, Endereco endereco, List<Estoque> estoque) {
		this.nome = nome;
		this.endereco = endereco;
		this.estoque = estoque;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<Estoque> getEstoque() {
		return estoque;
	}
	public void setEstoque(List<Estoque> estoque) {
		this.estoque = estoque;
	}

}
