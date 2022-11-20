/*
 * Created by JFormDesigner on Fri Dec 17 17:57:51 CST 2021
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
public class huifu extends JPanel {
    public huifu() {
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
            rs=stmt.executeQuery("select * from stu_l where " +
                    "st='NO'");
            rs.last();
            int k=rs.getRow();
            System.out.println(k);
            if(k==0){
                JOptionPane.showMessageDialog(this,"没有学生留言！","系统提示",JOptionPane.WARNING_MESSAGE);
                this.setVisible(false);
            }
            rs.beforeFirst();
            String ob[][]=new String[k][3];
            for(int i=0;i<k&&rs.next();i++){
                ob[i][0]=rs.getString("account");
                ob[i][1]=rs.getString("st");
                ob[i][2]=rs.getString("leave_m");
                System.out.println(ob[i][0]+"  --");
                textField1.setText(ob[i][0]);
                textField2.setText(ob[i][1]);
                textArea1.setText(ob[i][2]);
                String get_m=textArea2.getText();
                System.out.println(get_m);
                int a=stmt.executeUpdate("update stu_l set get_m='"+get_m+ "',st='yes' where account='"+textField1.getText()+"'");
                System.out.println("---");
                textArea2.setText("");
                break;
            }

            con.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    private void button1(ActionEvent e) {
        // TODO add your code here
        x();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label4 = new JLabel();
        scrollPane2 = new JScrollPane();
        textArea2 = new JTextArea();
        button1 = new JButton();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing.
        border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e" , javax. swing .border . TitledBorder. CENTER
        ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069al\u006fg", java .awt . Font
        . BOLD ,12 ) ,java . awt. Color .red ) , getBorder () ) );  addPropertyChangeListener(
        new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062or\u0064er"
        .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
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

        //---- label1 ----
        label1.setText("\u5b66\u53f7");
        add(label1, "cell 2 2");
        add(textField1, "cell 7 2 15 1");

        //---- label2 ----
        label2.setText("\u72b6\u6001");
        add(label2, "cell 2 4");
        add(textField2, "cell 7 4 15 1");

        //---- label3 ----
        label3.setText("\u7559\u8a00");
        add(label3, "cell 2 6");

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setColumns(6);
            textArea1.setRows(6);
            scrollPane1.setViewportView(textArea1);
        }
        add(scrollPane1, "cell 7 6 15 4");

        //---- label4 ----
        label4.setText("\u56de\u590d");
        add(label4, "cell 2 12");

        //======== scrollPane2 ========
        {

            //---- textArea2 ----
            textArea2.setRows(5);
            scrollPane2.setViewportView(textArea2);
        }
        add(scrollPane2, "cell 7 12 15 4");

        //---- button1 ----
        button1.setText("\u786e\u5b9a");
        button1.addActionListener(e -> button1(e));
        add(button1, "cell 20 18");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label4;
    private JScrollPane scrollPane2;
    private JTextArea textArea2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
