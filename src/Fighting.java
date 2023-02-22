import java.util.Random;

public class Fighting {



    // 1 eld 2 vatten
    // vapen 1 low dmg, high, element
    static int SpelareDamage;
    static Fighting fighting1 = new Fighting(5,9,2);
    static Fighting fighting2 = new Fighting(4,12,0);
    static AI andenai = new AI();

    int low;
    int high;
    int element;

    static int AndenHp = 100;
    static int spelarehp = 100;
    static int damage;
    static boolean tur;
    static boolean buttonpressed;
    static boolean defend = false;
    static boolean valdevapen = true;



    public static void hit() {
        if(valdevapen){
            fighting1.damagerandom();
            MyPanel.PlayerFrame = MyPanel.Sla1;

        }
        else{
            fighting2.damagerandom();
            MyPanel.PlayerFrame = MyPanel.Sla2;

        }
        AndenHp = AndenHp - damage;
        SpelareDamage = damage;
        buttonpressed = true;
    }

    public static void defend() {
        MyPanel.PlayerFrame = MyPanel.Block;
        defend = true;
        buttonpressed = true;
    }

    public static void valdvapen() {
        if (valdevapen){
            valdevapen = false;
            MyPanel.PlayerFrame = MyPanel.Vila2;
        }
        else{
            valdevapen = true;
            MyPanel.PlayerFrame = MyPanel.Vila1;
        }
    }


    public static void Fight(){
        tur = true;
        System.out.println(tur);
        while (true){
            System.out.println("Anden "+AndenHp);
            System.out.println("Du "+spelarehp);
            if (tur && spelarehp >= 0){


                MyPanel.buttons1.setVisible(true);
                MyPanel.buttons2.setVisible(true);
                MyPanel.buttons3.setVisible(true);


                while (true){
                    if (buttonpressed){
                        buttonpressed = false;
                        tur = false;
                        MyPanel.buttons1.setVisible(false);
                        MyPanel.buttons2.setVisible(false);
                        MyPanel.buttons3.setVisible(false);
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    }

                }
            }
            else if(spelarehp < 0 || AndenHp < 0){
                MyPanel.death();
                break;
            }
            else{
                if (valdevapen){
                    MyPanel.PlayerFrame = MyPanel.Vila1;

                }
                else{
                    MyPanel.PlayerFrame = MyPanel.Vila2;
                }
                andenai.AndenAI();
                defend = false;
                tur = true;
            }

        }




    }







    public Fighting(int low, int high, int element){

        this.low = low;
        this.high = high;
        this.element = element;

    }



    public void damagerandom(){
        Random r = new Random();

        if (element == 0){
            damage = high;
            System.out.println("Crit");
        }
        else{
            damage = r.nextInt(low,high);
            if (defend){
                damage = damage/2;
            }


        }
        System.out.println("randoms"+damage);
    }

}
