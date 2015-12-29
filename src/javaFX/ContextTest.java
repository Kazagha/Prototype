package javaFX;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ContextTest extends Application {
	
	private Rectangle bounds = new Rectangle(150, 150, 300, 300);
	StackPane container;
	Stage stage;
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.autosize();
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Context Test");
		primaryStage.setWidth(400);
		primaryStage.setHeight(500);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		stage = primaryStage;
		
		configureBox(root);
	}
	
	public void configureBox(VBox root)
	{
		container = new StackPane();
		container.setPrefHeight(250);
		container.setPrefSize(bounds.getWidth(), bounds.getHeight());
		container.setStyle("-fx-border-color: GREEN");		
		container.addEventHandler(Event.ANY, new Handler());
		
		root.getChildren().add(container);
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	class Handler implements EventHandler<Event>
	{

		@Override
		public void handle(Event event) 
		{
			System.out.format("Event: %s%n", event.getEventType());
			
			if (event instanceof MouseEvent)
			{
				MouseEvent mouseEvent = (MouseEvent) event;
				if (mouseEvent.getButton() == MouseButton.SECONDARY &&
						mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED) 
				{
					ContextMenu cm = new ContextMenu();
					cm.setAutoHide(true);
					MenuItem menu = new MenuItem("Edit");
					cm.getItems().add(menu);
					menu = new MenuItem("Test");
					cm.getItems().add(menu);
					
					cm.setAutoHide(true);
					cm.setHideOnEscape(true);
					cm.setAutoFix(true);
					
					cm.show(stage, ((MouseEvent) event).getScreenX(), ((MouseEvent) event).getScreenY());
					//cm.show((Node) null, mouseEvent.getScreenX(), mouseEvent.getScreenY());
					
				}
			}
		}
		
	}
}
