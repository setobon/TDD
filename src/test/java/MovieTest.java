import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MovieTest {

    Movie movie;

    @BeforeAll
    public void beforeAll(){
        movie = new Movie(1, "pelicula1", "comedia", true);
    }


    @Order(1)
    @Test
    public void findByName(){
        String  name= "pelicula1";
        Movie  movieMock = Mockito.mock(Movie.class);
        Mockito.doReturn(true)
                .when(movieMock)
                .isAvailable(name);
        assertEquals(name, movie.findByName("pelicula1"));
    }

    @Order(2)
    @Test
    public void findByNameFalse(){
        String  name= "pelicula2";
        Movie  movieMock = Mockito.mock(Movie.class);
        Mockito.doReturn(false)
                .when(movieMock)
                .isAvailable(name);
        assertEquals("not found", movie.findByName("pelicula2"));
    }
}
