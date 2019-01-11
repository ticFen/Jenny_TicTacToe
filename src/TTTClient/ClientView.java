package TTTClient;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ClientView {
		
	public Stage stage;
	public ClientModel model;
	
	
	private Scene scene;
	private Button connectButton;
	private TextField portArea;
	private final int MIN_SIZE = 530;
	private final int MAX_SIZE = 530;
	private Image background = new Image(this.getClass().getClassLoader().getResourceAsStream("images/Grid3.png"));
	private Button sendButton;
	private BorderPane root;
	public HBox topArea, 
	midFirstrow,
	midSecondrow,
	midThirdrow, 
	bottomArea;
	public HBox middleArea;
	public GridPane gridPane;
	
	
	private topPane tp;
	private botPane bp;
	private midPane mp;
	//private TextArea middleText;
	
		public ClientView(Stage stage, ClientModel model) {
		this.model = model;
		this.stage = stage;
		
		gridPane = new GridPane();
		
		portArea = new TextField("Enter Port");
		sendButton = new Button("Send");
		connectButton = new Button("Connect");
		//TextArea middleText = new TextArea();
			
		//TextField chatArea = new TextField("Enter new message here");
			
		tp = new topPane();
		bp = new botPane();
		mp = new midPane(model);
		
		topArea = new HBox();
		//middleArea = new HBox();
		
		
		gridPane.setMaxHeight(MAX_SIZE);
		gridPane.setMinHeight(MIN_SIZE);
		gridPane.setMaxWidth(MAX_SIZE);
		gridPane.setMinWidth(MIN_SIZE);
		gridPane.setHgap(0);
		gridPane.setVgap(0);
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		
		//gridPane.setBackground(new Background(new BackgroundImage(background, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null)));
		bottomArea = new HBox();
			
		topArea.getChildren().add(tp);
		gridPane.getChildren().addAll(mp);
		//bottomArea.getChildren().add(chatArea);
		bottomArea.getChildren().add(sendButton);
		bottomArea.getChildren().add(portArea);
		bottomArea.getChildren().add(connectButton);
		// Put menubar, players and controls into a BorderPane
		
		root = new BorderPane();
		root.setTop(topArea);
		root.setCenter(gridPane);
		root.setBottom(bottomArea);
					
		// Disallow resizing - which is difficult to get right with images
		//stage.setResizable(false);
		// Create the scene using our layout; then display it
		
		scene = new Scene(root);
		stage.setTitle("TTT Client");
		scene.getStylesheets().add(
                getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
		
	public Button getConnectButton()
	{
		return connectButton;
	}
	
	public int getPort()
	{
		return Integer.parseInt(portArea.getText());
	}
	
	public Button[] getButtonInterfaces(){
		return mp.btnInterFaces;
	}
	
	public TextField getPortarea()
	{
		return portArea;
	}
	
}
