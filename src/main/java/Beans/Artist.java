package Beans;

public class Artist {
    private int artistid ;
    private String artistName;

    public int getArtistid() {
        return artistid;
    }

    public void setAristid(int aristid) {
        this.artistid = aristid;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public Artist(int artistid, String artistName) {
        this.artistid = artistid;
        this.artistName = artistName;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistid=" + artistid +
                ", artistName='" + artistName + '\'' +
                '}';
    }
}
