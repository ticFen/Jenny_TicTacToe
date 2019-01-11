package TTTServer;

public class ServerController {
	private ServerView view;
	private ServerModel model;
	public ServerController(ServerView view, ServerModel model)
	{
		this.view = view;
		this.model = model;
		view.getStartButton().setOnAction(e -> {
			model.openServer(view.getPort());
			view.getStartButton().setDisable(true);
			});
	}
}
