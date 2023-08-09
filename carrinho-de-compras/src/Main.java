
import java.util.*;

import br.com.stuartwere.carrinho.cartao.Cartao;
import br.com.stuartwere.carrinho.produtos.Produto;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double total =0;

        List<Produto> carrinho = new ArrayList<>();

        Cartao cartao = new Cartao();
        System.out.println("Insira o credito disponivel em seu cartão: ");
        cartao.credito = scanner.nextDouble();
        scanner.nextLine();


        while(true) {
            Produto produto = new Produto();
            System.out.println("Insira a quantidade de produtos: ");
            produto.quantidadeDoProduto = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Insira o nome do produto: ");
            produto.nomeDoProduto = scanner.nextLine();

            System.out.println("Insira o valor do produto em reais: ");
            produto.precoDoProduto = scanner.nextDouble();

            total += produto.precoTotalDoProduto();

            carrinho.add(produto);

            System.out.println("Se deseja continuar adicionando produtos no carrinho digite 1 caso deseje encerrar as compras digite 0");
            int encerra = scanner.nextInt();


            if (encerra == 0) {
                break;
            }
        }

        if (total > cartao.credito) {
            System.out.println("Erro na compra, saldo insuficiente!");
        } else {

            Collections.sort(carrinho, Comparator.comparingDouble(produto -> produto.precoDoProduto));

            for (Produto produto : carrinho) {
                System.out.println(produto.toString());
            }
            
            double saldoRestante = cartao.credito - total;
            System.out.println("Total da compra: " + total);
            System.out.println("Saldo restante no cartão" + saldoRestante);
        }

        scanner.close();
    }
}