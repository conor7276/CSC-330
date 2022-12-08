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
import java.io.IOException;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;

import java.util.*;
import java.util.HashMap;

public class Main extends Application {
	
	@SuppressWarnings("removal")
	Integer size_amount = new Integer(0);
	
	GridSquare gameboard[][] = new GridSquare[size_amount][size_amount];
	Scene Menu, GameScreen, gamesize, EndScreen;
	@SuppressWarnings("removal")
	Integer Size_Graphic = new Integer(0);
	User u = new User();
	AI ai1 = new AI(), ai2 = new AI(), ai3 = new AI();
	@SuppressWarnings("removal")
	int selected_icon;
	String set_player;
	String set_trail;
	GridPane grid = new GridPane();

	public static void main(String[] args) throws FileNotFoundException {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		MediaPlayer game_audio;
		MediaPlayer button_press;
		button_press = new MediaPlayer(new Media(new File("Assets/button_press.mp3").toURI().toString()));
		button_press.setVolume(0.3);
		game_audio = new MediaPlayer(new Media(new File("Assets/In_game_theme_music.mp3").toURI().toString()));
		game_audio.setVolume(0.3);
		game_audio.setAutoPlay(true);
		game_audio.setCycleCount(MediaPlayer.INDEFINITE);

		try {

			primaryStage.setTitle("Slippery Turf Wars");
			
			Button play = new Button();
			play.setShape(new Circle());
			play.setMaxSize(3, 3);
			play.setGraphic(
					new ImageView(new Image(new FileInputStream("Assets/right_arrow.png"), 50, 50, false, false)));
			ImageView GameTitle = new ImageView(
					new Image(new FileInputStream("Assets/Title.png"), 250, 150, false, false));
			VBox menuLayOut = new VBox(30);
			menuLayOut.getChildren().addAll(GameTitle, play);
			menuLayOut.setAlignment(Pos.CENTER);
			BackgroundImage menu_BG = new BackgroundImage(new Image(new FileInputStream("Assets/slime_BG.jpg"), 500, 500, false, true),
					BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
					BackgroundSize.DEFAULT);
			menuLayOut.setBackground(new Background(menu_BG));
			Menu = new Scene(menuLayOut, 500, 250);
			play.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					primaryStage.setScene(gamesize);
					button_press.play();
				}
			});

			Label size_error_message = new Label();
			size_error_message.setStyle("-fx-text-fill:BLACK; -fx-font-size: 20;");
			Button entersize = new Button();
			entersize.setShape(new Circle());
			entersize.setMaxSize(3, 3);
			entersize.setGraphic(
					new ImageView(new Image(new FileInputStream("Assets/right_arrow.png"), 50, 50, false, false)));
			entersize.setDisable(true);
			Button back_to_menu = new Button();
			back_to_menu.setShape(new Circle());
			back_to_menu.setMaxSize(3, 3);
			back_to_menu.setGraphic(
					new ImageView(new Image(new FileInputStream("Assets/left_arrow.png"), 50, 50, false, false)));

			Button player_pink = new Button();
			player_pink.setPadding(Insets.EMPTY);
			player_pink.setGraphic(
					new ImageView(new Image(new FileInputStream("Assets/Pink_Slime_Icon.png"), 50, 50, false, false)));

			player_pink.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					button_press.play();
					entersize.setDisable(false);
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
					entersize.setDisable(false);
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
					entersize.setDisable(false);
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
					entersize.setDisable(false);
					selected_icon = 4;
				}
			});
			HBox player_select_group = new HBox(10);
			player_select_group.setAlignment(Pos.CENTER);
			player_select_group.getChildren().addAll(player_pink, player_green, player_purple, player_blue);

			TextField boardsize = new TextField();
			boardsize.setMaxWidth(250);
			boardsize.setPromptText("Please enter a whole number between 10-45");
			boardsize.setFocusTraversable(false);
			grid.setAlignment(Pos.CENTER);
			back_to_menu.setOnAction(e -> primaryStage.setScene(Menu));
			entersize.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {

					try {
						size_amount = Integer.parseInt(boardsize.getText());
					} catch (NumberFormatException e) {
						boardsize.clear();
					}
					if (size_amount > 45 || size_amount < 10) {
						size_error_message.setText("Please enter a number within range.");
						boardsize.clear();
					} else {
						gameboard = new GridSquare[size_amount][size_amount];
						for (int i = 0; i < size_amount; i++) {
							for (int j = 0; j < size_amount; j++) {
								gameboard[i][j] = new GridSquare();
								gameboard[i][j].setPadding(new Insets(0, 0, 0, 0));
								gameboard[i][j].setLocation(i, j);
								System.out.print(gameboard[i][j].getLocation()[0] + ","
										+ gameboard[i][j].getLocation()[1] + " ");

								if (size_amount <= 15)
									Size_Graphic = 50;

								else if (size_amount <= 25)
									Size_Graphic = 30;

								else if (size_amount <= 30)
									Size_Graphic = 22;

								else if (size_amount <= 40)
									Size_Graphic = 18;

								else if (size_amount <= 45)
									Size_Graphic = 15;

								try {
									gameboard[i][j].setGraphic(
											new ImageView(new Image(new FileInputStream("Assets/Gray_square_tile .PNG"),
													Size_Graphic, Size_Graphic, false, false)));
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								gameboard[i][j].setURL("Assets/Gray_square_tile .PNG");

							}
							System.out.print("\n");
						}
						for (int i = 0; i < size_amount; i++) {
							for (int j = 0; j < size_amount; j++) {

								gameboard[i][j].setCardinalConnections(gameboard);
								grid.add(gameboard[i][j], j, i);
							}
						}
						boardsize.clear();
						size_error_message.setText("");
						entersize.setDisable(false);
						primaryStage.setScene(GameScreen);
						if (selected_icon == 1) {
							set_player = "Assets/Pink_Slime_Icon.png";
							set_trail = "Assets/Pink_Slime_Trail.png";
							try {
								u.setGraphic(new ImageView(new Image(new FileInputStream("Assets/Pink_Slime_Icon.png"),
										Size_Graphic, Size_Graphic, false, false)));
								u.setPadding(new Insets(0, 0, 0, 0));
								ai1.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Green_Slime_Icon.png"),
												Size_Graphic, Size_Graphic, false, false)));
								ai1.setPadding(new Insets(0, 0, 0, 0));
								ai2.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Purple_Slime_Icon.png"),
												Size_Graphic, Size_Graphic, false, false)));
								ai2.setPadding(new Insets(0, 0, 0, 0));
								ai3.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Blue_Slime_Icon.png"),
												Size_Graphic, Size_Graphic, false, false)));
								ai3.setPadding(new Insets(0, 0, 0, 0));

								u.setLocation(0, 0);
								u.setCardinalConnections(gameboard);
								// copy paste these next line for the rest of the players and AI objects
								u.setURL("Assets/Pink_Slime_Icon.png");
								u.setTrail(new ImageView(new Image(new FileInputStream("Assets/Pink_Slime_Trail.png"),
										Size_Graphic, Size_Graphic, false, false)));
								u.setTrailString("Pink_Slime_Trail.png"); 
								gameboard[0][0] = u;

								ai1.setLocation(0, size_amount - 1);
								ai1.setCardinalConnections(gameboard);
								ai1.setURL("Assets/Green_Slime_Icon.png");
								ai1.setTrail(new ImageView(new Image(new FileInputStream("Assets/Green_SlimeTrail.png"),
										Size_Graphic, Size_Graphic, false, false)));
								ai1.setTrailString("Green_SlimeTrail.png");
								gameboard[0][size_amount - 1] = ai1;

								ai2.setLocation(size_amount - 1, 0);
								ai2.setCardinalConnections(gameboard);
								ai2.setURL("Assets/Purple_Slime_Icon.png");
								ai2.setTrail(
										new ImageView(new Image(new FileInputStream("Assets/Purple_Slime_Trail.png"),
												Size_Graphic, Size_Graphic, false, false)));
								ai2.setTrailString("Purple_Slime_Trail.png");
								gameboard[size_amount - 1][0] = ai2;

								ai3.setLocation(size_amount - 1, size_amount - 1);
								ai3.setCardinalConnections(gameboard);
								ai3.setURL("Assets/Blue_Slime_Icon.png");
								ai3.setTrail(new ImageView(new Image(new FileInputStream("Assets/Blue_Slime_Trail.jpg"),
										Size_Graphic, Size_Graphic, false, false)));
								ai3.setTrailString("Blue_Slime_Trail.jpg");
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
										Size_Graphic, Size_Graphic, false, false)));
								u.setPadding(new Insets(0, 0, 0, 0));
								ai1.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Pink_Slime_Icon.png"),
												Size_Graphic, Size_Graphic, false, false)));
								ai1.setPadding(new Insets(0, 0, 0, 0));
								ai2.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Purple_Slime_Icon.png"),
												Size_Graphic, Size_Graphic, false, false)));
								ai2.setPadding(new Insets(0, 0, 0, 0));
								ai3.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Blue_Slime_Icon.png"),
												Size_Graphic, Size_Graphic, false, false)));
								ai3.setPadding(new Insets(0, 0, 0, 0));

								u.setLocation(0, 0);
								u.setCardinalConnections(gameboard);
								u.setURL("Assets/Green_Slime_Icon.png");
								u.setTrail(new ImageView(new Image(new FileInputStream("Assets/Green_SlimeTrail.png"),
										Size_Graphic, Size_Graphic, false, false)));
								u.setTrailString("Green_SlimeTrail.png");
								gameboard[0][0] = u;

								ai1.setLocation(0, size_amount - 1);
								ai1.setCardinalConnections(gameboard);
								ai1.setURL("Assets/Pink_Slime_Icon.png");
								ai1.setTrail(new ImageView(new Image(new FileInputStream("Assets/Pink_Slime_Trail.png"),
										Size_Graphic, Size_Graphic, false, false)));
								ai1.setTrailString("Pink_Slime_Trail.png");
								gameboard[0][size_amount - 1] = ai1;

								ai2.setLocation(size_amount - 1, 0);
								ai2.setCardinalConnections(gameboard);
								ai2.setURL("Assets/Purple_Slime_Icon.png");
								ai2.setTrail(
										new ImageView(new Image(new FileInputStream("Assets/Purple_Slime_Trail.png"),
												Size_Graphic, Size_Graphic, false, false)));
								ai2.setTrailString("Purple_Slime_Trail.png");
								gameboard[size_amount - 1][0] = ai2;

								ai3.setLocation(size_amount - 1, size_amount - 1);
								ai3.setCardinalConnections(gameboard);
								ai3.setURL("Assets/Blue_Slime_Icon.png");
								ai3.setTrail(new ImageView(new Image(new FileInputStream("Assets/Blue_Slime_Trail.jpg"),
										Size_Graphic, Size_Graphic, false, false)));
								ai3.setTrailString("Blue_Slime_Trail.jpg");
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
												Size_Graphic, Size_Graphic, false, false)));
								u.setPadding(new Insets(0, 0, 0, 0));
								ai1.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Green_Slime_Icon.png"),
												Size_Graphic, Size_Graphic, false, false)));
								ai1.setPadding(new Insets(0, 0, 0, 0));
								ai2.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Pink_Slime_Icon.png"),
												Size_Graphic, Size_Graphic, false, false)));
								ai2.setPadding(new Insets(0, 0, 0, 0));
								ai3.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Blue_Slime_Icon.png"),
												Size_Graphic, Size_Graphic, false, false)));
								ai3.setPadding(new Insets(0, 0, 0, 0));

								u.setLocation(0, 0);
								u.setCardinalConnections(gameboard);
								u.setURL("Assets/Purple_Slime_Icon.png");
								u.setTrail(new ImageView(new Image(new FileInputStream("Assets/Purple_Slime_Trail.png"),
										Size_Graphic, Size_Graphic, false, false)));
								u.setTrailString("Purple_Slime_Trail.png");
								gameboard[0][0] = u;

								ai1.setLocation(0, size_amount - 1);
								ai1.setCardinalConnections(gameboard);
								ai1.setURL("Assets/Green_Slime_Icon.png");
								ai1.setTrail(new ImageView(new Image(new FileInputStream("Assets/Green_SlimeTrail.png"),
										Size_Graphic, Size_Graphic, false, false)));
								ai1.setTrailString("Green_SlimeTrail.png");
								gameboard[0][size_amount - 1] = ai1;

								ai2.setLocation(size_amount - 1, 0);
								ai2.setCardinalConnections(gameboard);
								ai2.setURL("Assets/Pink_Slime_Icon.png");
								ai2.setTrail(new ImageView(new Image(new FileInputStream("Assets/Pink_Slime_Trail.png"),
										Size_Graphic, Size_Graphic, false, false)));
								ai2.setTrailString("Pink_Slime_Trail.png");
								gameboard[size_amount - 1][0] = ai2;

								ai3.setLocation(size_amount - 1, size_amount - 1);
								ai3.setCardinalConnections(gameboard);
								ai3.setURL("Assets/Blue_Slime_Icon.png");
								ai3.setTrail(new ImageView(new Image(new FileInputStream("Assets/Blue_Slime_Trail.jpg"),
										Size_Graphic, Size_Graphic, false, false)));
								ai3.setTrailString("Blue_Slime_Trail.jpg");
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
										Size_Graphic, Size_Graphic, false, false)));
								u.setPadding(new Insets(0, 0, 0, 0));
								ai1.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Green_Slime_Icon.png"),
												Size_Graphic, Size_Graphic, false, false)));
								ai1.setPadding(new Insets(0, 0, 0, 0));
								ai2.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Purple_Slime_Icon.png"),
												Size_Graphic, Size_Graphic, false, false)));
								ai2.setPadding(new Insets(0, 0, 0, 0));
								ai3.setGraphic(
										new ImageView(new Image(new FileInputStream("Assets/Pink_Slime_Icon.png"),
												Size_Graphic, Size_Graphic, false, false)));
								ai3.setPadding(new Insets(0, 0, 0, 0));

								u.setLocation(0, 0);
								u.setCardinalConnections(gameboard);
								u.setURL("Assets/Blue_Slime_Icon.png");
								u.setTrail(new ImageView(new Image(new FileInputStream("Assets/Blue_Slime_Trail.jpg"),
										Size_Graphic, Size_Graphic, false, false)));
								u.setTrailString("Blue_Slime_Trail.jpg");
								gameboard[0][0] = u;

								ai1.setLocation(0, size_amount - 1);
								ai1.setCardinalConnections(gameboard);
								ai1.setURL("Assets/Green_Slime_Icon.png");
								ai1.setTrail(new ImageView(new Image(new FileInputStream("Assets/Green_SlimeTrail.png"),
										Size_Graphic, Size_Graphic, false, false)));
								ai1.setTrailString("Green_SlimeTrail.png");
								gameboard[0][size_amount - 1] = ai1;

								ai2.setLocation(size_amount - 1, 0);
								ai2.setCardinalConnections(gameboard);
								ai2.setURL("Assets/Purple_Slime_Icon.png");
								ai2.setTrail(new ImageView(new Image(new FileInputStream("Assets/Purple_Slime_Trail.png"),
												Size_Graphic, Size_Graphic, false, false)));
								ai2.setTrailString("Purple_Slime_Trail.png");
								gameboard[size_amount - 1][0] = ai2;

								ai3.setLocation(size_amount - 1, size_amount - 1);
								ai3.setCardinalConnections(gameboard);
								ai3.setURL("Assets/Pink_Slime_Icon.png");
								ai3.setTrail(new ImageView(new Image(new FileInputStream("Assets/Pink_Slime_Trail.png"),
										Size_Graphic, Size_Graphic, false, false)));
								ai3.setTrailString("Pink_Slime_Trail.png");
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
			gamesize_Button_layout.getChildren().addAll(back_to_menu, entersize);
			gamesize_Button_layout.setAlignment(Pos.CENTER);
			VBox gamesize_layout = new VBox(30);
			gamesize_layout.getChildren().addAll(size_error_message, boardsize, player_select_group,
					gamesize_Button_layout);
			gamesize_layout.setAlignment(Pos.CENTER);
			BackgroundImage gamesize_BG = new BackgroundImage(new Image(new FileInputStream("Assets/slime_BG.jpg"), 500, 500, false, true),
					BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
					BackgroundSize.DEFAULT);
			gamesize_layout.setBackground(new Background(gamesize_BG));
			gamesize = new Scene(gamesize_layout, 400, 250);
			Button exit = new Button();
			exit.setShape(new Circle());
			exit.setMaxSize(3, 3);
			exit.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					primaryStage.setScene(gamesize);
					grid.getChildren().clear();
					button_press.play();
				}
			});

			exit.setGraphic(new ImageView(new Image(new FileInputStream("Assets/left_arrow.png"), 30, 30, false, false)));
			VBox gameLayOut = new VBox(10);
			BackgroundImage gamescreen_BG = new BackgroundImage(new Image(new FileInputStream("Assets/slime_BG.jpg"), 500, 500, false, true),
					BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
					BackgroundSize.DEFAULT);
			gameLayOut.setBackground(new Background(gamescreen_BG));
			gameLayOut.getChildren().addAll(exit, grid);
			gameLayOut.setAlignment(Pos.CENTER);
			GameScreen = new Scene(gameLayOut);
			Menu.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(Menu);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void RunningGame(Stage primaryStage) {
		@SuppressWarnings("removal")
//		Boolean graytiles_exist = new Boolean(true);
		int grayTiles = (size_amount * size_amount) - 4;
		
		
			// have to set player URL strings when initialize to differentiate from game
			// board gray tiles.
			System.out.println("Gray tiles: " + grayTiles);
//			try {
			String[] options = {"north", "south", "west", "east"};
			Random randomOpt = new Random();
				GameScreen.setOnKeyPressed(e -> {
					if (e.getCode() == KeyCode.A) {
						
						System.out.println();
						System.out.println();
						
						gameboard =u.Movement(gameboard, "west");
						
						int CPUact1 = randomOpt.nextInt(4);
						gameboard =ai1.Movement(gameboard, options[CPUact1]);
						int CPUact2 = randomOpt.nextInt(4);
						gameboard =ai2.Movement(gameboard, options[CPUact2]);
						int CPUact3 = randomOpt.nextInt(4);
						gameboard =ai3.Movement(gameboard, options[CPUact3]);
						grid.getChildren().clear();
						for (int i = 0; i < size_amount; i++) {
							for (int j = 0; j < size_amount; j++) {
								grid.add(gameboard[i][j],j,i);
								System.out.print(gameboard[i][j].getLocation()[0] + ","
										+ gameboard[i][j].getLocation()[1] + " ");
								
							}
							System.out.println();
						}
						boolean end = checkTiles();
						if(end == true) {
							endgame(primaryStage);
						}
					}
					
					else if (e.getCode() == KeyCode.D) {
						
						System.out.println();
						System.out.println();
						
						gameboard =u.Movement(gameboard, "east");
						
						int CPUact1 = randomOpt.nextInt(4);
						gameboard =ai1.Movement(gameboard, options[CPUact1]);
						int CPUact2 = randomOpt.nextInt(4);
						gameboard =ai2.Movement(gameboard, options[CPUact2]);
						int CPUact3 = randomOpt.nextInt(4);
						gameboard =ai3.Movement(gameboard, options[CPUact3]);
						grid.getChildren().clear();
						for (int i = 0; i < size_amount; i++) {
							for (int j = 0; j < size_amount; j++) {
								grid.add(gameboard[i][j],j,i);
								System.out.print(gameboard[i][j].getLocation()[0] + ","
										+ gameboard[i][j].getLocation()[1] + " ");
								
							}
							System.out.println();
						}
						boolean end = checkTiles();
						if(end == true) {
							endgame(primaryStage);
						}
					}
				
					else if (e.getCode() == KeyCode.S) {
						System.out.println();
						System.out.println();
						
						
						gameboard =u.Movement(gameboard, "south");
						
						int CPUact1 = randomOpt.nextInt(4);
						gameboard =ai1.Movement(gameboard, options[CPUact1]);
						int CPUact2 = randomOpt.nextInt(4);
						gameboard =ai2.Movement(gameboard, options[CPUact2]);
						int CPUact3 = randomOpt.nextInt(4);
						gameboard =ai3.Movement(gameboard, options[CPUact3]);
						grid.getChildren().clear();
						for (int i = 0; i < size_amount; i++) {
							for (int j = 0; j < size_amount; j++) {
								grid.add(gameboard[i][j],j,i);
								System.out.print(gameboard[i][j].getLocation()[0] + ","
										+ gameboard[i][j].getLocation()[1] + " ");
								
							}
							System.out.println();
						}
						boolean end = checkTiles();
						if(end == true) {
							endgame(primaryStage);
						}
					}
						
					else if (e.getCode() == KeyCode.W) {
						System.out.println();
						System.out.println();
						
						gameboard =u.Movement(gameboard, "north");
						
						int CPUact1 = randomOpt.nextInt(4);
						gameboard =ai1.Movement(gameboard, options[CPUact1]);
						int CPUact2 = randomOpt.nextInt(4);
						gameboard =ai2.Movement(gameboard, options[CPUact2]);
						int CPUact3 = randomOpt.nextInt(4);
						gameboard =ai3.Movement(gameboard, options[CPUact3]);
						grid.getChildren().clear();
						for (int i = 0; i < size_amount; i++) {
							for (int j = 0; j < size_amount; j++) {
								grid.add(gameboard[i][j],j,i);
								System.out.print(gameboard[i][j].getLocation()[0] + ","
										+ gameboard[i][j].getLocation()[1] + " ");
								
							}
							System.out.println();
						}
						boolean endGame = checkTiles();
						if(endGame == true) {
							endgame(primaryStage);
						}
				}
				});
				System.out.println("We made it out alive");
		

	}
	
	boolean checkTiles() {
		// check conditions to end game
		System.out.println("We are in endgame");
		System.out.println(size_amount);
		int grayCounter = 0;
		for(int i = 0; i < size_amount; i++) {
			for(int j = 0; j < size_amount; j++) {
				if(gameboard[i][j].getURL() == "Assets/Gray_square_tile .PNG") { 
					grayCounter++;
				}
			}		
		}
		System.out.println("The number of gray tiles remaining is " + grayCounter);	
		if(grayCounter == 0) {
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
				
				if(gameboard[i][j].getURL() == "Pink_Slime_Trail.png") {
					
					pink_count++;
				}
				if(gameboard[i][j].getURL() == "Green_SlimeTrail.png") {
					green_count++;
					
				}
				if(gameboard[i][j].getURL() == "Blue_Slime_Trail.jpg") {
					blue_count++;
				}
				if(gameboard[i][j].getURL() == "Purple_Slime_Trail.png") {
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
		String displayScores = "";
		displayScores += "The winner is: " + names[0] + "\n";
		displayScores += "1. " + names[0] + " " + points[0] + "\n";
		displayScores += "2. " + names[1] + " " + points[1] + "\n";
		displayScores += "3. " + names[2] + " " + points[2] + "\n";
		displayScores += "4. " + names[3] + " " + points[3] + "\n";
		
		
		try {
			Label messageLabel = new Label(displayScores);
			messageLabel.setGraphic(new ImageView(new Image(new FileInputStream("Assets/Gray_square_tile .PNG"),200,100,false,false)));
			
			Button play = new Button();
			play.setShape(new Circle());
			play.setMaxSize(3, 3);
			play.setGraphic(
					new ImageView(new Image(new FileInputStream("Assets/right_arrow.png"), 50, 50, false, false)));
			play.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("Thanks for playing!");
					System.exit(0);
				}
			
			});
			VBox vbox = new VBox(messageLabel,play);
			BackgroundImage gamescreen_BG = new BackgroundImage(new Image(new FileInputStream("Assets/slime_BG.jpg"), 500, 500, false, true),
					BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
					BackgroundSize.DEFAULT);
			vbox.setBackground(new Background(gamescreen_BG));
			vbox.setAlignment(Pos.CENTER);
			
			
			Scene scene = new Scene(vbox, 500, 500);
			
			primaryStage.setScene(scene);
			
			primaryStage.show();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
	
}