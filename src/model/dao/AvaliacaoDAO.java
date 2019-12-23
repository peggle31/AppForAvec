/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Avaliacao;

/**
 *
 * @author Gustavo Crispim
 * 22/12/2019
 */
public class AvaliacaoDAO {
    
    //CÓDIGO PARA REALIZAR CRIAÇÃO DE PEDIDOS
    public void createAvaliacao (Avaliacao a) throws ParseException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            stmt = con.prepareStatement("INSERT INTO avaliacoes(nome, sobrenome, cpf, dt_nascimento, id_cidade, id_categoria, comentario, nota) "
            + "VALUES (?,?,?,?,(SELECT id_cidade from cidades where desc_cidade = ?),(SELECT id_categoria from categorias where desc_categoria =?),?,?)");
            stmt.setString(1,a.getNome());
            stmt.setString(2,a.getSobrenome());
            stmt.setLong(3,a.getCpf());
            stmt.setDate(4, (java.sql.Date) a.getDt_nascimento());
            stmt.setString(5,a.getDesc_cidade());
            stmt.setString(6,a.getDesc_categoria());
            stmt.setString(7,a.getComentario());
            stmt.setInt(8,a.getNota());
																	   
			
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar! ");
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        
        }
    }

        //CODIGO PARA EXIBIR CATEGORIAS NO COMBOBOX DE AVALIACAO
        public List<Avaliacao> readCategoria(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Avaliacao> avaliacoes = new ArrayList<>();

        try {
	stmt = con.prepareStatement("SELECT desc_categoria from categorias");
	rs = stmt.executeQuery();
        
            while (rs.next()){
        
		Avaliacao avaliacao = new Avaliacao();

		avaliacao.setDesc_categoria(rs.getString("desc_categoria"));																		   
		avaliacoes.add(avaliacao);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return avaliacoes;
    }
        
    public void update(Avaliacao a) throws ParseException {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE avaliacoes SET nome = ?, cpf = ?, id_cidade = (select id_cidade from cidades where desc_cidade = ?), id_categoria = (select id_categoria from categorias where desc_categoria = ?), nota = ? WHERE id_avaliacao = ?");
            stmt.setString(1,a.getNome());
            stmt.setLong(2,a.getCpf());
            stmt.setString(3,a.getDesc_cidade());
            stmt.setString(4,a.getDesc_categoria());
            stmt.setInt(5,a.getNota());
            stmt.setInt(6,a.getId_avaliacao());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Avaliacao a) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM avaliacoes WHERE id_avaliacao = ?");
            stmt.setInt(1, a.getId_avaliacao());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Avaliacao> readForCpf(String cpf) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Avaliacao> avaliacoes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT a.id_avaliacao, a.nome, a.cpf, a.dt_nascimento, ci.desc_cidade, ca.desc_categoria, a.nota, a.created_at FROM avaliacao a "
            +"JOIN categorias ca ON a.id_categoria = ca.id_categoria JOIN cidade ci ON a.id_cidade ON ci.id_cidade WHERE cpf LIKE ?");
            stmt.setString(1, "%"+cpf+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Avaliacao avaliacao = new Avaliacao();

                avaliacao.setId_avaliacao(rs.getInt("id_avaliacao"));
                avaliacao.setNome(rs.getString("nome"));
                avaliacao.setCpf(rs.getLong("cpf"));
                avaliacao.setDt_nascimento(rs.getDate("dt_nascimento"));
                avaliacao.setDesc_cidade(rs.getString("desc_cidade")); 
                avaliacao.setDesc_categoria(rs.getString("desc_categoria")); 
                avaliacao.setNota(rs.getInt("nota")); 
                avaliacao.setCreated_at(rs.getString("created_at")); 
                avaliacoes.add(avaliacao);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return avaliacoes;
    }
    
    public List<Avaliacao> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");

        List<Avaliacao> avaliacoes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT a.id_avaliacao, a.nome, a.cpf, a.dt_nascimento, ci.desc_cidade, ca.desc_categoria, a.nota, a.created_at FROM avaliacoes a "
            +"JOIN categorias ca ON a.id_categoria = ca.id_categoria JOIN cidades ci ON a.id_cidade = ci.id_cidade");   
            rs = stmt.executeQuery();

            while (rs.next()) {

                Avaliacao avaliacao = new Avaliacao();

                avaliacao.setId_avaliacao(rs.getInt("id_avaliacao"));
                avaliacao.setNome(rs.getString("nome"));
                avaliacao.setCpf(rs.getLong("cpf"));
                avaliacao.setDt_nascimento(rs.getDate("dt_nascimento"));
                avaliacao.setDesc_cidade(rs.getString("desc_cidade")); 
                avaliacao.setDesc_categoria(rs.getString("desc_categoria")); 
                avaliacao.setNota(rs.getInt("nota")); 
                avaliacao.setCreated_at(rs.getString("created_at")); 
                avaliacoes.add(avaliacao);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return avaliacoes;
    }
}