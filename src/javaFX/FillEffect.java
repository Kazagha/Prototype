package javaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class FillEffect extends Application {
	
	private TextField lA;
	private BackgroundFill fill;

	@Override
	public void start(Stage primaryStage) throws Exception {

		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setSpacing(10);
		
		fill = new BackgroundFill(Color.RED, new CornerRadii(3), Insets.EMPTY);;

		lA = new TextField("TextField A");
		root.getChildren().add(lA);
		
		TextField lB = new TextField("TextField B");
		lB.setBackground(
				new Background(fill)
				);
		root.getChildren().add(lB);
		
		TextField lC = new TextField("TextField C");
		lC.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(3), BorderWidths.DEFAULT, new Insets(2))));
		root.getChildren().add(lC);
		
		TextField lD = new TextField("TextField D");
		LinearGradient gradient = new LinearGradient(0.0, 0.0, 0.0, 5.0, false, CycleMethod.NO_CYCLE, new 
				Stop[] {
						new Stop(0, Color.RED),
						new Stop(1, Color.WHITE),
						});
		BackgroundFill gFill = new BackgroundFill(gradient, new CornerRadii(2), new Insets(1));
		lD.setBackground(new Background(gFill));
		root.getChildren().add(lD);
				
		Scene scene = new Scene(root);
		primaryStage.setWidth(400);
		primaryStage.setHeight(600);
		primaryStage.setScene(scene);
		primaryStage.show();	
		
		doAfter(root);
	}
	
	public void doAfter(VBox root)
	{
		TextField lE = new TextField("TextField E");
		BackgroundFill TextFieldFill = lA.getBackground().getFills().get(1);
		lE.setBackground(
				new Background(fill, TextFieldFill)
				);
		root.getChildren().add(lE);
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}

}
