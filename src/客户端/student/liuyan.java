/*
 * Created by JFormDesigner on Thu Dec 16 14:40:31 CST 2021
 */

package 客户端.student;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

import Mysql.Mysql;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class liuyan extends JPanel {
   public static String account=null;
    public liuyan() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here

        Mysql m=new Mysql();
        Connection connection=m.conn();
        Statement stat= null;
        try {
            stat = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
             account=Studentmenu.getAccount();
            int r=stat.executeUpdate("insert into stu_l(account,st,leave_m ) values('"+account+"',"+"'NO','"+textArea1.getText()+"')");
            JOptionPane.showMessageDialog(this,"留言成功,请耐心等待回复","tip",JOptionPane.WARNING_MESSAGE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("succeff");
        try {
            stat.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        m.close();

        this.setVisible(false);
        this.removeAll();
        
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        button1 = new JButton();

        //======== this ========
        setBackground(new Color(51, 255, 255));
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax
        . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing
        .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .
        Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red
        ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override
        public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName (
        ) ) )throw new RuntimeException( ) ;} } );
        setLayout(new MigLayout(
            "hidemode 3,align center center,gap 15 15",
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

            //---- textArea1 ----
            textArea1.setRows(3);
            scrollPane1.setViewportView(textArea1);
        }
        add(scrollPane1, "cell 10 11 20 8");

        //---- button1 ----
        button1.setText("\u53d1\u9001");
        button1.addActionListener(e -> button1(e));
        add(button1, "cell 28 22");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
