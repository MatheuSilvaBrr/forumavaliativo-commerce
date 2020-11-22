package matheus.financeiro.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Produto extends BaseEntity{
	
	private String nome;
	@Column(unique = true)
	private String codigo;
	private BigDecimal valor;
	private Integer quantidade;
	
	public Produto() {}
	public Produto(String nome, String codigo, BigDecimal valor, Integer quantidade) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.valor = valor;
		this.quantidade = quantidade;
	}
	
	public BigDecimal obterTotal(){
		return this.valor.multiply(new BigDecimal(quantidade)).setScale(2, RoundingMode.HALF_EVEN);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
