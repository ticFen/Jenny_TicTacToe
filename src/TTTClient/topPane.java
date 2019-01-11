package TTTClient;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class topPane extends HBox{
	public topPane()
	{
		Label ipLabel = new Label("IP Adress:");
		TextField ipArea = new TextField("");
		Label portLabel = new Label("Port:");
		TextField portArea = new TextField("");
		Label nameLabel = new Label("Name:");
		TextField nameArea = new TextField("");
		Button connectButton = new Button("Connect");
	}
}
