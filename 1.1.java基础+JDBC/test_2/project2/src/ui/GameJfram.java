package ui;

import Main.GameInfo;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Properties;
import java.util.Random;

public class GameJfram  extends JFrame implements KeyListener ,ActionListener{//继承了窗体JFrame
    //运动图片数组
    //运动图片
    String SportPath="project2\\image\\sport\\sport";
    int SportNum=10;
    //动物图片
    String AnimalPath="project2\\image\\animal\\animal";
    int AnimalNum=8;
    //女性图片
    String MalePath="project2\\image\\girl\\girl";
    int MaleNum=13;
    int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    final int [][]winArr=new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
    //图片位置数组
    int[][] data = new int[4][4];
    //0的初始位置
    int x = 0, y = 0;
    int step=0;
    String path = "project2\\image\\animal\\animal1\\";
    JMenuBar jMenuBar = new JMenuBar();
    JMenuItem Male=new JMenuItem("美女");
    JMenuItem Animal=new JMenuItem("动物");
    JMenuItem Sport=new JMenuItem("运动");
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reloginItem = new JMenuItem("重新登录");
    JMenuItem exitItem = new JMenuItem("关闭游戏");
    JMenuItem accountItem = new JMenuItem("公众号");

    JMenu saveJMenu=new JMenu("存档");
    JMenu loadJMenu=new JMenu("读档");
    JMenuItem saveItem0 = new JMenuItem("存档0(空)");
    JMenuItem saveItem1 = new JMenuItem("存档1(空)");
    JMenuItem saveItem2 = new JMenuItem("存档2(空)");
    JMenuItem saveItem3 = new JMenuItem("存档3(空)");
    JMenuItem saveItem4 = new JMenuItem("存档4(空)");

    JMenuItem loadItem0 = new JMenuItem("读档0(空)");
    JMenuItem loadItem1 = new JMenuItem("读档1(空)");
    JMenuItem loadItem2 = new JMenuItem("读档2(空)");
    JMenuItem loadItem3 = new JMenuItem("读档3(空)");
    JMenuItem loadItem4 = new JMenuItem("读档4(空)");

    public GameJfram() {
        //初始化窗口
        initJFrame();
        //初始化菜单
        initJMenuBar();
        //打乱图片
        InitData();
        //导入图片
        initImage();


        //让窗口保持可视化
        this.setVisible(true);

    }

    private void InitData() {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int index = r.nextInt(arr.length);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            data[i / 4][i % 4] = arr[i];
            if (arr[i] == 0) {
                x = i % 4;
                y = i / 4;
            }
        }
    }

    private void initImage() {
        //清空本容器所有图片
        this.getContentPane().removeAll();
        JLabel stepCount=new JLabel("步数："+step);
        stepCount.setBounds(50,30,100,20);
        this.add(stepCount);

        if(Win()){
            JLabel jLabel = new JLabel(new ImageIcon("project2\\image\\win.png"));
            jLabel.setBounds( 203,  283, 197, 73);
            this.getContentPane().add(jLabel);
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    System.out.println(data[i][j]+" "+winArr[i][j]);
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //导入图片
                ImageIcon icon = new ImageIcon(path + data[i][j] + ".jpg");
                //把图片放入容器
                JLabel jLabel = new JLabel(icon);
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);

                //为图片添加边框
                //BevelBorder(0)：让图片凸起来。也可以用BevelBorder.LOWERED
                //BevelBorder(1)：让图片凹下去。也可以用BevelBorder.RAISED
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //.getContentPane()用于获取隐藏容器
                this.getContentPane().add(jLabel);
            }
        }
        //小细节：先加载的图片放在上面面，后加载的图片放在下面
        //获取背景图片并放入容器
        JLabel background = new JLabel(new ImageIcon("project2\\image\\background.png"));
        background.setBounds(40, 40, 508, 560);
        //放入界面
        this.getContentPane().add(background);
        //更新界面
        this.getContentPane().repaint();
    }

    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu1 = new JMenu("功能");
        JMenu jMenu2 = new JMenu("关于我们");
        JMenu jMenu3=new JMenu("更换图片");

        //把5个存档，添加到saveJMenu中
        saveJMenu.add(saveItem0);
        saveJMenu.add(saveItem1);
        saveJMenu.add(saveItem2);
        saveJMenu.add(saveItem3);
        saveJMenu.add(saveItem4);

        //把5个读档，添加到loadJMenu中
        loadJMenu.add(loadItem0);
        loadJMenu.add(loadItem1);
        loadJMenu.add(loadItem2);
        loadJMenu.add(loadItem3);
        loadJMenu.add(loadItem4);


        //添加到功能菜单中
        jMenu1.add(jMenu3);
        jMenu1.add(replayItem);
        jMenu1.add(reloginItem);
        jMenu1.add(exitItem);
        jMenu1.add(saveJMenu);
        jMenu1.add(loadJMenu);
        jMenu2.add(accountItem);
        jMenu3.add(Male);
        jMenu3.add(Animal);
        jMenu3.add(Sport);
        //绑定监听事件
        Male.addActionListener(this);
        Animal.addActionListener(this);
        Sport.addActionListener(this);
        replayItem.addActionListener(this);
        reloginItem.addActionListener(this);
        exitItem.addActionListener(this);
        accountItem.addActionListener(this);
        saveItem0.addActionListener(this);
        saveItem1.addActionListener(this);
        saveItem2.addActionListener(this);
        saveItem3.addActionListener(this);
        saveItem4.addActionListener(this);
        loadItem0.addActionListener(this);
        loadItem1.addActionListener(this);
        loadItem2.addActionListener(this);
        loadItem3.addActionListener(this);
        loadItem4.addActionListener(this);



        //  getGameInfo();
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        this.setJMenuBar(jMenuBar);
    }
    public void getGameInfo(){
        File file=new File("project2\\save");
        File[]files=file.listFiles();
        for (File file1 : files) {
            GameInfo gi= null;
            try {
                ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file1));
                gi = (GameInfo)ois.readObject();
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            int step=gi.getStep();
            String name=file1.getName();
            int index=name.charAt(4)-'0';
            saveJMenu.getItem(index).setText("存档"+index+"("+step+")步");
            loadJMenu.getItem(index).setText("存档"+index+"("+step+")步");

        }
    }
    private void initJFrame() {
        //设置窗口大小
        this.setSize(603, 680);
        //设置窗口名
        this.setTitle("赫萝的拼图小游戏");
        //设置窗口处于上层
        this.setAlwaysOnTop(true);
        //设置窗口居中
        this.setLocationRelativeTo(null);
        //设置叉掉窗口后程序结束运行
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认的居中放置，只有取消了才会按照xy轴的形式添加组件
        this.setLayout(null);
        //给整个界面添加键盘监听设置
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //按住不放
    @Override
    public void keyPressed(KeyEvent e) {
        if(Win()){
            return;
        }
        int code = e.getKeyCode();
        //空格
        if (code == 32) {
            this.getContentPane().removeAll();
            JLabel jLabel = new JLabel(new ImageIcon(path + "all.jpg"));
            jLabel.setBounds(83, 134, 420, 420);
            this.add(jLabel);
        }
        //放入背景
        JLabel background = new JLabel(new ImageIcon("project2\\image\\background.png"));
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);
        this.getContentPane().repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(Win()){
            return;
        }
        int code = e.getKeyCode();
        System.out.println(code);
        switch (code) {
            case 83 -> {
                if (y == 0) {
                    return;
                }
                data[y][x] = data[y - 1][x];
                data[y - 1][x] = 0;
                y--;
                step++;
                System.out.println("向下");
                initImage();
            }
            case 87 -> {
                if (y == 3) {
                    return;
                }
                data[y][x] = data[y + 1][x];
                data[y + 1][x] = 0;
                y++;
                step++;
                System.out.println("向上");
                initImage();
            }
            case 68 -> {
                if (x == 0) {
                    return;
                }
                data[y][x] = data[y][x - 1];
                data[y][x - 1] = 0;
                x--;
                step++;
                System.out.println("向右");
                initImage();
            }
            case 65 -> {
                if (x == 3) {
                    return;
                }
                data[y][x] = data[y][x + 1];
                data[y][x + 1] = 0;
                x++;
                step++;
                System.out.println("向左");
                initImage();
            }
            case 32 -> {
                initImage();
            }
            case 48 -> {//0按键
                int cnt=1;
                for (int i = 0; i <4; i++) {
                    for(int j=0;j<4;j++){
                        data[i][j]=cnt;
                        cnt++;
                    }
                }
                data[3][3]=0;
                initImage();
                x=3;
                y=3;
            }

        }
    }
    public boolean Win(){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(data[i][j]!=winArr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj=e.getSource();
        if(obj==Male){//比较地址
            System.out.println("更换女性图片");
            Random r=new Random();
            int IndexMal=r.nextInt(MaleNum)+1;
            path=MalePath+IndexMal+"\\";
            System.out.println("重新游戏");
            //步数清零
            step=0;
            //打乱数组
            InitData();
            //初始化图片
            initImage();
        }
        else if(obj==Animal){
            System.out.println("更换动物图片");
            Random r=new Random();
            int IndexAnimal=r.nextInt(AnimalNum)+1;
            path=AnimalPath+IndexAnimal+"\\";
            System.out.println("重新游戏");
            //步数清零
            step=0;
            //打乱数组
            InitData();
            //初始化图片
            initImage();
        } else if (obj == Sport) {
            System.out.println("更换运动图片");
            Random r=new Random();
            int IndexSport=r.nextInt(SportNum)+1;
            path=SportPath+IndexSport+"\\";
            System.out.println("重新游戏");
            //步数清零
            step=0;
            //打乱数组
            InitData();
            //初始化图片
            initImage();

        } else if(obj==replayItem)
        {
            System.out.println("重新游戏");
            //步数清零
            step=0;
            //打乱数组
            InitData();
            //初始化图片
            initImage();
        }
        else if(obj==reloginItem){
            System.out.println("重新登录");
            //关闭当前页面
            this.setVisible(false);
            //打开登录页面
            try {
                new LoginJfram();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(obj==exitItem){
            System.out.println("关闭游戏");
            //直接关闭虚拟机
            System.exit(0);
        }
        else if(obj==accountItem){
            System.out.println("公众号");
            Properties prop=new Properties();
            try {
                BufferedReader br=new BufferedReader(new FileReader("project2\\GamePicture.properties"));
                prop.load(br);
                br.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            String path=(String) prop.get("account");
            System.out.println(prop);
            //生成弹窗
            JDialog jDialog=new JDialog();
            JLabel jLabel=new JLabel(new ImageIcon(path));
            jLabel.setBounds(0,0,258,258);
            jDialog.add(jLabel);
            jDialog.setSize(344,344);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);

            //不关闭就无法操作下面的页面
            jDialog.setModal(true);
            jDialog.setVisible(true);
        }else if(obj == saveItem0 || obj == saveItem1 || obj == saveItem2 || obj == saveItem3 ||obj == saveItem4){
            JMenuItem item = (JMenuItem) obj;
            int s=((JMenuItem) obj).getText().charAt(2)-'0';
            System.out.println(item.getText());

            ObjectOutputStream oos= null;
            try {
                oos = new ObjectOutputStream(new FileOutputStream("project2\\save\\save"+s+".data"));
                GameInfo gi=new GameInfo(data,x,y,path,step);
                oos.writeObject(gi);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                oos.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            item.setText("存档"+s+"("+step+"步)");
            loadJMenu.getItem(s).setText("读档"+s+"("+step+"步)");

        }else if(obj == loadItem0 || obj == loadItem1 || obj == loadItem2 || obj == loadItem3 ||obj == loadItem4){
            JMenuItem item=(JMenuItem)obj;
            String str=item.getText();
            int index=str.charAt(2)-'0';

            GameInfo gi=null;
            try {
                ObjectInputStream ois=new ObjectInputStream(new FileInputStream("D:\\java\\code\\test_2\\project2\\save\\save0.data"));
                gi=(GameInfo) ois.readObject();
                ois.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            data=gi.getData();
            path=gi.getPath();
            step=gi.getStep();
            x=gi.getX();
            y=gi.getY();
            initImage();


        }

    }
}
