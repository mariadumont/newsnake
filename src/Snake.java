
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alu20482156n
 */
public class Snake {

    private ArrayList<Node> listNodes;

    private DirectionType direction;

    private int countGrowSnake;

    Snake() {
        listNodes = new ArrayList<Node>(3);

        listNodes.add(new Node(ConfigSingleton.getInstance().getNumRows() / 2, ConfigSingleton.getInstance().getNumCols() / 2, Color.green.darker()));
        listNodes.add(new Node(ConfigSingleton.getInstance().getNumRows() / 2, ConfigSingleton.getInstance().getNumCols() / 2 - 1, Color.green));
        listNodes.add(new Node(ConfigSingleton.getInstance().getNumRows() / 2, ConfigSingleton.getInstance().getNumCols() / 2 - 2, Color.green));
        direction = DirectionType.RIGHT;

        countGrowSnake = 0;

    }

    public void drawSnake(Graphics g, int squareWidth, int squareHeight) {

        for (Node n : listNodes) {
            Util.drawSquare(g, n, squareWidth, squareHeight);
        }
    }

    public void move() {
        Node head = getNodeHead();
        boolean noWalls = ConfigSingleton.getInstance().getNoWalls();
        Node firstNode = null;

        switch (direction) {
            case RIGHT:
                if (noWalls && head.getCol() == ConfigSingleton.getInstance().getNumCols()-1) {
                    firstNode = new Node(head.row, head.getFirstCol(), head.color);

                } else {
                    firstNode = new Node(head.row, head.col + 1, head.color);
                }
                break;

            case LEFT:
                if (noWalls && head.getCol() == 0) {
                    //firstNode = new Node(head.row, head.getLastCol()-1, head.color);
                    firstNode = new Node(head.row, ConfigSingleton.getInstance().getNumCols()-1, head.color);
                } else {
                    firstNode = new Node(head.row, head.col - 1, head.color);
                }
                break;

            case UP:
                if (noWalls && head.getRow() == 0) {
                    //firstNode = new Node(head.getLastRow()-1, head.col, head.color);
                    firstNode = new Node(ConfigSingleton.getInstance().getNumRows()-1, head.col, head.color);
                } else {
                    firstNode = new Node(head.row - 1, head.col, head.color);
                }
                break;

            case DOWN:
                if (noWalls && head.getRow() == ConfigSingleton.getInstance().getNumRows()-1) {
                    firstNode = new Node(head.getFirstRow(), head.col, head.color);
                } else {
                    firstNode = new Node(head.row + 1, head.col, head.color);
                }
                break;
        }
        head.color = Color.green;
        listNodes.add(0, firstNode);

        if (countGrowSnake == 0) {
            listNodes.remove(listNodes.size() - 1);
        } else {
            countGrowSnake--;
        }

    }

    public void setDirection(DirectionType direction) {
        this.direction = direction;
    }

    public DirectionType getDirection() {
        return direction;
    }

    public ArrayList<Node> getListNodes() {
        return listNodes;
    }

    public Node getNodeHead() {
        return listNodes.get(0);
    }

    public boolean hitWall() {
        if (getNextNode().getCol() == ConfigSingleton.getInstance().getNumCols() || getNextNode().getCol() == -1
                || getNextNode().getRow() == ConfigSingleton.getInstance().getNumRows() || getNextNode().getRow() == -1) {
            return true;
        }

        return false;
    }


    public boolean hitItself() {
        for (int i = 1; i < listNodes.size(); i++) {
            if (Node.checkNodesHit(getNextNode(), listNodes.get(i))) {
                return true;
            }
        }
        return false;

    }

    public Node getNextNode() {
        Node head = getNodeHead();
        boolean noWalls = ConfigSingleton.getInstance().getNoWalls();
        Node nextNode = null;

        switch (direction) {
            case RIGHT:
                if (noWalls && head.getCol() == ConfigSingleton.getInstance().getNumCols()) {
                    nextNode = new Node(head.row, head.getFirstCol(), Color.red);
                } else {
                    nextNode = new Node(head.row, head.col + 1, Color.red);
                }
                break;

            case LEFT:
                if (noWalls && head.getCol() == 0) {
                    //nextNode = new Node(head.row, head.getLastCol()-1, Color.red);
                    nextNode = new Node(head.row, ConfigSingleton.getInstance().getNumCols()-1, Color.red);
                } else {
                    nextNode = new Node(head.row, head.col - 1, Color.red);
                }
                break;

            case UP:
                if (noWalls && head.getRow() == 0) {
                    //nextNode = new Node(head.getLastRow()-1, head.col, Color.red);
                    nextNode = new Node(ConfigSingleton.getInstance().getNumRows()-1, head.col, Color.red);
                } else {
                    nextNode = new Node(head.row - 1, head.col, Color.red);
                }
                break;

            case DOWN:
                if (noWalls && head.getRow() == ConfigSingleton.getInstance().getNumRows()) {
                    nextNode = new Node(head.getFirstRow(), head.col, Color.red);
                } else {
                    nextNode = new Node(head.row + 1, head.col, Color.red);
                }
                break;
        }
        return nextNode;
    }

    public void setCountGrowSnake(int countGrowSnake) {
        this.countGrowSnake = countGrowSnake;
    }

}
