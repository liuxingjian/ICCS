/*
 * Created by JFormDesigner on Fri Dec 17 18:42:31 CST 2021
 */

package 客户端.teacher;

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
public class xiugaixinxi extends JPanel {
    public xiugaixinxi() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        try {
            Mysql m=new Mysql();
            Connection con=m.conn();
            Statement stmt=null;
            stmt=con.createStatement(1005,1008);
            int a=stmt.executeUpdate("update teacher set password = '"+textField3.getText()+"' where " +
                    "account='"+textField1.getText()+"'");
            if(a!=0)
            JOptionPane.showMessageDialog(this,"修改成功","系统提示",JOptionPane.WARNING_MESSAGE);
            this.setVisible(false);
//            this.removeAll();
//            this.setVisible(true);
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        button1 = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
        ( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing. border
        . TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
        propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );
        setLayout(new MigLayout(
            "hidemode 3,gap 20 20",
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
            "[]"));

        //---- label1 ----
        label1.setText("\u8d26\u53f7");
        add(label1, "cell 3 3");
        add(textField1, "cell 7 3 8 1");

        //---- label2 ----
        label2.setText("\u5bc6\u7801");
        add(label2, "cell 3 6");
        add(textField2, "cell 7 6 8 1");

        //---- label3 ----
        label3.setText("\u65b0\u5bc6\u7801");
        add(label3, "cell 3 9");
        add(textField3, "cell 7 9 8 1");

        //---- button1 ----
        button1.setText("\u63d0\u4ea4");
        button1.addActionListener(e -> button1(e));
        add(button1, "cell 13 17");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
