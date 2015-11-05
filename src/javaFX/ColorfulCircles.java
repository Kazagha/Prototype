package javaFX;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.*;
import javafx.stage.Stage;

public class ColorfulCircles extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		Group root = new Group();
		Scene scene = new Scene(root, 800, 600, Color.BLACK);
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
