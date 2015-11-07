package javaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Bookmark extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane grid = new GridPane();
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setAlignment(Pos.CENTER);
		
		Label text = new Label("Text");
		grid.add(text, 1, 0);
		
		ScrollPane scroll = new ScrollPane();
		grid.add(scroll, 1, 1);
		
		Button buttonA = new Button("A");
		Button buttonB = new Button("B");
		
		grid.add(buttonB, 0, 0);
		grid.add(buttonA, 0, 1);
		
		
		StackPane glass = new StackPane();
		glass.getChildren().add(grid);
		glass.setStyle("-fx-background-color: rgba(0, 100, 100, 0.5); -fx-background-radius: 10;");
	    
		Scene scene = new Scene(glass, 350, 350, Color.TRANSPARENT);
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
