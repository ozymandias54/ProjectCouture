/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package report;

import dao.Connectdb;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author HP
 */
public class ReportRecu {
     public void affiche(Integer id){
  try {
            Connection conn = Connectdb.getInstance();
            HashMap hm = new HashMap();
            hm.put("idcmd", id);
            JasperPrint jprint = JasperFillManager.fillReport("report/recu.jasper", hm, conn);
            JRViewer viewer=new JRViewer(jprint); 
            JFrame frame = new JFrame("RECU");
            frame.getContentPane().add(viewer);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.pack();
            frame.setVisible(true);

        } catch (Exception e) {
            System.out.print("Exception:" + e);
        }
  }
}
