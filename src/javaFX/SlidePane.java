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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SlidePane extends Application {
	
	private Rectangle bounds = new Rectangle(150, 150, 300, 300);
	
	private StackPane lPane;
	private StackPane rPane;
	private Rectangle rClip;
	private Rectangle lClip;
	
	private Timeline timelineLClose;
	private Timeline timelineRClose;
	private Timeline timelineLOpen;
	private Timeline timelineROpen;

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.autosize();
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Slide Test");
		primaryStage.setWidth(400);
		primaryStage.setHeight(500);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		configureBox(root);
	}
	
	public void configureBox(VBox root)
	{
		StackPane container = new StackPane();
		container.setPrefHeight(250);
		container.setPrefSize(bounds.getWidth(), bounds.getHeight());
		container.setStyle("-fx-border-color: GREEN");
		
		lPane = new StackPane();
		lPane.getChildren().add(new Rectangle(bounds.getWidth(), bounds.getHeight(), Color.GREEN));
		lPane.getChildren().add(new Label("Left Pane"));
		
		rPane = new StackPane();
		rPane.getChildren().add(new Rectangle(bounds.getWidth(), bounds.getHeight(), Color.ORANGE));
		rPane.getChildren().add(new Label("Right Pane"));
		
		container.getChildren().addAll(lPane, rPane);
		
		// Setup the panel animation
		setAnimation();
		
		Group gp = new Group();
		gp.getChildren().add(container);
		root.getChildren().addAll(controlPane(), gp);
	}
	
	private void setAnimation()
	{
		// Initially hide the Panes
		lClip = new Rectangle();
		lClip.setHeight(bounds.getHeight());
		lClip.setWidth(0);
		lClip.translateXProperty().set(bounds.getWidth());		
		lPane.setClip(lClip);
		
		rClip = new Rectangle();
		rClip.setHeight(bounds.getHeight());
		rClip.setWidth(0);
		rClip.translateXProperty().set(bounds.getWidth());
		rPane.setClip(rClip);
		
		// Set the starting position
		lPane.translateXProperty().set(-bounds.getWidth());
		rPane.translateXProperty().set(bounds.getWidth());
		
		timelineLClose = new Timeline();
		timelineRClose = new Timeline();
		timelineLOpen  = new Timeline();
		timelineROpen  = new Timeline();
		
		// Close the left hand side panel
		timelineLClose.setCycleCount(1);
		timelineLClose.setAutoReverse(true);
		final KeyValue kvLClose1 = new KeyValue(lClip.widthProperty(), bounds.getWidth());
		final KeyValue kvLClose2 = new KeyValue(lClip.translateXProperty(), 0);
		final KeyValue kvLClose3 = new KeyValue(lPane.translateXProperty(), 0);
		final KeyFrame kfLClose = new KeyFrame(Duration.millis(1000), kvLClose1, kvLClose2, kvLClose3);
		timelineLClose.getKeyFrames().add(kfLClose);
		
		// Close the right hand side panel
		timelineRClose.setCycleCount(1);
		timelineRClose.setAutoReverse(true);
		final KeyValue kvRClose1;
		final KeyValue kvRClose2;
		final KeyValue kvRClose3 = new KeyValue(rPane.translateXProperty(), 0);
		final KeyFrame kfRClose = new KeyFrame(Duration.millis(1000), kvRClose3);
		timelineRClose.getKeyFrames().add(kfRClose);
		
		// Open the left hand side panel
		timelineLOpen.setCycleCount(1);
		timelineLOpen.setAutoReverse(true);
		final KeyValue kvLOpen1 = new KeyValue(lPane.translateXProperty(), -bounds.getWidth());
		final KeyFrame kfLOpen = new KeyFrame(Duration.millis(500), kvLOpen1);
		timelineLOpen.getKeyFrames().add(kfLOpen);
		
		// Open the right hand side panel
		timelineROpen.setCycleCount(1);
		timelineROpen.setAutoReverse(true);
		final KeyValue kvROpen1 = new KeyValue(rPane.translateXProperty(), bounds.getWidth());
		final KeyFrame kfROpen = new KeyFrame(Duration.millis(500), kvROpen1);
		timelineROpen.getKeyFrames().add(kfROpen);
	}
	
	public HBox controlPane()
	{
		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.setSpacing(10);
		hb.setPrefHeight(40);
		
		Button openButton = new Button("Open");
		Button closeButton = new Button("Close");
		
		closeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				timelineLClose.play();
				timelineRClose.play();
			}			
		});
		
		openButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				timelineLOpen.play();
				timelineROpen.play();
			}
		});
		
		hb.getChildren().addAll(openButton, closeButton);
		
		return hb;
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
