import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


public class Sound {

    Clip clip;
    File[] soundfile = new File[3];


    public Sound(){

        soundfile[0]  = new File("src/ljud/Minha.wav");
        soundfile[1] = new File("src/ljud/Beware the Friendly Stranger.wav");
        soundfile[2] = new File("src/ljud/ULove.wav");

    }
    public void setFile(int i){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundfile[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        }catch (Exception e){
            System.out.println("ost");

        }

    }
    public void play(){
        clip.start();

    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }
    public void stop(){
        clip.close();


    }

}
