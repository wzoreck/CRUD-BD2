package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import aplicacao.bd.PessoaDAO;
import aplicacao.bd.UtilBD;
import aplicacao.entidades.Pessoa;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		PessoaDAO dao = new PessoaDAO();
		UtilBD.initBD();
		Pessoa pessoa;

		int escolha, id;
		String nome, cpf;
		float altura, peso;

		while (true) {
			System.out.println();
			System.out.println(" ██████╗██████╗ ██╗   ██╗██████╗");
			System.out.println("██╔════╝██╔══██╗██║   ██║██╔══██╗");
			System.out.println("██║     ██████╔╝██║   ██║██║  ██║");
			System.out.println("██║     ██╔══██╗██║   ██║██║  ██║");
			System.out.println("╚██████╗██║  ██║╚██████╔╝██████╔╝");
			System.out.println(" ╚═════╝╚═╝  ╚═╝ ╚═════╝ ╚═════╝ ");
			System.out.println("_____________________________________");
			System.out.println(" _ __   ___  ___ ___  ___   __ _ ___ ");
			System.out.println("| '_ \\ / _ \\/ __/ __|/ _ \\ / _` / __|");
			System.out.println("| |_) |  __/\\__ \\__ \\ (_) | (_| \\__ \\");
			System.out.println("| .__/ \\___||___/___/\\___/ \\__,_|___/");
			System.out.println("|_|\n");

			System.out.println("[1] - Criar");
			System.out.println("[2] - Listar");
			System.out.println("[3] - Atualizar");
			System.out.println("[4] - Deletar");
			System.out.print("\nInforme sua escolha: ");
			escolha = sc.nextInt();
			sc.nextLine();

			switch (escolha) {
			case 1:
				System.out.print("\nInforme o nome da pessoa: ");
				nome = sc.nextLine();
				System.out.print("Informe o cpf da pessoa: ");
				cpf = sc.nextLine();
				System.out.print("Informe a altura da pessoa (real): ");
				altura = sc.nextFloat();
				System.out.print("Informe o peso da pessoa (real): ");
				peso = sc.nextFloat();

				dao.adiciona(new Pessoa(nome, cpf, altura, peso));
				break;

			case 2:
				pessoas = dao.busca();
				if (pessoas == null)
					break;
				for (int i = 0; i < pessoas.size(); i++) {
					System.out.println("\n------------------");
					pessoas.get(i).apresentaPessoa();
					System.out.println("------------------");
				}
				break;

			case 3:
				pessoas = dao.busca();
				if (pessoas == null)
					break;
				System.out.print("\nInforme o ID da pessoa que deseja atualizar: ");
				id = sc.nextInt();
				sc.nextLine();

				for (int i = 0; i < pessoas.size(); i++) {
					if (pessoas.get(i).getId() == id) {
						pessoa = pessoas.get(i);
						System.out.print("Nome da pessoa: ");
						nome = sc.nextLine();
						pessoa.setNome(nome);
						System.out.print("Cpf da pessoa: ");
						cpf = sc.nextLine();
						pessoa.setCpf(cpf);
						System.out.print("Altura da pessoa (real): ");
						altura = sc.nextFloat();
						pessoa.setAltura(altura);
						System.out.print("Peso da pessoa (real): ");
						peso = sc.nextFloat();
						pessoa.setPeso(peso);

						dao.atualiza(pessoa);
						break;
					}
				}
				break;

			case 4:
				System.out.print("Informe o ID da pessoa: ");
				id = sc.nextInt();
				sc.nextLine();

				for (int i = 0; i < pessoas.size(); i++) {
					if (pessoas.get(i).getId() == id) {
						dao.remove(pessoas.get(i));
						pessoas.remove(pessoas.get(i));
						break;
					}
				}
				break;

			default:
				System.err.println("A escolha informada não existe!");
			}

			UtilBD.fecharConexao();
		}

	}
}
