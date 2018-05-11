/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//crear factory comidas
//guardar carchivo ConfigSingleton ObjectOutput...
//cuenta atras...
/**
 *
 * @author alu20482156n
 */
public class ConfigSingleton {

    private static ConfigSingleton instance = null;

    private int score;
    private int level;
    private int deltaTime;
    private boolean noWalls;
    private int numRows;
    private int numCols;

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
        deltaTime = 300;
        noWalls = false;
        numCols = 20;
        numRows = 20;

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
}
