
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigSingleton implements Serializable {

    private static ConfigSingleton instance = null;

    private int score;
    private int level;
    private boolean noWalls;
    private int numRows;
    private int numCols;
    private int deltaTime;
    private int deltaTimeConfig;
    private int countFood;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDeltaTime() {
        return deltaTime;
    }

    public void setDeltaTime(int deltaTime) {
        this.deltaTime = deltaTime;
    }

    private ConfigSingleton() {

        score = 0;
        level = 1;
        noWalls = false;
        numCols = 20;
        numRows = 20;
        deltaTime = 300;
        deltaTimeConfig = deltaTime;
        countFood = 0;

    }

    public int getCountFood() {
        return countFood;
    }

    public void setCountFood(int countFood) {
        this.countFood = countFood;
    }
    
    public int getDeltaTimeConfig() {
        return deltaTimeConfig;
    }

    public void setDeltaTimeConfig(int deltaTimeConfig) {
        this.deltaTimeConfig = deltaTimeConfig;
    }
    
    

    public boolean getNoWalls() {
        return noWalls;
    }

    public void setNoWalls(boolean noWalls) {
        this.noWalls = noWalls;
    }

    public static ConfigSingleton getInstance() {
        if (instance == null) {
            instance = new ConfigSingleton();
        }
        return instance;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }

    public void saveConfigObject() throws IOException {
        ObjectOutputStream output = null;
        try {
            output = new ObjectOutputStream(new FileOutputStream("ConfigObject.data"));
            output.writeObject(instance);

        } catch (IOException ex) {
            ex.printStackTrace();

        } finally {
            if (output != null) {
                output.close();
            }
        }

    }

}
