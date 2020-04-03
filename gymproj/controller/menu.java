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
import javafx.animation.FadeTransition;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class menu{

    @FXML
    private VBox vbox, menu;

    @FXML
    private Pane programsPane, accountPane, payPane;

    @FXML
    private Button logoutButton;

    @FXML
    private Text quote1, quote2;

	@FXML
	private TableView<GymProgram> programTable;

	@FXML
	private TableColumn<GymProgram, String> colTitle, colDay, colHour, colCategory;

	@FXML
	private TableColumn<GymProgram, Float> colCost;

	public void menuStage(Stage stage) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("../views/menu.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("GymProj");
		scene.setFill(Color.TRANSPARENT);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.show();
    }

	public void initialize(){
		ObservableList<GymProgram> list = FXCollections.observableArrayList();
		colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
		colDay.setCellValueFactory(new PropertyValueFactory<>("day"));
		colHour.setCellValueFactory(new PropertyValueFactory<>("hour"));
		colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
		colCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
		try{
			Scanner scanner = new Scanner(new File("gymproj/Data/GymPrograms.txt"));
			while (scanner.hasNextLine()){
				list.add(new GymProgram(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), Float.parseFloat(scanner.nextLine())));
				scanner.nextLine();
			}
		} catch(FileNotFoundException e){
			System.out.println(e);
		}
        programTable.setItems(list);
    }

    public void logout() throws IOException{
        ((Stage) vbox.getScene().getWindow()).close();
        (new Main()).start(new Stage());
    }

	public void addAction() throws IOException{
		(new add()).addStage(new Stage());
	}

	public void removeAction(){
		programTable.getItems().remove(programTable.getSelectionModel().getSelectedItem());
		ObservableList<GymProgram> programs = programTable.getItems();
		try{
				BufferedWriter writer = new BufferedWriter(new FileWriter("gymproj/Data/GymPrograms.txt"));
				for(int i = 0;i < programs.size();i++){
					writer.write(programs.get(i).toString());
					writer.write("===\n");
				}
				writer.close();
			} catch(IOException io){
				System.out.println(io);
			}
	}

	public void refreshAction(){
		this.initialize();
	}

    //=============================================================================
	// Animations
	//=============================================================================
    public void homeButtonAction(){
        this.transition(0);
    }

    public void programButtonAction(){
		programsPane.setVisible(true);
        this.transition(1);
    }

    public void accountButtonAction(){
		accountPane.setVisible(true);
		this.transition(2);
    }

    public void payButtonAction(){
		payPane.setVisible(true);
        this.transition(3);
    }

	public void transition(int option){
		int[][] options = {{1,1,1,0,0,0,0,0,0,0,0},{0,1,1,1,0,0,575,525,-50,50,50},{1,0,1,0,1,0,575,525,-50,50,50},{1,1,0,0,0,1,575,525,-50,50,50}};
		boolean[][] options2 = {{false,false,false},{true,false,false},{false,true,false},{false,false,true}};
		TranslateTransition t1 = new TranslateTransition(Duration.seconds(1), vbox);
		TranslateTransition t2 = new TranslateTransition(Duration.seconds(1), menu);
		TranslateTransition t3 = new TranslateTransition(Duration.seconds(1), logoutButton);
		TranslateTransition t4 = new TranslateTransition(Duration.seconds(1), quote1);
		TranslateTransition t5 = new TranslateTransition(Duration.seconds(1), quote2);
		FadeTransition f1 = new FadeTransition(Duration.seconds(1), programsPane);
		FadeTransition f2 = new FadeTransition(Duration.seconds(1), accountPane);
		FadeTransition f3 = new FadeTransition(Duration.seconds(1), payPane);
		f1.setFromValue(options[option][0]);
		f2.setFromValue(options[option][1]);
		f3.setFromValue(options[option][2]);
		f1.setToValue(options[option][3]);
		f2.setToValue(options[option][4]);
		f3.setToValue(options[option][5]);
		t1.setToX(options[option][6]);
		t2.setToX(options[option][7]);
		t3.setToX(options[option][8]);
		t4.setToX(options[option][9]);
		t5.setToX(options[option][10]);
		f1.play();
		f2.play();
		f3.play();
		t1.play();
		t2.play();
		t3.play();
		t4.play();
		t5.play();
		t5.setOnFinished((e) -> {
            programsPane.setVisible(options2[option][0]);
			accountPane.setVisible(options2[option][1]);
			payPane.setVisible(options2[option][2]);
		});
	}
    //=============================================================================
	// End Animations
	//=============================================================================

}