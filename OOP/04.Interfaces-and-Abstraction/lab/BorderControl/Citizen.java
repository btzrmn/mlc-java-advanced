package oop04.lab.BorderControl;

public class Citizen implements Identifiable{
    private String name;
    private int age;
    private String id;

    public Citizen(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String getId() {
        return this.id;
    }

}
