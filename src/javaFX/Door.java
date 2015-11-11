package javaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Door extends Application {
	
	private static int frame = 10;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Alignment for background 
		StackPane stack = new StackPane();		
		stack.setAlignment(Pos.TOP_LEFT);

		// Alignment for GUI components
		StackPane center = new StackPane();
		center.setAlignment(Pos.CENTER);
		stack.getChildren().add(center);
		
		// Create clipping Rectangle and bind to the window size
		Rectangle rect = new Rectangle(50, 50);
		rect.widthProperty().bind(stack.widthProperty().add(- (frame * 2)));
		rect.heightProperty().bind(stack.heightProperty().add(- (frame * 2)));
		rect.layoutXProperty().bind(stack.layoutXProperty().add(frame));
		rect.layoutYProperty().bind(stack.layoutYProperty().add(frame));
			
		// Load the background image
		ImageView background = new ImageView();
		Image image = new Image(Door.class.getResourceAsStream("wood.jpg"));
		background.setImage(image);
		background.setClip(rect);
		// Set the background on the 'bottom' layer
		stack.getChildren().add(0, background);
		
		GridPane grid = new GridPane();		
		grid.setVgap(5);
		grid.setHgap(5);
		grid.setAlignment(Pos.CENTER);
		center.getChildren().add(grid);
		
		grid.add(new Label("User:"), 0, 0);
		grid.add(new TextField(), 1, 0);
		grid.add(new Label("Pass:"), 0, 1);
		grid.add(new TextField(), 1, 1);
		
		Scene scene = new Scene(stack, 350, 350);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}

}
