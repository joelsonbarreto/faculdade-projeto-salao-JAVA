package DAO;

import entity.Produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;

public class ProdutoDAO {
    public void cadastraProduto(Produtos produto){
        String sql = "INSERT INTO produto (nomeproduto, valorproduto, quantidadeproduto) VALUES (?, ?, ?)";

        try (Connection connection = Conexao.getConexao();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, produto.getNomeProduto());
            ps.setDouble(2, produto.getValorProduto());
            ps.setInt(3, produto.getQuantidadeProduto());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void diminuirQuantidadeProduto(Produtos produto, int quantidadeReduzida) {
        String sql = "UPDATE produto SET quantidadeproduto = quantidadeproduto - ? WHERE idproduto = ?";

        try (Connection connection = Conexao.getConexao();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, quantidadeReduzida);
            ps.setInt(2, produto.getIdProduto());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Produtos buscarProdutoPorCodigo(int codigo) {
        Produtos produto = null;
        String sql = "SELECT * FROM produto WHERE idproduto = ?";

        try (Connection connection = Conexao.getConexao();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Mapeia os valores do ResultSet para um objeto Produtos
                produto = new Produtos();
                produto.setIdProduto(rs.getInt("idproduto"));
                produto.setNomeProduto(rs.getString("nomeproduto"));
                produto.setValorProduto(rs.getDouble("valorproduto"));
                produto.setQuantidadeProduto(rs.getInt("quantidadeproduto"));
                // Defina outros atributos conforme necessário
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produto;
    }
}











// package DAO;

// import entity.Produtos;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;

// import conexao.Conexao;

// public class ProdutoDAO {
//     public void cadastraProduto(Produtos produto){
//         String sql = "INSERT INTO produto (idproduto, nomeproduto, valorproduto, quantidadeproduto) VALUES (?, ?, ?, ?)";

//         PreparedStatement ps = null;
//         try {
//             ps= Conexao.getConexao().prepareStatement(sql);
//             ps.setString(1, produto.getNomeProduto());
//             ps.setDouble(2, produto.getValorProduto());
//             ps.setInt(3, produto.getQuantidadeProduto());
            

//             ps.execute();
//         } catch (SQLException e) {
//             e.printStackTrace();
        
//         }
//     }

//     public void diminuirQuantidadeProduto(Produtos produto, int quantidadeReduzida) {
//         String sql = "UPDATE produto SET quantidadeproduto = quantidadeproduto - ? WHERE id_produto = ?";

//         try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
//             ps.setInt(1, quantidadeReduzida);
//             ps.setInt(2, produto.getIdProduto()); 
            
//             ps.executeUpdate(); 
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }
//     public Produtos buscarProdutoPorCodigo(int codigo) {
//         Produtos produto = null;
//         String sql = "SELECT * FROM produtos WHERE codigoProduto = ?";

//         try (Connection connection = Conexao.getConexao();
//             PreparedStatement ps = connection.prepareStatement(sql)) {

//             ps.setInt(1, codigo);
//             ResultSet rs = ps.executeQuery();

//             if (rs.next()) {
//                 // Aqui você mapeia os valores do ResultSet para um objeto Produtos
//                 produto = new Produtos();
//                 produto.setIdproduto(rs.getInt("codigoProduto"));
//                 produto.setNomeProduto(rs.getString("nomeProduto"));
//                 // Definir outros atributos do produto conforme necessário
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }

//         return produto;
// }


// }
    
