package reflectss.bean;

public class Student {
    public Student() {
        System.out.println("public constructor");
    }

    Student(int a) {
        System.out.println("default constructor");
    }

    private Student(String b) {
        System.out.println("private constructor");
    }

    protected Student(int a, String b) {
        System.out.println("protected constructor");
    }

}
