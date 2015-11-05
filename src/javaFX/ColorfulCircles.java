package javaFX;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.*;
import javafx.stage.Stage;

public class ColorfulCircles extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		// Setup
		Group root = new Group();
		Scene scene = new Scene(root, 800, 600, Color.BLACK);
		primaryStage.setScene(scene);
		
		// Create Circles
		Group circles = new Group();
		for (int i = 0; i < 30; i++) 
		{
			Circle circle = new Circle(150, Color.web("white", 0.05));
			circle.setStrokeType(StrokeType.OUTSIDE);
			circle.setStroke(Color.web("white", 0.16));
			circle.setStrokeWidth(4);
			
			circles.getChildren().add(circle);
		}
		
		// Add Circles to the root group
		root.getChildren().add(circles);
		
		// Add blur effect to circles
		circles.setEffect(new BoxBlur(10, 10, 3));		
		
		// Display the GUI
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
