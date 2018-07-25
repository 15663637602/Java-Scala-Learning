package reflectss;

import java.lang.reflect.Constructor;

public class Test {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("reflectss.bean.Student");
        System.out.println(clazz);

        // 获取所有的 公有 构造方法
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c: constructors){
            System.out.println(c);
        }

        // 获取所有的构造方法
        Constructor[] constructors1 = clazz.getDeclaredConstructors();
        for (Constructor c: constructors1) {
            System.out.println(c);
        }
        // 获取单个 公有 构造方法
        Constructor c1 = clazz.getConstructor();
        System.out.println(c1);
        // 获取单个 （所有类型）的构造方法
        Constructor c2 = clazz.getDeclaredConstructor(String.class);
        System.out.println(c2);
        System.out.println("-----------------");
        // 调用构造方法
        clazz.newInstance();
        // 普通的newInstance不能访问私有Constructor
        // c2.newInstance();

        // 取消构造方法前的权限
        c2.setAccessible(true);
        c2.newInstance("123");
    }
}
