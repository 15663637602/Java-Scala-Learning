package designPattern.strategy.behavior;

/**
 * @author yuqili
 * Date 11/09/18  12:03
 * @version 1.0
 * define TODO
 **/
public class NoFlyBehave implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("No fly");
    }
}
