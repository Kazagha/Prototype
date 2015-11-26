package javaFX;

import java.util.List;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.Interpolatable;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PromptDialog extends Application{
	
	private String itemName = new String("Item Name");
	private int itemNum = 0;
	private VBox contentPane;
	private WarningAnimation animation;

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
		EventHandler<MouseEvent> handler = new ContextHandler();
		animation = new WarningAnimation();
		
		Button edit = new Button("Edit");
		//edit.setOnAction(evt -> this.edit());	
		root.getChildren().addAll(new Label("Edit Item"), edit);
		
		contentPane = new VBox();
		contentPane.setSpacing(10);
		contentPane.setAlignment(Pos.CENTER);		
		for (int i = 0; i < 10; i++)
		{			
			GridPane grid = new GridPane();
			grid.addEventHandler(MouseEvent.ANY, handler);
			grid.setAlignment(Pos.CENTER);
			grid.add(new Label("Stack " + i + " "), 1, 0, 1, 1);
			ProgressBar p = new ProgressBar(100);
			p.setPrefWidth(350);
			p.setProgress(Math.random());
			
			// Progress Bar is not clickable by default
			// Put the Progress Bar underneath the StackPane to accept clicks 
			StackPane s = new StackPane();
			s.getChildren().addAll(p, new StackPane());
			grid.add(s, 0, 1, 3, 1);
			
			contentPane.getChildren().add(grid);
		}
		root.getChildren().add(contentPane);
	}
	
	class WarningAnimation 
	{
		Timeline timeline;
		Region node = null;
		Background bgFill;
		String warningStyle;
		
		public WarningAnimation()
		{
			EventHandler<ActionEvent> onFinished = new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent event)
				{
					node.setBackground(bgFill);
				}				
			};
			
			ObjectProperty<Color> warningColor = new SimpleObjectProperty<>();
			timeline = new Timeline();
			timeline .setCycleCount(4);
			timeline .setAutoReverse(true);
			KeyValue kv0 = new KeyValue(warningColor, Color.WHITE);
			KeyValue kv1 = new KeyValue(warningColor, Color.RED);
			KeyFrame kf0 = new KeyFrame(Duration.ZERO, onFinished, kv0);
			KeyFrame kf1 = new KeyFrame(Duration.millis(50), kv1);
			timeline.getKeyFrames().addAll(kf0, kf1);
			
			warningColor.addListener((obs, oldValue, newValue) -> {
				warningStyle = String.format("-fx-background-color: rgba(%d, %d, %d, %d);%n",
					(int)(newValue.getRed()		*255),
					(int)(newValue.getGreen()	*255),
					(int)(newValue.getBlue()	*255),
					(int)(newValue.getOpacity() *255));
				System.out.format("Warning: %s%n", warningStyle);
				node.setBackground(new Background(new BackgroundFill(newValue, CornerRadii.EMPTY, Insets.EMPTY)));
			});
		}
		
		public void playWarning(Region n)
		{
			this.node = n;
			bgFill = n.getBackground();
			timeline.play();
		}
	}
	
	class ContextHandler implements EventHandler<MouseEvent>
	{
		@Override
		public void handle(MouseEvent evt) {
			Node source = (Node) evt.getSource();
			Node target = (Node) evt.getTarget();
			
			// Release of the right click button
			if (evt.getEventType() == MouseEvent.MOUSE_RELEASED &&
					evt.getButton() == MouseButton.SECONDARY)
			{
				int index = contentPane.getChildren().indexOf(source);
				System.out.format("Right Click at %s%n", index);
				
				edit(index);
			}
				
		}		
	}
	
	public void edit(int idx)
	{		
		Item item = new Item("Name", 145);
		
		Dialog d = new Dialog();
		d.setTitle("Edit Item");
		d.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);		
		d.getDialogPane().setContent(item.edit());
		
		// Add event filter for valid inputs
		Button ok = (Button) d.getDialogPane().lookupButton(ButtonType.OK);
		ok.addEventFilter(ActionEvent.ACTION, event -> {
			if (! item.validateAndStore())	// Check if the input is valid and save it
				event.consume();
			}
		);
		
		d.showAndWait()
			.filter(response -> response == ButtonType.OK)
			.ifPresent(response -> System.out.format("Item Name: %s%n", item.itemName));		
	}
	
	/**
	 * Format the specified nodes into two columns and return the GridPane
	 * @param nodes
	 * @return
	 */
	public static GridPane toDialog(Node... nodes)
	{
		GridPane gp = new GridPane();
		gp.setVgap(10);
		gp.setHgap(10);
		int x = 0;
		int y = 0;
		
		for (Node n : nodes)
		{
			gp.add(n, x, y);
						
			if (++x == 2)
			{
				x = 0;
				y++;
			}			
		}
		
		return gp;
	}
		
	class Item {
		private String itemName = new String("");
		private int itemNumber = 0;
		
		private TextField nameField;
		private TextField numberField;
		
		public Item(String name, int number)
		{
			this.itemName = name;
			this.itemNumber = number;
		}
		
		public Pane edit()
		{
			GridPane grid = new GridPane();
			grid.setVgap(10);
			grid.setHgap(10);
			
			nameField  = new TextField(itemName.toString());
			numberField = new TextField(String.valueOf(itemNum));
			
			grid.add(new Label("Name"), 0, 0);
			grid.add(nameField, 1, 0);
			grid.add(new Label("Number"), 0, 1);
			grid.add(numberField, 1, 1);
			
			// Set foucs on the "Name" field after the dialog is created
			Platform.runLater(() -> nameField.requestFocus());
			
			return toDialog(new Label("Name"), nameField, new Label("Number"), numberField);
		}
		
		public boolean validateAndStore()
		{
			if (nameField.getText().equals("")) {
				nameField.setStyle("-fx-background-color: rgba(100, 0, 0, .25);");
				return false;
			}
			
			if (Integer.valueOf(numberField.getText()) <= 0)
			{				
				//numberField.setStyle("-fx-background-color: RED");
				animation.playWarning(numberField);
				return false;				
			}
			
			itemName = nameField.getText();
			itemNum = Integer.valueOf(numberField.getText());
			
			return true;
		}
	}
	
	public Timeline createTimeline(ObjectProperty<Color> color)
	{
		Timeline timeline = new Timeline();
		timeline.setCycleCount(1);
		timeline.setAutoReverse(true);
		final KeyValue kv1 = new KeyValue(color, Color.RED, Interpolator.LINEAR);
		final KeyFrame kf1 = new KeyFrame(Duration.millis(500), kv1);
		timeline.getKeyFrames().add(kf1);
		
		return timeline;
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
