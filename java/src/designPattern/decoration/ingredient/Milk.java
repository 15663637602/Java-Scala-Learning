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
public class Milk extends Decorator {
    public Milk(Drink drink) {
        super(drink);
        super.setDescription("Milk");
        super.setPrice(0.7f);
    }
}
