package javaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Bookmark_2 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		StackPane stack = new StackPane();
		
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
