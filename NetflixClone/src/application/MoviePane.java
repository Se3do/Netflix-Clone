package application;

import java.io.IOException;

import org.json.simple.JSONObject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MoviePane extends BorderPane {

    private String title, rated, releaseDate, plot, posterLink, genre,
            director, writer, actors, language, awards, year, runtime, rating;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public MoviePane(JSONObject x) {
        initializeMovieFields(x);
        setupImageViewAndLabel();
        setupMoviePaneStyleAndLayout();
        setupMouseClickEventHandler();
    }

    private void initializeMovieFields(JSONObject x) {
        this.title = (String) x.get("Title");
        this.rated = (String) x.get("Rated");
        this.releaseDate = (String) x.get("Released");
        this.posterLink = (String) x.get("Poster");
        this.genre = (String) x.get("Genre");
        this.director = (String) x.get("Director");
        this.writer = (String) x.get("Writer");
        this.actors = (String) x.get("Actors");
        this.plot = (String) x.get("Plot");
        this.language = (String) x.get("Language");
        this.awards = (String) x.get("Awards");
        this.year = (String) x.get("Year");
        this.runtime = (String) x.get("Runtime");
        this.rating = (String) x.get("imdbRating");
    }

    private void setupImageViewAndLabel() {
        ImageView imageView = new ImageView(new Image(this.posterLink));
        imageView.setFitWidth(150);
        imageView.setFitHeight(222);

        Label label = new Label(this.title);
        label.setStyle("-fx-text-fill: #EDEEEC");

        StackPane labelContainer = new StackPane();
        labelContainer.getChildren().add(label);

        this.setCenter(imageView);
        this.setBottom(labelContainer);
    }

    private void setupMoviePaneStyleAndLayout() {
        this.setCursor(getCursor().HAND);
        this.setPrefSize(105, 100);
    }

    private void setupMouseClickEventHandler() {
        this.setOnMouseClicked(e -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
                Scene2_Controller controller = new Scene2_Controller((MoviePane) e.getSource());
                loader.setController(controller);

                root = loader.load();

                stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getRated() {
        return rated;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getPlot() {
        return plot;
    }

    public String getPosterLink() {
        return posterLink;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getWriter() {
        return writer;
    }

    public String getActors() {
        return actors;
    }

    public String getLanguage() {
        return language;
    }

    public String getAwards() {
        return awards;
    }

    public String getYear() {
        return year;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getRating() {
        return rating;
    }

    // Setter methods
    public void setTitle(String title) {
        this.title = title;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public void setPosterLink(String posterLink) {
        this.posterLink = posterLink;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
