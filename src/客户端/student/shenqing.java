/*
 * Created by JFormDesigner on Thu Dec 16 14:24:47 CST 2021
 */

package 客户端.student;

import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import Mysql.Mysql;
import net.miginfocom.swing.*;
import text.TestGUI;

/**
 * @author unknown
 */
public class shenqing extends JPanel {
    String sp=null;
    TestGUI t=new TestGUI();
    public shenqing() {
        initComponents();
      //  add(new TestGUI());
    }

    private void button3(ActionEvent e) {
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
            Studentmenu.setAccount(textField1.getText());
            System.out.println(t.getS()+"00000");
            int r=stat.executeUpdate("insert into stu_pro(account,type,project,score,date,st)" +
                    "values ('"+textField1.getText()+"','"+textField2.getText()+
                    "','"+ textField3.getText()+"','"+ textField4.getText()+"','"+t.getS()+"','未审核')");
            String sa=Studentmenu.getAccount();
            int rr=stat.executeUpdate("insert into stu_path values ('"+sa+"','"+sp+"')");
            //  int total_s=
          //  int rr=stat.executeUpdate()
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JOptionPane.showMessageDialog(this,"申请成功,请耐心等待审核结果","提示",JOptionPane.WARNING_MESSAGE);
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

    private void button2(ActionEvent e) {
        // TODO add your code here



    }

    private void button1(ActionEvent e) {
        // TODO add your code here
            JButton developer= new JButton();
            JFileChooser chooser = new JFileChooser();
            chooser.setMultiSelectionEnabled(true);
            /** 过滤文件类型 * */
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*",
                    "xml", "txt", "doc", "docx");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(developer);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                /** 得到选择的文件* */
                File[] arrfiles = chooser.getSelectedFiles();
                if (arrfiles == null || arrfiles.length == 0) {
                    return;
                }
                FileInputStream input = null;
                FileOutputStream out = null;
                String ss= String.valueOf(System.currentTimeMillis());
                String path = "src//材料下载//"+ss+"//";
                try {
                    for (File f : arrfiles) {
                        File dir = new File(path);
                        if(!dir.exists()){
                            dir.mkdir();
                        }
                        /** 目标文件夹 * */
                        File[] fs = dir.listFiles();
                        HashSet<String> set = new HashSet<String>();
                        for (File file : fs) {
                            set.add(file.getName());
                        }
                        /** 判断是否已有该文件* */
                        if (set.contains(f.getName())) {
                            JOptionPane.showMessageDialog(new JDialog(),
                                    f.getName() + ":该文件已存在！");
                            return;
                        }
                        input = new FileInputStream(f);
                        byte[] buffer = new byte[1024];

                        File des = new File(path, f.getName());
                        sp=path+f.getName();
                        out = new FileOutputStream(des);
                        int len = 0;
                        while (-1 != (len = input.read(buffer))) {
                            out.write(buffer, 0, len);
                        }
                        out.close();
                        input.close();
                    }
                    JOptionPane.showMessageDialog(null, "上传成功！", "提示",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (FileNotFoundException e1) {
                    JOptionPane.showMessageDialog(null, "上传失败！", "提示",
                            JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace();
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "上传失败！", "提示",
                            JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace();
                }
            }
        }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        button2 = new JButton();
        button3 = new JButton();
        label6 = new JLabel();
        button1 = new JButton();
        label5 = new JLabel();
        label4 = new JLabel();
        textField4 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label1 = new JLabel();
        textField1 = new JTextField();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
        swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border
        . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dialo\u0067"
        ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder
        ( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
        .beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException
        ( ); }} );
        setLayout(new MigLayout(
            "btt,hidemode 3,align center center,gap 10 10",
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
            "[45,fill]" +
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
            "[0]" +
            "[0]" +
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

        //---- button2 ----
        button2.setText("\u53d6\u6d88");
        button2.addActionListener(e -> {
			button2(e);
			button2(e);
		});
        add(button2, "cell 18 13");

        //---- button3 ----
        button3.setText("\u786e\u8ba4");
        button3.addActionListener(e -> button3(e));
        add(button3, "cell 26 13");

        //---- label6 ----
        label6.setText("\u4e0a\u4f20\u6750\u6599\uff1a");
        add(label6, "cell 9 17 4 1");

        //---- button1 ----
        button1.setText("\u4e0a\u4f20\u6587\u4ef6");
        button1.addActionListener(e -> button1(e));
        add(button1, "cell 25 17 3 1");

        //---- label5 ----
        label5.setText("\u7533\u8bf7\u65f6\u95f4\uff1a");
        add(label5, "cell 9 20 5 1");
        add(t,"cell 21 20 15 1");
        //---- label4 ----
        label4.setText("\u7533\u8bf7\u5206\u6570\uff1a");
        add(label4, "cell 9 23 5 1");
        add(textField4, "cell 20 23 16 1");

        //---- label3 ----
        label3.setText("\u9879\u76ee\u540d\u79f0\uff1a");
        add(label3, "cell 9 26 7 1");
        add(textField3, "cell 20 26 16 1");

        //---- label2 ----
        label2.setText("\u9879\u76ee\u7c7b\u578b\uff1a");
        add(label2, "cell 9 29 8 1");
        add(textField2, "cell 20 29 16 1");

        //---- label1 ----
        label1.setText("\u8d26\u53f7\uff1a");
        add(label1, "cell 9 31 8 3");
        add(textField1, "cell 20 32 16 1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JButton button2;
    private JButton button3;
    private JLabel label6;
    private JButton button1;
    private JLabel label5;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label1;
    private JTextField textField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
