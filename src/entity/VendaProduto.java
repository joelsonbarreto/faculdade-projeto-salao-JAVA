package entity;
import java.time.LocalDate;


public class VendaProduto {
    private int codigoVenda;
    private LocalDate dataVenda;
    private String cliente;
    private Produtos produtos;
    private int quantidadeVenda;
    private double totalValorVenda;

    public VendaProduto(int codigoVenda, LocalDate dataVenda, String cliente, Produtos produtos, int quantidadeVenda, double totalValorVenda) {
        this.codigoVenda = codigoVenda;
        this.dataVenda = dataVenda;
        this.cliente = cliente;
        this.produtos = produtos;
        this.quantidadeVenda = quantidadeVenda;
        this.totalValorVenda = totalValorVenda;
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Produtos getProduto() {
        return produtos;
    }

    public void setProduto(Produtos produtos) {
        this.produtos = produtos;
    }

    public int getQuantidadeVenda() {
        return quantidadeVenda;
    }

    public double getTotalValorVenda() {
        return totalValorVenda;
    }
}

//     public String toString() {
//         return "Cógigo: " + codigoVenda + "\nData venda: " + dataVenda + "\nCliente: " + cliente + "\nProduto: " + produtos +"\nQuantidade: " + quantidadeVenda + "\nTotal venda: " +totalValorVenda;
//     }

//     public static void ExibirItens(List<Produtos> listaProdutos) {
//         for (Produtos produto : listaProdutos) {
//             System.out.println("Código do produto: " + produto.getCodigoProduto());
//             System.out.println("Nome do Produto: " + produto.getNomeProduto());
//             System.out.println("Preço: " + produto.getValorProduto());
//             System.out.println("Quantidade disponivel: " +produto.getQuantidadeProduto());
//             System.out.println("*=====================*");
//         }
//     }

//     public static double vender(double totalValorVenda, int quantidadeVenda) {
//         return quantidadeVenda * totalValorVenda;
//     }

//     public static void salvarVendaEmArquivo(VendaProduto venda, String caminhoArquivo){
//         try {
//             BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true));
//             writer.write(venda.toString());
//             writer.close();
//             System.out.println("Venda salvo em arquivo de texto com sucesso!");
//         } catch (IOException e) {
//             e.printStackTrace();
//         }

//         // String caminhoArquivo = "C:\\Users\\user\\Desktop\\Joelson\\faculdade\\com-projeto-salao-beleza\\com-projeto-salao-beleza/venda.produto.txt";

//         // try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
//         //     String linha = venda.getCodigoVenda() + "," + venda.getDataVenda() + "," + venda.getCliente() + "," + venda.getProduto().getCodigoProduto() + "," + venda.getQuantidadeVenda() + "," + venda.getTotalValorVenda();
//         //     writer.write(linha);
//         //     writer.newLine();
//         // } catch (IOException e) {
//         //     e.printStackTrace();
//         // }
//     }
// }

