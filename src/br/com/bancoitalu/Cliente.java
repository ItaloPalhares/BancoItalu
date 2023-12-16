package br.com.bancoitalu;

public class Cliente {

	private String cpf;
	private String nome;
	private String profissao;
	private String endereço;
	

	public Cliente(String cpf, String nome, String endereço) {
		this.cpf = cpf;
		this.nome = nome;
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setProfissão(String profissao) {
		this.profissao = profissao;
	}
	
	public String getProfissao() {
		return profissao;
	}
	
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}
	
	public String getEndereço() {
		return endereço;
	}
	
	@Override
	public String toString() {
		return "Cliente: "+ this.nome +" "+ "cpf:"+this.cpf;
	}
}
