package javaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PromptDialog extends Application{
	
	String itemName = new String("Item Name");
	int itemNum = 0;

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
		Button edit = new Button("Edit");
		edit.setOnAction(evt -> this.edit());	
		root.getChildren().addAll(new Label("Edit Item"), edit);
	}
	
	public void edit()
	{
		GridPane grid = new GridPane();
		grid.setVgap(10);
		grid.setHgap(10);
		
		TextField name  = new TextField(itemName.toString());
		TextField number = new TextField(String.valueOf(itemNum));
		
		grid.add(new Label("Name"), 0, 0);
		grid.add(name, 1, 0);
		grid.add(new Label("Number"), 0, 1);
		grid.add(number, 1, 1);
		
		Dialog d = new Dialog();
		d.setTitle("Edit Item");
		d.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
		d.getDialogPane().setContent(grid);
		d.showAndWait();
	}

	public void showDialog() {		
		Dialog d = new Dialog<String>();
		d.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
		d.getDialogPane().setContent(new TextField("Test"));
		d.showAndWait();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
