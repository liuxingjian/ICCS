/*
 * Created by JFormDesigner on Fri Dec 17 16:44:11 CST 2021
 */

package 客户端.teacher;

import java.awt.*;
import java.beans.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.*;

import Mysql.Mysql;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class chakan extends JPanel {
    String ob[][];
    public chakan() {
        x();
        initComponents();
    }
public void x(){
    try {
        Mysql m=new Mysql();
        Connection con=m.conn();
        Statement stmt=null;
        ResultSet rs=null;
        stmt=con.createStatement(1005,1008);
        rs=stmt.executeQuery("select * from stu_pro");
        rs.last();
        int k=rs.getRow();
        System.out.println(k+"  0---0");
        if(k==0){
            JOptionPane.showMessageDialog(this,"您查询的表为空表！","系统提示",JOptionPane.WARNING_MESSAGE);
        }
        rs.beforeFirst();
        ob=new String[k][8];
        for(int i=0;i<k&&rs.next();i++){
            ob[i][0]=rs.getString("account");
            ob[i][1]=rs.getString("type");
            ob[i][2]=rs.getString("project");
            ob[i][3]=rs.getString("score");
            ob[i][4]=rs.getString("date");
            ob[i][5]=rs.getString("st");
            ob[i][6]=rs.getString("r_score");
            ob[i][7]=rs.getString("degree");
            System.out.println("heslejflskdjf");
        }

        con.close();
    }catch (SQLException ex){
        ex.printStackTrace();
    }
}
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.
        swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e",javax.swing.border
        .TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dialo\u0067"
        ,java.awt.Font.BOLD,12),java.awt.Color.red), getBorder
        ())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java
        .beans.PropertyChangeEvent e){if("borde\u0072".equals(e.getPropertyName()))throw new RuntimeException
        ();}});
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                ob,
                new String[] {
                    "\u8d26\u53f7", "\u7c7b\u578b", "\u9879\u76ee", "\u7533\u8bf7\u5b66\u5206", "\u7533\u8bf7\u65e5\u671f", "\u7533\u8bf7\u72b6\u6001", "\u8ba4\u8bc1\u5b66\u5206", "\u8ba4\u8bc1\u7b49\u7ea7"
                }
            ));
            table1.setPreferredScrollableViewportSize(new Dimension(500, 400));
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1, "cell 0 2 37 18,align center center,grow 0 0");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
