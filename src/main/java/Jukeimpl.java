import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;

public class Jukeimpl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JukeBox j = new JukeBox();
        j.getConnection();
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("              JUKE BOX                  ");
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Enter : \n(1)To login if account already exists.\n(2) To Register new account.");
        System.out.println("\n----------------------------------------");
        int n = Integer.parseInt(sc.nextLine());
        int l =0;
        String userid;
        String password;
        List<Integer> a;

        while (n != 0) {
            switch (n) {
                case 1:
                    System.out.println("++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("              Login here ");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Enter username : ");
                    userid = sc.nextLine();
                    System.out.println("Enter Password : ");
                    password = sc.nextLine();
                    l = j.LoginVerfication(userid, password);
                    if (l == 0) {
                        System.out.println("Enter 1 to try again or 0 to exit");
                        n = Integer.parseInt(sc.nextLine());
                    }
                    if (l != 0) {
                        n = 3;
                    }
                    break;
                case 2:
                    System.out.println("++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("              Register here ");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Enter new username : ");
                    userid = sc.nextLine();
                    System.out.println("Enter new Password : ");
                    password = sc.nextLine();
                    j.register(userid, password);
                    System.out.println("Enter 1 to login or 0 to exit");
                    System.out.println("---------------------------------------------");
                    n = Integer.parseInt(sc.nextLine());

                    break;
                case 3:
                    while (n != 0) {
                        System.out.println("++++++++++++++++++++++++++++++++++++++++");
                        System.out.println("              JUKE BOX                  ");
                        System.out.println("++++++++++++++++++++++++++++++++++++++++");
                        System.out.println("\nEnter : ");
                        System.out.println("(1) To Search and play Song");
                        System.out.println("(2) To View  and play Playlist");
                        System.out.println("(3) To Create Playlist");
                        System.out.println("(0) To Exit");
                        System.out.println("---------------------------------------------");
                        n = Integer.parseInt(sc.nextLine());
                        switch (n) {
                            case 1:
                               n=j.toSearchSong(n);
                                break;
                            case 2:
                                System.out.println("---------------------------------------------");
                                System.out.println("To View and Play PLaylist : ");
                                j.displayPlaylists(l);
                                System.out.println("Enter the Id of the playlist to be played : ");
                                a = j.getPlaylist(Integer.parseInt(sc.nextLine()),l);
                                j.playSonglist(a);
                                System.out.println("---------------------------------------------");
                                break;
                            case 3:
                                System.out.println("---------------------------------------------");
                                System.out.println("To Create Playlist : ");
                                System.out.println("Enter the Playlist Name : ");
                                j.createPlaylist(sc.nextLine(),l);
                                System.out.println("---------------------------------------------");
                                break;
                        }

                    }

            }
        }
    }
}



