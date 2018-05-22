/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alu20482156n
 */
public class FoodFactory {

    private Snake snake;
    Board board;
    

    public FoodFactory(Board board, Snake snake) {
        this.board = board;
        this.snake = snake;

    }

    public Food createFood() {

        if (ConfigSingleton.getInstance().getCountFood() % 5 == 0 && ConfigSingleton.getInstance().getCountFood() != 0) {
            ConfigSingleton.getInstance().setCountFood(0);
            return new SpecialFood(snake, board);
        } else {
            return new NormalFood(snake);
        }

    }
}
