package test_3_Runtime;

import javax.swing.*;

public class test_3_2 extends JFrame {
    public test_3_2(){
        this.setSize(500,600);
        this.setTitle("恶搞小游戏");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
        initJFrame();

    }
    public void initJFrame(){
        JButton jb1=new JButton("你好");
        jb1.setBounds(120,150,300,50);
        jb1.setVisible(true);
        this.add(jb1);
    }

}
