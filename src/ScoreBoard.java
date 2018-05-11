
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alu20482156n
 */
public class ScoreBoard extends JLabel {

    public ScoreBoard() {

    }

    public void pause() {
        setText("Level: " + ConfigSingleton.getInstance().getLevel() + " · Score: " + ConfigSingleton.getInstance().getScore() + " PAUSED");

    }

    public void resume() {
        setText("Level: " + ConfigSingleton.getInstance().getLevel() + " · Score: " + ConfigSingleton.getInstance().getScore());
    }

    public void increment(int points) {
        ConfigSingleton.getInstance().setScore(ConfigSingleton.getInstance().getScore() + points);

        setText("Level: " + ConfigSingleton.getInstance().getLevel() + " · Score: " + ConfigSingleton.getInstance().getScore());

    }

    public void reset() {
        ConfigSingleton.getInstance().setScore(0);
        ConfigSingleton.getInstance().setLevel(1);
        setText("Level: " + ConfigSingleton.getInstance().getLevel() + " · Score: " + ConfigSingleton.getInstance().getScore());
    }

    public int getScore() {
        return ConfigSingleton.getInstance().getScore();
    }

    public int getLevel() {
        return ConfigSingleton.getInstance().getLevel();
    }

    public void setLevel(int level) {
        ConfigSingleton.getInstance().setLevel(level);
    }

    /*public void specialFoodTime() {
        
        setText("Level: " + level + " · Score: " + score + " · Time: " + SpecialFood.timerCountDown);
    }*/
}
