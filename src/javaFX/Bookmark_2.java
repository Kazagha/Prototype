package javaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Bookmark_2 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		StackPane stack = new StackPane();		
		BorderPane main = new BorderPane();
		stack.getChildren().add(main);
		
		GridPane center = new  GridPane();
		center.setVgap(10);
		center.setHgap(10);
		center.setAlignment(Pos.CENTER);
		
		VBox tabs = new VBox();
		tabs.setSpacing(5);
		tabs.setAlignment(Pos.CENTER);
		main.setCenter(center);
		main.setLeft(tabs);
		
		center.add(new Label("Select User Name"), 0, 0, 2, 1);
		center.add(new Label("Name:"), 0, 1);
		center.add(new TextField(), 1, 1);
		center.add(new Button("Enter"), 0, 2);
		
		for(int i = 0; i < 10; i++)
		{
			Label l = new Label(" Menu " + i + " ");
			l.setStyle("-fx-background-color: rgba(200, 200, 200, 1.0); -fx-border-color: Grey; -fx-border-width: 1");
			tabs.getChildren().add(l);
		}
		
		Scene scene = new Scene(stack, 350, 350, Color.TRANSPARENT);
		
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
