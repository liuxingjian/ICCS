/*
 * Created by JFormDesigner on Thu Dec 16 18:37:46 CST 2021
 */

package 客户端.teacher;

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
public class shenhe extends JPanel {
    public shenhe() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        panel1.setVisible(false);
        panel1.removeAll();
        panel1.setVisible(true);
        try {
        Mysql m=new Mysql();
        Connection con=m.conn();
        Statement stmt=null;
        ResultSet rs=null;
        stmt=con.createStatement(1005,1008);
        rs=stmt.executeQuery("select * from stu_m where " +
                "college='"+textField1.getText()+" ' or " +
                "grade='"+textField2.getText()+" ' or " +
                "name='"+textField3.getText()+" ' or " +
                "account='"+textField4.getText()+" '");
        rs.last();
        int k=rs.getRow();
        if(k==0){
            JOptionPane.showMessageDialog(this,"您查询的表为空表！","系统提示",JOptionPane.WARNING_MESSAGE);
        }
        rs.beforeFirst();
        String ob[][]=new String[k][4];
        for(int i=0;i<k&&rs.next();i++){
            ob[i][0]=rs.getString("account");
            ob[i][1]=rs.getString("name");
            ob[i][2]=rs.getString("college");
            ob[i][3]=rs.getString("grade");
//            ob[i][4]=rs.getString("bm");
//            ob[i][5]=rs.getString("jtdz");
        }
        String s[]={"学号","姓名","学院","年级"};
        JTable m_view = new JTable(ob, s);
        m_view.setSize(700,700);
        m_view.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane sPane=new JScrollPane(m_view);
        sPane.setPreferredSize(new Dimension(m_view.getWidth()-200,m_view.getHeight()-200));
        panel1.add(sPane);
        this.setVisible(true);
        con.close();
    }catch (SQLException ex){
        ex.printStackTrace();
    }


    }

    private void button3(ActionEvent e) {
        // TODO add your code here
        this.setVisible(false);
        this.removeAll();

        this.setVisible(true);
        this.add(new shenhe2());
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
        button1 = new JButton();
        button3 = new JButton();
        panel1 = new JPanel();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
        ( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing. border
        . TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
        propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );
        setLayout(new MigLayout(
            "hidemode 3,gap 10 20",
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
        label1.setText("\u5b66\u9662");
        add(label1, "cell 2 2");
        add(textField1, "cell 4 2 5 1");

        //---- label2 ----
        label2.setText("\u5e74\u7ea7");
        add(label2, "cell 9 2");
        add(textField2, "cell 11 2 5 1");

        //---- label3 ----
        label3.setText("\u59d3\u540d");
        add(label3, "cell 16 2");
        add(textField3, "cell 17 2 5 1");

        //---- label4 ----
        label4.setText("\u5b66\u53f7");
        add(label4, "cell 22 2");
        add(textField4, "cell 23 2 5 1");

        //---- button1 ----
        button1.setText("\u67e5\u8be2");
        button1.addActionListener(e -> button1(e));
        add(button1, "cell 29 2");

        //---- button3 ----
        button3.setText("\u8ba4\u5b9a");
        button3.addActionListener(e -> button3(e));
        add(button3, "cell 31 2");

        //======== panel1 ========
        {
            panel1.setLayout(new MigLayout(
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
                "[]"));
        }
        add(panel1, "cell 2 3 37 19");
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
    private JButton button1;
    private JButton button3;
    private JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
