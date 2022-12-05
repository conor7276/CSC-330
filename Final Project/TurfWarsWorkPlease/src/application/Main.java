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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.geometry.Pos;

import java.io.File;
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
	GridSquare gameboard[][] = new GridSquare[size_amount][size_amount];
	Scene Menu, GameScreen, gamesize;
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
	public void start(Stage primaryStage) { // start method for java fx program

		MediaPlayer game_audio;
		MediaPlayer button_press;
		button_press = new MediaPlayer(new Media(new File("Assets/button_press.mp3").toURI().toString())); // button press sfx
		button_press.setVolume(0.3);
		game_audio = new MediaPlayer(new Media(new File("Assets/In_game_theme_music.mp3").toURI().toString())); // music sfx only works in menu
		game_audio.setVolume(0.3);
		game_audio.setAutoPlay(true); // replay sounds
		game_audio.setCycleCount(MediaPlayer.INDEFINITE);

		try {
			// primary stage
			primaryStage.setTitle("Slippery Turf Wars"); // set title to window
			
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
//			BackgroundImage menu_BG = new BackgroundImage(new Image("slime_BG.jpg", 500, 500, false, true),
//					BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
//					BackgroundSize.DEFAULT);
//			menuLayOut.setBackground(new Background(menu_BG));
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

								u.setLocation(0, 7);
								u.setCardinalConnections(gameboard);
								// copy paste these next line for the rest of the players and AI objects
								u.setURL("Assets/Pink_Slime_Icon.png");
								u.setTrail(new ImageView(new Image(new FileInputStream("Assets/Pink_Slime_Trail.png"),
										Size_Graphic, Size_Graphic, false, false)));
//								u.setTrailString("Assets/Pink_Slime_Trail.png");
								gameboard[0][7] = u;

								ai1.setLocation(0, size_amount - 1);
								ai1.setCardinalConnections(gameboard);
								ai1.setTrail(new ImageView(new Image(new FileInputStream("Assets/Green_SlimeTrail.png"),
										Size_Graphic, Size_Graphic, false, false)));
//								ai1.setTrailString("Assets/Green_Slime_Trail.png");
								gameboard[0][size_amount - 1] = ai1;

								ai2.setLocation(size_amount - 1, 0);
								ai2.setCardinalConnections(gameboard);
								ai2.setTrail(
										new ImageView(new Image(new FileInputStream("Assets/Purple_Slime_Trail.png"),
												Size_Graphic, Size_Graphic, false, false)));
//								ai2.setTrailString("Assets/Purple_Slime_Trail.png");
								gameboard[size_amount - 1][0] = ai2;

								ai3.setLocation(size_amount - 1, size_amount - 1);
								ai3.setCardinalConnections(gameboard);
								ai3.setTrail(new ImageView(new Image(new FileInputStream("Assets/Blue_Slime_Trail.jpg"),
										Size_Graphic, Size_Graphic, false, false)));
//								ai3.setTrailString("Assets/Blue_Slime_Trail.png");
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
								u.setTrail(new ImageView(new Image(new FileInputStream("Assets/Green_SlimeTrail.png"),
										Size_Graphic, Size_Graphic, false, false)));
//								u.setTrailString("Assets/Green_Slime_Trail.png");
								gameboard[0][0] = u;

								ai1.setLocation(0, size_amount - 1);
								ai1.setCardinalConnections(gameboard);
								ai1.setTrail(new ImageView(new Image(new FileInputStream("Assets/Pink_Slime_Trail.png"),
										Size_Graphic, Size_Graphic, false, false)));
//								ai1.setTrailString("Assets/Pink_Slime_Trail.png");
								gameboard[0][size_amount - 1] = ai1;

								ai2.setLocation(size_amount - 1, 0);
								ai2.setCardinalConnections(gameboard);
								ai2.setTrail(
										new ImageView(new Image(new FileInputStream("Assets/Purple_Slime_Trail.png"),
												Size_Graphic, Size_Graphic, false, false)));
//								ai2.setTrailString("Assets/Purple_Slime_Trail.png");
								gameboard[size_amount - 1][0] = ai2;

								ai3.setLocation(size_amount - 1, size_amount - 1);
								ai3.setCardinalConnections(gameboard);
								ai3.setTrail(new ImageView(new Image(new FileInputStream("Assets/Blue_Slime_Trail.jpg"),
										Size_Graphic, Size_Graphic, false, false)));
//								ai3.setTrailString("Assets/Blue_Slime_Trail.png");
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
								u.setTrail(new ImageView(new Image(new FileInputStream("Assets/Purple_Slime_Trail.png"),
										Size_Graphic, Size_Graphic, false, false)));
//								u.setTrailString("Assets/Purple_Slime_Trail.png");
								gameboard[0][0] = u;

								ai1.setLocation(0, size_amount - 1);
								ai1.setCardinalConnections(gameboard);
								ai1.setTrail(new ImageView(new Image(new FileInputStream("Assets/Green_SlimeTrail.png"),
										Size_Graphic, Size_Graphic, false, false)));
//								ai1.setTrailString("Assets/Green_Slime_Trail.png");
								gameboard[0][size_amount - 1] = ai1;

								ai2.setLocation(size_amount - 1, 0);
								ai2.setCardinalConnections(gameboard);
								ai2.setTrail(new ImageView(new Image(new FileInputStream("Assets/Pink_Slime_Trail.png"),
										Size_Graphic, Size_Graphic, false, false)));
//								ai2.setTrailString("Assets/Pink_Slime_Trail.png");
								gameboard[size_amount - 1][0] = ai2;

								ai3.setLocation(size_amount - 1, size_amount - 1);
								ai3.setCardinalConnections(gameboard);
								ai3.setTrail(new ImageView(new Image(new FileInputStream("Assets/Blue_Slime_Trail.jpg"),
										Size_Graphic, Size_Graphic, false, false)));
//								ai3.setTrailString("Assets/Blue_Slime_Trail.png");
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
								u.setTrail(new ImageView(new Image(new FileInputStream("Assets/Blue_Slime_Trail.jpg"),
										Size_Graphic, Size_Graphic, false, false)));
//								u.setTrailString("Assets/Blue_Slime_Trail.png");
								gameboard[0][0] = u;

								ai1.setLocation(0, size_amount - 1);
								ai1.setCardinalConnections(gameboard);
								ai1.setTrail(new ImageView(new Image(new FileInputStream("Assets/Green_SlimeTrail.png"),
										Size_Graphic, Size_Graphic, false, false)));
//								ai1.setTrailString("Assets/Green_Slime_Trail.png");
								gameboard[0][size_amount - 1] = ai1;

								ai2.setLocation(size_amount - 1, 0);
								ai2.setCardinalConnections(gameboard);
								ai2.setTrail(
										new ImageView(new Image(new FileInputStream("Assets/Purple_Slime_Trail.png"),
												Size_Graphic, Size_Graphic, false, false)));
//								ai2.setTrailString("Assets/Purple_Slime_Trail.png");
								gameboard[size_amount - 1][0] = ai2;

								ai3.setLocation(size_amount - 1, size_amount - 1);
								ai3.setCardinalConnections(gameboard);
								ai3.setTrail(new ImageView(new Image(new FileInputStream("Assets/Pink_Slime_Trail.png"),
										Size_Graphic, Size_Graphic, false, false)));
//								ai3.setTrailString("Assets/Pink_Slime_Trail.png");
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

					RunningGame();
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
//			BackgroundImage gamesize_BG = new BackgroundImage(new Image("slime_BG.jpg", 500, 500, false, true),
//					BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
//					BackgroundSize.DEFAULT);
//			gamesize_layout.setBackground(new Background(gamesize_BG));
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

			exit.setGraphic(
					new ImageView(new Image(new FileInputStream("Assets/left_arrow.png"), 30, 30, false, false)));
			VBox gameLayOut = new VBox(10);
//			BackgroundImage gamescreen_BG = new BackgroundImage(new Image("slime_BG.jpg", 500, 500, false, true),
//					BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
//					BackgroundSize.DEFAULT);
//			gameLayOut.setBackground(new Background(gamescreen_BG));
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

	void RunningGame() {
		@SuppressWarnings("removal")
//		Boolean graytiles_exist = new Boolean(true);
		int grayTiles = size_amount * size_amount;
		while (grayTiles > 0) {

			// have to set player URL strings when initialize to differentiate from game
			// board gray tiles.

//			try {
				GameScreen.setOnKeyPressed(e -> {
					switch (e.getCode()) {
					case A:
						if (u.GetWest() == null || u.GetWest().getLocation() == ai3.getLocation() || u.GetWest().getLocation() == ai2.getLocation() || u.GetWest().getLocation() == ai1.getLocation()) {
							System.out.println("cannot move there");
						} else {
								u.setLocation(u.getLocation()[0], u.getLocation()[1]-1);
								u.setCardinalConnections(gameboard);
							try {
								gameboard[u.getLocation()[0]][u.getLocation()[1]].setGraphic(
										new ImageView(new Image(new FileInputStream(set_player),
												Size_Graphic, Size_Graphic, false, false)));
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							} 
						
						u.setURL("Assets/Pink_Slime_Icon.png");
						try {
							gameboard[u.getLocation()[0]][u.getLocation()[1]+1].setGraphic(new ImageView(new Image(new FileInputStream(set_trail),
									Size_Graphic, Size_Graphic, false, false)));
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
					}
						break;
					case D:
						if (u.GetEast() == null || u.GetEast().getLocation() == ai3.getLocation() || u.GetEast().getLocation() == ai2.getLocation() || u.GetEast().getLocation() == ai1.getLocation()) {
							System.out.println("cannot move there");
						} else {
								u.setLocation(u.getLocation()[0], u.getLocation()[1]+1);
								u.setCardinalConnections(gameboard);
							try {
								gameboard[u.getLocation()[0]][u.getLocation()[1]].setGraphic(
										new ImageView(new Image(new FileInputStream(set_player),
												Size_Graphic, Size_Graphic, false, false)));
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							} 
						
						u.setURL("Assets/Pink_Slime_Icon.png");
						try {
							gameboard[u.getLocation()[0]][u.getLocation()[1]-1].setGraphic(new ImageView(new Image(new FileInputStream(set_trail),
									Size_Graphic, Size_Graphic, false, false)));
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
					}
						break;
					case S:
						if (u.GetSouth() == null || u.GetSouth().getLocation() == ai3.getLocation() || u.GetSouth().getLocation() == ai2.getLocation() || u.GetSouth().getLocation() == ai1.getLocation()) {
							System.out.println("cannot move there");
						} else {
							System.out.println(u.getLocation()[0]+","+u.getLocation()[1]);
							u.setLocation(u.getLocation()[0]+1, u.getLocation()[1]);
							u.setCardinalConnections(gameboard);
							try {
								gameboard[u.getLocation()[0]][u.getLocation()[1]].setGraphic(
										new ImageView(new Image(new FileInputStream(set_player),
												Size_Graphic, Size_Graphic, false, false)));
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							} 
						
						u.setURL("Assets/Pink_Slime_Icon.png");
						try {
							gameboard[u.getLocation()[0]-1][u.getLocation()[1]].setGraphic(new ImageView(new Image(new FileInputStream(set_trail),
									Size_Graphic, Size_Graphic, false, false)));
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
					}
						break;
					case W:
						System.out.println(u.GetNorth());
						if (u.GetNorth() == null || u.GetNorth().getLocation() == ai3.getLocation() || u.GetNorth().getLocation() == ai2.getLocation() || u.GetNorth().getLocation() == ai1.getLocation()) {
							System.out.println("cannot move there");
						} else {
							u.setLocation(u.getLocation()[0] - 1, u.getLocation()[1]);
							u.setCardinalConnections(gameboard);
							try {
								gameboard[u.getLocation()[0]][u.getLocation()[1]].setGraphic(
										new ImageView(new Image(new FileInputStream(set_player),
												Size_Graphic, Size_Graphic, false, false)));
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							} 
						
						u.setURL("Assets/Pink_Slime_Icon.png");
						try {
							gameboard[u.getLocation()[0]+1][u.getLocation()[1]].setGraphic(new ImageView(new Image(new FileInputStream(set_trail),
									Size_Graphic, Size_Graphic, false, false)));
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
					}
						break;
					}
				});
				
				
//				wait(2);
//				gameboard = ai1.Movement(gameboard);
//				grid.getChildren().clear();
//				for (int i = 0; i < size_amount; i++) {
//					for (int j = 0; j < size_amount; j++) {
//
//						grid.add(gameboard[i][j], j, i);
//					}
//				}
//				wait(2);
//				gameboard = ai2.Movement(gameboard);
//				grid.getChildren().clear();
//				for (int i = 0; i < size_amount; i++) {
//					for (int j = 0; j < size_amount; j++) {
//
//						grid.add(gameboard[i][j], j, i);
//					}
//				}
//				wait(2);
//				gameboard = ai3.Movement(gameboard);
//				grid.getChildren().clear();
//				for (int i = 0; i < size_amount; i++) {
//					for (int j = 0; j < size_amount; j++) {
//
//						grid.add(gameboard[i][j], j, i);
//					}
//				}

//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}

//			int x = 0;
//			for (int i = 0; i < size_amount; i++) {
//				for (int j = 0; j < size_amount; j++) {
//					if (gameboard[i][j].getURL() == "Assets/Gray_square_tile .PNG")
//						;
//					{
//						x++;
//					}
//				}
//			}
//			if (x == 0) {
//				graytiles_exist = false;
//			}
				grayTiles--;
		}

		// count player claimed spaces and determine the winner after while loop
		// finishes;

	}
}
