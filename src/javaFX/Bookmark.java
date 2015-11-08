package javaFX;

import java.awt.Insets;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
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
		
		StackPane tabGlass = new StackPane();
		//tabGlass.setStyle("-fx-background-color: rgba(100, 0, 100, 0.5); -fx-background-radius: 10;");
		
		VBox tabs = new VBox();
		tabs.setSpacing(8);
		tabs.setAlignment(Pos.CENTER);
		
		for (int i = 0; i < 10; i++)
		{
			Label l = new Label(" Menu " + i + " ");			
			l.setStyle("-fx-background-color: rgba(100, 100, 0, 0.75);");
			tabs.getChildren().add(l);
		}
			
		StackPane glass = new StackPane();
		
		glass.setStyle("-fx-background-color: rgba(0, 100, 100, 0.5); -fx-background-radius: 10;");
		
		Rectangle shadow = new Rectangle(glass.getWidth(), glass.getHeight());
		shadow.widthProperty().bind(glass.widthProperty());
		shadow.heightProperty().bind(glass.heightProperty());
		
		//shadow.setStrokeType(StrokeType.OUTSIDE);
		//shadow.setStroke(Color.web("Blue", .25));
		//shadow.setStrokeWidth(4);
		shadow.setStyle("-fx-background-color: rgba(100, 100, 0, 1);");		
		//glass.getChildren().add(shadow);
		
		glass.getChildren().add(grid);
		
	   
		StackPane main = new StackPane();
		main.setStyle("-fx-background-color: rgba(100, 0, 100, 0.0); -fx-background-radius: 10; ");
		
		BorderPane borderPane = new BorderPane();
		main.getChildren().add(borderPane);   
		
		borderPane.setCenter(glass);
		borderPane.setLeft(tabs);
		
		//layout.setCenter(glass);
		//layout.setLeft(tabGlass);
		
		//Scene scene = new Scene(glass, 350, 350, Color.TRANSPARENT);
		//Scene scene = new Scene(layout, 350, 350, Color.TRANSPARENT);
		Scene scene = new Scene(main, 350, 350, Color.TRANSPARENT);
		
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
