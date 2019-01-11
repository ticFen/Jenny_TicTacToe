package TTTServer;

import javafx.application.Application;
import javafx.stage.Stage;

public class Server extends Application{

	public ServerModel serverModel;
	public ServerView serverView;
	public ServerController serverController;
	
	public static void main(String[] args)
	{
		launch();
	}
	
	public void start(Stage stage)
	{
		serverModel = new ServerModel();
		serverView = new ServerView(stage, serverModel);
		serverController = new ServerController(serverView, serverModel);
	}

}
