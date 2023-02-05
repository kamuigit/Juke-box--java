package Beans;

public class Genre {
    private int genreid;
    private String genreName;

    public int getGenreid() {
        return genreid;
    }

    public void setGenreid(int genreid) {
        this.genreid = genreid;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public Genre(int genreid, String genreName) {
        this.genreid = genreid;
        this.genreName = genreName;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreid=" + genreid +
                ", genreName='" + genreName + '\'' +
                '}';
    }
}
