package entity;

public class Produtos {
    private int idproduto;
    private String nomeproduto;
    private float valorproduto;
    private int quantidadeproduto;
    
    public Produtos(String nomeproduto, float valorproduto, int quantidadeproduto) {
        this.nomeproduto = nomeproduto;
        this.valorproduto = valorproduto;
        this.quantidadeproduto = quantidadeproduto;
        
    }
    public Produtos() {
        this.nomeproduto = "";
        this.valorproduto = 0;
        this.quantidadeproduto = 0;
        
    }
        
    public int getIdProduto(){
        return idproduto;
    }
    public String getNomeProduto() {
        return nomeproduto;
    }
    public float getValorProduto() {
        return valorproduto;
    }
    public int getQuantidadeProduto() {
        return quantidadeproduto;
    }
    public void setQuantidadeProduto(int quantidadeproduto) {
        this.quantidadeproduto = quantidadeproduto;
    }
    public void setNomeProduto(String nomeproduto){
        this.nomeproduto = nomeproduto;
    }
    public void setValorProduto(float valorproduto){
        this.valorproduto = valorproduto;
    }
}

//     public String toString() {
//         return "Nome Produto: " + nomeProduto + "\nPreço: " + valorProduto + "\nQuantidade: " + quantidadeProduto + "\n";
//     }

//     public static void salvarProduto(Produtos produto, String caminhoArquivo) {
//         try {
//             BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true));
//             writer.write(produto.toString());
//             writer.close();
//             System.out.println("Produto salvo em arquivo de texto com sucesso!");
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     public void removerEstoque(int quantidadeProduto) {
//         this.quantidadeProduto -= quantidadeProduto;
//     }
// }

    // public static void salvarProduto(Produtos produtos, String produtoArquivo) {
    //     try {
    //         BufferedWriter writer = new BufferedWriter(new FileWriter(produtoArquivo, true));
    //         writer.write(produtos.toString());
    //         writer.close();
    //         System.out.println("Produto salvo em arquivo de texto com sucesso!");
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    

    

