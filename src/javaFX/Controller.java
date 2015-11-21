package javaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
		view = new View(this);
		// Wire up event handler
		view.hookUpEvents(this);
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
	
	public void doAction(Object o)
	{
		System.out.format("Do Action on Objcet: %s%n", o.toString());
		
		if (o instanceof Button)
			((Button) o).setText("Action Button");
	}

	@Override
	public void handle(Event evt) 
	{
		if (evt.getEventType() == ActionEvent.ANY) 
		{
			Node source = (Node) evt.getSource();
			System.out.format("Event%n%s%n", source.toString() );
			
			view.setAttempts(++count);
		}
	}	
}
