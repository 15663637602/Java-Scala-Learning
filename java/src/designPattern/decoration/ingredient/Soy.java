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
public class Soy extends Decorator {
    public Soy(Drink drink) {
        super(drink);
        super.setDescription("Soy");
        super.setPrice(0.37f);
    }
}
