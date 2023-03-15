package repository;

import entity.ObraLiteraria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import resources.Util;

public class ObraLiterariaRepository {

    private Util util = new Util();
    Connection conn;
    PreparedStatement ppst;

    public ObraLiteraria salvarObraLiteraria(ObraLiteraria obraLiteraria) {
        conn = util.conexao();
        String sql = "INSERT INTO obra_literaria(id,"
                + "titulo,"
                + "autor,"
                + "editora,"
                + "ano_publicacao,"
                + "genero,"
                + "numero_paginas,"
                + "idioma,"
                + "emprestado,"
                + "numero_copias) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setInt(1, obraLiteraria.getId());
            ppst.setString(2, obraLiteraria.getTitulo());
            ppst.setString(3, obraLiteraria.getAutor());
            ppst.setString(4, obraLiteraria.getEditora());
            ppst.setInt(5, obraLiteraria.getAnoPublicacao());
            ppst.setString(6, obraLiteraria.getGenero());
            ppst.setInt(7, obraLiteraria.getNumeroPaginas());
            ppst.setString(8, obraLiteraria.getIdioma());
            ppst.setBoolean(9, obraLiteraria.isEmprestado());
            ppst.setInt(10, obraLiteraria.getNumCopias());
            ppst.executeUpdate();
            ppst.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }

        return null;
    }

    public ObraLiteraria buscarObraLiteraria(int id) {
        try {
            String sql = "SELECT * FROM obra_literaria where id = ?";
            conn = util.conexao();
            ppst = conn.prepareStatement(sql);
            ppst.setInt(1, id);
            ResultSet rs = ppst.executeQuery();
            while (rs.next()) {
                return new ObraLiteraria(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getString(6), rs.getInt(7),
                        rs.getString(8), rs.getBoolean(9), rs.getInt(10));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível consultar o banco.");
        }
        return null;
    }

    public ObraLiteraria editarObraLiteraria(ObraLiteraria obraLiteraria) {
        conn = util.conexao();
        String sql = "UPDATE obra_literaria SET titulo = ?,"
                + "autor = ?,"
                + "editora = ?,"
                + "ano_publicacao = ?,"
                + "genero = ?, "
                + "numero_paginas = ?, "
                + "idioma = ?, "
                + "emprestado = ?, "
                + "numero_copias = ? "
                + "WHERE id = ?";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setInt(10, obraLiteraria.getId());
            ppst.setString(1, obraLiteraria.getTitulo());
            ppst.setString(2, obraLiteraria.getAutor());
            ppst.setString(3, obraLiteraria.getEditora());
            ppst.setInt(4, obraLiteraria.getAnoPublicacao());
            ppst.setString(5, obraLiteraria.getGenero());
            ppst.setInt(6, obraLiteraria.getNumeroPaginas());
            ppst.setString(7, obraLiteraria.getIdioma());
            ppst.setBoolean(8, obraLiteraria.isEmprestado());
            ppst.setInt(9, obraLiteraria.getNumCopias());
            ppst.executeUpdate();
            ppst.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar os dados. " + ex);
        }

        return obraLiteraria;
    }

    public ObraLiteraria excluirObraLiteraria(ObraLiteraria obraLiteraria) {
        conn = util.conexao();
        String sql = "DELETE from obra_literaria WHERE id = ?";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setInt(1, obraLiteraria.getId());
            ppst.executeUpdate();
            ppst.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir os dados. " + ex);
        }
        JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!");
        return obraLiteraria;
    }
    
    public List<ObraLiteraria> buscarObrasLiterarias() {
        try {
            String sql = "SELECT * FROM obra_literaria";
            conn = util.conexao();
            ppst = conn.prepareStatement(sql);
            ResultSet rs = ppst.executeQuery();
            List<ObraLiteraria> obrasLiterarias = new ArrayList<>();
            while (rs.next()) {
                ObraLiteraria obraLiteraria = new ObraLiteraria();
                obraLiteraria = new ObraLiteraria(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getString(6), rs.getInt(7),
                        rs.getString(8), rs.getBoolean(9), rs.getInt(10));
                obrasLiterarias.add(obraLiteraria);
            }
            return obrasLiterarias;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível consultar o banco.");
        }
        return null;
    }

}
