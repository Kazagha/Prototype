package javaFX;

import java.util.Observable;

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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Bookmark_2 extends Application {

	int shadowSize = 30; 
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		StackPane stack = new StackPane();
		stack.setStyle("-fx-background-color: rgba(0, 100, 100, 0.0);");
		BorderPane main = new BorderPane();
		stack.getChildren().add(main);
		
		main.setTop(new Label("Test"));
		main.setBottom(new Label("Test"));
		main.setRight(new Label(" "));
		
		GridPane center = new  GridPane();
		center.setVgap(10);
		center.setHgap(10);
		center.setAlignment(Pos.CENTER);
		
		VBox tabs = new VBox();
		tabs.setSpacing(5);
		tabs.setAlignment(Pos.CENTER);
		main.setCenter(center);
		main.setLeft(tabs);
		//main.setStyle("-fx-background-color: rgba(100, 0, 100, 0.0);");
		
		center.add(new Label("Select User Name"), 0, 0, 2, 1);
		center.add(new Label("Name:"), 0, 1);
		center.add(new TextField(), 1, 1);
		center.add(new Button("Enter"), 0, 2);
		center.setStyle("-fx-background-color: rgba(100, 0, 100, 0.5);");
		
		Rectangle dropShadow = new Rectangle(center.getWidth(), center.getHeight());
		//dropShadow.widthProperty().bind(center.widthProperty());
		//dropShadow.heightProperty().bind(center.heightProperty());
		dropShadow.setStyle(
				"  -fx-fill: rgba(0, 100, 100, 1); "
				//+ "-fx-insets: 50;"
				+ "-fx-effect: dropshadow(gaussian, black, 40 , 0, 0, 0);"
				);
		
		center.layoutBoundsProperty().addListener(
				(observable, oldBounds, newBounds) -> {
					dropShadow.relocate(
							newBounds.getMinX() + main.getLeft().getLayoutBounds().getWidth() ,
							newBounds.getMinY() + main.getTop().getLayoutBounds().getHeight() 
							);
					dropShadow.setWidth(newBounds.getWidth()+ 10);
					dropShadow.setHeight(newBounds.getHeight() + 10);					
				}
			);		
		
		stack.getChildren().add(0, dropShadow);
		
		System.out.print(stack.getChildren());
		
		for(int i = 0; i < 10; i++)
		{
			Label l = new Label(" Menu " + i + " ");
			l.setStyle("-fx-background-color: rgba(200, 200, 200, 1.0); -fx-border-color: Grey; -fx-border-width: 1");
			tabs.getChildren().add(l);
		}
		
		Scene scene = new Scene(stack, 350, 350, Color.TRANSPARENT);
		
		primaryStage.setScene(scene);
		//primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
