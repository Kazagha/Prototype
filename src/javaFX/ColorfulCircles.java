package javaFX;

import static java.lang.Math.random;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ColorfulCircles extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		// Setup
		Group root = new Group();
		Scene scene = new Scene(root, 800, 600, Color.BLACK);
		primaryStage.setScene(scene);
		
		// Create Circles
		Group circles = new Group();
		for (int i = 0; i < 30; i++) 
		{
			Circle circle = new Circle(150, Color.web("white", 0.05));
			circle.setStrokeType(StrokeType.OUTSIDE);
			circle.setStroke(Color.web("white", 0.16));
			circle.setStrokeWidth(4);
			
			circles.getChildren().add(circle);
		}
		
		// Setup color gradient
		LinearGradient gradient = new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new 
		         Stop[]{
		                 new Stop(0, Color.web("#f8bd55")),
		                 new Stop(0.14, Color.web("#c0fe56")),
		                 new Stop(0.28, Color.web("#5dfbc1")),
		                 new Stop(0.43, Color.web("#64c2f8")),
		                 new Stop(0.57, Color.web("#be4af7")),
		                 new Stop(0.71, Color.web("#ed5fc2")),
		                 new Stop(0.85, Color.web("#ef504c")),
		                 new Stop(1, Color.web("#f2660f")),});
		
		// Create rectangle, lock width/height to the scene
		Rectangle colors = new Rectangle(scene.getWidth(), scene.getHeight(), gradient);		
		colors.widthProperty().bind(scene.widthProperty());
		colors.heightProperty().bind(scene.heightProperty());
				
		// Add components to the root group
		//root.getChildren().add(colors);
		//root.getChildren().add(circles);
		
		// Blend Group
		Group blendModeGroup = 
				new Group(
						new Group(
								new Rectangle(scene.getWidth(), scene.getHeight(), Color.BLACK), circles),
						colors);				
		colors.setBlendMode(BlendMode.OVERLAY);
		root.getChildren().add(blendModeGroup);
		
		// Setup time frame to move the circles		
		Timeline timeline = new Timeline();
		for (Node circle : circles.getChildren())
		{
			timeline.getKeyFrames().addAll(
					new KeyFrame(Duration.ZERO, // At time zero
							new KeyValue(circle.translateXProperty(), random() * 800),
							new KeyValue(circle.translateYProperty(), random() * 600)),
					new KeyFrame(Duration.seconds(40), // 40 second duration
							new KeyValue(circle.translateXProperty(), random() * 800),
							new KeyValue(circle.translateYProperty(), random() * 600)));			
		}
		// Begin the time frame
		timeline.play();
		
		// Add blur effect to circles
		circles.setEffect(new BoxBlur(10, 10, 3));		
		
		// Display the GUI
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
