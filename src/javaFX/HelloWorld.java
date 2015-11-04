package javaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application
{
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		// Create a basic button
		Button button = new Button();
		button.setText("Hello World");
		
		// Add an action to the button
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.format("Hello World Action %n");
				
			}
			
		});
		
		// Set Window title
		primaryStage.setTitle("Hello World");	
		
		// Create new Stack Pane and add the button
		StackPane root = new StackPane();
		root.getChildren().add(button);
				
		// Set the scene size 
		Scene scene = new Scene(root, 300, 250);
		primaryStage.setScene(scene);
		
		// Display the window
		primaryStage.show();
	}
	public static void main(String[] args)
	{
		launch(args);
	}
}
