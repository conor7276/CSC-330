package application;
import java.io.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.event.*;

public class Main extends Application {
	
	Label messageLabel = new Label("This message text will change based on the SSN.");
	HBox hbox1, hbox2;
	VBox myVBox;

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		//b) declare a Label variable called inputSSNLabel,
		//   and set its value to "Enter SSN: "
		Label inputSSNLabel = new Label("Enter SSN: ");
		TextField inputSSNField = new TextField();		
		//c) declare a Button named checkButton, and set its text to "Check SSN"
		Button checkButton = new Button("Check SSN");				
		checkButton.setOnAction((event) -> {
		try {
			String ssn = inputSSNField.getText();
			//d) if the length of the SSN is not equal to 11,
			//   throw a new SocSecException with the message
			//   "SSN length is not 11."
			if (ssn.length() != 11) {
				throw new SocSecException("SSN length is not 11.");
			}				
			//e) set the text of messageLabel to "Valid SSN!"
			messageLabel.setText("Valid SSN!");
			} catch (SocSecException sse) {
				//f) print the stack trace of sse
				sse.printStackTrace();
				//g) set the messageLabel text to the message of sse
				messageLabel.setText(sse.getMessage());
			}
		});
		//h) declare and instantiate an HBox named hbox1 with a spacing of 10, which holds
		//   inputSSNLabel, inputSSNField and checkButton, in that order
		hbox1 = new HBox(10, inputSSNLabel, inputSSNField, checkButton);
		hbox1.setPadding(new Insets(10));
		hbox2 = new HBox(10, messageLabel);
		hbox2.setPadding(new Insets(10));
		//i) declare and instantiate a VBox named myVbox with a spacing of 10, which holds
		//   hbox1 and hbox2, in that order
		myVBox = new VBox(10, hbox1, hbox2);
		myVBox.setPadding(new Insets(10));
		Scene scene = new Scene(myVBox);
		primaryStage.setScene(scene);
		//j) set the title of the primaryStage to "SSN Checker"
		primaryStage.setTitle("SSN Checker");
		primaryStage.show();
	}
}