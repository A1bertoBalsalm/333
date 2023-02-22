import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;


public class NewWindow extends AI implements ActionListener {

    JFrame frame = new JFrame();
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    static Random r1 = new Random();
    static Random r2 = new Random();
    JButton button1 = new JButton();
    JButton button2 = new JButton();
    JButton button3 = new JButton();

    static int button1x;
    static int button1y;
    static int button2x;
    static int button2y;
    static int button3x;
    static int button3y;

    static int klick = 0;

    ImageIcon backgroundImage;

    JLabel background;

    Timer timer;
    int second;

    int screenwidth;
    int screenheight;


    public static void Quickevent() {
        int i = 1;
        int screenwidth = (int)screenSize.getWidth();
        int screenheight = (int)screenSize.getHeight();



        for (int e = 1; e <= 3; e++) {

            int buttonx = r1.nextInt(100,screenwidth-100);
            int buttony = r2.nextInt(100,screenheight-100);


            switch (i){
                case 1:
                    button1x = buttonx;
                    button1y = buttony;
                    i++;
                    continue;
                case 2:
                    button2x = buttonx;
                    button2y = buttony;
                    i++;
                    continue;
                case 3:
                    button3x = buttonx;
                    button3y = buttony;
                    i++;
                case 4:
                    NewWindow myWindow = new NewWindow();



            }
        }














    }

    NewWindow(){
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(screenSize);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBackground(Color.black);



        frame.add(button1);
        frame.add(button2);
        frame.add(button3);

        button1.setBounds(button1x,button1y,100,100);
        button1.addActionListener(this);


        button2.setBounds(button2x,button2y,100,100);
        button2.addActionListener(this);


        button3.setBounds(button3x,button3y,100,100);
        button3.addActionListener(this);


        backgroundImage = new ImageIcon("src/Bilder/Dumbom.jpg");
        background = new JLabel("",backgroundImage,JLabel.CENTER);
        background.setBounds(0,0,screenwidth,screenheight);
        frame.add(background);



        simpleTimer();
        timer.start();



    }

    public void klickad(){
        klick++;
        if (klick == 3){
            frame.setVisible(false);
            OndDamage = "Miss";
            timer.stop();
            klick = 0;


        }
    }

    public void simpleTimer(){
        second=5;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                second--;
                System.out.println(second);
                if (second==0){
                    frame.setVisible(false);
                    if (Fighting.defend){
                        Fighting.spelarehp = Fighting.spelarehp-(30/2);
                        OndDamage = "15";

                    }
                    else{
                        Fighting.spelarehp = Fighting.spelarehp-30;
                        OndDamage = "30";
                    }

                    timer.stop();



                }

            }
        });

    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1){
            button1.setVisible(false);
            klickad();
        }
        if(e.getSource() == button2){
            button2.setVisible(false);
            klickad();
        }
        if(e.getSource() == button3){
            button3.setVisible(false);
            klickad();
        }


    }
}

