package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import conexao.Conexao;
import entity.Clientes;
import entity.Produtos;
import entity.VendaProduto;

public class VendaDAO {
    public void salvarVenda(VendaProduto venda) {
        String sql = "INSERT INTO vendaproduto (datavenda, nomecliente, nomeproduto, quantidadeproduto, valorproduto, valortotal) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;

        try {
            java.sql.Date sqlDate = java.sql.Date.valueOf(venda.getDataVenda());
            System.out.println(sqlDate);
            System.out.println(venda.getCliente().getNome());
            System.out.println(venda.getProdutos().getNomeProduto());
            System.out.println(venda.getQuantidadeVenda());
            System.out.println(venda.getProdutos().getValorProduto());
            System.out.println(venda.getTotalValorVenda());

            ps = Conexao.getConexao().prepareStatement(sql);
            
            System.out.println("teste");
            ps.setDate(1, sqlDate);
            ps.setString(2, venda.getCliente().getNome());
            ps.setString(3, venda.getProdutos().getNomeProduto());
            ps.setInt(4, venda.getQuantidadeVenda());
            ps.setFloat(5, venda.getProdutos().getValorProduto());
            ps.setFloat(6, venda.getTotalValorVenda());
            // ps.setInt(7, venda.getCliente().getIdcliente()); 
            // ps.setInt(8, venda.getProdutos().getIdProduto());
           
            ps.execute();
            //System.out.println(ps.execute());
        } catch (SQLException e) {
            System.out.println("teste2");
            e.printStackTrace();
        }
    }

    public VendaProduto buscarInformacoesVenda(String cpfcliente, int codigoProduto, int quantidadeVenda) {
        VendaProduto venda = null;
        String sqlCliente = "SELECT * FROM cliente WHERE cpfcliente = ?";
        String sqlProduto = "SELECT * FROM produto WHERE idproduto = ?";

        try (Connection connection = Conexao.getConexao();
             PreparedStatement psCliente = connection.prepareStatement(sqlCliente);
             PreparedStatement psProduto = connection.prepareStatement(sqlProduto)) {

            // Buscar cliente pelo CPF
            psCliente.setString(1, cpfcliente);
            ResultSet rsCliente = psCliente.executeQuery();

            if (rsCliente.next()) {
                // Cliente encontrado, obter informações
                Clientes cliente = new Clientes();
                cliente.setNome(rsCliente.getString("nomecliente"));
                // Definir outros atributos conforme necessário

                // Buscar produto pelo código
                psProduto.setInt(1, codigoProduto);
                ResultSet rsProduto = psProduto.executeQuery();

                if (rsProduto.next()) {
                    // Produto encontrado, obter informações
                    Produtos produto = new Produtos();
                    produto.setNomeProduto(rsProduto.getString("nomeproduto"));
                    produto.setValorProduto(rsProduto.getFloat("valorproduto"));

                    // Calcular valor total da venda
                    float totalValorVenda = produto.getValorProduto() * quantidadeVenda;

                    // Criar objeto VendaProduto com informações da venda
                    venda = new VendaProduto();
                    venda.setCliente(cliente);
                    venda.setProdutos(produto);
                    venda.setDataVenda(LocalDate.now());
                    venda.setQuantidadeVenda(quantidadeVenda);
                    venda.setTotalValorVenda(totalValorVenda);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return venda;
    }
}
