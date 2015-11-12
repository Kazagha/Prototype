package javaFX;

import javafx.application.Application;
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

public class SlidePane extends Application {
	
	private Rectangle bounds = new Rectangle(150, 150, 300, 300);

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
		
		StackPane lPane = new StackPane();
		lPane.getChildren().add(new Rectangle(bounds.getWidth(), bounds.getHeight(), Color.GREEN));
		lPane.getChildren().add(new Label("Left Pane"));
		
		StackPane rPane = new StackPane();
		rPane.getChildren().add(new Rectangle(bounds.getWidth(), bounds.getHeight(), Color.ORANGE));
		rPane.getChildren().add(new Label("Right Pane"));
		
		container.getChildren().addAll(lPane, rPane);
		
		Group gp = new Group();
		gp.getChildren().add(container);
		root.getChildren().addAll(controlPane(), gp);
	}
	
	public HBox controlPane()
	{
		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.setSpacing(10);
		hb.setPrefHeight(40);
		
		Button openButton = new Button("Open");
		Button closeButton = new Button("Close");
		
		hb.getChildren().addAll(openButton, closeButton);
		
		return hb;
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
