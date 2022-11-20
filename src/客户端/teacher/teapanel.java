/*
 * Created by JFormDesigner on Thu Dec 16 15:47:43 CST 2021
 */

package 客户端.teacher;

import java.awt.event.*;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * @author unknown
 */
public class teapanel extends JPanel {
    teachermenu tea;
    public teapanel(teachermenu tea) {
        this.tea=tea;
        initComponents();
    }




    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button6 = new JButton();
        button4 = new JButton();
        button5 = new JButton();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
        . border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder
        . CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .
        awt . Font. BOLD ,12 ) ,java . awt. Color .red ) , getBorder () ) )
        ;  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
        ) { if( "\u0062order" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
        ;
        setLayout(new MigLayout(
            "hidemode 3,gap 0 10",
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

        //---- button1 ----
        button1.setText("\u5ba1\u6838\u5b66\u5206");
        button1.addActionListener(tea);
        add(button1, "cell 4 2");

        //---- button2 ----
        button2.setText("\u67e5\u770b\u5b66\u5206\u660e\u7ec6");
        button2.addActionListener(tea);
        add(button2, "cell 4 3");

        //---- button3 ----
        button3.setText("\u56de\u590d\u7559\u8a00");
        button3.addActionListener(tea);
        add(button3, "cell 4 4");

        //---- button6 ----
        button6.setText("\u6c9f\u901a");
        button6.addActionListener(tea);
        add(button6, "cell 4 5");

        //---- button4 ----
        button4.setText("\u4fee\u6539\u4fe1\u606f");
        button4.addActionListener(tea);
        add(button4, "cell 4 7");

        //---- button5 ----
        button5.setText("\u9000\u51fa");
        button5.addActionListener(tea);
        add(button5, "cell 4 9");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button6;
    private JButton button4;
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
