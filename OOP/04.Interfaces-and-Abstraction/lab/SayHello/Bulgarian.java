package oop04.lab.SayHello;

public class Bulgarian implements Person {
    private String name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Здайрий";
    }
}
