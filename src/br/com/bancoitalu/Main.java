package br.com.bancoitalu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		int pageIni = 0;
		Conta contaDef = null;
		HashSet<Conta> setContas = new HashSet<>();
		Cliente clienteExemplo = new Cliente("45875415823", "ClienteTeste", "rua do Teste");
		Conta contaExemplo = new Conta(clienteExemplo, "rua do Teste");
		while (pageIni == 0) {

			System.out.println("Olá, Bem vindo(a) ao Banco Italú");
			System.out.println("********************************");
			System.out.println("Como deseja prosseguir?");
			System.out.println(" ");
			System.out.println("Digite (1) para criar uma conta.");
			System.out.println("Digite (2) para acessar uma conta já existente.");
			int resposta01;
			Scanner usuario01 = new Scanner(System.in);
			resposta01 = usuario01.nextInt();
			if (resposta01 == 1) {

				System.out.println("metodo de cadastrar de cliente");
				System.out.println("Realizar Cadastro de Cliente");
				System.out.println("**************************************");
				System.out.print("Digite seu CPF:");
				String resCPF = usuario01.next();
				System.out.print("Primeiro nome:");
				String resNome = usuario01.next();
				System.out.print("Cep:");
				String resCep = usuario01.next();
				Cliente cliente = new Cliente(resCPF, resNome, resCep);
				Conta conta = new Conta(cliente, cliente.getEndereço());
				System.out.println("**************************************");
				System.out.println("Seu cadastro foi concluido com sucesso");
				System.out.println("**************************************");
				System.out.println("Definir senha de acesso e segurança:");
				System.out.println("A senha deve ser formada por 4 caracteres númericos ");
				System.out.print("Digite a senha desejada:");
				int resSenha = usuario01.nextInt();
				conta.setSenha(resSenha);
				System.out.println("*************************************************************");
				System.out.println("Senha definida com sucesso, Redirecionando para tela de Login");
				System.out.println("*************************************************************");
				contaDef = conta;
				setContas.add(contaDef);

//				
			}

//			

			System.out.println("Olá, Bem vindo(a) ao Banco Italú");
			System.out.println("********************************");
			System.out.println("Digite seu cpf:");
			String cpfCheck = usuario01.next();
			System.out.print("Senha de acesso:");
			int senhaCheck = usuario01.nextInt();
			System.out.println("**********************");
			System.out.println("Solicitando acesso...");
			System.out.println("**********************");
//		System.out.println(setContas.contains(contaDef));
			Iterator<Conta> iterator = setContas.iterator();
			while (iterator.hasNext()) {
				Conta conta = iterator.next();
				System.out.println(conta);
				if (conta.getTitular().getCpf().equals(cpfCheck) && conta.getSenha() == senhaCheck) {
					System.out.println("Acesso autorizado. Bem-vindo, " + conta.getTitular().getNome());
					int sessao = 0;
					while (sessao != 1) {
						conta.login();
						System.out.print("Digite o número da ação deseja:");
						int comando = usuario01.nextInt();
						switch (comando) {

						case 1:
							System.out.println("Qual o valor da transferencia?");
							System.out.print("R$: ");
							double valor = usuario01.nextDouble();
							System.out.println(" ");
							System.out.print("Conta de destino: ContaExemplo ");
							conta.transferir(valor, contaExemplo);
							System.out.println("Transferencia finalizada");
							System.out.println("redirecionando para tela inicial");
							break;
						case 2:
							System.out.println("Qual o valor do deposito?");
							System.out.print("R$: ");
							double valor2 = usuario01.nextDouble();
							conta.depositar(valor2);
							System.out.println("... ");
							System.out.print("Deposito realizado com sucesso ");
							System.out.println("redirecionando para tela inicial");
							break;
						case 3:
							System.out.println("Qual o valor de saque?");
							System.out.print("R$: ");
							double valor3 = usuario01.nextDouble();
							System.out.println("... ");
							conta.sacar(valor3);
							System.out.println("Operação finalizada");
							System.out.println("redirecionando para tela inicial");
							break;
						case 4:
							System.out.println("Alteração de senha");
							System.out.println("******************");
							System.out.print("Senha atual: ");
							int valor4 = usuario01.nextInt();
							if (valor4 == conta.getSenha()) {
								System.out.print("Nova senha: ");
								int newSenha = usuario01.nextInt();
								conta.setSenha(newSenha);
								System.out.println("Nova senha definida com sucesso");
								System.out.println("Nova senha definida com sucesso");
								break;
							}
						case 5:
							System.out.println("O Banco Italu te deseja um ótimo dia.");
							System.out.println("finalizando sessão...");
							System.out.println("sessão encerrada");
							sessao = 1;
							break;

						}

					}
				}
			}

		}
	}
}
