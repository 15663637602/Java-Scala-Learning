package designPattern.strategy;

import designPattern.strategy.behavior.GuGuQuack;
import designPattern.strategy.behavior.NoFlyBehave;

/**
 * @author yuqili
 * Date 11/09/18  11:46
 * @version 1.0
 * define TODO
 **/
public class Main {
    public static void main(String[] args){
        Duck greenDuck = new GreenDuck();
        greenDuck.display();
        greenDuck.setFlyBehavior(new NoFlyBehave());
        greenDuck.setQuackBehavior(new GuGuQuack());
        greenDuck.display();
    }
}
