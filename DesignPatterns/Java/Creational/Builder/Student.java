package DesignPatterns.Creational.Builder;


public class Student {

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

}
