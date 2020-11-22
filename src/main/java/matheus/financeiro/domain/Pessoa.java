package matheus.financeiro.domain;

import java.util.Objects;

import javax.persistence.Entity;

import matheus.financeiro.exception.CpfCnpjInvalidoException;
import matheus.financeiro.exception.TipoPessoaInvalidoException;

@Entity
public class Pessoa extends BaseEntity{
	
	private String nome;
	private TipoPessoa tipoPessoa;
	private String cnpjCpf;
	
	public Pessoa() {}
	public Pessoa(String nome, TipoPessoa tipoPessoa, String cnpjCpf) {
		this.nome = nome;
		this.tipoPessoa = tipoPessoa;
		setCnpjCpf(cnpjCpf);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getCnpjCpf() {
		return cnpjCpf;
	}

	public void setCnpjCpf(String cnpjCpf) {
		if(Objects.isNull(this.tipoPessoa)) {
			throw new TipoPessoaInvalidoException("Tipo pessoa deve estar preenchido");
		}
		if((cnpjCpf.length() == 14) && !TipoPessoa.JURIDICA.equals(this.tipoPessoa)) {
			throw new CpfCnpjInvalidoException("CNPJ deve ter tamanho 14");
		}
		if((cnpjCpf.length() == 11) && !TipoPessoa.FISICA.equals(this.tipoPessoa)) {
			throw new CpfCnpjInvalidoException("CPF deve ter tamanho 11");
		}
		
		this.cnpjCpf = cnpjCpf;
	}
}
