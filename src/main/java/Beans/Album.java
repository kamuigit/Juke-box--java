package Beans;

public class Album {
   private int albumid;
   private String albumName;

    public int getAlbumid() {
        return albumid;
    }

    public void setAlbumid(int albumid) {
        this.albumid = albumid;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Album(int albumid, String albumName) {
        this.albumid = albumid;
        this.albumName = albumName;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumid=" + albumid +
                ", albumName='" + albumName + '\'' +
                '}';
    }
}
