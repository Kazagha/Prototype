package javaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
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
		primaryStage.setWidth(350);
		primaryStage.setHeight(350);
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
		
		StackPane rPane = new StackPane();
		rPane.getChildren().add(new Rectangle(bounds.getWidth(), bounds.getHeight(), Color.ORANGE));
		
		container.getChildren().addAll(lPane, rPane);
		
		root.getChildren().add(container);
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
