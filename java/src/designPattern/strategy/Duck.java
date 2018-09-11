package designPattern.strategy;

import designPattern.strategy.behavior.FlyBehavior;
import designPattern.strategy.behavior.QuackBehavior;

/**
 * @author yuqili
 * Date 11/09/18  11:25
 * @version 1.0
 * define 策略模式： 分别封装行为为接口，实现算法族，超类里放行为接口对象，在子类里设定具体行为对象。
 * 原则是：--分离变化部分--，封装接口，基于接口编程各种功能。
 * 让行为算法的变化独立于算法的使用者。
 *
 * 要分析项目中变化的和不变的部分
 * 多用组合， 少用继承； 用多个行为来组合成一个类， 而不是行为的继承
 **/
public abstract class Duck {
    // access is package private
    FlyBehavior mFlyBehavior;
    QuackBehavior mQuackBehavior;

    Duck() {}

    void fly() {
        mFlyBehavior.fly();
    }

    void quack(){
        mQuackBehavior.quack();
    }

    public abstract void display();

    void setFlyBehavior(FlyBehavior fly) {
        mFlyBehavior = fly;
    }

    void setQuackBehavior(QuackBehavior qb) {
        mQuackBehavior = qb;
    }
}
