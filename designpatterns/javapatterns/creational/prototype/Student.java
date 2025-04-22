package designpatterns.javapatterns.creational.prototype;

public class Student implements  ProtoType{

    int age;
    private int rollNumber;
    String name;

    Student(int age, int rollNumber, String name){
        this.age = age;
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public String toString() {
        return "age: " + age + ", rollNumber: " + rollNumber + ", name: " + name;
    }

    @Override
    public ProtoType clone() {
        return new Student(age, rollNumber, name);
    }
}
