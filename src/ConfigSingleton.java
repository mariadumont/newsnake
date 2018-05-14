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
    private boolean noWalls;
    // private boolean personalizedMode;

    private int numRows;
    private int numCols;
    private int deltaTime;

    /*private static int numRows;
    private static int numCols;
    private static int deltaTime;*/
    private int deltaTimeInit;

    private Personalized personalized;
    //private Cover cover;

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

    /*private ConfigSingleton() {

        score = 0;
        level = 1;
        noWalls = false;
        numCols = 20;
        numRows = 20;
   
       if(Cover.personalizedMode){
           deltaTime=Integer.parseInt(personalized.getjTextFieldSpeed().getText());
       }else{
           deltaTime = 200;
       }
  
        deltaTimeInit = deltaTime;
 
        System.out.println(deltaTime);

    }*/

 /*private ConfigSingleton() {

        score = 0;
        level = 1;
        noWalls = false;
        numCols = 20;
        numRows = 20;
        deltaTime = 1500;
        deltaTimeInit = deltaTime;
        personalizedMode = false;

    }*/
    private ConfigSingleton() {

        score = 0;
        level = 1;
        noWalls = false;
        numCols = 20;
        numRows = 20;
        deltaTime = Integer.parseInt(personalized.jTextFieldSpeed);
        deltaTimeInit = deltaTime;

    }

    /*private ConfigSingleton(int numCols, int numRows, int deltaTime) {

        score = 0;
        level = 1;
        noWalls = false;
        this.numCols = numCols;
        this.numRows = numRows;
        this.deltaTime = deltaTime;
        deltaTimeInit = deltaTime;

    }*/
    public int getDeltaTimeInit() {
        return deltaTimeInit;
    }

    public boolean getNoWalls() {
        return noWalls;
    }

    public void setNoWalls(boolean noWalls) {
        this.noWalls = noWalls;
    }

    public static ConfigSingleton getInstance() {
        if (instance == null) {
            /*if(personalizedMode){
             instance = new ConfigSingleton(numCols, numRows, deltaTime); 
            deltaTime=deltaTime;
             
             
            }else{
                instance = new ConfigSingleton();
            }*/
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
