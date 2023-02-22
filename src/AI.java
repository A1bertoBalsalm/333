
import java.util.Random;

public class AI {

    static Random r = new Random();

    Fighting fighting2 = new Fighting(4,12,2);
    boolean laddar = false;

    static String OndDamage = "0";


    AI(){

    }




    public void AndenAI(){
        int action;
        action = r.nextInt(100);
        System.out.println("AI action "+action);
        if(action < 25 && !laddar){
            // quicktimeevent
            NewWindow.Quickevent();
            MyPanel.AndenFrame = MyPanel.Andenklicka;
        }
        else if(action > 25 && action <50 || laddar){

            if (laddar){
                if (Fighting.defend){
                    Fighting.spelarehp = Fighting.spelarehp - (30/2);
                    OndDamage =  "15";

                }
                else {
                    Fighting.spelarehp = Fighting.spelarehp - 30;
                    OndDamage =  "30";

                }
                MyPanel.AndenFrame = MyPanel.Andensuper;
                laddar = false;

            }
            else{
                System.out.println("Massa energi");
                MyPanel.AndenFrame = MyPanel.Andenladdar;
                laddar = true;


            }
        }
        else{
            fighting2.damagerandom();
            MyPanel.AndenFrame = MyPanel.Andensla;

            Fighting.spelarehp = Fighting.spelarehp - Fighting.damage;



            System.out.println("Anden damage "+Fighting.damage);
            OndDamage =  Integer.toString(Fighting.damage);



        }

        System.out.println("onddamge"+OndDamage);


    }











    }








