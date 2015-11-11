package javaFX;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import javafx.util.Duration;

public class Door extends Application {
	
	private static int frame = 10;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Alignment for background 
		StackPane stack = new StackPane();		
		stack.setAlignment(Pos.TOP_LEFT);
		Scene scene = new Scene(stack, 350, 350);

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
		//background.setClip(rect);
		// Set the background on the 'bottom' layer
		stack.getChildren().add(0, background);
		
		// Translate rectangle		
		Group doors = new Group(); 
		doors.getChildren().addAll(new Rectangle());
		
		Timeline timeline = new Timeline();		
		for (Node n : doors.getChildren()) 
		{
			Rectangle r = (Rectangle) n;
			
			r.widthProperty().bind(center.widthProperty().divide(2));
			r.heightProperty().bind(center.heightProperty());
			r.setStyle(" -fx-fill: rgb(0, 100, 100, 0.25) ");
			
			r.setTranslateX(-50);
			r.setTranslateY(0);
			
			//r.setClip(rect);
			
			System.out.format("Width: %f" , center.getWidth());
			
			timeline.getKeyFrames().addAll(
					new KeyFrame(Duration.ZERO,
						new KeyValue(r.translateXProperty(), - 100),
						new KeyValue(r.translateYProperty(), 0)),
					new KeyFrame(Duration.seconds(3),
						new KeyValue(r.translateXProperty(), 0),
						new KeyValue(r.translateYProperty(), 0))
					);
		}
		
		doors.getChildren().get(0).setClip(rect);		
		stack.getChildren().addAll(doors.getChildren());
				
		GridPane grid = new GridPane();		
		grid.setVgap(5);
		grid.setHgap(5);
		grid.setAlignment(Pos.CENTER);
		center.getChildren().add(grid);
		
		grid.add(new Label("User:"), 0, 0);
		grid.add(new TextField(), 1, 0);
		grid.add(new Label("Pass:"), 0, 1);
		grid.add(new TextField(), 1, 1);
		
		Button signInButton = new Button("Sign in");
		signInButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent evt) {
				System.out.format("Button Pressed%n");
				timeline.play();
			}
		});
		grid.add(signInButton, 1, 2, 2, 1);		
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}

}
