package br.com.stuartwere.carrinho.produtos;

public class Produto {

    public int quantidadeDoProduto;
    public String nomeDoProduto;
    public double precoDoProduto;

   public double precoTotalDoProduto() {
        return precoDoProduto * quantidadeDoProduto;
    }

    @Override
    public String toString() {
        return quantidadeDoProduto + " - " + nomeDoProduto + " - R$" + precoTotalDoProduto();
    }
}
