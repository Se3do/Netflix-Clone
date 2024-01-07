package application;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.TilePane;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.InputStreamReader;

public class Scene1_Controller implements Initializable {

  	@FXML
    private TextField Search;

    @FXML
    private Button add;

    @FXML
    private ScrollPane scroll;

    @FXML
    private TilePane mvList;

    private List<MoviePane> movies;

    Scene1_Controller() {

    }

    Scene1_Controller(List<MoviePane> n) {
        movies = n;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        if (movies != null && !movies.isEmpty()) {
            mvList.getChildren().addAll(movies);
        }

        Search.setOnKeyTyped(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                addMovie();
            }
        });

        // scroll.setVvalue(0);
    }

    String getText() {
        return Search.getText();
        }

    public void addMovie() {
        try {
            String link = "https://www.omdbapi.com/?t=" + getText() + "&apikey=c2c3fcf9";
            JSONObject json = getjson(link);
            if ("False".equals(json.get("Response"))) {
                System.out.println(json.get("Error"));
                return;
            }
            MoviePane mv = new MoviePane(json);
            mvList.getChildren().add(mv);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            System.out.println("Error 404 !! Movie Not Found");
        }
    }

    public void addMovie(String s) {
        try {
            String link = "https://www.omdbapi.com/?t=" + s + "&apikey=c2c3fcf9";
            JSONObject json = getjson(link);
            if ("False".equals(json.get("Response"))) {
                System.out.println(json.get("Error"));
                return;
            }
            MoviePane mv = new MoviePane(json);
            mvList.getChildren().add(mv);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            System.out.println("Error 404 !! Movie Not Found");
        }
    }

    public void deleteMovie() {
        int size = mvList.getChildren().size();
        if (size > 0) {
            mvList.getChildren().remove(size - 1);
        }
    }

    public JSONObject getjson(String link) throws IOException, ParseException {
        URL url = new URL(link);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(new InputStreamReader(url.openStream()));
        return json;
    }

    public void goHome() {
        scroll.vvalueProperty().set(0);
    }

}
