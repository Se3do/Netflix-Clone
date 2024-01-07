package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene.fxml"));
		Scene1_Controller controller = new Scene1_Controller();
		loader.setController(controller);
		
		HBox root = loader.load();
		
		Scene scene = new Scene(root);
		
		configureStage(stage, scene);
	}
	
	private void configureStage(Stage stage, Scene scene) {
		stage.setTitle("Netflix");
		stage.setMinHeight(640);
		stage.setMaxHeight(640);
		stage.setMinWidth(815);
		stage.setMaxWidth(815);
		
		Image icon = new Image("iconn.png");
		stage.getIcons().add(icon);
		
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}	
	
	public static void main(String[] args) {
		launch(args);
	}
}
