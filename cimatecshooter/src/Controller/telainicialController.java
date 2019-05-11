/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Model.Fase;
import Model.Jogador;
import Model.DAO.jogadorDAO;
import View.telainicialview;
import View.telanome;
import View.telaranking;

/**
 *
 * @author PC
 */
public class telainicialController implements ActionListener {
    telainicialview tview = new telainicialview();
    telanome tnome;
    telaranking trank = new telaranking() ;
    telarankingController trankc;
    Jogador jogador = new Jogador();
    jogadorDAO jdao = new jogadorDAO();
    public telainicialController(telainicialview telainicialview, telanome telanome){
        this.tview=telainicialview;
        this.tnome= telanome;
        tview.btninit.addActionListener(this);
        tview.btnpont.addActionListener(this);
        tnome.btnok.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==tview.btninit){
            tview.setVisible(false);
            new ContainerJanela();
            
        }
            if(ae.getSource()==tnome.btnok){
                jogador.setNome(tnome.txtnome.getText());
                jdao.inserejogador(jogador);
                tview.setVisible(true);
                tnome.setVisible(false);
            }
        if (ae.getSource()==tview.btnpont){
            trankc = new telarankingController(trank) ;
            trankc.trank.setVisible(true);
            tview.setVisible(false);
        }
    }
    public void setponto(Jogador jogador2){
      this.jogador.setTempo(jogador2.getTempo());
    }
    
    public class ContainerJanela extends JFrame {
    
    public ContainerJanela(){
        add(new Fase()); 
        setTitle("JULIA EU TE AMO");
        setSize(500,400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        tnome.setVisible(false);
    }
    
   
        

    }
}
