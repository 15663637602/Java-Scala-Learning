package designPattern.decoration.ingredient;

import designPattern.decoration.base.Drink;
import designPattern.decoration.ingredient.base.Decorator;

/**
 * define TODO
 *
 * @author yuqili
 * Date 13/09/18  11:16
 * @version 1.0
 **/
public class Chocolate extends Decorator {
    public Chocolate(Drink drink) {
        super(drink);
        super.setDescription("Chocolate");
        super.setPrice(1.2f);
    }
}
