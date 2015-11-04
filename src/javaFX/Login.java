package javaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Login extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		primaryStage.setTitle("JaxaFX Login");
		
		// Create new grid layout
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		
		// Set horizontal and vertical spacing
		grid.setHgap(10);
		grid.setVgap(10);
				
		grid.setPadding(new Insets(25, 25, 25, 25));
		//grid.setGridLinesVisible(true);
		
		// Create the scene
		Scene scene = new Scene(grid, 300, 275);
		
		// Add Scene and display
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
