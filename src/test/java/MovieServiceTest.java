import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MovieServiceTest {

    private final Movie movie = new Movie("pelicula1","");

    @Order(1)
    @Test
    public void isAvailableTrue(){
        assertTrue(movie.isAvailable(movie.getId()).equals(true));
    }

    @Order(2)
    @Test
    public void isAvailableFalse(){
        assertTrue(movie.isAvailable(movie.getId()).equals(false));
    }

    @Order(3)
    @Test
    public void getName(){
        assertAll("movie", ()-> assertEquals("pelicula1", movie.getName()));
    }

    @Order(4)
    @Test
    public void getNameNotEquals(){
        assertAll("movie", ()-> assertNotEquals("pelicula2", movie.getName()));
    }

    @Order(5)
    @Test
    public void getNameAndGenre(){
        assertAll(
                ()->{
                    String name = movie.getName();
                    assertNotNull(name);
                    assertAll("name", ()-> assertTrue(name.equals("pelicula1"))
                    );
                },
                ()->{
                    String genre = movie.getGenre();
                    assertNotNull(genre);
                    assertAll("genre", ()-> assertTrue(genre.equals("comedia"))
                    );
                }
        );
    }

}
