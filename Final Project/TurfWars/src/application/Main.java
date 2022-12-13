package application;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//import javafx.fxml.FXMLLoader; // Conor: I have to comment these two imports out otherwise they throw an error for me idk what I'm missing ( I will uncomment these when I'm done)
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Parent;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.geometry.Pos;

//import java.awt.event.KeyEvent; // Conor: I have to comment these two imports out otherwise they throw an error for me idk what I'm missing ( I will uncomment these when I'm done)
import javafx.geometry.Insets;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.*;

public class Main extends Application {
	
	@SuppressWarnings("removal")
	Integer size_amount = new Integer(0);
	
	GridSquare gameboard[][] = new GridSquare[size_amount][size_amount];
	Scene menu, game_screen, game_size, howTo;
	@SuppressWarnings("removal")
	Integer size_graphic = new Integer(0);
	User u = new User();
	AI ai1 = new AI(), ai2 = new AI(), ai3 = new AI();
	@SuppressWarnings("removal")
	int selected_icon;
	String set_player;
	String set_trail;
	GridPane grid = new GridPane();

	boolean check = false;
	public static void main(String[] args) throws FileNotFoundException {
		launch(args);
	}
	MediaPlayer button_press;
	@Override
	public void start(Stage primaryStage) {
		

		MediaPlayer game_audio;
		
		button_press = new MediaPlayer(new Media(new File("Assets/button_press.mp3").toURI().toString()));
		button_press.setVolume(0.3);
		game_audio = new MediaPlayer(new Media(new File("Assets/In_game_theme_music.mp3").toURI().toString()));
		game_audio.setVolume(0);
		game_audio.setAutoPlay(true);
		game_audio.setCycleCount(MediaPlayer.INDEFINITE);

		try {

			primaryStage.setTitle("Slippery Turf Wars");
			
			Button rules = new Button();
			rules.setShape(new Circle());
			rules.setMaxSize(3, 3);
			rules.setGraphic(new ImageView(new Image(new FileInputStream("Assets/how_to_play.png"), 30, 30, false, false)));
			rules.setOnAction(e -> {
				primaryStage.setScene(howTo);
			});
			
			Button resume = new Button();
			resume.setShape(new Circle());
			resume.setMaxSize(3, 3);
			
			resume.setGraphic(new ImageView(new Image(new FileInputStream("Assets/Save.png"), 30, 30, false, false)));
			
			resume.setOnAction(e -> {
				
				if(check == false)
				{
				try {				
					//Let's load our data.	
					
					ObjectInputStream oit = new ObjectInputStream(new FileInputStream("stw.ser"));
					
					size_amount = oit.readInt();
					size_graphic = oit.readInt();
					
					gameboard = new GridSquare[size_amount][size_amount];
					gameboard = (GridSquare[][]) oit.readObject();
					System.out.println(size_amount);
					
					for (int i = 0; i < size_amount; i++) {
						for (int j = 0; j < size_amount; j++) {
							
							
							gameboard[i][j].setGraphic(new ImageView(new Image(new FileInputStream(gameboard[i][j].getURL()),
									size_graphic, size_graphic, false, false)));
							gameboard[i][j].setPadding(new Insets(0, 0, 0, 0));
							if(gameboard[i][j].getURL().equals("Assets/Bomb_tile.jpg") == true)
							{
								Bomb temp = new Bomb();
								temp.setURL(gameboard[i][j].getURL());
								System.out.print(temp.getURL());
								temp.setLocation(gameboard[i][j].getLocation()[0], gameboard[i][j].getLocation()[1]);
								temp.setGraphic(new ImageView(new Image(new FileInputStream(gameboard[i][j].getURL()),
										size_graphic, size_graphic, false, false)));
								temp.setPadding(new Insets(0, 0, 0, 0));
								gameboard[i][j] = temp;
								
							}
							
							 if(gameboard[i][j].getURL().equals("Assets/H_laser_tile.jpg") == true)
							{
								
								Horizontal_Beam  temp = new Horizontal_Beam();
								temp.setURL(gameboard[i][j].getURL());
								temp.setLocation(gameboard[i][j].getLocation()[0], gameboard[i][j].getLocation()[1]);
								temp.setGraphic(new ImageView(new Image(new FileInputStream(gameboard[i][j].getURL()),
										size_graphic, size_graphic, false, false)));
								temp.setPadding(new Insets(0, 0, 0, 0));
								gameboard[i][j] = temp;
								
							}
							 if(gameboard[i][j].getURL().equals("Assets/V_laser_tile.jpg")== true)
							{
								Vertical_Beam  temp = new Vertical_Beam();
								temp.setURL(gameboard[i][j].getURL());
								System.out.print(temp.getURL());
								temp.setLocation(gameboard[i][j].getLocation()[0], gameboard[i][j].getLocation()[1]);
								temp.setGraphic(new ImageView(new Image(new FileInputStream(gameboard[i][j].getURL()),
										size_graphic, size_graphic, false, false)));
								temp.setPadding(new Insets(0, 0, 0, 0));
								gameboard[i][j] = temp;
							}
							
						}
					
					}
					
					u = (User)oit.readObject();
					u.setGraphic(new ImageView(new Image(new FileInputStream(u.getURL()),
							size_graphic, size_graphic, false, false)));
					u.setPadding(new Insets(0, 0, 0, 0));
					gameboard[u.getLocation()[0]][u.getLocation()[1]] = u;
					u.setTrail(new ImageView(new Image(new FileInputStream(u.getTrailString()),
							size_graphic, size_graphic, false, false)));
					
					ai1 = (AI)oit.readObject();
					ai1.setGraphic(new ImageView(new Image(new FileInputStream(ai1.getURL()),
							size_graphic, size_graphic, false, false)));
					ai1.setPadding(new Insets(0, 0, 0, 0));
					gameboard[ai1.getLocation()[0]][ai1.getLocation()[1]] = ai1;
					ai1.setTrail(new ImageView(new Image(new FileInputStream(ai1.getTrailString()),
							size_graphic, size_graphic, false, false)));
					
					ai2 = (AI)oit.readObject();
					ai2.setGraphic(new ImageView(new Image(new FileInputStream(ai2.getURL()),
							size_graphic, size_graphic, false, false)));
					ai2.setPadding(new Insets(0, 0, 0, 0));
					gameboard[ai2.getLocation()[0]][ai2.getLocation()[1]] = ai2;
					ai2.setTrail(new ImageView(new Image(new FileInputStream(ai2.getTrailString()),
							size_graphic, size_graphic, false, false)));
					
					ai3 = (AI)oit.readObject();
					ai3.setGraphic(new ImageView(new Image(new FileInputStream(ai3.getURL()),
							size_graphic, size_graphic, false, false)));
					ai3.setPadding(new Insets(0, 0, 0, 0));
					gameboard[ai3.getLocation()[0]][ai3.getLocation()[1]] = ai3;
					ai3.setTrail(new ImageView(new Image(new FileInputStream(ai3.getTrailString()),
							size_graphic, size_graphic, false, false)));
					
					
					
					for (int i = 0; i < size_amount; i++) {
						for (int j = 0; j < size_amount; j++) {
							gameboard[i][j].setCardinalConnections(gameboard);
						}}
					
					for (int i = 0; i < size_amount; i++) {
						for (int j = 0; j < size_amount; j++) {
							grid.add(gameboard[i][j], j, i);
						}}

					oit.close();
				} catch (Exception ex) {
					System.out.println("Oobis!");
					ex.printStackTrace();
				}
				check = true;
				}
				primaryStage.setScene(game_screen);
				RunningGame(primaryStage);
			});
			
			//button to go back to main menu
			Button btMenu = new Button();
			btMenu.setShape(new Circle());
			btMenu.setMaxSize(3, 3);
			btMenu.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					primaryStage.setScene(howTo);
					grid.getChildren().clear();
					button_press.play();
				}
			});

			btMenu.setGraphic(new ImageView(new Image(new FileInputStream("Assets/left_arrow.png"), 30, 30, false, false)));
			
			//text thart tells you how the game works
			Text howToPlay1 = new Text("Your player starts at the top left");
			howToPlay1.setStyle("-fx-text-fill:WHITE; -fx-font-size: 30; font-weight: bold");
			howToPlay1.setFill(Color.WHITE);
			
			Text howToPlay2 = new Text("Use WASD keys to move!");
			howToPlay2.setStyle("-fx-text-fill:WHITE; -fx-font-size: 25");
			howToPlay2.setFill(Color.WHITE);
			
			Text howToPlay3 = new Text("The player with the most tiles taken by the \ntime all gray squares are gone wins!");
			howToPlay3.setStyle("-fx-text-fill:WHITE; -fx-font-size: 23; -fx-text-alignment: center; font-weight: bold");
			howToPlay3.setFill(Color.WHITE);
			
			howToPlay1.setStrokeWidth(1);
			howToPlay1.setStroke(Color.WHITE);
			
			howToPlay2.setStrokeWidth(1);
			howToPlay2.setStroke(Color.WHITE);
			
			howToPlay3.setStrokeWidth(1);
			howToPlay3.setStroke(Color.WHITE);
			
			VBox howToColumn = new VBox(90);
			VBox howToLayout1 = new VBox(30);
			VBox howToLayout2 = new VBox(30);
			VBox howToLayout3 = new VBox(30);
			
			howToLayout1.getChildren().addAll(howToPlay1);
			howToLayout2.getChildren().addAll(howToPlay2);
			howToLayout3.getChildren().addAll(howToPlay3);
			
			howToLayout1.setAlignment(Pos.CENTER);
			howToLayout2.setAlignment(Pos.CENTER);
			howToLayout3.setAlignment(Pos.CENTER);
			
			howToColumn.getChildren().addAll(btMenu, howToLayout1, howToLayout2, howToLayout3);
			btMenu.setOnAction(e -> primaryStage.setScene(menu));
			
			BackgroundImage howTo_BG = new BackgroundImage(new Image(new FileInputStream("Assets/slime_BG.jpg"), 500, 500, false, true),
					BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
					BackgroundSize.DEFAULT);
			howToColumn.setBackground(new Background(howTo_BG));
			howToColumn.setAlignment(Pos.CENTER);
			
			howTo = new Scene(howToColumn, 500, 500);
			
			// button to start actual game
			Button play = new Button();
			play.setShape(new Circle());
			play.setMaxSize(3, 3);
			play.setGraphic(
					new ImageView(new Image(new FileInputStream("Assets/right_arrow.png"), 50, 50, false, false)));
			ImageView gameTitle = new ImageView(
					new Image(new FileInputStream("Assets/Title.png"), 250, 150, false, false));
			VBox menu_layout = new VBox(30);
			HBox titleOptions = new HBox(40);
			titleOptions.getChildren().addAll(rules, play, resume);
			titleOptions.setAlignment(Pos.CENTER);
			menu_layout.getChildren().addAll(gameTitle, titleOptions);
			rules.setOnAction(e -> {
				primaryStage.setScene(howTo);
			});
			
			menu_layout.setAlignment(Pos.CENTER);
			BackgroundImage menu_bg = new BackgroundImage(new Image(new FileInputStream("Assets/slime_BG.jpg"), 500, 500, false, true),
					BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
					BackgroundSize.DEFAULT);
			menu_layout.setBackground(new Background(menu_bg));
			menu = new Scene(menu_layout, 500, 250);
			play.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					button_press = null;
					button_press = new MediaPlayer(new Media(new File("Assets/button_press.mp3").toURI().toString()));
					button_press.setVolume(0.3);
					button_press.play();
					primaryStage.setScene(game_size);
					button_press.play();
				}
				
			});

			//error message if you dont put specified grid size paramter
			Label size_error_message = new Label();
			size_error_message.setStyle("-fx-text-fill:BLACK; -fx-font-size: 20;");
			Button enter_size = new Button();
			enter_size.setShape(new Circle());
			enter_size.setMaxSize(3, 3);
			enter_size.setGraphic(
					new ImageView(new Image(new FileInputStream("Assets/right_arrow.png"), 50, 50, false, false)));
			enter_size.setDisable(true);
			Button back_to_menu = new Button();
			back_to_menu.setShape(new Circle());
			back_to_menu.setMaxSize(3, 3);
			back_to_menu.setGraphic(
					new ImageView(new Image(new FileInputStream("Assets/left_arrow.png"), 50, 50, false, false)));

			//choose your character
			Button player_pink = new Button();
			player_pink.setPadding(Insets.EMPTY);
			player_pink.setGraphic(
					new ImageView(new Image(new FileInputStream("Assets/Pink_Slime_Icon.png"), 50, 50, false, false)));

			player_pink.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					button_press.play();
					enter_size.setDisable(false);
					selected_icon = 1;
				}
			});
			Button player_green = new Button();
			player_green.setPadding(Insets.EMPTY);
			player_green.setGraphic(
					new ImageView(new Image(new FileInputStream("Assets/Green_Slime_Icon.png"), 50, 50, false, false)));

			player_green.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					button_press.play();
					enter_size.setDisable(false);
					selected_icon = 2;
				}
			});
			Button player_purple = new Button();
			player_purple.setPadding(Insets.EMPTY);
			player_purple.setGraphic(new ImageView(
					new Image(new FileInputStream("Assets/Purple_Slime_Icon.png"), 50, 50, false, false)));

			player_purple.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					button_press.play();
					enter_size.setDisable(false);
					selected_icon = 3;

				}
			});
			Button player_blue = new Button();
			player_blue.setPadding(Insets.EMPTY);
			player_blue.setGraphic(
					new ImageView(new Image(new FileInputStream("Assets/Blue_Slime_Icon.png"), 50, 50, false, false)));

			player_blue.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					button_press.play();
					enter_size.setDisable(false);
					selected_icon = 4;
				}
			});
			
			//row of characters to choose from
			HBox player_select_group = new HBox(10);
			player_select_group.setAlignment(Pos.CENTER);
			player_select_group.getChildren().addAll(player_pink, player_green, player_purple, player_blue);

			//place you are entering the size of your board in
			TextField board_size = new TextField();
			board_size.setMaxWidth(250);
			board_size.setPromptText("Please enter a whole number between 10-30");
			board_size.setFocusTraversable(false);
			grid.setAlignment(Pos.CENTER);
			back_to_menu.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) { 
					button_press = null;
					button_press = new MediaPlayer(new Media(new File("Assets/button_press.mp3").toURI().toString()));
					button_press.setVolume(0.3);
					button_press.play();
					primaryStage.setScene(menu);
				}	
				});
			enter_size.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					button_press = null;
					button_press = new MediaPlayer(new Media(new File("Assets/button_press.mp3").toURI().toString()));
					button_press.setVolume(0.3);
					button_press.play();
					try {
						size_amount = Integer.parseInt(board_size.getText());
					} catch (NumberFormatException e) {
						board_size.clear();
					}
					if (size_amount > 30 || size_amount < 10) {
						size_error_message.setText("Please enter a number within range.");
						board_size.clear();
					} else {
						gameboard = new GridSquare[size_amount][size_amount];
						for (int i = 0; i < size_amount; i++) {
							for (int j = 0; j < size_amount; j++) {
								gameboard[i][j] = new GridSquare();
								gameboard[i][j].setPadding(new Insets(0, 0, 0, 0));
								gameboard[i][j].setLocation(i, j);
								//System.out.print(gameboard[i][j].getLocation()[0] + ","
										//+ gameboard[i][j].getLocation()[1] + " ");

								if (size_amount <= 15)
									size_graphic = 50;

								else if (size_amount <= 25)
									size_graphic = 30;

								else if (size_amount <= 30)
									size_graphic = 22;

								else if (size_amount <= 40)
									size_graphic = 18;

								else if (size_amount <= 45)
									size_graphic = 15;

								try {
									gameboard[i][j].setURL("Assets/Gray_square_tile .PNG");
									gameboard[i][j].setGraphic(
											new ImageView(new Image(new FileInputStream("Assets/Gray_square_tile .PNG"),
													size_graphic, size_graphic, false, false)));
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								gameboard[i][j].setURL("Assets/Gray_square_tile .PNG");

							}
							//System.out.print("\n");
						}
						for (int i = 0; i < size_amount; i++) {
							for (int j = 0; j < size_amount; j++) {

								gameboard[i][j].setCardinalConnections(gameboard);
								grid.add(gameboard[i][j], j, i);
							}
						}
						board_size.clear();
						size_error_message.setText("");
						enter_size.setDisable(false);
						primaryStage.setScene(game_screen);
						if (selected_icon == 1) {
							set_player = "Assets/Pink_Slime_Icon.png";
							set_trail = "Assets/Pink_Slime_Trail.png";
							try {
								u.setGraphic(new ImageView(new Image(new FileInputStream("Assets/Pink_Slime_Icon.png"),
										size_graphic, size_graphic, false, false)));
								u.setPadding(new Insets(0, 0, 0, 0));
								ai1.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Green_Slime_Icon.png"),
												size_graphic, size_graphic, false, false)));
								ai1.setPadding(new Insets(0, 0, 0, 0));
								ai2.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Purple_Slime_Icon.png"),
												size_graphic, size_graphic, false, false)));
								ai2.setPadding(new Insets(0, 0, 0, 0));
								ai3.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Blue_Slime_Icon.png"),
												size_graphic, size_graphic, false, false)));
								ai3.setPadding(new Insets(0, 0, 0, 0));

								u.setLocation(0, 0);
								u.setCardinalConnections(gameboard);
								// copy paste these next line for the rest of the players and AI objects
								u.setURL("Assets/Pink_Slime_Icon.png");
								u.setTrail(new ImageView(new Image(new FileInputStream("Assets/Pink_Slime_Trail.png"),
										size_graphic, size_graphic, false, false)));
								u.setTrailString("Assets/Pink_Slime_Trail.png"); 
								gameboard[0][0] = u;

								ai1.setLocation(0, size_amount - 1);
								ai1.setCardinalConnections(gameboard);
								ai1.setURL("Assets/Green_Slime_Icon.png");
								ai1.setTrail(new ImageView(new Image(new FileInputStream("Assets/Green_SlimeTrail.png"),
										size_graphic, size_graphic, false, false)));
								ai1.setTrailString("Assets/Green_SlimeTrail.png");
								gameboard[0][size_amount - 1] = ai1;

								ai2.setLocation(size_amount - 1, 0);
								ai2.setCardinalConnections(gameboard);
								ai2.setURL("Assets/Purple_Slime_Icon.png");
								ai2.setTrail(
										new ImageView(new Image(new FileInputStream("Assets/Purple_Slime_Trail.png"),
												size_graphic, size_graphic, false, false)));
								ai2.setTrailString("Assets/Purple_Slime_Trail.png");
								gameboard[size_amount - 1][0] = ai2;

								ai3.setLocation(size_amount - 1, size_amount - 1);
								ai3.setCardinalConnections(gameboard);
								ai3.setURL("Assets/Blue_Slime_Icon.png");
								ai3.setTrail(new ImageView(new Image(new FileInputStream("Assets/Blue_Slime_Trail.jpg"),
										size_graphic, size_graphic, false, false)));
								ai3.setTrailString("Assets/Blue_Slime_Trail.jpg");
								gameboard[size_amount - 1][size_amount - 1] = ai3;

							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							grid.getChildren().clear();
							for (int i = 0; i < size_amount; i++) {
								for (int j = 0; j < size_amount; j++) {

									grid.add(gameboard[i][j], j, i);
								}
							}

						} else if (selected_icon == 2) {
							set_player = "Assets/Green_Slime_Icon.png";
							set_trail = "Assets/Green_SlimeTrail.png";
							try {
								u.setGraphic(new ImageView(new Image(new FileInputStream("Assets/Green_Slime_Icon.png"),
										size_graphic, size_graphic, false, false)));
								u.setPadding(new Insets(0, 0, 0, 0));
								ai1.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Pink_Slime_Icon.png"),
												size_graphic, size_graphic, false, false)));
								ai1.setPadding(new Insets(0, 0, 0, 0));
								ai2.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Purple_Slime_Icon.png"),
												size_graphic, size_graphic, false, false)));
								ai2.setPadding(new Insets(0, 0, 0, 0));
								ai3.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Blue_Slime_Icon.png"),
												size_graphic, size_graphic, false, false)));
								ai3.setPadding(new Insets(0, 0, 0, 0));

								u.setLocation(0, 0);
								u.setCardinalConnections(gameboard);
								u.setURL("Assets/Green_Slime_Icon.png");
								u.setTrail(new ImageView(new Image(new FileInputStream("Assets/Green_SlimeTrail.png"),
										size_graphic, size_graphic, false, false)));
								u.setTrailString("Assets/Green_SlimeTrail.png");
								gameboard[0][0] = u;

								ai1.setLocation(0, size_amount - 1);
								ai1.setCardinalConnections(gameboard);
								ai1.setURL("Assets/Pink_Slime_Icon.png");
								ai1.setTrail(new ImageView(new Image(new FileInputStream("Assets/Pink_Slime_Trail.png"),
										size_graphic, size_graphic, false, false)));
								ai1.setTrailString("Assets/Pink_Slime_Trail.png");
								gameboard[0][size_amount - 1] = ai1;

								ai2.setLocation(size_amount - 1, 0);
								ai2.setCardinalConnections(gameboard);
								ai2.setURL("Assets/Purple_Slime_Icon.png");
								ai2.setTrail(
										new ImageView(new Image(new FileInputStream("Assets/Purple_Slime_Trail.png"),
												size_graphic, size_graphic, false, false)));
								ai2.setTrailString("Assets/Purple_Slime_Trail.png");
								gameboard[size_amount - 1][0] = ai2;

								ai3.setLocation(size_amount - 1, size_amount - 1);
								ai3.setCardinalConnections(gameboard);
								ai3.setURL("Assets/Blue_Slime_Icon.png");
								ai3.setTrail(new ImageView(new Image(new FileInputStream("Assets/Blue_Slime_Trail.jpg"),
										size_graphic, size_graphic, false, false)));
								ai3.setTrailString("Assets/Blue_Slime_Trail.jpg");
								gameboard[size_amount - 1][size_amount - 1] = ai3;

							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							grid.getChildren().clear();
							for (int i = 0; i < size_amount; i++) {
								for (int j = 0; j < size_amount; j++) {

									grid.add(gameboard[i][j], j, i);
								}
							}
						} else if (selected_icon == 3) {
							set_player = "Assets/Purple_Slime_Icon.png";
							set_trail = "Assets/Purple_Slime_Trail.png";
							try {
								u.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Purple_Slime_Icon.png"),
												size_graphic, size_graphic, false, false)));
								u.setPadding(new Insets(0, 0, 0, 0));
								ai1.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Green_Slime_Icon.png"),
												size_graphic, size_graphic, false, false)));
								ai1.setPadding(new Insets(0, 0, 0, 0));
								ai2.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Pink_Slime_Icon.png"),
												size_graphic, size_graphic, false, false)));
								ai2.setPadding(new Insets(0, 0, 0, 0));
								ai3.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Blue_Slime_Icon.png"),
												size_graphic, size_graphic, false, false)));
								ai3.setPadding(new Insets(0, 0, 0, 0));

								u.setLocation(0, 0);
								u.setCardinalConnections(gameboard);
								u.setURL("Assets/Purple_Slime_Icon.png");
								u.setTrail(new ImageView(new Image(new FileInputStream("Assets/Purple_Slime_Trail.png"),
										size_graphic, size_graphic, false, false)));
								u.setTrailString("Assets/Purple_Slime_Trail.png");
								gameboard[0][0] = u;

								ai1.setLocation(0, size_amount - 1);
								ai1.setCardinalConnections(gameboard);
								ai1.setURL("Assets/Green_Slime_Icon.png");
								ai1.setTrail(new ImageView(new Image(new FileInputStream("Assets/Green_SlimeTrail.png"),
										size_graphic, size_graphic, false, false)));
								ai1.setTrailString("Assets/Green_SlimeTrail.png");
								gameboard[0][size_amount - 1] = ai1;

								ai2.setLocation(size_amount - 1, 0);
								ai2.setCardinalConnections(gameboard);
								ai2.setURL("Assets/Pink_Slime_Icon.png");
								ai2.setTrail(new ImageView(new Image(new FileInputStream("Assets/Pink_Slime_Trail.png"),
										size_graphic, size_graphic, false, false)));
								ai2.setTrailString("Assets/Pink_Slime_Trail.png");
								gameboard[size_amount - 1][0] = ai2;

								ai3.setLocation(size_amount - 1, size_amount - 1);
								ai3.setCardinalConnections(gameboard);
								ai3.setURL("Assets/Blue_Slime_Icon.png");
								ai3.setTrail(new ImageView(new Image(new FileInputStream("Assets/Blue_Slime_Trail.jpg"),
										size_graphic, size_graphic, false, false)));
								ai3.setTrailString("Assets/Blue_Slime_Trail.jpg");
								gameboard[size_amount - 1][size_amount - 1] = ai3;
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							grid.getChildren().clear();
							for (int i = 0; i < size_amount; i++) {
								for (int j = 0; j < size_amount; j++) {

									grid.add(gameboard[i][j], j, i);
								}
							}
						} else if (selected_icon == 4) {
							set_player = "Assets/Blue_Slime_Icon.png";
							set_trail = "Assets/Blue_Slime_Trail.jpg";
							try {
								u.setGraphic(new ImageView(new Image(new FileInputStream("Assets/Blue_Slime_Icon.png"),
										size_graphic, size_graphic, false, false)));
								u.setPadding(new Insets(0, 0, 0, 0));
								ai1.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Green_Slime_Icon.png"),
												size_graphic, size_graphic, false, false)));
								ai1.setPadding(new Insets(0, 0, 0, 0));
								ai2.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Purple_Slime_Icon.png"),
												size_graphic, size_graphic, false, false)));
								ai2.setPadding(new Insets(0, 0, 0, 0));
								ai3.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Pink_Slime_Icon.png"),
												size_graphic, size_graphic, false, false)));
								ai3.setPadding(new Insets(0, 0, 0, 0));

								u.setLocation(0, 0);
								u.setCardinalConnections(gameboard);
								u.setURL("Assets/Blue_Slime_Icon.png");
								u.setTrail(new ImageView(new Image(new FileInputStream("Assets/Blue_Slime_Trail.jpg"),
										size_graphic, size_graphic, false, false)));
								u.setTrailString("Assets/Blue_Slime_Trail.jpg");
								gameboard[0][0] = u;

								ai1.setLocation(0, size_amount - 1);
								ai1.setCardinalConnections(gameboard);
								ai1.setURL("Assets/Green_Slime_Icon.png");
								ai1.setTrail(new ImageView(new Image(new FileInputStream("Assets/Green_SlimeTrail.png"),
										size_graphic, size_graphic, false, false)));
								ai1.setTrailString("Assets/Green_SlimeTrail.png");
								gameboard[0][size_amount - 1] = ai1;

								ai2.setLocation(size_amount - 1, 0);
								ai2.setCardinalConnections(gameboard);
								ai2.setURL("Assets/Purple_Slime_Icon.png");
								ai2.setTrail(new ImageView(new Image(new FileInputStream("Assets/Purple_Slime_Trail.png"),
												size_graphic, size_graphic, false, false)));
								ai2.setTrailString("Assets/Purple_Slime_Trail.png");
								gameboard[size_amount - 1][0] = ai2;

								ai3.setLocation(size_amount - 1, size_amount - 1);
								ai3.setCardinalConnections(gameboard);
								ai3.setURL("Assets/Pink_Slime_Icon.png");
								ai3.setTrail(new ImageView(new Image(new FileInputStream("Assets/Pink_Slime_Trail.png"),
										size_graphic, size_graphic, false, false)));
								ai3.setTrailString("Assets/Pink_Slime_Trail.png");
								gameboard[size_amount - 1][size_amount - 1] = ai3;

							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						grid.getChildren().clear();
						for (int i = 0; i < size_amount; i++) {
							for (int j = 0; j < size_amount; j++) {

								grid.add(gameboard[i][j], j, i);
							}
						}

					}

					RunningGame(primaryStage);
					button_press.play();
				}
			});
			HBox gamesize_Button_layout = new HBox(5);
			gamesize_Button_layout.getChildren().addAll(back_to_menu, enter_size);
			gamesize_Button_layout.setAlignment(Pos.CENTER);
			VBox gamesize_layout = new VBox(30);
			gamesize_layout.getChildren().addAll(size_error_message, board_size, player_select_group,
					gamesize_Button_layout);
			gamesize_layout.setAlignment(Pos.CENTER);
			BackgroundImage gamesize_BG = new BackgroundImage(new Image(new FileInputStream("Assets/slime_BG.jpg"), 500, 500, false, true),
					BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
					BackgroundSize.DEFAULT);
			gamesize_layout.setBackground(new Background(gamesize_BG));
			game_size = new Scene(gamesize_layout, 400, 250);
			Button exit = new Button();
			exit.setShape(new Circle());
			exit.setMaxSize(3, 3);
			exit.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					button_press = null;
					button_press = new MediaPlayer(new Media(new File("Assets/button_press.mp3").toURI().toString()));
					button_press.setVolume(0.3);
					button_press.play();
					primaryStage.setScene(game_size);
					grid.getChildren().clear();
					button_press.play();
				}
			});

			exit.setGraphic(new ImageView(new Image(new FileInputStream("Assets/left_arrow.png"), 30, 30, false, false)));
			VBox game_layout = new VBox(10);
			BackgroundImage gamescreen_bg = new BackgroundImage(new Image(new FileInputStream("Assets/slime_BG.jpg"), 500, 500, false, true),
					BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
					BackgroundSize.DEFAULT);
			game_layout.setBackground(new Background(gamescreen_bg));
			game_layout.getChildren().addAll(exit, grid);
			game_layout.setAlignment(Pos.CENTER);
			game_screen = new Scene(game_layout);
			menu.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(menu);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	Integer On_Screen_Items =0;
	void RunningGame(Stage primaryStage) {
		@SuppressWarnings("removal")
//		Boolean graytiles_exist = new Boolean(true);
		int gray_tiles = (size_amount * size_amount) - 4;
		
		
			String[] options = {"north", "south", "west", "east"};
			Random random_opt = new Random();
				game_screen.setOnKeyPressed(e -> {
					if (e.getCode() == KeyCode.A) {
						
						//System.out.println();
						//System.out.println();
						
						gameboard =u.Movement(gameboard, "west");
						
						int CPUact1 = random_opt.nextInt(4);
						gameboard =ai1.Movement(gameboard, options[CPUact1]);
						int CPUact2 = random_opt.nextInt(4);
						gameboard =ai2.Movement(gameboard, options[CPUact2]);
						int CPUact3 = random_opt.nextInt(4);
						gameboard =ai3.Movement(gameboard, options[CPUact3]);
						
						
						Item_generator(gameboard);
						
						On_Screen_Items=0;
						grid.getChildren().clear();
						for (int i = 0; i < size_amount; i++) {
							for (int j = 0; j < size_amount; j++) {
								grid.add(gameboard[i][j],j,i);
								if(gameboard[i][j].getURL() != null)
								{
								if(gameboard[i][j].getURL().equals("Assets/V_laser_tile.jpg") == true ||gameboard[i][j].getURL().equals("Assets/Bomb_tile.jpg") == true|| gameboard[i][j].getURL().equals( "Assets/H_laser_tile.jpg")==true)
								{
									On_Screen_Items ++;
								
								}
							}
							}
							//System.out.println();
						}
						
						boolean end = checkTiles();
						if(end == true) {
							endgame(primaryStage);
						}
						try {		
							ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("stw.ser"));
							output.writeInt(size_amount);
							output.writeInt(size_graphic);
							output.writeObject(gameboard);
							output.writeObject((User)u);
							output.writeObject((AI)ai1);
							output.writeObject((AI)ai2);
							output.writeObject((AI)ai3);
							output.close();
						} catch (Exception ex) {
							System.out.println("Error writing board to file.");
							ex.printStackTrace();
						}
						}
					
					
					else if (e.getCode() == KeyCode.D) {
						
						//System.out.println();
						//System.out.println();
						gameboard = u.Movement(gameboard, "east");
						
						System.out.println("User movement " + u.getLocation()[0] + ", " + u.getLocation()[1]);
						
						int CPUact1 = random_opt.nextInt(4);
						gameboard =ai1.Movement(gameboard, options[CPUact1]);
						int CPUact2 = random_opt.nextInt(4);
						gameboard =ai2.Movement(gameboard, options[CPUact2]);
						int CPUact3 = random_opt.nextInt(4);
						gameboard =ai3.Movement(gameboard, options[CPUact3]);
						
						Item_generator(gameboard);
						
						On_Screen_Items=0;
						grid.getChildren().clear();
						for (int i = 0; i < size_amount; i++) {
							for (int j = 0; j < size_amount; j++) {
								grid.add(gameboard[i][j],j,i);
								if(gameboard[i][j].getURL() != null)
								{
								if(gameboard[i][j].getURL().equals("Assets/V_laser_tile.jpg") == true ||gameboard[i][j].getURL().equals("Assets/Bomb_tile.jpg") == true|| gameboard[i][j].getURL().equals( "Assets/H_laser_tile.jpg")==true)
								{
									On_Screen_Items ++;
								
								}
							}
							}
							System.out.println();
						}
						boolean end = checkTiles();
						if(end == true) {
							endgame(primaryStage);
						}
						try {		
							ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("stw.ser"));
							output.writeInt(size_amount);
							output.writeInt(size_graphic);
							output.writeObject(gameboard);
							output.writeObject((User)u);
							output.writeObject((AI)ai1);
							output.writeObject((AI)ai2);
							output.writeObject((AI)ai3);
							output.close();
						} catch (Exception ex) {
							System.out.println("Error writing board to file.");
							ex.printStackTrace();
						}
					}
				
					
					else if (e.getCode() == KeyCode.S) {
						//System.out.println();
						//System.out.println();
						
						
						gameboard =u.Movement(gameboard, "south");
						
						int CPUact1 = random_opt.nextInt(4);
						gameboard =ai1.Movement(gameboard, options[CPUact1]);
						int CPUact2 = random_opt.nextInt(4);
						gameboard =ai2.Movement(gameboard, options[CPUact2]);
						int CPUact3 = random_opt.nextInt(4);
						gameboard =ai3.Movement(gameboard, options[CPUact3]);
			
						Item_generator(gameboard);
						
						On_Screen_Items=0;
						grid.getChildren().clear();
						for (int i = 0; i < size_amount; i++) {
							for (int j = 0; j < size_amount; j++) {
								grid.add(gameboard[i][j],j,i);
								if(gameboard[i][j].getURL() != null)
								{
								if(gameboard[i][j].getURL().equals("Assets/V_laser_tile.jpg") == true ||gameboard[i][j].getURL().equals("Assets/Bomb_tile.jpg") == true|| gameboard[i][j].getURL().equals( "Assets/H_laser_tile.jpg")==true)
								{
									On_Screen_Items ++;
								
								}
							}
							}
							//System.out.println();
						}
						boolean end = checkTiles();
						if(end == true) {
							endgame(primaryStage);
						}
						try {		
							ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("stw.ser"));
							output.writeInt(size_amount);
							output.writeInt(size_graphic);
							output.writeObject(gameboard);
							output.writeObject((User)u);
							output.writeObject((AI)ai1);
							output.writeObject((AI)ai2);
							output.writeObject((AI)ai3);
							output.close();
						} catch (Exception ex) {
							System.out.println("Error writing board to file.");
							ex.printStackTrace();
						}
					}
						
					else if (e.getCode() == KeyCode.W) {
						//System.out.println();
						//System.out.println();
						
						gameboard =u.Movement(gameboard, "north");
						
						int CPUact1 = random_opt.nextInt(4);
						gameboard =ai1.Movement(gameboard, options[CPUact1]);
						int CPUact2 = random_opt.nextInt(4);
						gameboard =ai2.Movement(gameboard, options[CPUact2]);
						int CPUact3 = random_opt.nextInt(4);
						gameboard =ai3.Movement(gameboard, options[CPUact3]);
						
                        Item_generator(gameboard);
						
						On_Screen_Items=0;
						grid.getChildren().clear();
						for (int i = 0; i < size_amount; i++) {
							for (int j = 0; j < size_amount; j++) {
								grid.add(gameboard[i][j],j,i);
								if(gameboard[i][j].getURL() != null)
								{
								if(gameboard[i][j].getURL().equals("Assets/V_laser_tile.jpg") == true ||gameboard[i][j].getURL().equals("Assets/Bomb_tile.jpg") == true|| gameboard[i][j].getURL().equals( "Assets/H_laser_tile.jpg")==true)
								{
									On_Screen_Items ++;
								
								}
							}
							}
							//System.out.println();
						}
						boolean end = checkTiles();
						if(end == true) {
							endgame(primaryStage);
						}
						try {		
							ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("stw.ser"));
							output.writeInt(size_amount);
							output.writeInt(size_graphic);
							output.writeObject(gameboard);
							output.writeObject((User)u);
							output.writeObject((AI)ai1);
							output.writeObject((AI)ai2);
							output.writeObject((AI)ai3);
							output.close();
						} catch (Exception ex) {
							System.out.println("Error writing board to file.");
							ex.printStackTrace();
						}
				}
				});
			
	
	}
	
	ArrayList<GridSquare> items_bucket;
	Random random_num_items = new Random();
	ArrayList<GridSquare> available_tiles = new ArrayList<GridSquare>();
	Random random_tile = new Random();
	void Item_generator(GridSquare[][] gameboard)
	{
		if(On_Screen_Items == 0)
		{
			items_bucket = null;
			if(size_amount <= 15)
			{
				int random_item = random_num_items.nextInt(3);
				items_bucket = new ArrayList<GridSquare>();
				if( random_item == 1)
				{
					items_bucket.add(new Vertical_Beam("Assets/V_laser_tile.jpg", size_graphic));
					items_bucket.get(items_bucket.size() - 1).setPadding(new Insets(0, 0, 0, 0));
					items_bucket.get(items_bucket.size() - 1).setURL("Assets/V_laser_tile.jpg");
				}
				else if(random_item == 2 )
				{
					items_bucket.add(new Bomb("Assets/Bomb_tile.jpg",size_graphic));
					items_bucket.get(items_bucket.size() - 1).setPadding(new Insets(0, 0, 0, 0));
					items_bucket.get(items_bucket.size() - 1).setURL("Assets/Bomb_tile.jpg");
				}
				else 
				{
					items_bucket.add(new Horizontal_Beam("Assets/H_laser_tile.jpg",size_graphic));
					items_bucket.get(items_bucket.size() - 1).setPadding(new Insets(0, 0, 0, 0));
					items_bucket.get(items_bucket.size() - 1).setURL("Assets/H_laser_tile.jpg");
				}
				
			}
			else if(size_amount <= 20)
			{
				items_bucket = new ArrayList<GridSquare>();
				for(int i = 0; i < 2; i++) {
					int random_item = random_num_items.nextInt(3);
					
					if( random_item == 1)
					{
						items_bucket.add(new Vertical_Beam("Assets/V_laser_tile.jpg", size_graphic));
						items_bucket.get(items_bucket.size() - 1).setPadding(new Insets(0, 0, 0, 0));
						items_bucket.get(items_bucket.size() - 1).setURL("Assets/V_laser_tile.jpg");
					}
					else if(random_item == 2 )
					{
						items_bucket.add(new Bomb("Assets/Bomb_tile.jpg",size_graphic));
						items_bucket.get(items_bucket.size() - 1).setPadding(new Insets(0, 0, 0, 0));
						items_bucket.get(items_bucket.size() - 1).setURL("Assets/Bomb_tile.jpg");
					}
					else
					{
						items_bucket.add(new Horizontal_Beam("Assets/H_laser_tile.jpg",size_graphic));
						items_bucket.get(items_bucket.size() - 1).setPadding(new Insets(0, 0, 0, 0));
						items_bucket.get(items_bucket.size() - 1).setURL("Assets/H_laser_tile.jpg");
					}
					
					
				}
				
			}
			else if(size_amount <= 25)
			{
				items_bucket = new ArrayList<GridSquare>();
				for(int i = 0; i < 3; i++) {
					int random_item = random_num_items.nextInt(3);
					
					if( random_item == 1)
					{
						items_bucket.add(new Vertical_Beam("Assets/V_laser_tile.jpg", size_graphic));
						items_bucket.get(items_bucket.size() - 1).setPadding(new Insets(0, 0, 0, 0));
						items_bucket.get(items_bucket.size() - 1).setURL("Assets/V_laser_tile.jpg");
					}
					else if(random_item == 2 )
					{
						items_bucket.add(new Bomb("Assets/Bomb_tile.jpg",size_graphic));
						items_bucket.get(items_bucket.size() - 1).setPadding(new Insets(0, 0, 0, 0));
						items_bucket.get(items_bucket.size() - 1).setURL("Assets/Bomb_tile.jpg");
					}
					else
					{
						items_bucket.add(new Horizontal_Beam("Assets/H_laser_tile.jpg",size_graphic));
						items_bucket.get(items_bucket.size() - 1).setPadding(new Insets(0, 0, 0, 0));
						items_bucket.get(items_bucket.size() - 1).setURL("Assets/H_laser_tile.jpg");
					}
					
					
				}
			}
			else if(size_amount <= 30)
			{
				items_bucket = new ArrayList<GridSquare>();
				for(int i = 0; i < 4; i++) {
					int random_item = random_num_items.nextInt(3);
					
					if( random_item == 1)
					{
						items_bucket.add(new Vertical_Beam("Assets/V_laser_tile.jpg", size_graphic));
						items_bucket.get(items_bucket.size() - 1).setPadding(new Insets(0, 0, 0, 0));
						items_bucket.get(items_bucket.size() - 1).setURL("Assets/V_laser_tile.jpg");
					}
					else if(random_item == 2 )
					{
						items_bucket.add(new Bomb("Assets/Bomb_tile.jpg",size_graphic));
						items_bucket.get(items_bucket.size() - 1).setPadding(new Insets(0, 0, 0, 0));
						items_bucket.get(items_bucket.size() - 1).setURL("Assets/Bomb_tile.jpg");
					}
					else 
					{
						items_bucket.add(new Horizontal_Beam("Assets/H_laser_tile.jpg",size_graphic));
						items_bucket.get(items_bucket.size() - 1).setPadding(new Insets(0, 0, 0, 0));
						items_bucket.get(items_bucket.size() - 1).setURL("Assets/H_laser_tile.jpg");
					}
					
					
				}
			}
			else if(size_amount <= 35)
			{
				items_bucket = new ArrayList<GridSquare>();
				for(int i = 0; i < 5; i++) {
					int random_item = random_num_items.nextInt(3);
					
					if( random_item == 1)
					{
						items_bucket.add(new Vertical_Beam("Assets/V_laser_tile.jpg", size_graphic));
						items_bucket.get(items_bucket.size() - 1).setPadding(new Insets(0, 0, 0, 0));
						items_bucket.get(items_bucket.size() - 1).setURL("Assets/V_laser_tile.jpg");
					}
					else if(random_item == 2 )
					{
						items_bucket.add(new Bomb("Assets/Bomb_tile.jpg",size_graphic));
						items_bucket.get(items_bucket.size() - 1).setPadding(new Insets(0, 0, 0, 0));
						items_bucket.get(items_bucket.size() - 1).setURL("Assets/Bomb_tile.jpg");
					}
					else 
					{
						items_bucket.add(new Horizontal_Beam("Assets/H_laser_tile.jpg",size_graphic));
						items_bucket.get(items_bucket.size() - 1).setPadding(new Insets(0, 0, 0, 0));
						items_bucket.get(items_bucket.size() - 1).setURL("Assets/H_laser_tile.jpg");
					}
					
					
				}
			}
			else if(size_amount <= 40)
			{
				items_bucket = new ArrayList<GridSquare>();
				for(int i = 0; i < 6; i++) {
					int random_item = random_num_items.nextInt(3);
					
					if( random_item == 1)
					{
						items_bucket.add(new Vertical_Beam("Assets/V_laser_tile.jpg", size_graphic));
						items_bucket.get(items_bucket.size() - 1).setPadding(new Insets(0, 0, 0, 0));
						items_bucket.get(items_bucket.size() - 1).setURL("Assets/V_laser_tile.jpg");
						
					}
					else if(random_item == 2 )
					{
						items_bucket.add(new Bomb("Assets/Bomb_tile.jpg",size_graphic));
						items_bucket.get(items_bucket.size() - 1).setPadding(new Insets(0, 0, 0, 0));
						items_bucket.get(items_bucket.size() - 1).setURL("Assets/Bomb_tile.jpg");
					}
					else
					{
						items_bucket.add(new Horizontal_Beam("Assets/H_laser_tile.jpg",size_graphic));
						items_bucket.get(items_bucket.size() - 1).setPadding(new Insets(0, 0, 0, 0));
						items_bucket.get(items_bucket.size() - 1).setURL("Assets/H_laser_tile.jpg");
					}
					
					
				}
			}
			
			// it is spawning items on slime trails check to see if all URLs in objects are geting updated
			for (int i = 0; i < size_amount; i++) {
				for (int j = 0; j < size_amount; j++) {
					
					if(gameboard[i][j].getURL().equals("Assets/Gray_square_tile .PNG")==true)
					{
						available_tiles.add(gameboard[i][j]);
					}
					
					
				}
			    }
			if(available_tiles.size() > 0)
			{
			for(int k = 0; k < items_bucket.size(); k++)
			{
				if(available_tiles.size() > 0) {
				int rand_element = random_tile.nextInt(available_tiles.size());
				
				gameboard[available_tiles.get(rand_element).getLocation()[0]][available_tiles.get(rand_element).getLocation()[1]] = items_bucket.get(k);
				gameboard[available_tiles.get(rand_element).getLocation()[0]][available_tiles.get(rand_element).getLocation()[1]].setLocation(available_tiles.get(rand_element).getLocation()[0], available_tiles.get(rand_element).getLocation()[1]);
			    available_tiles.remove(rand_element);
				}
			
			}
			}
			for (int i = 0; i < size_amount; i++) {
				for (int j = 0; j < size_amount; j++) {
					gameboard[i][j].setCardinalConnections(gameboard);	
				}
			    }
			
		}
		available_tiles.clear();

	}





boolean checkTiles() {
	// check conditions to end game
	//System.out.println("We are in endgame");
	//System.out.println(size_amount);
	int gray_counter = 0;
	for(int i = 0; i < size_amount; i++) {
		for(int j = 0; j < size_amount; j++) {
			if(gameboard[i][j] != null)
			{
			if(gameboard[i][j].getURL().equals("Assets/Gray_square_tile .PNG") == true) { 
				gray_counter++;
			}
			else if(gameboard[i][j].getURL().equals("Assets/H_laser_tile.jpg") == true) { 
				gray_counter++;
			}
			else if(gameboard[i][j].getURL().equals("Assets/Bomb_tile.jpg") == true) { 
				gray_counter++;
			}
			else if(gameboard[i][j].getURL().equals("Assets/V_laser_tile.jpg") == true) { 
				gray_counter++;
			}
			}
		}		
	}
	System.out.println("The number of gray tiles remaining is " + gray_counter);	
	if(gray_counter == 0) {
		return true;
	}
	else {
		return false;
	}
	
}

void endgame(Stage primaryStage) {
	int pink_count = 0;
	int green_count = 0;
	int blue_count = 0;
	int purple_count = 0;
	System.out.println("Are we counting colors???");
	for(int i = 0; i < size_amount; i++) {
		for(int j = 0; j < size_amount; j++) {
			
			if(gameboard[i][j].getURL().equals("Assets/Pink_Slime_Trail.png")) {
				
				pink_count++;
			}
			if(gameboard[i][j].getURL().equals("Assets/Green_SlimeTrail.png")) {
				green_count++;
				
			}
			if(gameboard[i][j].getURL().equals("Assets/Blue_Slime_Trail.jpg")) {
				blue_count++;
			}
			if(gameboard[i][j].getURL().equals("Assets/Purple_Slime_Trail.png")) {
				purple_count++;
			}
			}
	}
	
	int[] points = {pink_count,green_count,blue_count,purple_count};
	String[] names = {"Pink","Green","Blue","Purple"};
	
	for(int i = 0; i < points.length; i++) {
		for(int j = 0; j < points.length; j++) {
			if(points[j] < points[i]) {
				int temp = points[j];
				String Temp = names[j];
				points[j] = points[i];
				names[j] = names[i];
				points[i] = temp;
				names[i] = Temp;
			}
		}
	}
	System.out.println(points[0]+ " " + points[1] + " " + points[2] + " " + points[3]);
	System.out.println(names[0]+ " " + names[1] + " " + names[2] + " " + names[3]);
	String display_scores = "";
	display_scores += "The winner is: " + names[0] + "\n";
	display_scores += "1. " + names[0] + " " + points[0] + "\n";
	display_scores += "2. " + names[1] + " " + points[1] + "\n";
	display_scores += "3. " + names[2] + " " + points[2] + "\n";
	display_scores += "4. " + names[3] + " " + points[3] + "\n";
	
	
	try {
		Label message_label = new Label(display_scores);
		
		Button play = new Button();
		play.setShape(new Circle());
		play.setMaxSize(3, 3);
		play.setGraphic(
				new ImageView(new Image(new FileInputStream("Assets/left_arrow.png"), 50, 50, false, false)));
		play.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				primaryStage.setScene(menu);
			}
		
		});
		Button exit = new Button();
		exit.setShape(new Circle());
		exit.setMaxSize(3, 3);
		exit.setGraphic(
				new ImageView(new Image(new FileInputStream("Assets/exit.png"), 50, 50, false, false)));
		exit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("Thanks for playing!");
				System.exit(0);
			}
		
		});
		
		
		try {
			VBox inner_vbox = new VBox(20);
			HBox buttons = new HBox(30);
			buttons.getChildren().addAll(play,exit);
			buttons.setAlignment(Pos.CENTER);
			inner_vbox.getChildren().addAll(message_label,buttons);
		BackgroundImage image = new BackgroundImage(new Image(new FileInputStream("Assets/3d_white_background.png"), 300, 300, false, true),
		        BackgroundRepeat.NO_REPEAT,
		        BackgroundRepeat.NO_REPEAT,
		        BackgroundPosition.CENTER,BackgroundSize.DEFAULT );
		inner_vbox.setAlignment(Pos.CENTER);
		inner_vbox.setPrefSize(300, 300);
		inner_vbox.setBackground(new Background(image));
		VBox vbox = new VBox(inner_vbox);
		BackgroundImage gamescreen_bg = new BackgroundImage(new Image(new FileInputStream("Assets/slime_BG.jpg"), 500, 500, false, true),
				BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		vbox.setBackground(new Background(gamescreen_bg));
		vbox.setAlignment(Pos.CENTER);
		
		
		Scene scene = new Scene(vbox, 700, 500);
		primaryStage.setScene(scene);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		primaryStage.show();
	}
	catch(Exception e) {
		System.out.println(e);
	}
	
}
}