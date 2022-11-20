package 客户端.student;

import javax.swing.*;
import java.awt.*;

public class Stupanel extends JPanel {
    JPanel p2;
    private JButton shengqing, liuyan, goutong, chakan, xiugai, tuichu;

    public Stupanel(Studentmenu stu) {
        Image icon = new ImageIcon("src\\background\\000.png").getImage();
        p2 = new 客户端.student.BackgroundPanel(icon);

        p2.setLayout(new GridLayout(7, 1));
        shengqing = new JButton("申请学分");
        p2.add(shengqing);
        shengqing.addActionListener(stu);
        liuyan = new JButton("留言");
        p2.add(liuyan);
        liuyan.addActionListener(stu);
        goutong = new JButton("沟通");
        p2.add(goutong);
        goutong.addActionListener(stu);
        chakan = new JButton("查看认证标准");
        p2.add(chakan);
        chakan.addActionListener(stu);
        xiugai = new JButton("修该信息");
        p2.add(xiugai);
        xiugai.addActionListener(stu);
        tuichu = new JButton("退出");
        p2.add(tuichu);
        tuichu.addActionListener(stu);
    }

    public JPanel jp() {
        return p2;
    }

}
