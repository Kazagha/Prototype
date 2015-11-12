package javaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SlidePane extends Application {

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
	
	public void configureBox(Node root)
	{
		
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
