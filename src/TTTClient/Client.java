package TTTClient;

import javafx.application.Application;

import javafx.stage.Stage;

public class Client extends Application{

	public ClientModel clientModel;
	public ClientView clientView;
	public ClientController clientController;
	
	public static void main(String[] args)
	{
		launch();
	}
	
	public void start(Stage stage)
	{
		clientModel = new ClientModel();
		clientView = new ClientView(stage, clientModel);
		clientController = new ClientController(clientView, clientModel);
	}

}
