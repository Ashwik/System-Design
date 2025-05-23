package designpatterns.javapatterns.creational.factory;

public class ShapeInstanceFactory {

    public Shape getShapeInstance(String value){
        return switch (value) {
            case "Circle" -> new Circle();
            case "Rectangle" -> new Rectangle();
            case "Square" -> new Square();
            default -> null;
        };
    }
}
