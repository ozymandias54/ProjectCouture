/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package report;
import java.sql.Connection;
import dao.Connectdb;
import java.util.HashMap;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;


/**
 *
 * @author HP
 */
public class ReportUtilisateur {
 
    public void afficher() {
           try {
     Connection conn = Connectdb.getInstance();
     HashMap param = new HashMap();
     JasperPrint print = JasperFillManager.fillReport("report/utilisateur.jasper", param, conn);
         JRViewer viewer=new JRViewer(print); 
         JFrame frame = new JFrame("Liste des Utilisateurs");
            frame.getContentPane().add(viewer);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.pack();
            frame.setVisible(true);
        } 
    catch (JRException ex) {
        System.out.println("erreur:"+ex);
        }
    }
}
