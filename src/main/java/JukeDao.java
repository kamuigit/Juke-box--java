import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Beans.*;



public class JukeDao {
    public Connection getConnection(){
        Connection connection=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/music","root","kamui");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return connection;

    }
    public void register(String usid, String passwd ){
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            st.execute("insert into Login(username,passwd) values('"+usid+"','"+passwd+"');");
            System.out.println("Registration Successful...");
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    public List<Login> LogList(){
        List<Login> l = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Login;");
            while(rs.next()){
                l.add(new Login(rs.getInt("usid"),rs.getString("username"),rs.getString("passwd")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return l;
    }

    public List<Artist> allArists(){
        List<Artist> l = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Artist;");
            while(rs.next()){
                l.add(new Artist(rs.getInt("artistid"),rs.getString("artistName")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return l;
    }

    public List<Genre> allGenre(){
        List<Genre> l = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Genre;");
            while(rs.next()){
                l.add(new Genre(rs.getInt("genreid"),rs.getString("genreName")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return l;
    }

    public List<Album> allAlbum(){
        List<Album> l = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Album;");
            while(rs.next()){
                l.add(new Album(rs.getInt("albumid"),rs.getString("albumName")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return l;
    }
    public List<Songs> allSongs(){
        List<Songs> l = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from songs;");
            while(rs.next()){
                l.add(new Songs(rs.getInt("songid"),rs.getString("songname"),rs.getString("songloc"),rs.getTime("duration"),rs.getInt("artistid"),rs.getInt("genreid"),rs.getInt("albumid")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return l;
    }

    public List<Playlist> allPlaylist(int usid) {
        List<Playlist> l = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from playlist ;");
            while (rs.next()) {
                l.add(new Playlist(rs.getInt("playlistid"), rs.getString("playlistName")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return l;
    }
    public List<Integer> playlistById(int playlistid,int usid) {
        List<Integer> l = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select songid from playlisttc where playlistid = "+playlistid+" and usid ="+usid+" ;");
            while (rs.next()) {
                l.add(rs.getInt("songid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return l;
    }
    public void addPlaylistname(String playlistname){
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            st.executeUpdate("insert into playlist(playlistName) values('"+playlistname+"');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int getplaylistId(String playlistname){
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("select playlistid from playlist where  playlistName ='"+playlistname+"';");
           rs.next();
            return rs.getInt("playlistid");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public void addPlaylistTCL(int usid, int songid,int playlistid ){
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            st.execute("insert into playlisttc(playlistid,songid,usid) values ("+playlistid+","+songid+","+usid+");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
