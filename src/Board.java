
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (!(snake.getDirection() == DirectionType.RIGHT)) {
                        snake.setDirection(DirectionType.LEFT);
                    }

                    break;
                case KeyEvent.VK_RIGHT:
                    if (!(snake.getDirection() == DirectionType.LEFT)) {
                        snake.setDirection(DirectionType.RIGHT);
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (!(snake.getDirection() == DirectionType.DOWN)) {
                        snake.setDirection(DirectionType.UP);
                    }
                    break;

                case KeyEvent.VK_DOWN:
                    if (!(snake.getDirection() == DirectionType.UP)) {
                        snake.setDirection(DirectionType.DOWN);
                    }
                    break;

                case KeyEvent.VK_P:
                    if (!timer.isRunning()) {
                        scoreBoard.resume();
                        timer.start();
                    } else {
                        timer.stop();
                        scoreBoard.pause();

                    }
                    break;

                default:
                    break;
            }
            repaint();
        }

    }

    private NormalFood normalFood;
    private SpecialFood specialFood;
    private Snake snake;

    private Timer timer;

    private MyKeyAdapter myKeyAdepter;
    private ScoreBoard scoreBoard;

    private JFrame parentFrame;

    private FoodFactory foodFactory;
    private JLabel labelCountDown;

    public void setParentFrame(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    public Board() {
        super();
        initComponents();
        setFocusable(true);

        timer = new Timer(ConfigSingleton.getInstance().getDeltaTime(), this);
        myKeyAdepter = new MyKeyAdapter();

        normalFood = null;
        specialFood = null;
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public void initGame() {

        removeKeyListener(myKeyAdepter);
        addKeyListener(myKeyAdepter);

        ConfigSingleton.getInstance().setDeltaTime(ConfigSingleton.getInstance().getDeltaTimeInit());
        timer.setDelay(ConfigSingleton.getInstance().getDeltaTimeInit());

        timer.stop();
        timer.start();

        scoreBoard.reset();

        snake = new Snake();
        foodFactory = new FoodFactory(this, snake);

        createFood();
    }

    public void createFood() {
        Food food = foodFactory.createFood();
        if (food instanceof NormalFood) {
            normalFood = (NormalFood) food;
        } else {
            specialFood = (SpecialFood) food;
        }
    }

    private int squareWidth() {
        return getWidth() / ConfigSingleton.getInstance().getNumCols();
    }

    private int squareHeight() {
        return getHeight() / ConfigSingleton.getInstance().getNumRows();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (snake != null) {
            snake.drawSnake(g, squareWidth(), squareHeight());

        }

        if (normalFood != null) {
            normalFood.drawFood(g, squareWidth(), squareHeight());
        }
        if (specialFood != null) {
            specialFood.drawFood(g, squareWidth(), squareHeight());
        }

        drawBorder(g);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (isGameOver()) {
            gameOver();
        } else {
            snake.move();
            eat();
            eatSpecialFood();

        }

        repaint();
        Toolkit.getDefaultToolkit().sync();
    }

    public void eat() {
        if (normalFood != null) {
            if (snake.getNodeHead().checkNodesHit(snake.getNodeHead(), normalFood.getNodeFood())) {

                scoreBoard.increment(1);
                makeFaster();
                normalFood = null;

                createFood();
                if (specialFood != null) {
                    createFood();
                }

                snake.setCountGrowSnake(1);
            }
        }

    }

    public void eatSpecialFood() {
        if (specialFood != null) {
            if (snake.getNodeHead().checkNodesHit(snake.getNodeHead(), specialFood.getNodeFood())) {
                scoreBoard.increment(specialFood.getRandomScore());

                snake.setCountGrowSnake(specialFood.getRandomScore());

                specialFood = null;

                makeFaster();

            }

        }
    }

    public void makeFaster() {
        if (scoreBoard.getScore() % 5 == 0) {
            if (ConfigSingleton.getInstance().getDeltaTime() > 70) {
                ConfigSingleton.getInstance().setDeltaTime(ConfigSingleton.getInstance().getDeltaTime() - 50);

                timer.setDelay(ConfigSingleton.getInstance().getDeltaTime());
            }
        }
    }

    public boolean isGameOver() {
        boolean noWalls = ConfigSingleton.getInstance().getNoWalls();

        if (noWalls && snake.hitItself()) {
            return true;
        }
        if (noWalls == false && (snake.hitWall() || snake.hitItself())) {
            return true;
        }
        return false;
    }

    public void gameOver() {

        scoreBoard.setText("GAME OVER");

        removeKeyListener(myKeyAdepter);
        timer.stop();

        RecordsDialog d = new RecordsDialog(parentFrame, true, scoreBoard.getScore());
        d.setVisible(true);
    }

    public void drawBorder(Graphics g) {
        if (ConfigSingleton.getInstance().getNoWalls()) {
            g.setColor(Color.black);
        } else {
            g.setColor(Color.red);
        }
        g.drawRect(0, 0, ConfigSingleton.getInstance().getNumCols() * squareWidth(), ConfigSingleton.getInstance().getNumRows() * squareHeight());
    }

    public void removeSpecialFood() {
        specialFood = null;

    }

    public void setLabelCountDown(JLabel labelCountDown) {
        this.labelCountDown = labelCountDown;
    }
    
    public void initCounter() {
        CountDown cd = new CountDown(labelCountDown, this);
        cd.timerDisplay();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
