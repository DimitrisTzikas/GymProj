package gymproj.controller;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Scene.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
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

public class login{
    
    @FXML
    private Pane paneSignin, paneSignup;

	@FXML
	private VBox vbox;

	public void close(){
		System.exit(0);
	}

	public void loginStage(Stage stage) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("../views/login.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("GymProj");
		scene.setFill(Color.TRANSPARENT);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.show();
	}

	public void signinAction(){
		//TODO Login action
		((Stage) vbox.getScene().getWindow()).close();
		try{
	    	(new menu()).menuStage(new Stage());
		} catch(IOException e){
		    System.out.println(e);
		};
	}

	public void signupAction(){
		//TODO Signup action
		((Stage) vbox.getScene().getWindow()).close();
		try{
		    (new menu()).menuStage(new Stage());
		} catch(IOException e){
		    System.out.println(e);
		};
	}

	//=============================================================================
	// Animations
	//=============================================================================
    public void signup(){
		TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
		t.setToX(-460);
		t.play();
		t.setOnFinished((e) -> {
			paneSignin.setVisible(false);
			paneSignup.setVisible(true);
	    	});
    }

	public void signin(){
		TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
		t.setToX(0);
		t.play();
		t.setOnFinished((e) -> {
			paneSignin.setVisible(true);
			paneSignup.setVisible(false);
		    });
	}
	//=============================================================================
	// End Animations
	//=============================================================================

}
