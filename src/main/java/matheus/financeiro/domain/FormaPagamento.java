package matheus.financeiro.domain;

public enum FormaPagamento {
	
	DEPOSITO("Depósito", 1), BOLETO("Boleto", 2 );

	private Integer codigo;
	private String descricao;
	
	FormaPagamento(String descricao, Integer codigo) {
		this.descricao = descricao;
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
