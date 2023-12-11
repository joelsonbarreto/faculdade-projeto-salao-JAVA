package entity;

import java.util.Scanner;
import DAO.ClienteDAO;
import DAO.ProdutoDAO;
import DAO.ServicoDAO;

public class App{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        
        while(opcao != 7){
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar produto");
            System.out.println("3 - Cadastrar serviço");
            System.out.println("4 - Vender produto");
            System.out.println("5 - Agendar atendimento");
            System.out.println("6 - Exibir estoque");
            System.out.println("7 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine(); 
            int op_caso = opcao;
            switch (op_caso) {
                case 1:
                    System.out.println("Informe o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.println("Informe o CPF do cliente: ");
                    String cpf = scanner.nextLine();
                    ClienteDAO clienteDAO = new ClienteDAO(); 
                    if (clienteDAO.verificarExistenciaCPF(cpf)) {
                        System.out.println("CPF já cadastrado no banco de dados, verifique o CPF e tente novamente");
                    } else {
                        System.out.println("Endereço para cadastro: ");
                        String endereco = scanner.nextLine();
                        System.out.println("Telefone para contato: ");
                        String telefone = scanner.nextLine();
                        Clientes novoCliente = new Clientes(nome, cpf, endereco, telefone);
                        clienteDAO.cadastraCliente(novoCliente);
                    }
                    break;
                case 2:
                    System.out.println("Informe o nome do produto: ");
                    String nomeproduto = scanner.nextLine();
                    System.out.println("Preço do produto: ");
                    float valorProduto = Float.parseFloat(scanner.nextLine());
                    System.out.println("Quantidade Produto: ");
                    int quantidadeProduto = Integer.parseInt(scanner.nextLine());
                    Produtos novoProduto = new Produtos(nomeproduto, valorProduto, quantidadeProduto);
                    new ProdutoDAO().cadastraProduto(novoProduto);
                break;
                case 3:
                    System.out.println("Informe o nome do serviço: ");
                    String nomeServico = scanner.nextLine();
                    System.out.println("Valor desse serviço: ");
                    float valorServico = Float.parseFloat(scanner.nextLine());
                    Servicos novoServico = new Servicos(nomeServico, valorServico);
                    new ServicoDAO().cadastraServico(novoServico);
                    
                break;

                default:
                    
                break;
            }
                
        }
    }
}









// package entity;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// import LeituraArquivo;
// import Produtos;
// import Servicos;
// import VendaProduto;

// import java.util.Date;
// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;
// import java.time.format.DateTimeParseException;

// public class App {
// public static void main(String[] args) {
       
//     Scanner scanner = new Scanner(System.in);
//     List<Clientes> listaClientes = LeituraArquivo.lerClientesDoArquivo("C:\\Users\\user\\Desktop\\Joelson\\faculdade\\com-projeto-salao-beleza\\com-projeto-salao-beleza/cliente.txt");
//     List<Produtos> listaProdutos = LeituraArquivo.lerProdutosDoArquivo("C:\\Users\\user\\Desktop\\Joelson\\faculdade\\com-projeto-salao-beleza\\com-projeto-salao-beleza/produto.txt");
//     List<Servicos> listaServicos = LeituraArquivo.lerServicoDoArquivo("C:\\Users\\user\\Desktop\\Joelson\\faculdade\\com-projeto-salao-beleza\\com-projeto-salao-beleza/Servico.txt");
//     List<VendaProduto> listaVendaProdutos = LeituraArquivo.lerVendaProdutoDoArquivo("C:\\Users\\user\\Desktop\\Joelson\\faculdade\\com-projeto-salao-beleza\\com-projeto-salao-beleza/venda.produto.txt");
//     int opcao = 0;
//     while(opcao != 7){
        

//         System.out.println("Escolha uma opção:");
//         System.out.println("1 - Cadastrar cliente");
//         System.out.println("2 - Cadastrar produto");
//         System.out.println("3 - Cadastrar serviço");
//         System.out.println("4 - Vender produto");
//         System.out.println("5 - Agendar atendimento");
//         System.out.println("6 - Exibir estoque");
//         System.out.println("7 - Sair");

//         opcao = scanner.nextInt();
//         scanner.nextLine(); 
//         int op_caso = opcao;
//         switch (op_caso) {
//             case 1:
//             System.out.println("Informe o nome do cliente: ");
//             String nome = scanner.nextLine();
//             System.out.println("Informe o CPF do cliente: ");
//             String cpf = scanner.nextLine();
//             System.out.println("Endereço para cadastro: ");
//             String endereco = scanner.nextLine();
//             System.out.println("Telefone para contato: ");
//             String telefone = scanner.nextLine();

//             if (!ChecarClientes.clienteJaCadastradoPorCPF(cpf, listaClientes)) {
//                 Clientes novoCliente = new Clientes(nome, endereco, telefone, cpf);
//                 listaClientes.add(novoCliente);
//                 Clientes.salvarCliente(novoCliente, "C:\\Users\\user\\Desktop\\Joelson\\faculdade\\com-projeto-salao-beleza\\com-projeto-salao-beleza/cliente.txt");
//                 System.out.println("Cliente cadastrado com sucesso!");
//             } else {
//                 System.out.println("Cliente já cadastrado!");
//             }
            
//             break;
//             case 2:
//                 System.out.println("Informe o nome do produto:");
//                 String nomeProduto = scanner.nextLine();
//                 System.out.println("Preço do produto: ");
//                 float valorProduto = Float.parseFloat(scanner.nextLine());
//                 System.out.println("Quantidade do produto: ");
//                 int quantidadeProduto = Integer.parseInt(scanner.nextLine());
        
//                 int ultimoCodigo = 0;
//                 if (!listaProdutos.isEmpty()) {
//                     ultimoCodigo = listaProdutos.get(listaProdutos.size() - 1).getCodigoProduto();
//                 }
//                 int codigoProduto = ultimoCodigo + 1;
        
//                 Produtos novoProduto = new Produtos(codigoProduto, nomeProduto, valorProduto, quantidadeProduto);
//                 listaProdutos.add(novoProduto);
//                 Produtos.salvarProduto(novoProduto, "C:\\Users\\user\\Desktop\\Joelson\\faculdade\\com-projeto-salao-beleza\\com-projeto-salao-beleza/produto.txt");
//                 System.out.println("Produto cadastrado com sucesso!");
//             break;
//             case 3:
//                 System.out.println("Informe o nome do serviço: ");
//                 String nomeServico = scanner.nextLine();
//                 System.out.println("Valor desse serviço: ");
//                 float valorServico = Float.parseFloat(scanner.nextLine());
            
//                 int ultimoCodigoServico = 0;
//                 if (!listaServicos.isEmpty()) {
//                     ultimoCodigoServico = listaServicos.get(listaServicos.size() - 1).getCodigoServico();
//                 }
//                 int codigoServico = ultimoCodigoServico + 1;
            
//                 Servicos novoServico = new Servicos(codigoServico, nomeServico, valorServico);
//                 listaServicos.add(novoServico);
//                 Servicos.salvarServico(novoServico, "C:\\Users\\user\\Desktop\\Joelson\\faculdade\\com-projeto-salao-beleza\\com-projeto-salao-beleza/Servico.txt");
//                 System.out.println("Serviço cadastrado com sucesso!");
//             break;
        
//             case 4:
//                 System.out.println("Selecione o produto a ser vendido informando o código: ");
//                 VendaProduto.ExibirItens(listaProdutos);
//                 int codigoVenda = Integer.parseInt(scanner.nextLine());
//                 Produtos produtoSelecionado = null;
//                 for (Produtos vendaProduto : listaProdutos) {
//                     if (codigoVenda == vendaProduto.getCodigoProduto()) {
//                         produtoSelecionado = vendaProduto;
//                     break;
//                     }
//                 }
//                 if (produtoSelecionado != null) {
//                     System.out.println("Quantidade do produto:");
//                     int quantidadeVenda = Integer.parseInt(scanner.nextLine());
//                     if (quantidadeVenda <= produtoSelecionado.getQuantidadeProduto()) {
//                         System.out.println("CPF do cliente:");
//                         String cpfClienteVenda = scanner.nextLine();
//                         if (!ChecarClientes.clienteJaCadastradoPorCPF(cpfClienteVenda, listaClientes)) {
//                             System.out.println("Cliente não localizado");
//                         } else {
//                             LocalDate dataVenda = LocalDate.now(); // Data atual
//                             double totalValorVenda = VendaProduto.vender(produtoSelecionado.getValorProduto(), quantidadeVenda);
//                             String clienteNome = ChecarClientes.getNomeClientePorCPF(cpfClienteVenda, listaClientes);
//                             VendaProduto novaVenda = new VendaProduto(codigoVenda, dataVenda, clienteNome, produtoSelecionado, quantidadeVenda, totalValorVenda);
//                             listaVendaProdutos.add(novaVenda);
//                             produtoSelecionado.diminuirQuantidade(quantidadeVenda);
//                             //Produtos.setQuantidadeProduto = (produtoSelecionado.getQuantidadeProduto() - quantidadeVenda);
//                             // produtoSelecionado.setQuantidadeProduto(produtoSelecionado.getQuantidadeProduto() - quantidadeVenda);
//                             System.out.println("Cliente: " + clienteNome + "\nProduto: " + produtoSelecionado.getNomeProduto() + "\nQuantidade: " + quantidadeVenda + "\nValor total pedido:" + totalValorVenda);
//                             VendaProduto.salvarVendaEmArquivo(novaVenda, "C:\\Users\\user\\Desktop\\Joelson\\faculdade\\com-projeto-salao-beleza\\com-projeto-salao-beleza/venda.produto.txt");
//                         }
//                     } else {
//                         System.out.println("Quantidade maior que a quantidade existente em estoque.");
//                     }
//                 } else {
//                     System.out.println("Produto não encontrado.");
//                 }
//             break;
        
//             // case 5:
//             //     System.out.println("Informe o CPF do cliente: ");
//             //     String cpfAgendamento = scanner.nextLine();
//             //     if (ChecarCliente.clienteJaCadastradoPorCPF(cpfAgendamento, listaClientes)) {
//             //         Cliente clienteAgendamento = ChecarCliente.getClienteAgendamento(cpfAgendamento, listaClientes);
//             //         System.out.println("Serviço a ser realizado: ");
//             //         for (Servico servico2 : listaServicos) {
//             //             System.out.println(servico2.getCodigoServico() + " - " + servico2.getNomeServico());
//             //         }
//             //         int codigoAtendimentoSelecionado = Integer.parseInt(scanner.nextLine());
//             //         Servico servicoEscolhido = null;
//             //         for (Servico servico2 : listaServicos) {
//             //             if (servico2.getCodigoServico() == codigoAtendimentoSelecionado) {
//             //                 servicoEscolhido = servico2;
//             //                 break;
//             //             }
//             //         }
//             //         if (servicoEscolhido != null) {
//             //             System.out.println("Informe a data para o agendamento (AAAA-MM-DD): ");
//             //             String dataAgendamento = scanner.nextLine();
//             //             try {
//             //                 LocalDate dataAgendamentoSelecionado = LocalDate.parse(dataAgendamento);
//             //                 int proximoCodigoAtendimento = listAtendimentos.size() + 1;
//             //                 Atendimento novoAtendimento = new Atendimento(proximoCodigoAtendimento, clienteAgendamento, servicoEscolhido, dataAgendamentoSelecionado);
//             //                 listAtendimentos.add(novoAtendimento);
//             //                 System.out.println("Agendamento realizado com sucesso para " + dataAgendamentoSelecionado);
//             //             } catch (DateTimeParseException e) {
//             //                 System.out.println("Formato de data inválido. Use o formato aaaa-mm-dd.");
//             //             }
//             //         } else {
//             //             System.out.println("Serviço não encontrado.");
//             //         }
//             //     } else {
//             //         System.out.println("Cliente não encontrado.");
//             //     }
//             //     break;            
//                 case 6:
//                     String arquivoProdutos = "C:\\Users\\user\\Desktop\\Joelson\\faculdade\\com-projeto-salao-beleza\\com-projeto-salao-beleza/produto.txt";
//                     //EstoqueProduto.ExibirEstoque(arquivoProdutos);
//                 break;
//                 case 7:
//                     scanner.close();
//                 break;
//                 default:
//                     System.out.println("Opção padrão ou inválida.");
//                 break;
                
//             }
//         }
//     }
// }