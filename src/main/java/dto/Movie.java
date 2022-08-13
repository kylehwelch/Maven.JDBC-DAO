package dto;

public class Movie implements DTO {

    private Integer id;
    private String title;
    private String genre;
    private Double runtime;
    private String rating;
    private Integer year;

    public Movie() {
    }

    public Movie(Integer id, String title, String genre, Double runtime, String rating, Integer year) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.runtime = runtime;
        this.rating = rating;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getRuntime() {
        return runtime;
    }

    public void setRuntime(Double runtime) {
        this.runtime = runtime;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}