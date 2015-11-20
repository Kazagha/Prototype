package javaFX;

import java.util.Objects;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
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
		scene.getStylesheets().add(
				Selection.class.getResource("Selection.css").toExternalForm());
		primaryStage.setTitle("Selection Test");
		primaryStage.setWidth(400);
		primaryStage.setHeight(600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void init(VBox root)
	{
		EventHandler handler = new ItemEventHandler();
		
		for (int i = 0; i < 10; i++)
		{			
			GridPane grid = new GridPane();
			grid.addEventHandler(MouseEvent.ANY, handler);
			grid.setAlignment(Pos.CENTER);
			grid.add(new Label("Stack " + i + " "), 1, 0, 1, 1);
			ProgressBar p = new ProgressBar(100);
			p.setPrefWidth(350);
			p.setProgress(Math.random());
			
			// Progress Bar is not clickable by default
			// Put the Progress Bar underneath the StackPane to accept clicks 
			StackPane s = new StackPane();
			s.getChildren().addAll(p, new StackPane());
			grid.add(s, 0, 1, 3, 1);
			
			root.getChildren().add(grid);
		}
	}
	
	class ItemEventHandler implements EventHandler<MouseEvent>
	{
		Node prev = new Label();
		Node selected = new Label();

		@Override
		public void handle(MouseEvent evt) 
		{						
			Node source = (Node) evt.getSource();
			Node target = (Node) evt.getTarget();
			
			if (evt.getEventType() == MouseEvent.MOUSE_CLICKED)
			{		
				System.out.format("Source: %s Target: %s%n", source.toString(), target.toString());
				if (source == selected)
					return; 
				
				selected.setId(null);
				source.setId("selected");
				
				selected = source;
			} else if (evt.getEventType() == MouseEvent.MOUSE_ENTERED) {
				
				if (source == prev)
					return;
				
				if (source == selected)
				{
					if (source != prev)
						prev.setId(null);
					
					return;
				}	
				
				if (prev != selected)
					prev.setId(null);
				
				source.setId("mouseOver");				
				prev = source;
			}
		}	
	}
	
	public int getIndex(Pane parent, Pane target)
	{
		for (int i = 0; i < parent.getChildren().size(); i++)
		{
			if (Objects.equals(parent.getChildren().get(i), target));
				return i;
		}
		
		return -1;
	}

	public static void main(String[] args)
	{
		launch(args);
	}

}
