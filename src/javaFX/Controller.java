package javaFX;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller extends Application 
		implements EventHandler<Event> {
	int count;
	View view;
	
	public Controller()
	{
		// Create the model
		count = 0;
		// Create the view
		view = new View();		
	}
	
	public static void main(String[] args) throws Exception
	{	
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Set the scene, add the view
		primaryStage.setTitle("MVC Test Application");
		primaryStage.setScene(view.getScene());
		//primaryStage.setScene(new Scene(new GridPane(), 250, 250));
		primaryStage.show();		
	}

	@Override
	public void handle(Event evt) 
	{
		System.out.format("Event%n");
	}	
}
