package javaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginCSS extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		primaryStage.setTitle("JaxaFX Login");
		
		// Create new grid layout
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		
		// Set horizontal and vertical spacing between components
		grid.setHgap(10);
		grid.setVgap(10);
				
		// Set padding around the GridPane component
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		// Visually display the constraints around each cell
		//grid.setGridLinesVisible(true);
		
		// Create the welcome text in position 0, 1
		Text sceneTitle = new Text("Welcome");
		// Set ID access for CSS style sheet
		sceneTitle.setId("welcome-text");
		grid.add(sceneTitle, 0, 1, 2, 1);
				
		// Create Labels and Text Fields		
		Label userName = new Label("User Name:");
		grid.add(userName, 0, 2);
		
		Label passWord = new Label("Password:");
		grid.add(passWord, 0, 3);
		
		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 2);
		
		PasswordField passTextField = new PasswordField();
		grid.add(passTextField, 1, 3);
		
		// Add error text
		final Text actionTarget = new Text();
		// Set ID access for CSS style sheet
		actionTarget.setId("actiontarget");
		grid.add(actionTarget, 1, 6);		
		
		// Create Buttons
		Button button = new Button("Sign in");		
		// Add the button to the bottom right of the HBox component 
		HBox hbButton = new HBox(10);
		hbButton.setAlignment(Pos.BOTTOM_RIGHT);
		hbButton.getChildren().add(button);
		// Add the HBox to the grid
		grid.add(hbButton, 1, 4);
		
		button.setOnAction(new EventHandler<ActionEvent>() 
			{			
			@Override
			public void handle(ActionEvent evt) 
			{
				actionTarget.setText("Sign in button pressed");			
			}
		});
		
		// Create the scene
		Scene scene = new Scene(grid, 300, 275);
		
		scene.getStylesheets().add(
				LoginCSS.class.getResource("Login.css").toExternalForm());
		
		// Add Scene and display
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
