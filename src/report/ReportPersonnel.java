/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package report;

import dao.Connectdb;
import java.awt.GridLayout;
import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author HP
 */
public class ReportPersonnel {
    public  void afficher_report() {
    try {
     Connection conn = Connectdb.getInstance();
     HashMap param = new HashMap();
			
 JasperPrint print = JasperFillManager.fillReport("report/Personnel.jasper", param, conn);
         JRViewer viewer=new JRViewer(print); 

            JFrame frame = new JFrame("LISTE DES EMPLOYEES");
            frame.getContentPane().add(viewer);
            frame.setExtendedState(frame.MAXIMIZED_BOTH);
            frame.pack();
            frame.setVisible(true);
        } 
    catch (JRException ex) {
       Logger.getLogger(ReportUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public JPanel afficher() {
        GridLayout grid=new GridLayout();
         JPanel panel = new JPanel(grid);
    try {
     Connection conn = Connectdb.getInstance();
     HashMap param = new HashMap();
			
 JasperPrint print = JasperFillManager.fillReport("report/Personnel.jasper", param, conn);
         JRViewer viewer=new JRViewer(print); 
         panel.add(viewer);
        } 
    catch (JRException ex) {
       Logger.getLogger(ReportUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    return panel;
    }
}
