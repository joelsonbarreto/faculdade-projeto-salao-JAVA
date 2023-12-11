package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import conexao.Conexao;
import entity.Produtos;
import entity.Clientes;

public class VendaDAO {
    public void venderProduto(Clientes cliente, Produtos produto, LocalDate dataVenda, float valorTotalVenda){
        String sql = "INSERT INTO vendaproduto (datavenda, nomecliente, nomeproduto, quantidadeproduto, valorproduto, valortotal, idcliente, idproduto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = Conexao.getConexao();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            // Conversão do LocalDate para java.sql.Date
            java.sql.Date sqlDate = java.sql.Date.valueOf(dataVenda);

            // Definição dos parâmetros no PreparedStatement
            ps.setDate(1, sqlDate);
            ps.setString(2, cliente.getNome()); 
            ps.setString(3, produto.getNomeProduto());
            ps.setInt(4, produto.getQuantidadeProduto());
            ps.setFloat(5, produto.getValorProduto());
            ps.setFloat(6, valorTotalVenda); // Utilizando o parâmetro recebido no método
            // ps.setInt(7, cliente.getIdCliente()); // Supondo que existe um método getIdCliente() em Clientes
            // ps.setInt(8, produto.getIdProduto()); // Supondo que existe um método getIdProduto() em Produtos

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


