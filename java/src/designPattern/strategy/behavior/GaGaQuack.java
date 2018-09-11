package designPattern.strategy.behavior;

/**
 * @author yuqili
 * Date 11/09/18  11:42
 * @version 1.0
 * define TODO
 **/
public class GaGaQuack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("Ga Ga");
    }
}
