package controller.library;

import controller.SwitchScene;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;

import java.net.URL;
import java.util.*;
import java.util.stream.Stream;

public class RankingLibraryController extends SwitchScene implements Initializable {
    public NumberAxis id_yAxis;
    public CategoryAxis id_xAxis;
    @FXML
    private StackedBarChart<?, ?> id_chart;
    XYChart.Series[] series;
    int sizeCategoryMovies;
    String str;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sizeCategoryMovies = 10;
        declareVariablesAxises();

        str = String.valueOf(listOfMovie);

        List<String> name = new LinkedList<>();
        List<Integer> year = new LinkedList<>();
        List<String> category = new LinkedList<>();
        List<Double> rating = new LinkedList<>();
        StringTokenizer tokenizer = new StringTokenizer(str, ",");

        while (tokenizer.hasMoreTokens()) {
            //-------  'REPLACE' METHOD TO REMOVE FROM START LINE SIGN '[' - WTIHOUT COMPILATION LEVEL ERROR  -----------------------------------
            name.add(tokenizer.nextToken().replace('[', ' '));

            //-------  'TRIM()' METHOD TO THE DELETE SPACE SIGN  - COMPILATION LEVEL ERROR -----------------------------------
            year.add(Integer.parseInt(tokenizer.nextToken().trim()));
            category.add(tokenizer.nextToken());

            //-------  'REPLACE' METHOD TO REMOVE ']' CHARACTER AT THE END - COMPILATION LEVEL ERROR -----------------------------------
            rating.add(Double.parseDouble(tokenizer.nextToken().replace(']', ' ')));
        }

        addMovieToCategory(name, category, rating);
        id_chart.getData().addAll(series);
    }

    //-------  ASSIGN MOVIE TO THE CATEGORY  -----------------------------------
    private void addMovieToCategory(List<String> name, List<String> category, List<Double> rating) {
        for (int i = 0; i < name.size(); i++) {
            if (category.get(i).trim().equals(String.valueOf(MovieCategory.AKCJA))) {
                addDataToCategory(name, rating, i, series[0]);
            } else if (category.get(i).trim().equals(String.valueOf(MovieCategory.ANIMACJA))) {
                addDataToCategory(name, rating, i, series[1]);
            } else if (category.get(i).trim().equals(String.valueOf(MovieCategory.DRAMAT))) {
                addDataToCategory(name, rating, i, series[2]);
            } else if (category.get(i).trim().equals(String.valueOf(MovieCategory.HORROR))) {
                addDataToCategory(name, rating, i, series[3]);
            } else if (category.get(i).trim().equals(String.valueOf(MovieCategory.KOMEDIA))) {
                addDataToCategory(name, rating, i, series[4]);
            } else if (category.get(i).trim().equals(String.valueOf(MovieCategory.KRYMINALNY))) {
                addDataToCategory(name, rating, i, series[5]);
            } else if (category.get(i).trim().equals(String.valueOf(MovieCategory.PRZYGODOWY))) {
                addDataToCategory(name, rating, i, series[6]);
            } else if (category.get(i).trim().equals(String.valueOf(MovieCategory.ROMANTYCZNY))) {
                addDataToCategory(name, rating, i, series[7]);
            } else if (category.get(i).trim().equals(String.valueOf(MovieCategory.SCIENCE_FICTION))) {
                addDataToCategory(name, rating, i, series[8]);
            } else if (category.get(i).trim().equals(String.valueOf(MovieCategory.THRILLER))) {
                addDataToCategory(name, rating, i, series[9]);
            }
        }
    }

    private void addDataToCategory(List<String> name, List<Double> rating, int i, XYChart.Series series) {
        series.getData().add(new XYChart.Data(name.get(i), rating.get(i)));
    }

    // -----    declaration of variables Axis X and Y   ------------------------------------------------------
    private void declareVariablesAxises() {
        series = Stream.<XYChart.Series<?, ?>>generate(XYChart.Series::new).limit(sizeCategoryMovies).toArray(XYChart.Series[]::new);

        int i = 0;
        // -----   LOOP WHICH WRITE CATEGORY OF MOVIES TO TABLE   ------------------------------------------------------
        for (MovieCategory movie : MovieCategory.values()) {
            series[i++].setName(String.valueOf(movie));
        }
    }
}
