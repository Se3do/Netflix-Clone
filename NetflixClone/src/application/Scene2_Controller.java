package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Scene2_Controller implements Initializable {

    private MoviePane movie;
    private TilePane mvlist;

    @FXML
    private Label Title;

    @FXML
    private HBox Genres;

    @FXML
    private Label Overview;

    @FXML
    private Label Rated;

    @FXML
    private Label Runtime;

    @FXML
    private Label Language;

    @FXML
    private Label Rating;

    @FXML
    private Label Date;

    @FXML
    private Label Actors;

    @FXML
    private Label Directors;

    @FXML
    private Label Writers;

    @FXML
    private Label Awards;

    @FXML
    private ImageView Poster;
    
    private Label[] labels; 
 
    
    private List<MoviePane> movies;

    private Stage stage;
    private Scene scene;
    private Parent root;

    Scene2_Controller(MoviePane x) {
        movies = new ArrayList<>();
//        mvlist = (TilePane) x.getParent();
//
//        for (Node i : mvlist.getChildren()) {
//            MoviePane n = (MoviePane) i;
//            movies.add(n);
//        }
        
        this.movie = x;
    }

    private List<Label> getGenres(String s) {
        List<Label> out = new ArrayList<>();

        String[] str = s.split(", ");

        for (String x : str) {
            Label label = new Label(" " + x + " ");
            label.setWrapText(true);
            label.setStyle("-fx-border-color: #fcf9f9; -fx-border-radius: 8px; -fx-font-size: 16px; -fx-text-fill: #fcf9f9");
            out.add(label);
        }
        return out;
    }

    public void switchToScene1(ActionEvent event) throws IOException {
    		mvlist = (TilePane) movie.getParent();

    		for (Node i : mvlist.getChildren()) {
    				MoviePane n = (MoviePane) i;
          	movies.add(n);
    		}
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene.fxml"));
        Scene1_Controller controller = new Scene1_Controller(movies);
        loader.setController(controller);

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public void edit() {
    	Scanner input = new Scanner(System.in);
    	System.out.println("What Field do you wish to edit ?");
    	int i = 0;
    	for(i = 0; i < labels.length; i++) {
    		System.out.println("[" + (i+1) + "]" + " " + labels[i].getId());
//    		System.out.println("Edit " + i.getId() + " ?\n[y]Yes [n]No");
//    		if(op.equals("y")) {
//    			System.out.println();
//    			i.setText(input.next());
//    		}
    	}
    	System.out.println("[" + 12 + "]" + "None");
    	int op = 0;
    	System.out.print("Enter field index : ");
    	op = input.nextInt();
    	input.nextLine();
    	while(op != 12) {
    		System.out.println("Enter new text");
    		String val = input.nextLine();
    		labels[op-1].setText(val);
    		System.out.print("Done ;)\nEnter field index : ");
    		op = input.nextInt();
    		input.nextLine();
    	}
    	movie.setTitle(Title.getText());
    	movie.setPlot(Overview.getText());
    	movie.setRated(Rated.getText());
    	movie.setLanguage(Language.getText());
    	movie.setRating(Rating.getText());
    	movie.setReleaseDate(Date.getText());
    	movie.setActors(Actors.getText());
    	movie.setDirector(Directors.getText());
    	movie.setWriter(Writers.getText());
    	movie.setAwards(Awards.getText());
    }
  

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    		
        Title.setText(movie.getTitle());
        getGenres(movie.getGenre()).forEach(label -> Genres.getChildren().add(label));
        Overview.setText(movie.getPlot());
        Rated.setText("  " + movie.getRated() + "  ");
        Runtime.setText("  " + movie.getRuntime() + "  ");
        Language.setText("  " + movie.getLanguage() + "  ");
        Rating.setText(" " + movie.getRating() + "/10 ");
        Date.setText(" " + movie.getReleaseDate() + "  ");
        Actors.setText("  " + movie.getActors() + "  ");
        Directors.setText("  " + movie.getDirector() + "  ");
        Writers.setText("  " + movie.getWriter() + "  ");
        Awards.setText("  " + movie.getAwards() + "  ");
        Poster.setImage(new Image(movie.getPosterLink()));
        labels = new Label[]{Title, Overview, Rated, Runtime, Language, Rating, Date, Actors, Directors, Writers, Awards};
    }

}
