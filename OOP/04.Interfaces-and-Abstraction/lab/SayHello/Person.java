package oop04.lab.SayHello;

public interface Person {
    String getName();

    default String sayHello() {
        return "Hello";
    }
}
