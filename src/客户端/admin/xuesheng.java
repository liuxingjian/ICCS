/*
 * Created by JFormDesigner on Sat Dec 18 21:16:44 CST 2021
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
public class xuesheng extends JPanel {
    public xuesheng() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        try {
            Mysql m=new Mysql();
            Connection con=m.conn();
            Statement stmt=null;
            stmt=con.createStatement(1005,1008);
            int a=stmt.executeUpdate("Insert into stu_m values ('"+textField1.getText()+"','"+textField2.getText()+"','"+textField3.getText()+"','"+textField4.getText()+"')");
            int b=stmt.executeUpdate("Insert into s_t values('"+textField1.getText()+"','"+textField5.getText()+"')");
            int c=stmt.executeUpdate("Insert into student values('"+textField1.getText()+"','"+textField6.getText()+"')");

            if(a!=0&&b!=0&&c!=0)
                JOptionPane.showMessageDialog(this,"添加成功","系统提示",JOptionPane.WARNING_MESSAGE);
            else
               JOptionPane.showMessageDialog(this,"添加失败","系统提示",JOptionPane.WARNING_MESSAGE);

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
        label6 = new JLabel();
        textField6 = new JTextField();
        button1 = new JButton();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder (
        0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder
        . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .
        red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java .
        beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
        setLayout(new MigLayout(
            "hidemode 3,gap 15 15",
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
            "[]"));

        //---- label1 ----
        label1.setText("\u5b66\u53f7");
        add(label1, "cell 13 2");
        add(textField1, "cell 18 2 11 1");

        //---- label2 ----
        label2.setText("\u59d3\u540d");
        add(label2, "cell 13 4");
        add(textField2, "cell 18 4 11 1");

        //---- label3 ----
        label3.setText("\u5b66\u9662");
        add(label3, "cell 13 6");
        add(textField3, "cell 18 6 11 1");

        //---- label4 ----
        label4.setText("\u5e74\u7ea7");
        add(label4, "cell 13 8");
        add(textField4, "cell 18 8 11 1");

        //---- label5 ----
        label5.setText("\u6559\u5e08\u5de5\u53f7");
        add(label5, "cell 13 10");
        add(textField5, "cell 18 10 11 1");

        //---- label6 ----
        label6.setText("\u5bc6\u7801");
        add(label6, "cell 13 12");
        add(textField6, "cell 18 12 11 1");

        //---- button1 ----
        button1.setText("\u63d0\u4ea4");
        button1.addActionListener(e -> button1(e));
        add(button1, "cell 27 15");
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
    private JLabel label6;
    private JTextField textField6;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
