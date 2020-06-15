/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Word_Racer;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import static javafx.util.Duration.seconds;


public class Controller implements Initializable {
    
    @FXML
    private Button btnTuto, btnPlay;
    @FXML
    private TextField txtPy1, txtPy2;
    @FXML
    private AnchorPane anchorRoot;
    @FXML
    private StackPane parentContainer;
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Primera ejecución del juego
    }

    @FXML
    private void loadGamePlay(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Game_Play/GamePlay.fxml"));
        Scene scene = btnPlay.getScene();
        
        root.translateYProperty().set(scene.getHeight());
        parentContainer.getChildren().add(root);
        
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(javafx.util.Duration.seconds(1));
        boolean add = timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event1 -> {
            
            parentContainer.getChildren().remove(anchorRoot);
        });
        timeline.play();
        
    }
    
}
    
    

