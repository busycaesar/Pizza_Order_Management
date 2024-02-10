package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

// This is the class for declaring the front-end of the application! It extends the existing class application can adds on the functions required!
public class Main extends Application {
	
	// This function from the Application class is overridden to set the scene on the stage for the application!
	@Override
	public void start(Stage primaryStage) {
		try {
			
			// Declaring the BorderPane and loading the .fxml line in the object!
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
			// Declaring the Scene, adding the BorderPane declared into it and setting the size of the Scene.
			Scene scene = new Scene(root,900,700);
			
			// Adding the Scene created into the Stage!
			primaryStage.setScene(scene);
			
			// Setting the property of the stage!
			primaryStage.setTitle("Pizza 24/7");
			primaryStage.setResizable(false);
			
			// Finally displaying the stage to the user!
			primaryStage.show();
			
		} catch(Exception e) { e.printStackTrace(); }
	}
	
	// This is the main function of the application!
	public static void main(String[] args) {
		
		// This launch function calls the start overridden function of the application!
		launch(args);
		
	}
}
