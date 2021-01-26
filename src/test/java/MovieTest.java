import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MovieTest {

    Movie movie;

    @BeforeAll
    public void beforeAll(){
        movie = new Movie(1, "pelicula1", "comedia");
    }


    @Order(1)
    @Test
    public void isAvailableTrue(){
        Movie movieMock = Mockito.spy(movie);
        Mockito.doReturn(true).when(movieMock).isAvailable(1);
        assertTrue(movieMock.isAvailable(1));
    }

    @Order(2)
    @Test
    public void isAvailableFalse(){
        Movie movieMock = Mockito.spy(movie);
        Mockito.doReturn(false).when(movieMock).isAvailable(2);
        assertFalse(movieMock.isAvailable(2));
    }

    @Order(3)
    @Test
    public void getMovieByName(){
        Movie movieMock = Mockito.spy(movie);
        assertEquals("pelicula1", movieMock.getName());
    }

    @Order(4)
    @Test
    public void getMovieByNameNotEquals(){
        Movie movieMock = Mockito.spy(movie);
         assertNotEquals("pelicula2", movieMock.getName());
    }

    @Order(5)
    @Test
    public void getNameAndGenre(){
        Movie movieMock = Mockito.spy(movie);
        assertAll(
                ()->{
                    String name = movieMock.getName();
                    assertNotNull(name);
                    assertAll("name", ()-> assertTrue(name.equals("pelicula1"))
                    );
                },
                ()->{
                    String genre = movieMock.getGenre();
                    assertNotNull(genre);
                    assertAll("genre", ()-> assertTrue(genre.equals("comedia"))
                    );
                }
        );
    }

}
