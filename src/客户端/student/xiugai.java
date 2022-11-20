/*
 * Created by JFormDesigner on Thu Dec 16 15:29:12 CST 2021
 */

package 客户端.student;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

import Mysql.Mysql;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class xiugai extends JPanel {
    public xiugai() {
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
            int r=stat.executeUpdate("UPDATE stu_m SET " +
                    "name ='"+ textField2.getText()+"',college='"+ textField3.getText()+"'" +
                            ",grade='"+ textField4.getText()+"' WHERE account ='"+textField1.getText()+"'");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JOptionPane.showMessageDialog(this,"修改成功","tip",JOptionPane.WARNING_MESSAGE);
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
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        button2 = new JButton();
        button1 = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
        . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder
        . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .
        awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder( )) )
        ;  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
        ;
        setLayout(new MigLayout(
            "hidemode 3,gap 20 20",
            // columns
            "[0,fill]" +
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
        label1.setText("\u8d26\u53f7\uff1a");
        add(label1, "cell 3 3 4 1");
        add(textField1, "cell 10 3 9 1");

        //---- label2 ----
        label2.setText("\u59d3\u540d\uff1a");
        add(label2, "cell 3 5 4 1");
        add(textField2, "cell 10 5 9 1");

        //---- label4 ----
        label4.setText("\u5b66\u9662\uff1a");
        add(label4, "cell 3 8");
        add(textField4, "cell 10 8 9 1");

        //---- label3 ----
        label3.setText("\u5e74\u7ea7\uff1a");
        add(label3, "cell 3 10 4 1");
        add(textField3, "cell 10 10 9 1");

        //---- button2 ----
        button2.setText("\u53d6\u6d88");
        add(button2, "cell 7 15");

        //---- button1 ----
        button1.setText("\u63d0\u4ea4");
        button1.addActionListener(e -> button1(e));
        add(button1, "cell 15 15");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label3;
    private JTextField textField3;
    private JButton button2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
