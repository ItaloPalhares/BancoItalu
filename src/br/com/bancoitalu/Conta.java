package br.com.bancoitalu;

import java.util.*;

public class Conta {

	private double saldo;
	private int agencia = 022045;
	private int numero;
	private String endCobrança;
	Cliente titular;
	private static int contas = 0;
	private int senha;

	public Conta(Cliente titular, String endereço) {
		this.titular = titular;
		if (this.titular.getEndereço() == endereço) {
			this.endCobrança = endereço;
			contas++;

		}

	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void depositar(double valor) {
		if (valor > 0) {
			this.saldo += valor;
		}
	}

	public boolean transferir(double valor, Conta destino) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			destino.depositar(valor);
			return true;
		} else {
			return false;
		}

	}

	public boolean sacar(double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			return true;
		} else {
			return false;
		}
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public int getSenha() {
		return senha;
	}

//	public String login(String cpf, int senha, Set<Conta> set){
//		Iterator<Conta> iterator = set.iterator();
//		if(iterator.next().getTitular().getCpf() == cpf && iterator.next().getSenha() == senha){
//			String opa = "funcionou";
//			return opa;
//		}
//		
//	}

	@Override
	public boolean equals(Object obj) {
		return this.titular == obj;
	}

	

@Override
public String toString() {
	return this.titular + " " + "ag: " + this.agencia + " " + "num:" +  this.numero;
}

public void login() {
	System.out.println("Banco Italu");
	System.out.println("************************************");
	System.out.println("************************************");
	System.out.print("Usuário: " + this.getTitular()); System.out.print(" Saldo: " + this.getSaldo());
	System.out.println();
	System.out.println("Transferir (1)");
	System.out.println("Depositar (2)");
	System.out.println("Sacar (3)");
	System.out.println("Alterar senha (4)");
	System.out.println("finalizar sessão (5)");
	
	
	
	
}

}
