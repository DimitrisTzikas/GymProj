package gymproj.controller;

import gymproj.Main;
import gymproj.models.GymProgram;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Scene.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.scene.text.Text; 
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class add{

	@FXML
	private TextField titleField, costField;

	@FXML
	private ComboBox<String> dayBox, hourBox, categoryBox;

	@FXML
	private Button addButton;

    public void addStage(Stage stage) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("../views/add.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("GymProj");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
    }

	public void initialize(){
		dayBox.getItems().addAll("SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY");
		hourBox.getItems().addAll("9-10", "10-11", "11-12", "12-13", "13-14", "14-15", "15-16", "16-17", "17-18", "18-19", "19-20", "20-21");
		categoryBox.getItems().addAll("Alone", "Team");
	}

	public void addAction(){
		String var[] = new String[5];
		var[0] = titleField.getText();
		var[1] = dayBox.getValue();
		var[2] = hourBox.getValue();
		var[3] = categoryBox.getValue();
		var[4] = costField.getText();

		if(var[0].equals("") || var[1] == null || var[2] == null || var[3] == null || var[4].equals("")){
			addButton.setStyle("-fx-background-color: #aa5555");
		}
		else{
			addButton.setStyle("-fx-background-color: #55aa55");
			titleField.clear();
			costField.clear();
			dayBox.getItems().clear();
			hourBox.getItems().clear();
			categoryBox.getItems().clear();
			this.initialize();
			GymProgram program = new GymProgram(var[0], var[1], var[2], var[3], Float.parseFloat(var[4]));

			try{
				BufferedWriter writer = new BufferedWriter(new FileWriter("gr/ihu/gymproj/Data/GymPrograms.txt", true));
				writer.write(program.toString());
				writer.write("===\n");
				writer.close();
			} catch(IOException io){
				System.out.println(io);
			}
		}

	}

	public void close(){
		((Stage) titleField.getScene().getWindow()).close();
	}	

}