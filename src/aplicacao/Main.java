package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Cliente;
import entidades.Ordem;
import entidades.OrdemItem;
import entidades.Produto;
import entidades.enums.OrdemStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com as informações do cliente: ");
		System.out.println("Nome: ");
		String nome = sc.nextLine();
		System.out.println("Entre com o email do cliente:");
		String email = sc.nextLine();
		System.out.println("Entre com a data de nascimento do cliente (DD/MM/AAAA");
		Date data = sdf.parse(sc.next());
		Cliente cliente = new Cliente(nome, email, data);
		
		System.out.println("Entre com as informações da ordem: ");
		System.out.println("Entre com Status da ordem: ");
		OrdemStatus status = OrdemStatus.valueOf(sc.next());
		System.out.println("Quatos item terão na ordem?");
		int n = sc.nextInt();
		
		Ordem ordem = new Ordem(new Date(), status, cliente);
		
		for (int i =1; i<=n; i++) {
			sc.nextLine();
			System.out.println("Nome do produto: ");
			String produtoNome = sc.nextLine();
			System.out.println("Preço: ");
			Double produtoPreco = sc.nextDouble();
			System.out.println("Quantidade de produtos: ");
			Integer produtoQuant = sc.nextInt();
			
			Produto produto = new Produto(produtoNome,produtoPreco);
			OrdemItem ordemI = new OrdemItem(produtoQuant,produtoPreco,produto);
			
			ordem.addItem(ordemI);
		}
		
		System.out.println(ordem);

		

	}

}
