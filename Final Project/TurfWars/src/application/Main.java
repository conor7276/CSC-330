package application;
	import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;

import java.util.*;

public class Main extends Application {
	@SuppressWarnings("removal")
	Integer size_amount = new Integer(0);
	GridSquare gameboard[][]= new GridSquare[size_amount][size_amount];
	Scene Menu, GameScreen, gamesize;
	public static void main(String[] args) throws FileNotFoundException {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			primaryStage.setTitle("Slippery Turf Wars");
			Button play = new Button();
			play.setShape(new Circle());
			play.setMaxSize(3,3);
			play.setGraphic(new ImageView( new Image(new FileInputStream("Assets/right_arrow.png"), 50, 50, false, false)));
			ImageView GameTitle = new ImageView( new Image(new FileInputStream("Assets/Title.png"), 250, 150, false, false));
			VBox menuLayOut = new VBox(30);
			menuLayOut.getChildren().addAll(GameTitle,play);
			menuLayOut.setAlignment(Pos.CENTER);
			BackgroundImage menu_BG= new BackgroundImage(new Image("slime_BG.jpg",500,500,false,true),
			        BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			          BackgroundSize.DEFAULT);
			menuLayOut.setBackground(new Background(menu_BG));
		    Menu = new Scene(menuLayOut, 500, 250);
			play.setOnAction(e -> primaryStage.setScene(gamesize));
			
			
			Label size_error_message = new Label();
			size_error_message.setStyle("-fx-text-fill:BLACK; -fx-font-size: 20;");
			Button entersize = new Button();
			entersize.setShape(new Circle());
			entersize.setMaxSize(3,3);
			entersize.setGraphic(new ImageView( new Image(new FileInputStream("Assets/right_arrow.png"), 50, 50, false, false)));
			entersize.setDisable(true);
			Button back_to_menu = new Button();
			back_to_menu.setShape(new Circle());
			back_to_menu.setMaxSize(3,3);
			back_to_menu.setGraphic(new ImageView( new Image(new FileInputStream("Assets/left_arrow.png"), 50, 50, false, false)));

			
			Button player_pink = new Button();
			player_pink.setPadding(Insets.EMPTY);
			player_pink.setGraphic(new ImageView( new Image(new FileInputStream("Assets/Pink_Slime_Icon.png"), 50, 50, false, false)));
			player_pink.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event)
				{
					entersize.setDisable(false);
				}
				});
			Button player_green = new Button();
			player_green.setPadding(Insets.EMPTY);
			player_green.setGraphic(new ImageView( new Image(new FileInputStream("Assets/Green_Slime_Icon.png"), 50, 50, false, false)));
			player_green.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event)
				{
					entersize.setDisable(false);
				}
				});
			Button player_purple = new Button();
			player_purple.setPadding(Insets.EMPTY);
			player_purple.setGraphic(new ImageView( new Image(new FileInputStream("Assets/Purple_Slime_Icon.png"), 50, 50, false, false)));
			player_purple.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event)
				{
					entersize.setDisable(false);
				}
				});
			Button player_blue= new Button();
			player_blue.setPadding(Insets.EMPTY);
			player_blue.setGraphic(new ImageView( new Image(new FileInputStream("Assets/Blue_Slime_Icon.png"), 50, 50, false, false)));
			player_blue.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event)
				{
					entersize.setDisable(false);
				}
				});
			HBox player_select_group = new HBox(10);
			player_select_group.setAlignment(Pos.CENTER);
			player_select_group.getChildren().addAll(player_pink,player_green,player_purple,player_blue);
			
			TextField boardsize = new TextField();
			boardsize.setMaxWidth(250);
			boardsize.setPromptText("Please enter a whole number between 10-45");
			boardsize.setFocusTraversable(false);
			GridPane  grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			back_to_menu.setOnAction(e -> primaryStage.setScene(Menu));
			entersize.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event)
			{
				try {
					size_amount = Integer.parseInt(boardsize.getText());
					} catch (NumberFormatException e) {
						boardsize.clear();
					}
				if(size_amount > 45 || size_amount < 10)
				{
					size_error_message.setText("Please enter a number within range.");
					boardsize.clear();
				}
				else {
					gameboard = new GridSquare[size_amount][size_amount];
					for(int i=0; i < size_amount; i++)
					{
						for(int j=0; j < size_amount; j++)
						{
							gameboard[i][j] =  new GridSquare();
							gameboard[i][j].setPadding(new Insets(0,0,0,0));
							gameboard[i][j].setLoction(i, j);
							System.out.print(gameboard[i][j].getLocation()[0] + "," + gameboard[i][j].getLocation()[1]+ " ");
							try {
								if(size_amount <= 15)
								gameboard[i][j].setGraphic(new ImageView(new Image(new FileInputStream("Assets/Gray_square_tile .PNG"), 50, 50, false, false)));
							    else if(size_amount <= 25) gameboard[i][j].setGraphic(new ImageView(new Image(new FileInputStream("Assets/Gray_square_tile .PNG"), 30, 30, false, false)));
							    else if(size_amount <= 30)gameboard[i][j].setGraphic(new ImageView(new Image(new FileInputStream("Assets/Gray_square_tile .PNG"), 22, 22, false, false)));
							    else if(size_amount <= 40)gameboard[i][j].setGraphic(new ImageView(new Image(new FileInputStream("Assets/Gray_square_tile .PNG"), 18, 18, false, false)));
							    else if(size_amount <= 45)gameboard[i][j].setGraphic(new ImageView(new Image(new FileInputStream("Assets/Gray_square_tile .PNG"), 15, 15, false, false)));
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
						}
						System.out.print("\n");
					}
					for(int i=0; i < size_amount; i++)
					{
						for(int j=0; j < size_amount; j++)
						{
							GridSquare temp = gameboard[i][j];
						
							grid.add(temp, j, i);
						}
					}
					boardsize.clear();
					size_error_message.setText("");
					entersize.setDisable(false);
					primaryStage.setScene(GameScreen);
				}
			}
			});
			HBox gamesize_Button_layout = new HBox(5);
			gamesize_Button_layout.getChildren().addAll(back_to_menu,entersize);
			gamesize_Button_layout.setAlignment(Pos.CENTER);
			VBox gamesize_layout = new VBox(30);
			gamesize_layout.getChildren().addAll(size_error_message,boardsize,player_select_group,gamesize_Button_layout);
			gamesize_layout.setAlignment(Pos.CENTER);
			BackgroundImage gamesize_BG= new BackgroundImage(new Image("slime_BG.jpg",500,500,false,true),
			        BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			          BackgroundSize.DEFAULT);
			gamesize_layout.setBackground(new Background(gamesize_BG));
			gamesize = new Scene(gamesize_layout,400, 250);
			
			
			
			
			Button exit = new Button();
			exit.setShape(new Circle());
			exit.setMaxSize(3,3);
			exit.setOnAction(e -> primaryStage.setScene(gamesize)); //bug here cant reset the size without first restting the gameboard array to null.
		    exit.setGraphic(new ImageView( new Image(new FileInputStream("Assets/left_arrow.png"), 30, 30, false, false)));
			VBox gameLayOut = new VBox(10);
			BackgroundImage gamescreen_BG= new BackgroundImage(new Image("slime_BG.jpg",500,500,false,true),
			        BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			          BackgroundSize.DEFAULT);
			gameLayOut.setBackground(new Background(gamescreen_BG));
			gameLayOut.getChildren().addAll(exit,grid);
			gameLayOut.setAlignment(Pos.CENTER);
			GameScreen = new Scene(gameLayOut);
			if(primaryStage.getScene() == GameScreen)
			{
				
				
				
				
				
				
			}
			
			
			Menu.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(Menu);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
