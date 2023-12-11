import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entity.Clientes;

public class LeituraArquivo {
    public static List<Clientes> lerClientesDoArquivo(String caminhoArquivo) {
        List<Clientes> listaClientes = new ArrayList<>();

        Path caminho = Paths.get(caminhoArquivo);

        try {
            List<String> linhasArquivo = Files.readAllLines(caminho);

            for (String linha : linhasArquivo) {
                String[] dadosCliente = linha.split(",");

                if (dadosCliente.length == 4) {
                    String nome = dadosCliente[0];
                    String endereco = dadosCliente[1];
                    String telefone = dadosCliente[2];
                    String cpf = dadosCliente[3];

                    Clientes cliente = new Clientes(nome, endereco, telefone, cpf);
                    listaClientes.add(cliente);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaClientes;
    }

    public static List<Produtos> lerProdutosDoArquivo(String caminhoArquivo) {
        List<Produtos> listaProdutos = new ArrayList<>();

        Path caminho = Paths.get(caminhoArquivo);

        try {
            List<String> linhasArquivo = Files.readAllLines(caminho);

            for (String linha : linhasArquivo) {
                String[] dadosProdutos = linha.split(",");

                if (dadosProdutos.length == 4) {
                    int codigoProduto = Integer.parseInt(dadosProdutos[1]);
                    String nomeProduto = dadosProdutos[1];
                    float valorProduto = Float.parseFloat(dadosProdutos[2]);
                    int quantidadeProduto = Integer.parseInt(dadosProdutos[3]);

                    Produtos produto = new Produtos(codigoProduto, nomeProduto, valorProduto, quantidadeProduto);
                    listaProdutos.add(produto);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaProdutos;
    }

    public static List<Servicos> lerServicoDoArquivo(String caminhoArquivo) {
        List<Servicos> listaServicos = new ArrayList<>();

        Path caminho = Paths.get(caminhoArquivo);

        try {
            List<String> linhasArquivo = Files.readAllLines(caminho);

            for (String linha : linhasArquivo) {
                String[] dadosServicos = linha.split(",");

                if (dadosServicos.length == 4) {
                    int codigoProduto = Integer.parseInt(dadosServicos[1]);
                    String nomeServico = dadosServicos[1];
                    float valorServico = Float.parseFloat(dadosServicos[2]);
                    
                    Servicos novoServico = new Servicos(codigoProduto, nomeServico, valorServico);
                    listaServicos.add(novoServico);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaServicos;
    }

    public static List<VendaProduto> lerVendaProdutoDoArquivo(String caminhoArquivo) {
        List<VendaProduto> vendaProdutos = new ArrayList<>();
    
        Path caminho = Paths.get(caminhoArquivo);
    
        try {
            List<String> linhasArquivo = Files.readAllLines(caminho);
    
            for (String linha : linhasArquivo) {
                String[] dadosVendaProduto = linha.split(",");
    
                if (dadosVendaProduto.length == 6) {
                    int codigoVenda = Integer.parseInt(dadosVendaProduto[0]);
                    LocalDate dataVenda = LocalDate.parse(dadosVendaProduto[1]);
                    String nomeCliente = dadosVendaProduto[2];
                    String nomeProduto = dadosVendaProduto[3];
                    float valorProduto = Float.parseFloat(dadosVendaProduto[4]);
                    int quantidadeProduto = Integer.parseInt(dadosVendaProduto[5]);
                    float totalValorVenda = Float.parseFloat(dadosVendaProduto[6]);
    
                    VendaProduto vendaProduto = new VendaProduto(codigoVenda, null, nomeCliente, null, quantidadeProduto, totalValorVenda);
                    vendaProdutos.add(vendaProduto);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return vendaProdutos;
    }
    
}
