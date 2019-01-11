package TTTClient;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
//https://stackoverflow.com/questions/27912628/how-to-overlap-buttons-text-over-an-image-with-javafx-8

public class midPane extends GridPane{
	
	private ClientView view;
	private ClientModel model;
	private Image image;
	private ImageView imageView;
	private String filePath;
	public Button[] btnInterFaces;
	private Double moveX, moveY;
	
	public midPane(ClientModel model) {
		super();
		this.model = model;
		
		btnInterFaces = new Button[9];
		
		for(int i = 0; i < btnInterFaces.length; i++)
		{
			addButtons(i);
		}
		
	}
	
	public void addButtons(int number)
	{
		
		btnInterFaces[number] = new Button("");
		btnInterFaces[number].setMinHeight(160);
		btnInterFaces[number].setMaxHeight(160);
		btnInterFaces[number].setMinWidth(160);
		btnInterFaces[number].setMinWidth(160);
		//btnInterFaces[number].setTranslateX(number * 30);
		//this.getChildren().add(btnInterFaces[number]);
		
		if(number <= 2) {
			this.add(btnInterFaces[number], 0, number);
			GridPane.setMargin(btnInterFaces[number], new Insets(5, 0, 10, 10));
		}
		if(number > 2 && number < 6)
		{
			this.add(btnInterFaces[number], 1, number - 3);
			GridPane.setMargin(btnInterFaces[number], new Insets(5, 0, 10, 10));
		}
		if(number > 5)
		{
			this.add(btnInterFaces[number], 2, number - 6);	
			GridPane.setMargin(btnInterFaces[number], new Insets(5, 0, 10, 10));
		}
		}
		
	}

	//public ImageView addGrid(String filePath) {
		//try {			//try to add the background grid
			//image = new Image(this.getClass().getClassLoader().getResourceAsStream("images/" + filePath));
			//imageView = new ImageView(image);
			//if(filePath == "Grid.png") {
				//imageView.setFitHeight(540); 
				//imageView.setFitWidth(540);
			//}
			//imageView.setPreserveRatio(true);
			
//		} catch (Exception e)
//			{
//				System.out.println(e.getMessage());
//			}
//	return imageView;
//	
//	}
