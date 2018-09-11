package designPattern.strategy.behavior;

/**
 * @author yuqili
 * Date 11/09/18  12:02
 * @version 1.0
 * define TODO
 **/
public class GuGuQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Gu Gu Quack");
    }
}
