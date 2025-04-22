package designpatterns.javapatterns.creational.prototype;

public class Main {
    public static void main(String[] args) {

        Student obj = new Student(12, 21, "ashwik");
        Student cloneObj = (Student) obj.clone();
        System.out.println(cloneObj.toString());
    }
}
