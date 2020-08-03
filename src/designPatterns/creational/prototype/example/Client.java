package designPatterns.creational.prototype.example;

public class Client {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedShape =(Shape)ShapeCache.getShape("1");
        System.out.println("Client Shape : "+clonedShape.getType());

        Shape clonedShape1 =(Shape)ShapeCache.getShape("2");
        System.out.println("Client Shape : "+clonedShape1.getType());

        Shape clonedShape2 =(Shape)ShapeCache.getShape("3");
        System.out.println("Client Shape : "+clonedShape2.getType());
    }
}
