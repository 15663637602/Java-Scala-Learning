package designPattern.strategy.behavior;

/**
 * @author yuqili
 * Date 11/09/18  11:41
 * @version 1.0
 * define TODO
 **/
public class GoodFlyBehave implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("Good Fly");
    }
}
