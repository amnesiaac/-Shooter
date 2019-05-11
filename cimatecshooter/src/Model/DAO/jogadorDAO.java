/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Jogador;
import Model.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */

/**
 *
 * @author aluno
 */
public class jogadorDAO {
    Conexao conexao;
    
    public jogadorDAO(){
    conexao = new Conexao();
}
    
    public void inserejogador(Jogador jogador){
        try{
            Connection con = conexao.conectar();
            String script ="insert into jogador "
                    + "(nome,tempo) "
                    + "values (?,?)";
            PreparedStatement statement= con.prepareStatement(script);
            statement.setString(1,jogador.getNome());
            statement.setLong(2,jogador.getTempo());
            statement.executeUpdate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "deyu erro"+e.getMessage());
        }
    }
    public ArrayList <Jogador> buscarJogador(){
        String script = "select * from jogador ORDER BY tempo ASC";
        Connection con = conexao.conectar();

        ArrayList <Jogador> jogadores = new ArrayList<>();
        try{
            PreparedStatement statement= con.prepareStatement(script);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Jogador jogador = new Jogador();
                jogador.setNome(rs.getString("nome"));
                jogador.setTempo(rs.getLong("tempo"));
                jogadores.add(jogador);
                
            }
        }catch(Exception e){
            System.out.println("errim "+e.getMessage());
        }
        return jogadores;
}
}

