package TTTClient;

import javafx.scene.control.Button;

public class ClientController {
	private ClientView view;
	private ClientModel model;
	private boolean isXplayer, isOplayer;
	
	public ClientController(ClientView view, ClientModel model) {
			this.view = view;
			this.model = model;
			view.getConnectButton().setOnAction(e -> model.startConnection(view.getPort()));
			view.getPortarea().setOnAction(e -> view.getPortarea().clear());
			view.getButtonInterfaces();
			for(Button b : view.getButtonInterfaces()) {
				b.setOnAction(e -> buttonOnClick(b));
			}
	}
	
	public Button[] getBtnInterfaces(){
		return view.getButtonInterfaces();
	}
	
	public void buttonOnClick(Button b) { //Check if already set
		
		if(b.getText().equals(""))
		{
			String x = "X";
			model.sendInputToServer(x);
			isXplayer = true;
			isOplayer = false;
		}
		
		if(b.getText().equals("X"))
		{
			b.setDisable(true);
		}
		
		if(b.getText().equals("O"))
		{
			b.setDisable(true);
		}
	}
	
}
