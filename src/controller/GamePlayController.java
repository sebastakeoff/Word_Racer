
package controller;

import model.Time;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class GamePlayController implements Initializable {

    @FXML
    private Button btnStart;
    @FXML
    public Label tmr;
    @FXML
    private Circle cir;
    @FXML
    private AnchorPane anchorGame;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
       
    
    @FXML
    public void countDownTimer(ActionEvent event){
            
        TranslateTransition transition = new TranslateTransition();
        transition.setToX(300);
        transition.setDuration(Duration.seconds(1));
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setNode(cir);
        transition.play();
        
        Time timer = new Time();
        
          
                  
    }
    
}
