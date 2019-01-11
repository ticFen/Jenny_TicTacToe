package TTTServer;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ServerView {
	private Stage stage;
	private ServerModel model;
	private Label portLabel;
	private TextField portArea;
	private Button startButton;
	
	public ServerView(Stage stage, ServerModel model) {
		
		portLabel = new Label("Port:");
		portArea = new TextField("");
		startButton = new Button("Start");
		
		TextArea serverArea = new TextArea();
		
		this.model = model;
		this.stage = stage;
		
		HBox topArea = new HBox();
		HBox middleArea = new HBox();
		
		topArea.getChildren().add(portLabel);
		topArea.getChildren().add(portArea);
		topArea.getChildren().add(startButton);
		middleArea.getChildren().add(serverArea);
		// Put menubar, players and controls into a BorderPane
		BorderPane root = new BorderPane();
		root.setTop(topArea);
		root.setCenter(middleArea);
				
		// Disallow resizing - which is difficult to get right with images
		//stage.setResizable(false);

		// Create the scene using our layout; then display it
		Scene scene = new Scene(root);
		stage.setTitle("TTT Server");
		stage.setScene(scene);
		stage.show();
	}
	
	public Button getStartButton()
	{
		return startButton;
	}
	
	public int getPort()
	{
		return Integer.parseInt(portArea.getText());
	}
}
