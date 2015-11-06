package javaFX;

import javafx.stage.Stage;

public class Controller {
	int count;
	View view;
	
	public Controller(View view)
	{
		this.view = view;
		this.count = 0;
		
		view.setAttempts(count);
	}
	
	public static void main(String[] args) throws Exception
	{
		View v = new View();
		Controller c = new Controller(v); 
		
		v.launch(View.class);	
	}	
}
