package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.Servicos;

public class ServicoDAO {
    public void cadastraServico(Servicos servico){
        String sql = "INSERT INTO servico (nomeservico, valorservico) VALUES (?, ?)";

        PreparedStatement ps = null;
        try {
            ps= Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, servico.getNomeServico());
            ps.setDouble(2, servico.getValorServico());           

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        
        }
    }
}
