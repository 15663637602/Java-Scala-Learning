package java8.lambda.methodRefer;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @ClassName MmethodReference
 * @Description TODO
 * @Author yuqili
 * @Date 25/07/18  11:03
 * @Version 1.0
 **/
public class MmethodReference {
    private static void saySomething(){
        System.out.println("static method");
    }

    private static int threadStatus(){
        System.out.println("Thread is running");
        return 0;
    }

    private void saySomething2(){
        System.out.println("instance method");
    }

    public static void main(String[] args) {
        // refer a static method
        Sayable sayable = MmethodReference::saySomething; // must be a static method.
        sayable.say();

        Thread t2 = new Thread(MmethodReference::threadStatus);
        t2.start();

        // To refer a non-static method, you need to refer methods by class object or anonymous object.
        MmethodReference reference = new MmethodReference();
        Sayable sayable1 = reference::saySomething2;
        Sayable sayable2 = new MmethodReference()::saySomething2;




        // or arbitrary type: the method of String
        BiFunction<String, Integer, Character> getChar = String::charAt;
        System.out.println("getChar: " + getChar.apply("12345", 3));
        // Compare with the method below:
        String str = "hello";
        Function<Integer, Character> getChar2 = str::charAt;
        System.out.println(getChar2.apply(3));




        // Reference to a constructor
        // ClassName::new
        Messageable hello = Message::new;
        hello.getMessage("hello");
    }
}

@FunctionalInterface
interface Sayable {
    void say();
}

@FunctionalInterface
interface Messageable{
    Message getMessage(String msg);
}

class Message {
    Message(String msg){
        System.out.println(msg);
    }
}