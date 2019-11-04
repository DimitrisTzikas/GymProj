package gymproj;

import gymproj.controller.login;
//
import gymproj.controller.menu;
//
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
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class Main extends javafx.application.Application{

    public static void main(String[] args){
		launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException{
		//(new login()).loginStage(stage);
		(new menu()).menuStage(stage);
    }

}
