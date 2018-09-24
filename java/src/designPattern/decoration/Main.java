package designPattern.decoration;

import designPattern.decoration.base.Drink;
import designPattern.decoration.ingredient.Chocolate;
import designPattern.decoration.ingredient.Milk;
import designPattern.decoration.product.Decaf;
import designPattern.decoration.product.Longblack;

/**
 * define TODO
 *
 * @author yuqili
 * Date 13/09/18  10:40
 * @version 1.0
 **/
public class Main {
    public static void main(String[] args){
        // 点一个Decaf
        Drink order = new Decaf();
        System.out.println("order1 price: " + order.cost() + " ----- " + "order1 desc: " + order.getDescription());

        System.out.println("**********************");
        order = new Longblack();
        // 添加牛奶
        order = new Milk(order);
        order = new Chocolate(order);
        order = new Chocolate(order);
        System.out.println("order1 price: " + order.cost() + " ----- " + "order1 desc: " + order.getDescription());

        System.out.println("**********************");
    }
}
