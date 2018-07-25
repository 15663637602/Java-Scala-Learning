package java8.lambda;

/**
 * @ClassName People
 * @Description TODO
 * @Author yuqili
 * @Date 25/07/18  10:47
 * @Version 1.0
 **/
public class People {
    private int age;
    private String name;

    public People(int a, String n){
        age = a;
        name = n;
    }

    public People(String ext, int a, String n){
        age = a;
        name = n;
        System.out.println("Generate a Complex People object");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
