package designPattern.decoration.product.base;

import designPattern.decoration.base.Drink;

/**
 * define TODO
 *
 * @author yuqili
 * Date 13/09/18  11:04
 * @version 1.0
 **/
public class Coffee extends Drink {
    @Override
    public float cost() {
        return getPrice();
    }
}
