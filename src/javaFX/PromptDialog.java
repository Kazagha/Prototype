package javaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PromptDialog extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setSpacing(10);
				
		init(root);
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(
				Selection.class.getResource("Selection.css").toExternalForm());
		primaryStage.setTitle("Selection Test");
		primaryStage.setWidth(400);
		primaryStage.setHeight(600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void init(VBox root)
	{
		root.getChildren().add(new Label("Select"));		
	}

	public void showDialog() {		
		Dialog d = new Dialog<String>();
		d.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
		d.getDialogPane().setContent(new TextField("Test"));
		d.showAndWait();
	}
}
