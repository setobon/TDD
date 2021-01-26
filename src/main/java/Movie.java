import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Movie {

    private int id;
    private String name;
    private String genre;
    private boolean status;

    public Movie(int id, String name, String genre, boolean status) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



    public String findByName(String name) {
        if (isAvailable(name)) {
            return name;
        }
        return "not found";
    }

    public boolean isAvailable(String name) {

        Optional<Movie> index = getMoviesList().stream()
                .filter(movie -> name.equals(movie.getName()))
                .findFirst();
        if (index.isPresent()) {
            return true;
        }
        return false;
    }

    public List<Movie> getMoviesList() {
        List<Movie> moviesName = new ArrayList<>();
        Movie movie1 = new Movie(1, "pelicula1", "comedia", true);
        Movie movie2 = new Movie(2, "pelicula3", "accion", false);
        moviesName.add(movie1);
        moviesName.add(movie2);
        return moviesName;
    }
}
