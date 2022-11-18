package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.Node;

/* We are going to be focusing on Model-View-Controller (MVC)
 * 
 * Model - the object representing the data to be manipulated by the controller ??
 * View -  GUI view of the data (reflection) -- GridPane
 * Controller - the code that manipulates the Model (and sometimes the view)
 * 
 */

public class Main extends Application {
	
	private final int GRID_SIZE = 10;
	private char[][] allColors;
	
	@Override	
	public void start(Stage primaryStage) {
		allColors = new char[GRID_SIZE][GRID_SIZE];
		//initialize my model
		for(int row = 0; row < GRID_SIZE; row++) {
			for(int col = 0; col < GRID_SIZE; col++) {
				int randNum = (int)(Math.random() * 6);
				if (randNum == 0) {
					allColors[row][col] = 'B';
				} else if (randNum == 1) {
					allColors[row][col] = 'r';
				} else if (randNum == 2) {
					allColors[row][col] = 'b';
				} else if (randNum == 3) {
					allColors[row][col] = 'C';
				} else if (randNum == 4){
					allColors[row][col] = 'g';
				} else {
					allColors[row][col] = 'y';
				}
			}
		}
		System.out.println("Original configuration of the board:\n");
		//The model now has values!
		printColors();		

		//Now it's time to make the view.
		GridPane grid = new GridPane();
		//Go through the model, using its values to initialize the view
		for(int row = 0; row < GRID_SIZE; row++) {
			for(int col = 0; col < GRID_SIZE; col++) {
				//My individual Nodes are going to be Rectangles
				Rectangle rect = new Rectangle(50,50);
				//set the background color - based on the model's values
				if (allColors[row][col] == 'B') {
					rect.setFill(Color.BROWN);
				} else if (allColors[row][col] == 'r') {
					rect.setFill(Color.RED);
				} else if (allColors[row][col] == 'b') {
					rect.setFill(Color.BLUE);
				} else if (allColors[row][col] == 'C') {
					rect.setFill(Color.CHARTREUSE);
				} else if (allColors[row][col] == 'g') {
					rect.setFill(Color.GREEN);
				} else {
					rect.setFill(Color.YELLOW);
				}
				//Now the Rectangle has a internal color. Need to give it a border:
				rect.setStrokeWidth(2);
				rect.setStroke(Color.BLACK);
				//Add my bit of code that is going to act as the controller.
				rect.setOnMouseClicked(e -> {
					Node n = (Node)e.getSource();     //get the Node living in the gridpane
					Integer r1 = grid.getRowIndex(n);     //get the node's row
					Integer c1 = grid.getColumnIndex(n);  //get the node's column
					//I need to alter my MODEL!!!
					allColors[r1][c1] = 'p';
					//I need to reflect this change in the view
					Rectangle rect1 = (Rectangle)n;  //I can cast the Node to a Rectangle!
					rect1.setFill(Color.HOTPINK);	
					
					//Print the change in the model.
					System.out.println("After the click, the color array is:\n ");
					printColors();
					
					//Let's say, after a mouse click, I want to check for a "winner"
					//That code should go here and LOOK AT THE MODEL!
					
					//Let's say winning in our game is getting 5 pinks in a row 
					//horizontally
					if (checkForWinner()) {
						System.out.println("There has been a winner!!");
					}
				});
				grid.add(rect, col, row);
			}
		}
		Scene scene = new Scene(grid);  //scene will have dimensions equal to the grid
		primaryStage.setScene(scene);
        primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void printColors() {
		for(int row = 0; row < GRID_SIZE; row++) {
			for(int col = 0; col < GRID_SIZE; col++) {
				System.out.print(allColors[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private boolean checkForWinner() {
		int sum;
		for(int r = 0; r < GRID_SIZE; r++) {
			sum = 0;
			for(int c = 0; c < GRID_SIZE; c++) {
				if (allColors[r][c] == 'p') {
					sum++;
					if (sum >= 5) {
						return true;
					}
				} else {
					sum = 0;
				}
			}			
		}
		return false;
	}
	
}