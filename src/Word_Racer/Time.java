package Word_Racer;
import Game_Play.GamePlayController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 *
 * @author  Grupo 11 - Paradigmas de programación
 */
public class Time extends GamePlayController {
    
    private final Timeline animation;
    private int tmp = 20;
    private String S = "";
    
    public Time(){
        
        animation = new Timeline(new KeyFrame(Duration.seconds(1), e -> timelabel()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        
    }
    
    private void timelabel(){
    
        if(tmp > 0){
            tmp--;
        }
        S = tmp + "";
        tmr.setText(S);
    }    
    
}
