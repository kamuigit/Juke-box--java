import Beans.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JukeBox extends MusicControls{
    Scanner sc;

    public int LoginVerfication(String usid, String passwd){
        List<Login> l = LogList();
        Login l1 = new Login(0,usid,passwd);
        int id =0;
        for( Login l2 : l ){
            if(l2.getUsername().equals(l1.getUsername()) && l2.getPasswd().equals(l1.getPasswd())) {
                System.out.println("Login Successful..");
                id = l2.getUsid();
                return id;
            }
        }
        if(id ==0){
            System.out.println("Incorrect UserName/Password .Try Again");
        }
        return id;
    }

    public Songs searchBySongName(String songName){
        List<Songs> s = allSongs();
        for (Songs s1:s) {
            if(s1.getSongname().contains(songName)){
                return s1;
            }
        }
        System.out.println("Invalid song name .");
        return null;
    }


    public void displayAlbums(){
        List<Album> a = allAlbum();
        System.out.println("Albums available are :");
        System.out.println("---------------------------------------------");
        System.out.format("|%-20s|%-20s|\n","Albumid", "AlbumName");
        System.out.println("---------------------------------------------");
        for (Album a1: a) {
            System.out.format("|%-20d|%-20s|\n",a1.getAlbumid(),a1.getAlbumName());
        }
        System.out.println("---------------------------------------------");
    }
    public void displaySongs(){
        List<Songs> a = allSongs();
        System.out.println("Songs available are :");
        System.out.println("---------------------------------------------");
        System.out.format("|%-20s|%-20s|\n","Songid", "SongName");
        System.out.println("---------------------------------------------");
        for (Songs a1: a) {
            System.out.format("|%-20d|%-20s|\n",a1.getSongid(),a1.getSongname());
        }
        System.out.println("---------------------------------------------");
    }
    public List<Integer> BysearchSongname(int id){
        List<Songs> a = allSongs();
        List<Integer> b = new ArrayList<>();
        for (Songs a1: a) {
        if(a1.getSongid() == id){
            b.add(a1.getSongid());
            }
        }
         return b;
    }
    public void displayArtists(){
        List<Artist> a = allArists();
        System.out.println("Artists available are :");
        System.out.println("---------------------------------------------");
        System.out.format("|%-20s|%-20s|\n","Artistid", "ArtistName");
        System.out.println("---------------------------------------------");
        for (Artist a1: a) {
            System.out.format("|%-20d|%-20s|\n",a1.getArtistid(),a1.getArtistName());
        }
        System.out.println("---------------------------------------------");
    }
    public void displayPlaylists(int usid){
        List<Playlist> a = allPlaylist(usid);
        if(a!=null) {
            System.out.println("Playlist available are :");
            System.out.println("---------------------------------------------");
            System.out.format("|%-20s|%-20s|\n", "Playlistid", "PlaylistName");
            System.out.println("---------------------------------------------");
            for (Playlist a1 : a) {
                System.out.format("|%-20d|%-20s|\n", a1.getPlaylistid(), a1.getPlaylistName());
            }
            System.out.println("---------------------------------------------");
        }
        else{
            System.out.println("No Playlist created by the user.");
        }
    }
    public void displayGenre(){
        List<Genre> a = allGenre();
        System.out.println("Genres available are :");
        System.out.println("---------------------------------------------");
        System.out.format("|%-20s|%-20s|\n","Genreid", "GenreName");
        System.out.println("---------------------------------------------");
        for (Genre a1: a) {
            System.out.format("|%-20d|%-20s|\n",a1.getGenreid(),a1.getGenreName());
        }
        System.out.println("---------------------------------------------");
    }

    public List <Integer> searchSongByAlbum(int albumid){
        List<Album> ar = allAlbum();
        if(albumid>0 ) {
            List<Integer> a = new ArrayList<>();
            for (Album a1 : ar) {
                if (a1.getAlbumid() == albumid) {
                    System.out.println("album : " + a1.getAlbumName());
                    for (Songs s1 : allSongs()) {
                        if (s1.getAlbumid() == a1.getAlbumid()) {
                            a.add(s1.getSongid());
                        }
                    }
                }
            }
            return a;
        }
        else{
            return null;
        }
    }



    public List<Integer> searchSongByGenre(int id){
        List<Genre> ar = allGenre();
        if(id>1 ) {
            List<Integer> a = new ArrayList<>();
            for (Genre a1 : ar) {
                if (a1.getGenreid() == id) {
                    System.out.println("Album name : " + a1.getGenreName());
                    for (Songs s1 : allSongs()) {
                        if (s1.getGenreid() == a1.getGenreid()) {
                            a.add(s1.getSongid());
                        }
                    }
                }
            }
            return a;
        }
        else{
            return null;
        }
    }
    public List<Integer> searchSongByArtist(int id){
        List<Artist> ar = allArists();
        if(id>0 ) {
            List<Integer> a = new ArrayList<>();
            for (Artist a1 : ar) {
                if (a1.getArtistid() == id) {
                    System.out.println("Selected Artist name : " + a1.getArtistName());
                    for (Songs s1 : allSongs()) {
                        if (s1.getAristid() == a1.getArtistid()) {
                            a.add(s1.getSongid());
                        }
                    }
                }
            }
            return a;
        }
        else{
            return null;
        }
    }
    public List<Integer> getPlaylist(int playlistid,int usid){
        List<Playlist> ar = allPlaylist(usid);
        if(playlistid >0 ) {
            for (Playlist p : ar) {
                if (p.getPlaylistid() == playlistid) {
                    System.out.println("Selected Playlist name : " + p.getPlaylistName());
                    }
                }
            return getplaylistById(playlistid,usid);
            }
        else{
            return null;
        }
    }
    public void createPlaylist(String playlistname,int usid){
        sc = new Scanner(System.in);
        if(playlistname != null){
            addPlaylistname(playlistname);
            System.out.println();
            System.out.println("Enter the number of songs to be added : ");
            int d = Integer.parseInt(sc.nextLine());
            System.out.println();
            displaySongs();
            System.out.println("From the table select the songs to be added to the playlist : ");
            System.out.println("Enter the Id of the songs one by one.");
            List<Integer> s = new ArrayList<>();
            for (int i =0;i<d;i++){
                System.out.println("Enter the id of song "+(i+1)+" : ");
                s.add(Integer.parseInt(sc.nextLine()));
            }
            System.out.println("Playlist Creation complete ....");
            System.out.println();
            int f = getplaylistId(playlistname);
            for (Integer e : s){
                addPlaylistTCL(usid,e,f);
            }
        }
    }

    public int toSearchSong(int n){
        List <Integer> a;
        sc = new Scanner(System.in);
        while (n != 0) {
            System.out.println("---------------------------------------------");
            System.out.println("To Search Song : ");
            System.out.println("Enter to Search Song By :");
            System.out.println("(1) Album Name ");
            System.out.println("(2) Artist Name ");
            System.out.println("(3) Genre Name ");
            System.out.println("(4) Song Name ");
            System.out.println("(5) To return to previous menu ");
            System.out.println("(0) To Exit");
            System.out.println("---------------------------------------------");
            n = Integer.parseInt(sc.nextLine());

            switch (n) {
                case 1:
                    System.out.println("---------------------------------------------");
                    System.out.println("By Album name :");
                    displayAlbums();
                    System.out.println("Look above and Enter Album id to play :");
                    a = searchSongByAlbum(Integer.parseInt(sc.nextLine()));
                    if(a==null){
                        System.out.println("Invalid AlbumId , Try again.");
                        break;
                    }
                    playSonglist(a);
                    System.out.println("---------------------------------------------");
                    break;
                case 2:
                    System.out.println("---------------------------------------------");
                    System.out.println("By Artist name :");
                    displayArtists();
                    System.out.println("Look above and Enter Artist id to play :");
                    a = searchSongByArtist(Integer.parseInt(sc.nextLine()));
                    if(a==null){
                        System.out.println("Invalid ArtistId , Try again.");
                        break;
                    }
                    playSonglist(a);
                    System.out.println("---------------------------------------------");
                    break;
                case 3:
                    System.out.println("---------------------------------------------");
                    System.out.println("By Genre name :");
                    displayGenre();
                    System.out.println("Look above and Enter Genre id to play :");
                    a = searchSongByGenre(Integer.parseInt(sc.nextLine()));
                    if(a==null){
                        System.out.println("Invalid GenreId , Try again.");
                        break;
                    }
                    playSonglist(a);
                    System.out.println("---------------------------------------------");
                    break;
                case 4:
                    System.out.println("---------------------------------------------");
                    System.out.println("By Song name :");
                    displaySongs();
                    System.out.println("Look above and Enter Song id to play :");
                    a = BysearchSongname(Integer.parseInt(sc.nextLine()));
                    if(a==null){
                        System.out.println("Invalid SongId , Try again.");
                        break;
                    }
                    playSonglist(a);
                    System.out.println("---------------------------------------------");
                    break;
            }
            if (n == 5) {
                n = 3;
                break;
            }
        }
        return n;
    }


}
