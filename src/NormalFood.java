/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alu20482156n
 */
public class NormalFood extends Food {

    public NormalFood(Snake snake) {
        super(snake);
         ConfigSingleton.getInstance().setCountFood(ConfigSingleton.getInstance().getCountFood() + 1);
    }


}
