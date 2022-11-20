/*
 * Created by JFormDesigner on Fri Dec 17 19:14:40 CST 2021
 */

package 客户端.admin;

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
public class jiaoshi extends JPanel {
    public jiaoshi() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        try {
            Mysql m=new Mysql();
            Connection con=m.conn();
            Statement stmt=null;
            stmt=con.createStatement(1005,1008);
            int a=stmt.executeUpdate("Insert into tea_m values ('"+textField1.getText()+"','"+textField2.getText()+"','"+textField3.getText()+"','"+textField4.getText()+"')");
            int b=stmt.executeUpdate("Insert into teacher values('"+textField1.getText()+"','"+textField5.getText()+"')");
            if(a!=0&&b!=0)
                JOptionPane.showMessageDialog(this,"添加成功","系统提示",JOptionPane.WARNING_MESSAGE);
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
        label4 = new JLabel();
        textField4 = new JTextField();
        label5 = new JLabel();
        textField5 = new JTextField();
        button1 = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder( 0
        , 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
        , new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,
         getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
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
            "[]"));

        //---- label1 ----
        label1.setText("\u8d26\u53f7");
        add(label1, "cell 2 2 2 1");
        add(textField1, "cell 7 2 8 1");

        //---- label2 ----
        label2.setText("\u59d3\u540d");
        add(label2, "cell 2 4");
        add(textField2, "cell 7 4 8 1");

        //---- label3 ----
        label3.setText("\u7535\u8bdd");
        add(label3, "cell 2 7");
        add(textField3, "cell 7 7 8 1");

        //---- label4 ----
        label4.setText("\u5bb6\u5ead\u5730\u5740");
        add(label4, "cell 2 10");
        add(textField4, "cell 7 10 8 1");

        //---- label5 ----
        label5.setText("\u767b\u5f55\u5bc6\u7801");
        add(label5, "cell 2 13");
        add(textField5, "cell 7 13 8 1");

        //---- button1 ----
        button1.setText("\u786e\u8ba4");
        button1.addActionListener(e -> button1(e));
        add(button1, "cell 14 17");
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
    private JLabel label4;
    private JTextField textField4;
    private JLabel label5;
    private JTextField textField5;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
