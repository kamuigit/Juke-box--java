import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;

public class Jukeimpl {
    private String userid;
    private String password;
    private int l;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JukeBox j = new JukeBox();
        Jukeimpl j1 = new Jukeimpl();
        j.getConnection();
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("              JUKE BOX                  ");
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Enter : \n(1)To login if account already exists.\n(2) To Register new account.");
        System.out.println("\n----------------------------------------");
        int n = Integer.parseInt(sc.nextLine());

        List<Integer> a;

        while (n != 0) {
            switch (n) {
                case 1:
                    System.out.println("++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("              Login here ");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Enter username : ");
                    j1.setUserid( sc.nextLine());
                    System.out.println("Enter Password : ");
                    j1.setPassword(sc.nextLine());
                    int l = j.LoginVerfication(j1.getUserid(), j1.getPassword());
                    if (l == 0) {
                        System.out.println("Enter 1 to try again or 0 to exit");
                        n = Integer.parseInt(sc.nextLine());
                    }
                    if (l != 0) {
                        j1.setL(l);
                        n = 3;
                    }
                    break;
                case 2:
                    System.out.println("++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("              Register here ");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Enter new username : ");
                    j1.setUserid( sc.nextLine());
                    System.out.println("Enter new Password : ");
                    j1.setPassword(sc.nextLine());
                    j.register(j1.getUserid(), j1.getPassword());
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
                                j.displayPlaylists(j1.getL());
                                System.out.println("Enter the Id of the playlist to be played : ");
                                a = j.getPlaylist(Integer.parseInt(sc.nextLine()),j1.getL());
                                if(a==null){
                                    System.out.println("Invalid PlaylistId , Try again.");
                                    break;
                                }
                                j.playSonglist(a);
                                System.out.println("---------------------------------------------");
                                break;
                            case 3:
                                System.out.println("---------------------------------------------");
                                System.out.println("To Create Playlist : ");
                                System.out.println("Enter the Playlist Name : ");
                                j.createPlaylist(sc.nextLine(),j1.getL());
                                System.out.println("---------------------------------------------");
                                break;
                        }

                    }

            }
        }
    }
}



