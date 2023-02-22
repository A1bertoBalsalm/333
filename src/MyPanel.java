import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 500;
    final int PANEL_Height = 500;

    static Image AndenFrame, PlayerFrame;
    static Image Andenidle, Andenklicka, Andenladdar, Andensuper, Andensla, Andendod;
    static Image Vila1, Vila2, Sla1, Sla2, Block, Dod;




    Image enemy;
    ImageIcon backgroundImage;

    JLabel background;
    Timer timer;
    int xVelocity = 1;
    int yVelocity = 1;
    int x = 0;
    int y = 0;


    //JButton[] Buttons = new JButton[4];

    static JButton buttons1 = new JButton();
    static JButton buttons2 = new JButton();
    static JButton buttons3 = new JButton();

    static JButton buttons4 = new JButton();

    static JLabel Andendamage = new JLabel();
    JLabel AndenHp = new JLabel();
    JLabel SpelareHp = new JLabel();
    JLabel SpelareDamage = new JLabel();




    static JLabel Finished = new JLabel();



    public static void death(){
        stopMusic();
        Finished.setVisible(true);
        if (Fighting.spelarehp >= 0){
            playMusic(1);
            Finished.setText("Victory");
            AndenFrame = Andendod;
        }
        else{
            playMusic(2);
            Finished.setText("Lose");
            PlayerFrame = Dod;

        }

    }

    public void Spelarebilder() {
         Vila1 = new ImageIcon("src/Bilder/Vila1.png").getImage();
         Vila2 = new ImageIcon("src/Bilder/Vila2.png").getImage();

         Sla1 = new ImageIcon("src/Bilder/Sla1.png").getImage();
         Sla2 = new ImageIcon("src/Bilder/Sla2.png").getImage();


         Block = new ImageIcon("src/Bilder/Block.png").getImage();
         Dod = new ImageIcon("src/Bilder/Dod.png").getImage();

         PlayerFrame = Vila1;




    }

      void Andenbilder() {
         Andenidle = new ImageIcon("src/Bilder/Andenidle.png").getImage();

         Andenklicka = new ImageIcon("src/Bilder/Andenklicka.png").getImage();

         Andenladdar = new ImageIcon("src/Bilder/Andenladdar.png").getImage();

         Andensuper = new ImageIcon("src/Bilder/Andensuper.png").getImage();

         Andensla = new ImageIcon("src/Bilder/Andensla.png").getImage();

          Andendod = new ImageIcon("src/Bilder/AndenDod.png").getImage();

          AndenFrame = Andenidle;

    }

    MyPanel(){

        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_Height));
        this.setBackground(Color.white);
        this.setLayout(null);
        enemy = new ImageIcon("src/Bilder/unknown32423.png").getImage();



        timer = new javax.swing.Timer(10, this);
        timer.start();


        this.add(buttons1);
        buttons1.setBounds(100,50,100,100);
        buttons1.setText("Attack");
        buttons1.addActionListener(this);
        this.add(buttons2);
        buttons2.setBounds(200,50,100,100);
        buttons2.setText("Defend");
        buttons2.addActionListener(this);
        this.add(buttons3);
        buttons3.setBounds(300,50,100,100);
        buttons3.setText("Switch Weapon");
        buttons3.addActionListener(this);



        this.add(buttons4);
        buttons4.setBounds(0,0,100,20);
        buttons4.setText("Gud");
        buttons4.addActionListener(this);

        this.add(Andendamage);
        Andendamage.setBounds(200,180,100,100);
        Andendamage.setText(AI.OndDamage);
        Andendamage.setForeground(Color.red);


        this.add(AndenHp);
        AndenHp.setBounds(400,400,100,100);
        AndenHp.setText(Integer.toString(Fighting.AndenHp));
        AndenHp.setForeground(Color.green);

        this.add(SpelareHp);
        SpelareHp.setBounds(100,400,100,100);
        SpelareHp.setText(Integer.toString(Fighting.spelarehp));
        SpelareHp.setForeground(Color.green);

        this.add(SpelareDamage);
        SpelareDamage.setBounds(300,180,100,100);
        SpelareDamage.setText(Integer.toString(Fighting.SpelareDamage));
        SpelareDamage.setForeground(Color.red);

        this.add(Finished);
        Finished.setText("");
        Finished.setVisible(false);
        Finished.setBounds(250,250,100,100);
        Finished.setForeground(Color.black);
        Finished.setSize(400, 400);

        backgroundImage = new ImageIcon("src/Bilder/saffransbullar_med_vanilj.jpg");
        background = new JLabel("", backgroundImage,JLabel.CENTER);
        background.setBounds(0,0,500,500);
        this.add(background);

        Spelarebilder();
        Andenbilder();
        playMusic(0);


    }
    static Sound sound = new Sound();

    public static void playMusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();
    }
    public static void stopMusic(){
        sound.stop();
    }




    public void paint(Graphics g){

        super.paint(g);

        Graphics g2D = (Graphics2D) g;
        //g2D.drawImage(backgroundImage, 0, 0, null);

        g2D.drawImage(enemy, x, y, null);

        g2D.drawImage(AndenFrame, 300, 250, null);
        g2D.drawImage(PlayerFrame, 100, 250, null);


        Andendamage.setText(AI.OndDamage);

        AndenHp.setText(Integer.toString(Fighting.AndenHp));

        SpelareHp.setText(Integer.toString(Fighting.spelarehp));

        SpelareDamage.setText(Integer.toString(Fighting.SpelareDamage));









    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (x>=PANEL_WIDTH-enemy.getWidth(null) || x<0){
            xVelocity = xVelocity * -1;
        }
        x = x + xVelocity;
        if (y>=PANEL_Height-enemy.getHeight(null) || y<0){
            yVelocity = yVelocity * -1;
        }
        y = y + yVelocity;

        if(e.getSource() == buttons1){
            Fighting.hit();

        }
        if(e.getSource() == buttons2){
            Fighting.defend();

        }
        if(e.getSource() == buttons3){
            Fighting.valdvapen();

        }
        if(e.getSource() == buttons4){
            Sort sort = new Sort();
            int[] arr = {63,78,102,252,3,1};
            int[] arr2 = {4,3,1,5,76,2,5,2};
            sort.Bubblesort(arr);
            sort.Selectionsort(arr2);
            sort.display(arr);
            sort.display(arr2);


        }

       repaint();

    }
}
