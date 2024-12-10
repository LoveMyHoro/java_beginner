package project3_斗地主.domain;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Poker extends JLabel implements MouseListener {
    private String name;
    //显示牌是正面还是反面
    private boolean up;
    //是否可以被点击
    private boolean canChick=false;
    //当前的状态
    private boolean clicked=false;
    public Poker(String name,boolean up){
        this.name=name;
        this.up=up;
        if(this.up){
            turnFront();
        }
        else{
            turnRear();
        }
        this.setSize(71,96);
        this.setVisible(true);
        //添加监听
        this.addMouseListener(this);


    }


    //显示正面
    public void turnFront(){
        this.setIcon(new ImageIcon("image/poker/"+this.name+".png"));
        this.up=true;
    }
    //显示反面
    public void turnRear(){
        this.setIcon(new ImageIcon("image/poker/rear.png"));
        this.up=false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //点击
        //判断当前的牌是否可以被点击
        if(canChick){
            int step=0;
            if(clicked){
                step=20;
            }
            else{
                step=-20;
            }
            clicked=!clicked;
            Point from = this.getLocation();
            Point to=new Point(from.x,from.y+step);
            this.setLocation(to);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return up
     */
    public boolean isUp() {
        return up;
    }

    /**
     * 设置
     * @param up
     */
    public void setUp(boolean up) {
        this.up = up;
    }

    /**
     * 获取
     * @return canChick
     */
    public boolean isCanChick() {
        return canChick;
    }

    /**
     * 设置
     * @param canChick
     */
    public void setCanChick(boolean canChick) {
        this.canChick = canChick;
    }

    /**
     * 获取
     * @return clicked
     */
    public boolean isClicked() {
        return clicked;
    }

    /**
     * 设置
     * @param clicked
     */
    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public String toString() {
        return "Poker{name = " + name + ", up = " + up + ", canChick = " + canChick + ", clicked = " + clicked + "}";
    }

    //自己练习
}
