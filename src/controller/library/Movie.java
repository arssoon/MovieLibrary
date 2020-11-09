package controller.library;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Movie {
//    private SimpleIntegerProperty idMovie;
    private SimpleStringProperty nameMovie;
    private SimpleIntegerProperty yearCreateMovie;
    private SimpleStringProperty directorMovie;
    private SimpleDoubleProperty reatingMovie;

    public Movie(String nameMovie, Integer yearCreateMovie, String directorMovie, Double reatingMovie) {
//        this.idMovie = new SimpleIntegerProperty(idMovie);
        this.nameMovie = new SimpleStringProperty(nameMovie);
        this.yearCreateMovie = new SimpleIntegerProperty(yearCreateMovie);
        this.directorMovie = new SimpleStringProperty(directorMovie);
        this.reatingMovie = new SimpleDoubleProperty(reatingMovie);
    }

    public String getNameMovie() {
        return nameMovie.get();
    }

    public SimpleStringProperty nameMovieProperty() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie.set(nameMovie);
    }

    public int getYearCreateMovie() {
        return yearCreateMovie.get();
    }

    public SimpleIntegerProperty yearCreateMovieProperty() {
        return yearCreateMovie;
    }

    public void setYearCreateMovie(int yearCreateMovie) {
        this.yearCreateMovie.set(yearCreateMovie);
    }

    public String getDirectorMovie() {
        return directorMovie.get();
    }

    public SimpleStringProperty directorMovieProperty() {
        return directorMovie;
    }

    public void setDirectorMovie(String directorMovie) {
        this.directorMovie.set(directorMovie);
    }

    public double getReatingMovie() {
        return reatingMovie.get();
    }

    public SimpleDoubleProperty reatingMovieProperty() {
        return reatingMovie;
    }

    public void setReatingMovie(double reatingMovie) {
        this.reatingMovie.set(reatingMovie);
    }
}
