package designPattern.strategy;

import designPattern.strategy.behavior.GaGaQuack;
import designPattern.strategy.behavior.GoodFlyBehave;

/**
 * @author yuqili
 * Date 11/09/18  11:40
 * @version 1.0
 * define TODO
 **/
public class GreenDuck extends Duck {

    GreenDuck() {
        mFlyBehavior = new GoodFlyBehave();
        mQuackBehavior = new GaGaQuack();
    }

    @Override
    public void display() {
        quack();
        fly();
    }
}
