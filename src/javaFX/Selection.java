package javaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Selection extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setSpacing(10);
		
		init(root);
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Selection Test");
		primaryStage.setWidth(400);
		primaryStage.setHeight(500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void init(VBox root)
	{
		EventHandler handler = new ItemEventHandler();
		
		for (int i = 0; i < 10; i++)
		{			
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.add(new Label("Stack " + i + " "), 0, 0, 2, 1);
			ProgressBar p = new ProgressBar(100);
			p.setProgress(Math.random());
			grid.add(p, 0, 1, 5, 1);
			
			grid.addEventHandler(MouseEvent.ANY, handler);
						
			root.getChildren().add(grid);
		}
	}
	
	class ItemEventHandler implements EventHandler<MouseEvent>
	{

		@Override
		public void handle(MouseEvent evt) 
		{
			Node source = (Node) evt.getSource();

			System.out.format("Event: %s%n", source);
			source.setStyle("-fx-border-color: BLUE");
		}	
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}

}