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

public class SlidePaneHalf extends Application {
	
	private Rectangle bounds = new Rectangle(150, 150, 300, 300);
	private int bounce = 4;
	
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
		container.setStyle("-fx-border-color: DIMGREY");
		
		lPane = new StackPane();
		lPane.setAlignment(Pos.CENTER_LEFT);
		//lPane.setStyle("-fx-border-color: BLUE");
		lPane.getChildren().add(new Rectangle(bounds.getWidth() / 2, bounds.getHeight(), Color.GREEN));
		lPane.getChildren().add(new Label("Left Pane"));
		
		rPane = new StackPane();
		rPane.setAlignment(Pos.CENTER_RIGHT);
		//rPane.setStyle("-fx-border-color: RED");
		rPane.getChildren().add(new Rectangle(bounds.getWidth() / 2, bounds.getHeight(), Color.ORANGE));
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
		lClip.translateXProperty().set(bounds.getWidth() / 2);		
		lPane.setClip(lClip);
		
		rClip = new Rectangle();
		rClip.setHeight(bounds.getHeight());
		rClip.setWidth(0);
		rClip.translateXProperty().set(bounds.getWidth() / 2);
		rPane.setClip(rClip);
		
		// Set the starting position
		lPane.translateXProperty().set(-bounds.getWidth() / 2);
		rPane.translateXProperty().set(bounds.getWidth() / 2);
						
		timelineLClose = new Timeline();
		timelineRClose = new Timeline();
		timelineLOpen  = new Timeline();
		timelineROpen  = new Timeline();
		Timeline timelineLBounce = new Timeline();
		Timeline timelineRBounce = new Timeline();
		
		timelineLBounce.setCycleCount(2);
		timelineLBounce.setAutoReverse(true);	
		final KeyValue kvL0 = new KeyValue(lPane.translateXProperty(), 0);
		final KeyValue kvL1 = new KeyValue(lClip.widthProperty(), (bounds.getWidth() / 2) - bounce);
		final KeyValue kvL2 = new KeyValue(lClip.translateXProperty(),  bounce);
		final KeyValue kvL3 = new KeyValue(lPane.translateXProperty(), -bounce);		
		final KeyFrame kfL = new KeyFrame(Duration.millis(50), kvL1, kvL2, kvL3);
		timelineLBounce.getKeyFrames().add(kfL);
		
		timelineRBounce.setCycleCount(2);
		timelineRBounce.setAutoReverse(true);
		final KeyValue kvR0 = new KeyValue(rPane.translateXProperty(),  0);
		final KeyValue kvR1 = new KeyValue(rClip.widthProperty(), (bounds.getWidth() / 2) - bounce);		
		final KeyValue kvR2 = new KeyValue(rClip.translateXProperty(), (bounds.getWidth() / 2));
		final KeyValue kvR3 = new KeyValue(rPane.translateXProperty(),  bounce);
		final KeyFrame kfR = new KeyFrame(Duration.millis(50), kvR1, kvR2, kvR3);
		timelineRBounce.getKeyFrames().add(kfR);
		
		EventHandler<ActionEvent> onFinishedLeft = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) 
			{
				timelineLBounce.play();
			}
		};
		
		EventHandler<ActionEvent> onFinishedRight = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) 
			{
				timelineRBounce.play();
			}
		};
		
		// Close the left hand side panel
		timelineLClose.setCycleCount(1);
		timelineLClose.setAutoReverse(true);
		final KeyValue kvLClose1 = new KeyValue(lClip.widthProperty(), bounds.getWidth() / 2);
		final KeyValue kvLClose2 = new KeyValue(lClip.translateXProperty(), 0);
		final KeyValue kvLClose3 = new KeyValue(lPane.translateXProperty(), 0);
		final KeyFrame kfLClose = new KeyFrame(Duration.millis(400), onFinishedLeft, kvLClose1, kvLClose2, kvLClose3);
		timelineLClose.getKeyFrames().add(kfLClose);
		
		// Close the right hand side panel
		timelineRClose.setCycleCount(1);
		timelineRClose.setAutoReverse(true);
		final KeyValue kvRClose1 = new KeyValue(rClip.widthProperty(), bounds.getWidth() / 2);
		final KeyValue kvRClose2 = new KeyValue(rClip.translateXProperty(), bounds.getWidth() / 2);
		final KeyValue kvRClose3 = new KeyValue(rPane.translateXProperty(), 0);
		final KeyFrame kfRClose = new KeyFrame(Duration.millis(400), onFinishedRight, kvRClose1, kvRClose2, kvRClose3);
		timelineRClose.getKeyFrames().add(kfRClose);
		
		// Open the left hand side panel
		timelineLOpen.setCycleCount(1);
		timelineLOpen.setAutoReverse(true);
		final KeyValue kvLOpen1 = new KeyValue(lClip.widthProperty(), 0);
		final KeyValue kvLOpen2 = new KeyValue(lClip.translateXProperty(), bounds.getWidth() / 2);
		final KeyValue kvLOpen3 = new KeyValue(lPane.translateXProperty(), -bounds.getWidth() / 2);
		final KeyFrame kfLOpen = new KeyFrame(Duration.millis(350), kvLOpen1, kvLOpen2, kvLOpen3);
		timelineLOpen.getKeyFrames().add(kfLOpen);
		
		// Open the right hand side panel
		timelineROpen.setCycleCount(1);
		timelineROpen.setAutoReverse(true);
		final KeyValue kvROpen1 = new KeyValue(rClip.widthProperty(), 0);
		final KeyValue kvROpen2 = new KeyValue(rClip.translateXProperty(), bounds.getWidth() / 2);
		final KeyValue kvROpen3 = new KeyValue(rPane.translateXProperty(), bounds.getWidth() / 2);		
		final KeyFrame kfROpen = new KeyFrame(Duration.millis(350), kvROpen1, kvROpen2, kvROpen3);
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
