package matheus.financeiro.domain;

import javax.persistence.Entity;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

@Entity
public class Endereco extends BaseEntity{
	
	private String rua;
	private Integer numero;
	private String bairro;
	private String cep;
	private String cidade;
	
	public Endereco() {}
	public Endereco(String rua, Integer numero, String bairro, String cep, String cidade) {
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}
