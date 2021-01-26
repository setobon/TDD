public class Movie {

    private int id;
    private String name;
    private String genre;

    public Movie(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
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


    public boolean isAvailable(int id){
        if (id == 1){
            System.out.println("La pelicula con el id " + id + " está disponible");
            return true;
        }
        System.out.println("La pelicula con el id " + id + " no está disponible");
        return false;
    }
}
