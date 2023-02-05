package Beans;

public class Playlist {
    private int playlistid;
    private String playlistName;

    public int getPlaylistid() {
        return playlistid;
    }

    public void setPlaylistid(int playlistid) {
        this.playlistid = playlistid;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public Playlist(int playlistid, String playlistName) {
        this.playlistid = playlistid;
        this.playlistName = playlistName;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistid=" + playlistid +
                ", playlistName='" + playlistName + '\'' +
                '}';
    }
}
