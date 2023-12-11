package entity;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import Produtos;

public class EstoqueProduto {
    private Produtos produtos;

    public EstoqueProduto(Produtos produtos){
        this.produtos = produtos;
    }
    public static List<Produtos> carregarProdutos(String produtoArquivo) {
        List<Produtos> produtos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(produtoArquivo))) {
            while (true) {
                try {
                    Produtos produto = (Produtos) ois.readObject();
                    produtos.add(produto);
                } catch (EOFException | ClassNotFoundException e) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    public static void ExibirEstoque(List<Produtos> listaProdutos) {
        if (listaProdutos.isEmpty()) {
            System.out.println("Não há produtos no estoque.");
        } else {
            for (Produtos produto : listaProdutos) {
                System.out.println("*=====================*");
                System.out.println("Código do produto: " + produto.getCodigoProduto());
                System.out.println("Nome do Produto: " + produto.getNomeProduto());
                System.out.println("Preço do Produto: " + produto.getValorProduto());
                System.out.println("Quantidade em Estoque: " + produto.getQuantidadeProduto());
                System.out.println("*=====================*");
            }
        }
    }

    // public static void ExibirEstoque(String produtoArquivo) {
    //     List<Produtos> listaProdutos = carregarProdutos(produtoArquivo);
        
    //     if (listaProdutos.isEmpty()) {
    //         System.out.println("Não há produtos no estoque.");
    //     } else {
    //         for (Produtos produtos : listaProdutos) {
    //             System.out.println("*=====================*");
    //             System.out.println("Código do produto: " + produtos.getCodigoProduto());
    //             System.out.println("Nome do Produto: " + produtos.getNomeProduto());
    //             System.out.println("Preço do Produto: " + produtos.getValorProduto());
    //             System.out.println("Quantidade em Estoque: " + produtos.getQuantidadeProduto());
    //             System.out.println("*=====================*");
    //         }
    //     }
    // }
    // public static void ExibirEstoqueArquivo(String arquivoProdutos) {
    //     List<Produtos> listaProdutos = carregarProdutos(arquivoProdutos);
    //     ExibirEstoque(listaProdutos);
    // }
}
    