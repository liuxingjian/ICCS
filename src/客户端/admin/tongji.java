/*
 * Created by JFormDesigner on Sat Dec 18 21:41:31 CST 2021
 */

package 客户端.admin;

import java.awt.event.*;
import java.io.File;
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
public class tongji extends JPanel {
    String[][] obb;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel panel1;
    private JComboBox<String> comboBox1;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JTable table1;

    public tongji() {
        initComponents();
    }

    private void comboBox1(ActionEvent e) {
        // TODO add your code here
    }

    private void comboBox1ItemStateChanged(ItemEvent e) {
        // TODO add your code here
        try {
            Mysql m = new Mysql();
            Connection con = m.conn();
            Statement stmt = null;
            ResultSet rs = null;
            stmt = con.createStatement(1005, 1008);
            rs = stmt.executeQuery("select * from stu_pro order by degree");
            if (e.getStateChange() == ItemEvent.SELECTED) {
                System.out.println("选中" + e.getItem());
                if (e.getItem().equals("审核状态")) {
                    rs = stmt.executeQuery("select * from stu_pro order by st");
                } else if (e.getItem().equals("成绩等级")) {
                    rs = stmt.executeQuery("select * from stu_pro order by degree");
                }
            }
            rs.last();
            int k = rs.getRow();
            System.out.println(k + "  0---0");
            if (k == 0) {
                JOptionPane.showMessageDialog(this, "您查询的表为空表！", "系统提示", JOptionPane.WARNING_MESSAGE);
            }
            rs.beforeFirst();
            obb = new String[k][8];
            for (int i = 0; i < k && rs.next(); i++) {
                obb[i][0] = rs.getString("account");
                obb[i][1] = rs.getString("type");
                obb[i][2] = rs.getString("project");
                obb[i][3] = rs.getString("score");
                obb[i][4] = rs.getString("date");
                obb[i][5] = rs.getString("st");
                obb[i][6] = rs.getString("r_score");
                obb[i][7] = rs.getString("degree");
                System.out.println("heslejflskdjf");
                System.out.println(obb[i][0]);
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        table1.setModel(new DefaultTableModel(
                obb,
                new String[]{
                        "账号", "类型", "项目", "申请学分", "申请日期", "审核状态", "认证分数", "成绩等级"
                }
        ));
        scrollPane1.setViewportView(table1);
        add(scrollPane1, "cell 2 2 18 12");
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        Java_App mexel = new Java_App();
        Mysql m = new Mysql();
        Connection conn = m.conn();

        String sql = "select * from stu_pro";
        Statement stm = null;
        ResultSet rs = null;
        String sn = String.valueOf(System.currentTimeMillis());
        File newFile = new File("src\\导出文件\\" + sn + ".xls");
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException ee) {
            // TODO Auto-generated catch block
            ee.printStackTrace();
        }
        try {
            mexel.WriteExcel(newFile, rs);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            conn.close();
            // 关闭数据库连接
        } catch (SQLException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        JOptionPane.showMessageDialog(this,"导出成功","提示",JOptionPane.WARNING_MESSAGE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        panel1 = new JPanel();
        comboBox1 = new JComboBox<>();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.
                EmptyBorder(0, 0, 0, 0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax.swing.border.TitledBorder.CENTER, javax.swing
                .border.TitledBorder.BOTTOM, new java.awt.Font("D\u0069alog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder()));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java.beans.PropertyChangeEvent e) {
                if ("\u0062order".equals(e.getPropertyName()))
                    throw new RuntimeException();
            }
        });
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
                        "[]"));

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
                            "[fill]",
                    // rows
                    "[]" +
                            "[]" +
                            "[]" +
                            "[]"));

            //---- comboBox1 ----
            comboBox1.setModel(new DefaultComboBoxModel<>(new String[]{
                    "\u5ba1\u6838\u72b6\u6001",
                    "\u6210\u7ee9\u7b49\u7ea7"
            }));
            comboBox1.addItemListener(e -> comboBox1ItemStateChanged(e));
            panel1.add(comboBox1, "cell 8 1 3 1");

            //---- button2 ----
            button2.setText("\u5bfc\u51fa\u6587\u4ef6");
            button2.addActionListener(e -> button2(e));
            panel1.add(button2, "cell 14 1");
        }
        add(panel1, "cell 3 1 17 1");

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                    new Object[][]{
                            {null, null, null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null, null, null},
                    },
                    new String[]{
                            null, null, null, null, null, null, null, null, null, null
                    }
            ));
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1, "cell 2 2 18 12");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
