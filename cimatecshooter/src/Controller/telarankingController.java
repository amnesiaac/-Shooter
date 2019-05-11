/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.telainicialController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Model.Jogador;
import Model.DAO.jogadorDAO;
import View.telainicialview;
import View.telanome;
import View.telaranking;

/**
 *
 * @author aluno
 */
public class telarankingController implements ActionListener {
    telaranking trank;
    telainicialview tview = new telainicialview();
    telanome tnome = new telanome();
    telainicialController tviewc;
    jogadorDAO jdao = new jogadorDAO();
    public telarankingController(telaranking telaranking){
        trank = telaranking;
        trank.btnok.addActionListener(this);
        preenchetabela(trank.tabelaranking);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==trank.btnok){
            tviewc = new telainicialController(tview,tnome);
            tviewc.tview.setVisible(true);
            trank.setVisible(false);
        }
    }
      public void preenchetabela(JTable tabelajogadores) {
        DefaultTableModel tabela = new DefaultTableModel();       
        tabelajogadores.setModel(tabela);
        tabela.addColumn("nome");
        tabela.addColumn("tempo em milisegundos");
        Object[] coluna = new Object[2];
        ArrayList<Jogador> jogadores = jdao.buscarJogador();
        for (int i = 0; i < jogadores.size(); i++) {
            coluna[0] = jogadores.get(i).getNome();
            coluna[1] = jogadores.get(i).getTempo();
            tabela.addRow(coluna);
            
        }
        tabelajogadores.setModel(tabela);
    }
    
}
