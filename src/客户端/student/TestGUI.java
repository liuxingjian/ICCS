package text;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jdesktop.swingx.JXDatePicker;


import javax.swing.*;


public class TestGUI extends JPanel {

    public String s;
    public TestGUI() {
        this.setSize(400, 300);

        Date date = new Date();
        final JXDatePicker datepick = new JXDatePicker();

// 设置 date日期
        datepick.setDate(date);
        datepick.setSize(177, 24);
        this.add(datepick);
        JButton b = new JButton("获取时间");
        b.setSize( 100, 30);
        this.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = datepick.getDate();
                SimpleDateFormat f1=new SimpleDateFormat("yyyy-MM-dd");
                s=f1.format(d);
                System.out.println(s);    //将当前时间袼式化为指定的格式
            }
        });
    }

    public String getS() {
        return s;
    }
}