package javaFX;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class View  {

	public Scene scene;
	private Button buttonA;
	private Button buttonB;
	private Button buttonC;
	private Label attempts;
	
	private Controller controller;
	
	public View(Controller c)
	{
		controller = c;
		
		GridPane grid = new GridPane();		
		grid.setAlignment(Pos.CENTER);
		
		grid.setHgap(10);
		grid.setVgap(10);
		
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		buttonA = new Button("Button A");
		buttonB = new Button("Button B");
		buttonC = new Button("Button C");
		attempts = new Label();
		
		buttonC.setOnAction(ActionEvent -> controller.doAction(buttonA));
		
		grid.add(new Text("Select:"), 0, 0, 2, 1);
		grid.add(buttonA, 0, 1);
		grid.add(buttonB, 1, 1);
		grid.add(buttonC, 2, 1);
		grid.add(attempts, 0, 2, 2, 1);
			
		grid.setGridLinesVisible(true);
		
		scene = new Scene(grid, 300, 125);
	}
	
	public void hookUpEvents(EventHandler<Event> handler)
	{
		buttonA.addEventHandler(ActionEvent.ANY, handler);
		buttonB.addEventHandler(ActionEvent.ANY, handler);
	}
	
	public Scene getScene()
	{
		return scene;
	}
	
	public void setAttempts(int i) 
	{
		attempts.setText("Number of Attempts: " + i);
	}
}
