package designPattern.decoration.ingredient.base;

import designPattern.decoration.base.Drink;

/**
 * define TODO
 *
 * @author yuqili
 * Date 13/09/18  11:11
 * @version 1.0
 **/
public class Decorator extends Drink {

    private Drink drink;

    // 被包装进去的类
    public Decorator(Drink drink){
        this.drink = drink;
    }

    @Override
    public float cost() {
        return getPrice() + drink.cost();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "-" + super.getPrice() + "&&" + drink.getDescription();
    }
}
