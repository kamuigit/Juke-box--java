package Beans;

import java.sql.Time;

public class Songs {
    private int songid ;
    private String songname;
    private String songloc ;

    private Time duration;

    private int aristid;
    private int genreid ;
    private int albumid ;



    public int getAristid() {
        return aristid;
    }

    public void setAristid(int aristid) {
        this.aristid = aristid;
    }

    public int getGenreid() {
        return genreid;
    }

    public void setGenreid(int genreid) {
        this.genreid = genreid;
    }

    public int getAlbumid() {
        return albumid;
    }

    public void setAlbumid(int albumid) {
        this.albumid = albumid;
    }

    public int getSongid() {
        return songid;
    }

    public void setSongid(int songid) {
        this.songid = songid;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getSongloc() {
        return songloc;
    }

    public void setSongloc(String songloc) {
        this.songloc = songloc;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public Songs(int songid, String songname, String songloc, Time duration, int aristid, int genreid, int albumid) {
        this.songid = songid;
        this.songname = songname;
        this.songloc = songloc;
        this.duration = duration;
        this.aristid = aristid;
        this.genreid = genreid;
        this.albumid = albumid;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "songid=" + songid +
                ", songname='" + songname + '\'' +
                ", songloc='" + songloc + '\'' +
                ", duration=" + duration +
                ", aristid=" + aristid +
                ", genreid=" + genreid +
                ", albumid=" + albumid +
                '}';
    }
}
