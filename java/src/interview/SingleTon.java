package interview;

public class SingleTon {
    private SingleTon(){

    }

    private static SingleTon singleTon = new SingleTon();
    private static SingleTon singleTon2 = null;

    // 饱汉
    public static SingleTon getSingleTon(){
        return singleTon;
    }

    // 饥汉, 防止多个线程一下子创建了好几个对象
    public synchronized static SingleTon getSingleTon2(){
        if (singleTon2 == null) return new SingleTon();
        else return singleTon2;
    }
}
