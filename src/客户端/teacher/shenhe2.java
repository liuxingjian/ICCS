/*
 * Created by JFormDesigner on Fri Dec 17 10:43:47 CST 2021
 */

package 客户端.teacher;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
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
public class shenhe2 extends JPanel {
    public shenhe2() {
        initComponents();
        x();
    }
public void x(){
    try {
        Mysql m=new Mysql();
        Connection con=m.conn();
        Statement stmt=null;
        ResultSet rs=null;
        stmt=con.createStatement(1005,1008);
        rs=stmt.executeQuery("select * from stu_pro where " +
                "st like N'未审核'");
        rs.last();
        int k=rs.getRow();
        if(k==0){
            JOptionPane.showMessageDialog(this,"没有待审核的学生！","系统提示",JOptionPane.WARNING_MESSAGE);
            this.setVisible(false);
        }
        rs.beforeFirst();
        String ob[][]=new String[k][6];
        for(int i=0;i<k&&rs.next();i++){
            ob[i][0]=rs.getString("account");
            ob[i][1]=rs.getString("type");
            ob[i][2]=rs.getString("project");
            ob[i][3]=rs.getString("score");
            ob[i][4]=rs.getString("date");
            ob[i][5]=rs.getString("st");
            textField5.setText(ob[i][0]);
            textField6.setText(ob[i][1]);
            textField7.setText(ob[i][2]);
            textField8.setText(ob[i][3]);
            textField9.setText(ob[i][4]);
            textField10.setText(ob[i][5]);
            break;
        }
        con.close();
    }catch (SQLException ex){
        ex.printStackTrace();
    }
}
    private void button1(ActionEvent e) {
        // TODO add your code here

        System.out.println("-----");
        try {
            Connection con=new Mysql().conn();
            Statement stmt=null;
            stmt=con.createStatement();
            int d= Integer.parseInt(textField1.getText());
            String s=null;
            if(d>=7){
                s="优秀";
            }else if(d>=6){
                s="良好";
            }else if(d>=5){
                s="中等";
            }else if(d>4){
                s="及格";
            }else s="不及格";
            System.out.println(textField5.getText()+"  "+s);
            String s1="UPDATE stu_pro set r_score ='"+textField1.getText()+"'," +
                    "degree='"+s+"', st='已审核' where account='"+textField5.getText()+"'";
            int a=stmt.executeUpdate(s1);
            JOptionPane.showMessageDialog(this,"审核成功","tip",JOptionPane.WARNING_MESSAGE);
            System.out.println(a);
            con.close();
            textField1.setText("");
            x();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        try {
            Connection con=new Mysql().conn();
            Statement stmt=null;
            stmt=con.createStatement();
            ResultSet rs=stmt.getResultSet();
            String s1="SELECT  * from stu_path where account='"+textField5.getText()+"'";
            rs=stmt.executeQuery(s1);
            String path=null;
            while(rs.next()){
                path=rs.getString("path");
            }


            System.out.println(path+"---");
            File file=new File(path);
            try {
                java.awt.Desktop.getDesktop().open(file.getParentFile());
            } catch (IOException e1) {
                e1.printStackTrace();
            };
            try {
                java.awt.Desktop.getDesktop().open(file.getParentFile());
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            con.close();
            x();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        textField5 = new JTextField();
        label12 = new JLabel();
        label2 = new JLabel();
        textField6 = new JTextField();
        label7 = new JLabel();
        label3 = new JLabel();
        textField7 = new JTextField();
        label8 = new JLabel();
        label5 = new JLabel();
        textField8 = new JTextField();
        label9 = new JLabel();
        label6 = new JLabel();
        textField9 = new JTextField();
        label4 = new JLabel();
        textField10 = new JTextField();
        label10 = new JLabel();
        label11 = new JLabel();
        textField1 = new JTextField();
        button2 = new JButton();
        button1 = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(
        0,0,0,0), "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder
        .BOTTOM,new java.awt.Font("D\u0069al\u006fg",java.awt.Font.BOLD,12),java.awt.Color.
        red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.
        beans.PropertyChangeEvent e){if("\u0062or\u0064er".equals(e.getPropertyName()))throw new RuntimeException();}});
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
            "[]"));

        //---- label1 ----
        label1.setText("\u8d26\u53f7");
        add(label1, "cell 6 5");
        add(textField5, "cell 12 5 16 1");
        add(label12, "cell 35 5 18 1");

        //---- label2 ----
        label2.setText("\u7c7b\u578b");
        add(label2, "cell 6 7");
        add(textField6, "cell 12 7 16 1");
        add(label7, "cell 35 7 18 1");

        //---- label3 ----
        label3.setText("\u9879\u76ee");
        add(label3, "cell 6 10");
        add(textField7, "cell 12 10 16 1");
        add(label8, "cell 35 10 18 1");

        //---- label5 ----
        label5.setText("\u7533\u8bf7\u5206\u6570");
        add(label5, "cell 6 13");
        add(textField8, "cell 12 13 16 1");
        add(label9, "cell 35 13 18 1");

        //---- label6 ----
        label6.setText("\u7533\u8bf7\u65f6\u95f4");
        add(label6, "cell 6 16");
        add(textField9, "cell 12 16 16 1");

        //---- label4 ----
        label4.setText("\u7533\u8bf7\u72b6\u6001");
        add(label4, "cell 6 21");
        add(textField10, "cell 12 21 16 1");
        add(label10, "cell 30 21 21 1");

        //---- label11 ----
        label11.setText("\u8ba4\u8bc1\u5206\u6570");
        add(label11, "cell 6 26");
        add(textField1, "cell 12 26 16 1");

        //---- button2 ----
        button2.setText("\u8bc1\u660e\u6750\u6599");
        button2.addActionListener(e -> button2(e));
        add(button2, "cell 19 29");

        //---- button1 ----
        button1.setText("\u786e\u8ba4");
        button1.addActionListener(e -> button1(e));
        add(button1, "cell 25 29");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JTextField textField5;
    private JLabel label12;
    private JLabel label2;
    private JTextField textField6;
    private JLabel label7;
    private JLabel label3;
    private JTextField textField7;
    private JLabel label8;
    private JLabel label5;
    private JTextField textField8;
    private JLabel label9;
    private JLabel label6;
    private JTextField textField9;
    private JLabel label4;
    private JTextField textField10;
    private JLabel label10;
    private JLabel label11;
    private JTextField textField1;
    private JButton button2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
