package javaFX;

import javafx.application.Application;
import javafx.stage.Stage;

public class View extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("MVC Test Application");
		
		primaryStage.show();
	}
	
	public void setAttempts(int i) {}
}
