package javaFX;

import java.awt.Insets;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Bookmark extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		GridPane grid = new GridPane();
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setAlignment(Pos.CENTER);
		
		Label text = new Label("Text");
		grid.add(text, 1, 0);
		
		ScrollPane scroll = new ScrollPane();
		grid.add(scroll, 1, 1);
		
		Button buttonA = new Button("A");
		Button buttonB = new Button("B");
		
		grid.add(buttonB, 0, 0);
		grid.add(buttonA, 0, 1);
		
		//StackPane tabGlass = new StackPane();
		//tabGlass.setStyle("-fx-background-color: rgba(100, 0, 100, 0.5); -fx-background-radius: 10;");
		
		VBox tabs = new VBox();
		tabs.setSpacing(0);
		tabs.setAlignment(Pos.CENTER);
		

		
		Stop[] stops = new Stop[] { new Stop(1, Color.web("Black", .85)), new Stop(0.5, Color.web("Black", .25)), new Stop(0, Color.TRANSPARENT) };
		LinearGradient gradient = new LinearGradient(0.0f, 0.5f, 1.0f, 0.5f, true, CycleMethod.NO_CYCLE, stops);
		//	Stop[] {
		//		new Stop(0, Color.web("Black"),
		//		new Stop(1, Color.web("Red")),
		//});
	
		for (int i = 0; i < 10; i++)
		{
			StackPane tabPane = new StackPane();
		
			Label l = new Label(" Menu " + i + "   ");			
			l.setStyle("-fx-background-color: rgba(200, 200, 200, 1.0); -fx-border-color: Grey; -fx-border-width: 1");
			
			/*
			Rectangle stroke = new Rectangle(16, 16);
			stroke.widthProperty().bind(l.widthProperty());
			stroke.setStroke(Color.RED);
			stroke.setStrokeWidth(1);
			stroke.setStrokeType(StrokeType.INSIDE);
			*/
			
			Rectangle rect = new Rectangle(17, 23);
			rect.setFill(gradient);

			//rect.setStyle("-fx-background-color: rgba(100, 0, 0, 1.0);");
			
			//Group blendGroup =
			//		new Group ( l, stroke );
			//blendGroup.setBlendMode(BlendMode.OVERLAY);
			
			
						
			//tabPane.getChildren().addAll(l, rect);
			tabPane.getChildren().add(l);			
			//tabPane.getChildren().add(stroke);
			tabPane.getChildren().add(rect);
			tabPane.setAlignment(Pos.CENTER_RIGHT);
			//tabPane.getChildren().add(blendGroup);
			tabs.getChildren().add(tabPane);
		}

		
		grid.add(new Rectangle(20, 20, gradient), 3, 3);
			
		StackPane glass = new StackPane();
		
		glass.setStyle("-fx-background-color: rgba(0, 100, 100, 1); -fx-background-radius: 10;" );
		
		Rectangle shadow = new Rectangle(tabs.getWidth(), tabs.getHeight());
		shadow.widthProperty().bind(tabs.widthProperty());
		shadow.heightProperty().bind(tabs.heightProperty());
		shadow.setFill(gradient);
		
		glass.getChildren().add(grid);
		
	   
		StackPane main = new StackPane();
		main.setStyle("-fx-background-color: rgba(100, 0, 100, 0.0); -fx-background-radius: 10; ");
		
		BorderPane borderPane = new BorderPane();
		main.getChildren().add(borderPane);   
		
		borderPane.setCenter(glass);
		borderPane.setLeft(tabs);
		
		//layout.setCenter(glass);
		//layout.setLeft(tabGlass);
		
		//Scene scene = new Scene(glass, 350, 350, Color.TRANSPARENT);
		//Scene scene = new Scene(layout, 350, 350, Color.TRANSPARENT);
		Scene scene = new Scene(main, 350, 350, Color.TRANSPARENT);
		
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
