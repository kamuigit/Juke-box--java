import Beans.Songs;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicControls extends JukeDao{
    public void playSonglist(List<Integer> a) {

        List<Songs> s = allSongs();
        List<String> sname = new ArrayList<>();
        List<String> path = new ArrayList<>();
        List<Time> duration = new ArrayList<>();
        for (Songs s1 : s){
            for (Integer integer : a) {
                if (s1.getSongid() == integer) {
                    sname.add(s1.getSongname());
                    path.add(s1.getSongloc());
                    duration.add(s1.getDuration());
                }
            }
        }
        player(path,sname,duration);
    }
    public int player(List<String> s,List<String> a,List<Time> t) {

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        for (int i = 0; i < s.size(); i++) {
            try {
                File file = new File(s.get(i));
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);

                String response = "";

                while (!response.equals("N")) {
                    System.out.println("Current Song Name : "+a.get(i)+"\t\tSong duration : "+t.get(i));
                    System.out.println("P = play/resume" +
                            "\nS = Pause/Stop" +
                            "\nR = Reset" +
                            "\nL = Loop");
                    if(i!=s.size() && i!=1){
                        System.out.println("N = Next");
                    }
                    if(s.size()>1) {
                        if (i >= 1) {
                            System.out.println("PR = Previous");
                        }
                    }
                    System.out.println("E = Exit");
                    System.out.print("Enter your choice: ");

                    response = scanner.next();
                    response = response.toUpperCase();

                    switch (response) {
                        case ("P"):
                            clip.start();
                            break;
                        case ("S"):
                            clip.stop();
                            break;
                        case ("R"):
                            clip.stop();
                            clip.setMicrosecondPosition(0);
                            break;
                        case ("N"):
                            clip.close();
                            System.out.println("Click play to start next song .");
                            break;
                        case ("PR"):
                            i = i - 2;
                            clip.close();
                            response = "N";
                            break;
                        case ("L"):
                            clip.loop(3);
                            break;
                        case ("E"):
                            return 0;

                    }
                    System.out.println();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

}
