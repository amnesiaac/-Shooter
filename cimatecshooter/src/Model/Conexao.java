/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class Conexao {
    Connection connection;
    
    public Connection conectar(){
        String usuario="root";
        String senha="cimatec";
        String driver ="com.mysql.jdbc.Driver";
        String servidor="jdbc:mysql://localhost:3306/jogo";
        try{
            Class.forName(driver);
            return DriverManager.getConnection(servidor,usuario,senha);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Deu erro man"+e.getMessage());
        }
        return null;
    }
}