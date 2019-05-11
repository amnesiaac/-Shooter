
package jogonave;


import View.telanome;
import View.telainicialview;
import Controller.telainicialController;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Principal {
   
    
    public static void main(String[] args) {
        telainicialview tview = new telainicialview();
        telanome tnome = new telanome();
        
        tview.setVisible(true);
        telainicialController c = new telainicialController(tview,tnome);
    }
    
}
