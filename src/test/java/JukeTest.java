import Beans.Album;
import Beans.Artist;
import Beans.Genre;
import Beans.Songs;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class JukeTest extends JukeDao{

    JukeBox j;
    List<Songs> s;
    List<Artist> ar;
    List<Album> ab;
    List<Genre> g;
    @Before
    public void setUp(){
        j = new JukeBox();
        s = allSongs();
        ab = allAlbum();
        ar = allArists();
        g = allGenre();
    }
    @After
    public void tearDown(){
        j= null;
        s = null;
        ar=null;
        ab = null;
        g = null;
    }

    @Test
    public void checkLists()
    {
        assertEquals(s,j.allSongs());
        assertEquals(g,j.allGenre());
        assertEquals(ar,j.allArists());
        assertEquals(ab, j.allAlbum());

    }
    @Test
        public void checkLoginFunction(){
            //positive test case
            assertEquals(1,j.LoginVerfication("loki","1234"));
            //negative case
            assertEquals(0,j.LoginVerfication(null,null));
        }

        @Test public void checkGetPlaylist(){
            assertNull(j.getPlaylist(0, 1));
        }
    @Test
    public void checkSearchSongByAlbum(){
        assertNull(j.searchSongByAlbum(0));
    }
    @Test
    public void checkSearchByArtist(){
        assertNull(j.searchSongByArtist(0));
    }
    @Test
    public void checkSearchByGenre(){
        assertNull(j.searchSongByGenre(0));
    }



}
