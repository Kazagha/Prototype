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
			grid.setAlignment(Pos.CENTER);
			grid.add(new Label("Stack " + i + " "), 1, 0, 1, 1);
			ProgressBar p = new ProgressBar(100);
			p.setPrefWidth(350);
			p.setProgress(Math.random());
			grid.add(p, 0, 1, 3, 1);
			
			grid.addEventHandler(MouseEvent.ANY, handler);
						
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
			
			if (evt.getEventType() == MouseEvent.MOUSE_CLICKED)
			{		
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

	public static void main(String[] args)
	{
		launch(args);
	}

}
