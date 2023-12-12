package DAO;

import entity.Clientes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;

public class ClienteDAO {
    public void cadastraCliente(Clientes cliente){
        String sql = "INSERT INTO cliente (nomecliente, cpfcliente, enderecocliente, telefonecliente) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getEndereco());
            ps.setString(4, cliente.getTelefone());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        
        }
    }
    public Clientes getCliente(String cpfCliente){
         String sql = "SELECT * FROM cliente WHERE cpfcliente = ?";
         try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, cpfCliente); 
            ResultSet rs = ps.executeQuery();
    
            if (rs.next()) {
               Clientes cliente = new Clientes(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
               return cliente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean verificarExistenciaCPF(String cpf) {
        String sql = "SELECT COUNT(*) AS total FROM cliente WHERE cpfcliente = ?";
        boolean cpfExiste = false;
    
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, cpf); // Correção para utilizar o parâmetro correto, que é 'cpf'
            ResultSet rs = ps.executeQuery();
    
            if (rs.next()) {
                int totalRegistros = rs.getInt("total");
                cpfExiste = totalRegistros > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return cpfExiste;
    }
    
}
    
